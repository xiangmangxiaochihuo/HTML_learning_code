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
            list.add(new Phone("iPhone" , "����"));
            list.add(new Phone("HuaWei" , "����"));
            list.add(new Phone("XiaoMi" , "����"));
        }else if(level.equals("2")) {
            if(first.equals("iPhone")) {
                list.add(new Phone("iPhone1" , "��ʦ3"));
                list.add(new Phone("iPhone2" , "GTA5"));
                list.add(new Phone("iPhone3" , "��Ĺ��Ӱ"));
                list.add(new Phone("iPhone4" , "����Σ��"));
                list.add(new Phone("other" , "..."));
            }else if(first.equals("HuaWei")){
                list.add(new Phone("HuaWei1" , "DOTA2"));
                list.add(new Phone("HuaWei2" , "Ӣ������"));
                list.add(new Phone("HuaWei3" , "�����ȷ�"));
                list.add(new Phone("HuaWei4" , "ħ������"));
                list.add(new Phone("other" , "..."));
            }
            else if(first.equals("XiaoMi")){
                list.add(new Phone("XiaoMi1" , "������ҫ"));
                list.add(new Phone("XiaoMi2" , "������"));
                list.add(new Phone("XiaoMi3" , "ԭ��"));
                list.add(new Phone("XiaoMi4" , "QQ�ɳ�"));
                list.add(new Phone("other" , "..."));
            }
        }
        String json = JSON.toJSONString(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
    }
}
