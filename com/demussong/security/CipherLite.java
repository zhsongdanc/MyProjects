package com.demussong.security;

public interface CipherLite {


	public byte[]  deal(byte[] bytes,int offSet,int len) ;
	public void reset();

	
}
