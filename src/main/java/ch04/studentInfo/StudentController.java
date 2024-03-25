package ch04.studentInfo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new StudentDAO(); // 서블릿 초기화시 StudentDAO객체가 딱 한 번만 생성
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // view 페이지에서 넘어오는 한글 데이터 깨짐 방지

		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			getServletContext().getRequestDispatcher("/studentControl?action=list").forward(request, response);
		} else {
			switch (action) {
			case "list":
				view = list(request, response);
				break;
			case "insert":
				view = insert(request, response);
				break;
			}

			getServletContext().getRequestDispatcher("/ch04/studentInfo/" + view).forward(request, response);
		}
	}

	// StudentDAO 객체(model)에서 학생리스트를 불러와 request 객체에 저장한다.
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("students", dao.getAll());
		return "studentInfo.jsp";
	}

	// 입력받은 학생 데이터를 StudentDAO 객체(model)를 통해 insert해준다.
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Student s = new Student();

		try {
			BeanUtils.populate(s, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

		dao.insert(s);

		/*
		 * BeanUtils 라이브러리가 아래 코드를 대신 처리해준다. -> request 객체를 Student 객체로 변경해줌
		 * 
		 * s.setUsername(request.getParameter("username"));
		 * s.setUniv(request.getParameter("univ"));
		 * s.setEmail(request.getParameter("email"));
		 * 
		 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd"); Date date
		 * = (Date)formatter.parse(request.getParameter("birth")); s.setBirth(date);
		 */

		return "studentInfo.jsp";
	}
}
