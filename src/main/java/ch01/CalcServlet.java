package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet request");
		// 1. request 객체에서 피연자와 연산자 받아와서 계산
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));

		System.out.println("n1: " + n1 + ", n2: " + n2);
		System.out.println("op: " + request.getParameter("op"));

		long result = 0; // 연산결과

		switch (request.getParameter("op")) {
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "*":
			result = n1 * n2;
			break;
		case "/":
			result = n1 / n2;
			break;
		}

		// 2. response 객체에 태그와 결과값을 클라이언트에게 응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<html><body><h2>계산기 서블릿</h2><hr>").append("계산결과: " + result + "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpServletRequest 메소드 사용
		System.out.println("request.getRequestURI(): " + request.getRequestURI());
		System.out.println("request.getRequestURL(): " + request.getRequestURL());
		System.out.println("request.getServerName(): " + request.getServerName());
		System.out.println("request.getMethod(): " + request.getMethod());

		System.out.println("doPost request");
		doGet(request, response); // post로 요청이 와도 doGet 메소드 실행
	}

}
