package edu.hust.responsibilityChain;

public interface Filter {
	
	/**
	 * 为了实现response能逆向使用Filter，加入filter链的引用
	 */
	public void doFilter(Request request, Response response, FilterChain chain);
}
