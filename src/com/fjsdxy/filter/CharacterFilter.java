package com.fjsdxy.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterFilter
 */
public class CharacterFilter implements Filter {
    /**
     * Default constructor. 
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 拦截所有的请求 解决全站中文乱码
		// 指定 request 和 response 的编码
		request.setCharacterEncoding("utf-8"); // 只对消息体有效
		response.setContentType("text/html;charset=utf-8");
		// 对request进行包装
		CharacterRequest characterRequest = new CharacterRequest(request);
		chain.doFilter(characterRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

//继承 默认包装类HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	// 子类继承父类一定会覆写一些方法，此处用于重写getParamter()方法
	public String getParameter(String name) {
		// 调用被包装对象的getParameter()方法，获得请求参数
		String value = super.getParameter(name);
		if (value == null)
			return null;
		// 判断请求方式
		String method = super.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
					value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		// 解决乱码后返回结果
		return value;
	}
}
