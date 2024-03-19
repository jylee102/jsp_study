package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 실행");
		// req: 클라이언트로부터 받아온 request 데이터들이 있는 객체
		// resp: 클라이언트로 전송할 response 데이터들을 넣어주는 객체
		
		// response해주기
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("<h2>Hello world!</h2><hr>")
		.append("현재 날짜와 시간은: " + java.time.LocalDateTime.now())
		.append("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 실행");
		doGet(req, resp); //post로 request가 와도 doGet 메소드를 무조건 실행
	}

}
