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
 * Servlet implementation class ChannelServlet
 */
@WebServlet("/channel")
public class ChannelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChannelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String level = request.getParameter("level");
		String parent = request.getParameter("parent");
		List chlist = new ArrayList();
		if(level.equals("1")) {
			chlist.add(new Channel("ai" , "ǰ��/������/�˹�����"));
			chlist.add(new Channel("web" , "ǰ��/С����/JS"));
		}else if(level.equals("2")) {
			if(parent.equals("ai")) {
				chlist.add(new Channel("micro" , "΢����"));
				chlist.add(new Channel("blockchain" , "������"));
				chlist.add(new Channel("other" , "..."));
			}else if(parent.equals("web")){
				chlist.add(new Channel("html" , "HTML"));
				chlist.add(new Channel("css" , "CSS"));
				chlist.add(new Channel("other" , "..."));
			}
		}
		String json = JSON.toJSONString(chlist);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);
	}

}
