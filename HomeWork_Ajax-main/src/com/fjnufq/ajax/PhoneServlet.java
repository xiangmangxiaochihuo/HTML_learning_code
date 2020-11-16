package com.fjnufq.ajax;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/phone")
public class PhoneServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String level = request.getParameter("level");
        String first = request.getParameter("first");
        List list = new ArrayList();
        if(level.equals("1")) {
            list.add(new Phone("iPhone" , "单机"));
            list.add(new Phone("HuaWei" , "网游"));
            list.add(new Phone("XiaoMi" , "手游"));
        }else if(level.equals("2")) {
            if(first.equals("iPhone")) {
                list.add(new Phone("iPhone1" , "巫师3"));
                list.add(new Phone("iPhone2" , "GTA5"));
                list.add(new Phone("iPhone3" , "古墓丽影"));
                list.add(new Phone("iPhone4" , "生化危机"));
                list.add(new Phone("other" , "..."));
            }else if(first.equals("HuaWei")){
                list.add(new Phone("HuaWei1" , "DOTA2"));
                list.add(new Phone("HuaWei2" , "英雄联盟"));
                list.add(new Phone("HuaWei3" , "守望先锋"));
                list.add(new Phone("HuaWei4" , "魔兽世界"));
                list.add(new Phone("other" , "..."));
            }
            else if(first.equals("XiaoMi")){
                list.add(new Phone("XiaoMi1" , "王者荣耀"));
                list.add(new Phone("XiaoMi2" , "斗地主"));
                list.add(new Phone("XiaoMi3" , "原神"));
                list.add(new Phone("XiaoMi4" , "QQ飞车"));
                list.add(new Phone("other" , "..."));
            }
        }
        String json = JSON.toJSONString(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
    }
}
