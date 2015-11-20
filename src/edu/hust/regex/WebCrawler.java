package edu.hust.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		crawl("http://www.douban.com/event/14146775/discussion/40108760/");

	}
	
	public static void crawl(String site) throws IOException {
		URL url = new URL(site);
		URLConnection con =  url.openConnection();
		
		String reg = "\\w{4,14}@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		Pattern p = Pattern.compile(reg);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = null;
		while((line=reader.readLine())!=null){
			Matcher m = p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
			}
		}
	}

}
