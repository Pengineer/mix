package edu.hust.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class FileTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("d:\\af.txt");   //û�д����ļ�
		
//		FileWriter fw = new FileWriter(file); //�����ļ�
		
//		String ext = FilenameUtils.getExtension("1.txt.doc");   //doc
		
//		FileUtils.cleanDirectory(file);//java.lang.IllegalArgumentException: d:\f.txt is not a directory
		
//		Boolean deleteBoolean = FileUtils.deleteQuietly(file);//ɾ���ļ�����Ŀ¼
		
		FileUtils.forceDelete(file);//ɾ���ļ���Ŀ¼
		
		FileUtils.copyFile(file, new File("d:\\f2.txt"));

	}

}
