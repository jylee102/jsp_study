package ch04.product;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//controller(컨트롤러)
// 1. view로부터 request를 받는다.
// 2. model한테 데이터를 전달해 요청(조회, 수정, 삭제)한다.
// 3. model로부터 전달받은 데이터를 가공해 view에 forward 해준다.
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService service;

	// init: 서블릿 초기화 담당. 톰캣을 실행 후 서블릿 객체가 만들어질 때 딱 1번만 실행
	// init() 메소드 안의 코드는 딱 한 번만 실행이 된다.
	// ProductService() 객체를 딱 한 번만 생성한다.(여러 번 생성하지 X)
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // 서블릿 초기화
		service = new ProductService();
	}

	// service: 모든 request룰 받아 doGet() 메소드를 실행할지 doPost() 메소드를 실행할지 정해준다.
	// 따라서 모든 request는 service()메소드에서 우선적으로 처리 가능
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action"); // 두 번째 페이지 request 할 때에는 action값이 존재
		String view = "";

		if (action == null) { // 최초로 페이지 request 할 때 실행되는 부분
			getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(req, resp);
		} else {
			switch (action) {
			case "list":
				view = list(req, resp);
				break;
			case "info":
				view = info(req, resp);
				break;
			}
			getServletContext().getRequestDispatcher("/ch04/product/" + view).forward(req, resp);
		}
	}

	private String list(HttpServletRequest req, HttpServletResponse resp) {
		// product 객체가 들어있는 ArrayList(상품리스트)를 request 객체에 넣어줌
		req.setAttribute("products", service.findAll());
		return "productList.jsp";
	}

	private String info(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id"); // 쿼리스트링의 id값(상품코드)을 가져온다.
		req.setAttribute("p", service.find(id));
		return "productInfo.jsp";
	}
}
