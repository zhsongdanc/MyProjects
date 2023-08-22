package com.demussong.security;

import org.bouncycastle.util.Arrays;

public class DecryptedByteBuffer {

	private int decryptedSize;
	private byte[] buffer=new byte[4096];
	
	public void appendDecryptedBytes(byte[] decryptedBytes) {
		
		
		if(decryptedBytes.length+decryptedSize>buffer.length) {
			buffer=Arrays.copyOf(buffer, 2*buffer.length);
		}
		
		System.arraycopy(decryptedBytes, 0, buffer, decryptedSize, decryptedBytes.length);
		decryptedSize+=decryptedBytes.length;
	}
	public byte[] getDecrypteBytes() {
		
		byte[] tmp=new byte[decryptedSize];
		System.arraycopy(buffer, 0, tmp, 0, decryptedSize);
		return tmp;
	}
}
