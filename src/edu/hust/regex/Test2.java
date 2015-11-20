package edu.hust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Test2
{
	public static void main(String[] args) 
	{
		String src = "sss#this#xx#that#df";  
        Pattern pattern = Pattern.compile("#\\w+#");  
        Matcher matcher = pattern.matcher(src);  
        System.out.println("matcher.groupCount():" + matcher.groupCount());  
        while(matcher.find()){  
            System.out.println(matcher.group());   
        }  
        
        
        System.out.println("...........................");
        
        
        
		Matcher m = Pattern.compile("(，)", 
				Pattern.CASE_INSENSITIVE).matcher("<p style='margin: 16px 0px; pa'>5月27号，该局根据该，1，2，3，4，5，，8979797</p>");
		if (!m.find()) {
			return ;
		}
		System.out.println("count:" + m.groupCount());  //groupCount()捕获组
		String[] res = new String[m.groupCount()+1];
		for (int i = 0; i <= m.groupCount(); i++) {
			res[i] = m.group(i).trim();
			System.out.println(res[i]);
		}
	}
}
