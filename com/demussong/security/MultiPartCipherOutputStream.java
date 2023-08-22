package com.demussong.security;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/8/24 17:20
 */

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MultiPartCipherOutputStream extends FilterOutputStream {

    private OutputStream output;

    private CipherLite cipherLite;
    private byte[] bufin = new byte[1];
    private byte[] bufout; //加密后的缓存

    private boolean closed = false;

    public MultiPartCipherOutputStream(OutputStream os, CipherLite c) {
        super(os);
        output = os;
        cipherLite = c;
    };

    public void write(int b) throws IOException {
        bufin[0] = (byte) b;
        bufout = cipherLite.deal(bufin, 0, 1);
        if (bufout != null) {
            output.write(bufout);
            bufout = null;
        }
    };

    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte b[], int off, int len) throws IOException {
        bufout = cipherLite.deal(b, off, len);
        if (bufout != null) {
            output.write(bufout);
            bufout = null;
        }
    }

    public void flush() throws IOException {
        if (bufout != null) {
            output.write(bufout);
            bufout = null;
        }
        output.flush();
    }

    public void close() throws IOException {
        if (closed) {
            return;
        }
        try {
            bufout = cipherLite.deal(null,0,-1);
        } catch (Exception e) {
            bufout = null;
        }
        closed = true;
        try {
            flush();
        } catch (IOException ignored) {}
        out.close();
    }
}
