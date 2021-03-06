package edu.hust.responsibilityChain;

/**
 * 文字内容处理 
 */
public class TextFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("被就业", "就业") + "---TextFilter");
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr() + "---TextFilter");
	}

}
