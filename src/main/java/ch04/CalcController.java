package ch04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/calcControl")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));

		long result = 0;

		switch (request.getParameter("op")) {
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "/":
			result = n1 / n2;
			break;
		case "*":
			result = n1 * n2;
			break;
		}

		// request 객체에 연산결과 저장 (key: result)
		request.setAttribute("result", result);

		// 연산결과가 저장된 request 객체를 calcResult.jsp로 전송
		getServletContext().getRequestDispatcher("/ch04/calc/calcResult.jsp")
				// request 객체를 다른 페이지로 전송한다.
				// 단, 페이지의 이동은 내부에서 일어나므로 주소가 calcResult.jsp로 바뀌지 않는다.
				.forward(request, response);
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
