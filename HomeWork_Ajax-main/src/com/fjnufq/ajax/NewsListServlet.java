package com.fjnufq.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class NewsListServlet
 */
@WebServlet("/news_list")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String type = request.getParameter("t");
		List list = new ArrayList();
		if(type != null && type.equals("pypl")) {
			list.add(new News("PYPL:2018��5�·�ȫ�����������а�" , "2018-5-1" , "PYPL" , "..."));
			list.add(new News("PYPL:2018��6�·�ȫ�����������а�" , "2018-6-1" , "PYPL" , "..."));
			list.add(new News("PYPL:2018��7�·�ȫ�����������а�" , "2018-7-1" , "PYPL" , "..."));
			list.add(new News("PYPL:2018��8�·�ȫ�����������а�" , "2018-8-1" , "PYPL" , "..."));
			
		}else if(type == null || type.equals("tiobe")) {
			list.add(new News("TIOBE:2018��5�·�ȫ�����������а�" , "2018-5-1" , "TIOBE" , "..."));
			list.add(new News("TIOBE:2018��6�·�ȫ�����������а�" , "2018-6-1" , "TIOBE" , "..."));
			list.add(new News("TIOBE:2018��7�·�ȫ�����������а�" , "2018-7-1" , "TIOBE" , "..."));
			list.add(new News("TIOBE:2018��8�·�ȫ�����������а�" , "2018-8-1" , "TIOBE" , "..."));
			
		}
		String json = JSON.toJSONString(list);
		System.out.println(json);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(json);
	}

}
