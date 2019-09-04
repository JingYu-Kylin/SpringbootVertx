package com.fire.server.protocol;

import com.fire.server.utils.StreamUtil;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class MessageInputStream extends FilterInputStream implements Serializable{
	private InputStream inputStream;

	public MessageInputStream(InputStream inputStream) {
		super(inputStream);
		this.inputStream = inputStream;
	}

	public byte read(byte x) throws Exception {
		byte var = 0;
		var = (byte) (inputStream.read());
		return var;
	}

	public short read(short x) throws Exception {
		short var1 = 0, var2 = 0;
		var1 = (short) inputStream.read();
		var2 = (short) inputStream.read();
		var1 = (short) ((var1 & 0xffff) | (var2 << 8));
		
		return var1;
	}

	public int read(int x) throws Exception {
		int var1 = read((short) x);
		int var2 = read((short) x);
		return (var1 & 0xffff) | (var2 << 16);
	}

	public long read(long x) throws Exception {
		long var1 = read((int) x);
		long var2 = read((int) x);
		return (var1 & 0xffffffff) | (var2 << 32);
	}

	public String read(String x) throws Exception {
		short len = 0;
		len = read(len);
		if (len == 0)
			return "";
		byte[] buf = new byte[len];
		try {
			inputStream.read(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StreamUtil.AsciitoString(buf);
	}
}
