package edu.hust.test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteBufferClass {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = "Œ“hello".getBytes();
		
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		buffer.putChar(3, 'b');
		bytes = buffer.array();
		System.out.println(new String(bytes, "GB2312"));
	}

}
