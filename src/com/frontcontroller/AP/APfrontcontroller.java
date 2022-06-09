package com.frontcontroller.AP;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distributor.AP.DistributorImpl;

/**
 * Servlet implementation class APfrontcontroller
 */
//@WebServlet("/APfrontcontroller") // 기본생성 어노테이션
@WebServlet("*.do") //모든 .do를 받는다.
public class APfrontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APfrontcontroller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String departurePoint = request.getRequestURI().substring(request.getContextPath().length());
		
		String destination = null;
		DistributorImpl d1 = null;
		
		switch(departurePoint) {
		case "/hosting.do" :
			System.out.println("성공");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destination);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
