package edu.hust.test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileNameProcesses {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		File fileDir = new File("E:\\2015");
		File[] files = fileDir.listFiles();
		for (File file : files){
			String fileName = new String(file.getName().getBytes(),"utf-8");
			System.out.println(fileName);
		}
	}
}
