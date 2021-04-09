package com.fjsdxy.session1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseServlet
 */
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 获得用户购买的商品
			String id = req.getParameter("id");
			if (id == null) {
				// 如果id为null，重定向到ListBookServlet页面
				String url = "/J1932/ListBookServlet";
				resp.sendRedirect(url);
				return;
			}
			Book book = BookDB.getBook(id);
			// 创建或者获得用户的Session对象
			HttpSession session = req.getSession();
			// 从Session对象中获得用户的购物车
			List<Book> cart = (List) session.getAttribute("cart");
			if (cart == null) {
				// 首次购买，为用户创建一个购物车(List集合模拟购物车)
				cart = new ArrayList<Book>();
				// 将购物城存入Session对象
				session.setAttribute("cart", cart);
			}
			// 将商品放入购物车
			cart.add(book);
			// 创建Cookie存放Session的标识号
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60 * 30);
			cookie.setPath("/J1932");
			resp.addCookie(cookie);
			// 重定向到购物车页面
			String url = "/J1932/CartServlet";
//			resp.sendRedirect(url);
			String newurl=resp.encodeRedirectURL(url);
			resp.sendRedirect(newurl);

		}	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
