package edu.hust.regex;

import java.io.ObjectInputStream.GetField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args){
		test1("11111111111111111X");
		
		//System.out.println(test("三峡大学  文学与传媒学院"));
			
		//System.out.println(getName("   张   三"));
	}
		
	public static String test(String str){
		//"中山大学"，"三峡大学  文学与传媒学院"，" 徐州工程学院"，"上海交通大学人文学院历史系"，"《世界急诊医学杂志》编辑部"，"中国地质大学（武汉）"
		//"中国地质大学（武汉）体育部"，"中国石油大学(华东)"，"中国石油大学（北京）"，"中国矿业大学纪委办、监察处"，"中国计量学院（武汉大学博士在读）"
		//"人文社会科学（马克思主义）学院"，"伊犁师范学院体育学院（在读博士）"，"信息技术学院（二级学院）"，"南京理工大学学报（社会科学版）"
		//"党委办公室/院长办公室"，"党委办公室、院长办公室"，"党委（校长）办公室"
		//"发展规划处"，"发展规划处、高等教育研究所"，"发展规划处（医学教育研究中心）"
		//"吉林大学文学院/边疆考古研究中心","吉林大学文学院 边疆考古研究中心","学报编辑部/知识产权中心"
		//"哈尔滨工业大学（威海）体育部"，"哈尔滨工业大学，管理学院","天水师范学院（经济与社会管理学）"
		//"商学院、金融工程研究中心"，"商学院  管理科学与工程系"，"商学院；沿海沿江发展研究院","商学院，苏州城乡一体化研究院","大学生心理咨询中心；脑科学研究所"
		//"？？ 河北联合大学经济学院"，"？湛江师范学院美术学院"，"WTO研究教育学院"," 社科部"，"三峡大学翻译研究中心"，"上海工程技术大学学生工作部（处）"
		 
		String str1 = str.replaceAll("\\((.*?)\\)", "（$1）"); //英文括号变中文括号
		String str2 = str1.replaceAll("？*", "").replaceAll("\\s+", "");  //去掉开始的？
					
		if(str2.contains("学院") && !str2.endsWith("学院") && !str2.contains("（")){  //吉林大学文学院边疆考古研究中心      商学院管理科学与工程系          商学院 (xxx)  商学院
			int index = str2.indexOf("学院");
			String[] strs = str2.split("学院");
			
			if(strs.length == 1){
				str2 = strs[0]+"学院、";
			}else if(strs.length == 2){
				str2 = strs[0]+"学院、"+strs[1];
			}
		}
		
		return str2;
	}
	
	public static String getName(String name) {
		name = name.replaceAll("[\\.。,，、]+", "·").replaceAll("[^A-Za-z\\u4e00-\\u9fa5 ·]+", "").replaceAll("^[· ]+", "").replaceAll("[· ]+$", "");
		Pattern p = Pattern.compile("[A-Za-z]");
		Matcher m = p.matcher(name);
		if (m.find()) {
			name = name.replaceAll("[· ]+", " ");
		} else {
			name = name.replaceAll("\\s+", "").replaceAll("·+", "·");
		}
		return name;
	}
	
	public static void test(){
		String s = "ab";
		String[] ss = s.split("a");
		System.out.println(ss[1]);
	}
	
	public static void test1(String str){
		System.out.println(str.matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)"));
	}
}