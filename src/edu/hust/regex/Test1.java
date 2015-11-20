package edu.hust.regex;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String code = getSubjectCode("79021/发展经济学; 79035/数量经济学; 79057/农村经济学"); 
		System.out.println(code);
		//String s = null;
		//System.out.println(""+"12");
	}
	
	public static String getSubjectCode(String subject){
		String code = "";
		subject = subject.replaceAll("\\s+", "");
		String[] subjects = subject.split(";");
		for(int i = 0; i<subjects.length; i++){
			String[] codesubject = subjects[i].split("/");
			code += codesubject[0];
		}
		return code;
	}
	
	public static String transformDisc(String subject1) {
		subject1 = "bb";
		return subject1;
	}
	
	
}
