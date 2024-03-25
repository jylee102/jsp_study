package ch04.studentInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	Connection conn = null; // Connection:데이터베이스의 연결을 담당
	PreparedStatement pstmt; // PreparedStatemen: 쿼리문의 실행을 담당

	// jdbc 뜻: 자바와 DB를 연결해주는 api -> ojdbc6.jar
	final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// DB연결 메소드
	public void open() {
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); // DB 연결
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB연결 닫는 메소드
	public void close() {
		try {
			// pstmt, conn은 리소스(데이터 읽고 쓰는 객체)이므로 사용 후 반드시 닫아줘야 한다.
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB에서 학생 정보를 불러오는 메소드
	public ArrayList<Student> getAll() {
		open(); // DB 오픈
		ArrayList<Student> students = new ArrayList<>(); // student객체를 담을 리스트 준비

		try {
			pstmt = conn.prepareStatement("select * from student"); // 실행할 쿼리문 입력
			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행(select문 사용시 이용), ResultSet: DB 데이터를 받는 역할

			while (rs.next()) { // 한 행씩 값이 있는지 없는지 판단한다.
				// 레코드 하나당 하나의 student 객체를 생성
				Student s = new Student();

				s.setId(rs.getInt("id"));// 매개변수: 컬럼명
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));

				// 학생 레코드별 값이 저장된 student 객체를 ArrayList에 추가 -> 총 4명의 학생 객체가 저장됨
				students.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // DB연결 항상 닫기!
		}

		return students;
	}

	// DB에 학생 정보를 저장하는 메소드
	public void insert(Student s) {
		open();

		try {
			pstmt = conn.prepareStatement("INSERT INTO STUDENT VALUES(id_seq.NEXTVAL,?,?,?,?)");

			// insert할 데이터를 넣어준다. setString(순서, 넣을 데이터)
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());

			pstmt.executeUpdate(); // insert, delete, update 실행시
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
