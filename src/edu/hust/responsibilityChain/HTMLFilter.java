package edu.hust.responsibilityChain;

public class HTMLFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("<", "[").replaceAll(">", "]") + "---HTMLFilter");
		chain.doFilter(request, response, chain); //调用filter链中的下一个filter，这就是为什么要加入chain引用的原因
		response.setResponseStr(response.getResponseStr() + "---HTMLFilter");//逐层返回，刚好逆序
	}

}
