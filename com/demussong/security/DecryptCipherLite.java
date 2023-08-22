package com.demussong.security;

import com.qcloud.cos.exception.CosClientException;

import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.util.List;
import java.util.stream.Collectors;

public class DecryptCipherLite implements CipherLite {

	private Cipher cipher;
	private List<Long> cipherChunkLenLst;
	private int chunkIndex;
	private SecretKey secretKey;
	private long currChunk_pos;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DecryptCipherLite.class);

	public DecryptCipherLite(SecretKey secretkey, List<Long> plainChunkLenLst) {

		try {
			cipher = Cipher.getInstance("AES");
			this.secretKey = secretkey;
			cipher.init(Cipher.DECRYPT_MODE, secretkey);

			this.cipherChunkLenLst = plainChunkLenLst.stream().map(n -> n + 16 - n % 16).collect(Collectors.toList());

		} catch (Exception e) {

			throw new CosClientException("Unable to create cipher instance, make sure secretkey is correct!!", e);
		}

	}

	@Override
	public byte[] deal(byte[] bytes, int offset, int len) {

		if (len < 0) {

			try {
				return this.cipher.doFinal();
			} catch (Exception e) {

				logger.error(" decrypted failed!!");
				throw new DecryptErrorException("decrypt file error", e);
			}
		}

		DecryptedByteBuffer decryptedByteBuffer = new DecryptedByteBuffer();
		while (chunkIndex < cipherChunkLenLst.size() && currChunk_pos + len >= cipherChunkLenLst.get(chunkIndex)) {

			int currChunkRemainByteLength = (int) (cipherChunkLenLst.get(chunkIndex) - currChunk_pos);
			byte[] currChunkRemainByteToDecrypt = new byte[currChunkRemainByteLength];
			System.arraycopy(bytes, offset, currChunkRemainByteToDecrypt, 0, currChunkRemainByteLength);

			currChunk_pos = 0;
			offset += currChunkRemainByteLength;
			len -= currChunkRemainByteLength;

			try {
				byte[] decryptedBytes = this.cipher.doFinal(currChunkRemainByteToDecrypt);

				decryptedByteBuffer.appendDecryptedBytes(decryptedBytes);
				chunkIndex++;
			} catch (Exception e) {

				logger.error(" decrypted failed!!");
				throw new DecryptErrorException("decrypt file error", e);
			}
		}

		if (len > 0) {
			currChunk_pos += len;
			decryptedByteBuffer.appendDecryptedBytes(this.cipher.update(bytes, offset, len));
		}
		return decryptedByteBuffer.getDecrypteBytes();
	}

	@Override
	public void reset() {

		try {
			this.cipher.init(Cipher.DECRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			throw new CosClientException("Unable to create cipher instance, make sure secretkey is correct!!", e);
		}
	}

}
