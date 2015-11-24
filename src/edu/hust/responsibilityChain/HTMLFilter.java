package edu.hust.responsibilityChain;

/**
 * HTML脚本中特殊符号处理 
 */
public class HTMLFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("<", "[").replaceAll(">", "]") + "---HTMLFilter");
		chain.doFilter(request, response, chain); //调用filter链中的下一个filter，这就是为什么要加入chain引用的原因
		response.setResponseStr(response.getResponseStr() + "---HTMLFilter");//逐层返回，刚好逆序
	}

}
