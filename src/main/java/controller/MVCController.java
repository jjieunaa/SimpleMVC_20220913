package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class MVCController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 컨트롤러의 역할 1. 요청 분석 후 요청 응답
		String paramRequest = req.getParameter("request")==null ? "" : req.getParameter("request");
		
		// 요청 처리 후 결과를 저장할 객체
		Object resultObj = null;
		
		// 처리 결과를 표현할 View인 JSP 페이지의 경로를 저장
		Object viewJSP = null;
		
		// 컨트롤러의 역할 2. 요청에 따라 결과를 생성(Model)하고 뷰를 결정
		if (paramRequest.equals("name")) {
			resultObj = "홍길동";
			viewJSP = "/jsp/name.jsp";
		} else if (paramRequest.equals("age")) {
			resultObj = "26";
			viewJSP = "/jsp/age.jsp";
		}
		
		// request 속성 변수에 처리 결과를 저장
		req.setAttribute("resultObj", resultObj);
		
		// 컨트롤러의 역할 3. 생성된 결과를 뷰에 전달
		RequestDispatcher dispatcher = req.getRequestDispatcher((String) viewJSP);
		dispatcher.forward(req, resp);
	
	}
	
}	// class
