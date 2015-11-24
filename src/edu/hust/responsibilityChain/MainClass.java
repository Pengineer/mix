package edu.hust.responsibilityChain;

/**
 * 责任链模式
 * 
 * strust的过滤器。
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		Request request = new Request();
		request.setRequestStr("<script>据中央情报局消息，瓜抓岛利尔国今年的“被就业”数直线上升</script>");
		Response response = new Response();
		response.setResponseStr("response");
		
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		  .addFilter(new TextFilter());
		
		fc.doFilter(request, response, fc);
		
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
	}

}
