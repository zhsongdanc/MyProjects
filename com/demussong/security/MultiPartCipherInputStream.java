//package com.demussong.security;
//
//import com.qcloud.cos.internal.SdkFilterInputStream;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//public class MultiPartCipherInputStream extends SdkFilterInputStream {
//
//	private static final int MAX_RETRY = 1000;
//	private static final int DEFAULT_IN_BUFFER_SIZE = 512;
//
//	private boolean eof;
//	private byte[] bufin;//缓存加密字符
//	private byte[] bufout;//缓存解密字符
//	private int curr_pos;// bufout当前已经读取的位置
//	private int max_pos;// bufout可以读取的最大长度
//	private InputStream is;
//
//	private CipherLite cipherLite;
//
//	public MultiPartCipherInputStream(InputStream is, CipherLite cipherLite) {
//		this(is, cipherLite, DEFAULT_IN_BUFFER_SIZE);
//	}
//
//	public MultiPartCipherInputStream(InputStream is, CipherLite cipherLite, int buffSize) {
//
//		super(is);
//		this.is = is;
//		this.cipherLite = cipherLite;
//		bufin = new byte[buffSize];
//	}
//
//	@Override
//	public int read() throws IOException {
//		if (curr_pos >= max_pos) {
//			if (eof)
//				return -1;
//			int count = 0;
//			int len;
//			do {
//				if (count > MAX_RETRY)
//					throw new IOException("exceeded maximum number of attempts to read next chunk of data");
//
//				int read = is.read(bufin);
//				bufout = cipherLite.deal(bufin, 0, read);
//				len = bufout.length;
//				curr_pos = 0;
//				max_pos = bufout.length;
//
//				count++;
//			} while (len == 0);
//
//			if (len == -1)
//				eof = true;
//		}
//		return ((int) bufout[curr_pos++] & 0xFF);
//	};
//
//	@Override
//	public int read(byte b[]) throws IOException {
//		return read(b, 0, b.length);
//	}
//
//	@Override
//	public int read(byte buf[], int off, int target_len) throws IOException {
//		if (curr_pos >= max_pos) {
//			// all buffered data has been read, let's get some more
//			if (eof)
//				return -1;
//			int count = 0;
//			int len;
//			do {
//				if (count > MAX_RETRY)
//					throw new IOException("exceeded maximum number of attempts to read next chunk of data");
//
//				int read = is.read(bufin);
//				bufout = cipherLite.deal(bufin, 0, read);
//				len = read == -1 ? -1 : bufout.length;
//				max_pos = bufout.length;
//				curr_pos = 0;
//				count++;
//			} while (len == 0);
//
//			if (len == -1) {//读取长度为-1，说明流已经关闭，无法再次读取，那么不再读取
//
//				eof = true;
//			}
//
//		}
//		if (target_len <= 0)
//			return 0;
//		int len = max_pos - curr_pos;//待复制的字节长度
//		if (target_len < len)
//			len = target_len;
//		// if buf == null, will throw NPE as intended per javadoc
//		System.arraycopy(bufout, curr_pos, buf, off, len);
//		curr_pos += len;
//		return len;
//	}
//
//	@Override
//	public long skip(long n) throws IOException {
//		abortIfNeeded();
//		int available = max_pos - curr_pos;
//		if (n > available)
//			n = available;
//		if (n < 0)
//			return 0;
//		curr_pos += n;
//		return n;
//	}
//
//	@Override
//	public int available() {
//		abortIfNeeded();
//		return max_pos - curr_pos;
//	}
//
//	@Override
//	public void close() throws IOException {
//		in.close();
//		// For multipart upload the doFinal has to be triggered via the read
//		// methods, since we cann't tell if the close is due to error or normal
//		// completion.
//		curr_pos = max_pos = 0;
//		abortIfNeeded();
//	}
//
//	@Override
//	public boolean markSupported() {
//		abortIfNeeded();
//		return in.markSupported();
//	}
//
//	@Override
//	public void mark(int readlimit) {
//		abortIfNeeded();
//		in.mark(readlimit);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * <p>
//	 * Subclassing this method would need to take care in keeping all internal
//	 * states consistent. REF: TT0036173414, ISSUE-JAVA-547.
//	 */
//	@Override
//	public void reset() throws IOException {
//		abortIfNeeded();
//		in.reset();
//		cipherLite.reset();
////        cipherLite.reset();
//		resetInternal();
//	}
//
//	final void resetInternal() {
//		curr_pos = max_pos = 0;
//		eof = false;
//	}
//
//}
