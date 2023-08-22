package com.demussong.security;

import com.qcloud.cos.exception.CosClientException;

import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;

public class EncryptCipherLite implements CipherLite{

	
	private Cipher cipher;
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(EncryptCipherLite.class);
	private long cipherSize=0;
	private SecretKey secretKey;
	public EncryptCipherLite(SecretKey secretkey) {

        try {
        	cipher = Cipher.getInstance("AES");
        	this.secretKey=secretkey;
			cipher.init(Cipher.ENCRYPT_MODE, secretkey);
		} catch (Exception e) {
			
			throw new CosClientException("Unable to create cipher instance, make sure secretkey is correct!!",e);
		}
		
	}
	@Override
	public byte[] deal(byte[] bytes,int offSet,int len)  {
		
		if(len<0) {
			
			try {
				byte[] doFinal = this.cipher.doFinal();
				cipherSize+=doFinal.length;
				return doFinal;
			} catch (Exception e) {
				logger.info(" do final ,exception:{}",e.getMessage());
				 throw new EncryptErrorException("encrypt failed",e);
			}
		}else {
				 byte[] update = this.cipher.update(bytes,offSet,len);
				 cipherSize+=update.length;
				return update;
		}
		
	}

	public long getCipherLength() {
		return cipherSize;
	}
	@Override
	public void reset() {
		try {
			this.cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			throw new CosClientException("Unable to init cipher instance, make sure secretkey is correct!!",e);
		}	
		
	}
}
