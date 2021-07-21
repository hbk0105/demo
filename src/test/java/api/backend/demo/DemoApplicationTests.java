package api.backend.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {

		try {
			System.out.println("생성자");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ");
			try {
				conn.close();
			} catch (SQLException e1) {    }
		}


	}


	private Connection conn; //DB 커넥션 연결 객체
	private static final String USERNAME = "root";//DBMS접속 시 아이디
	private static final String PASSWORD = "root";//DBMS접속 시 비밀번호
	private static final String URL = "jdbc:mysql://192.168.0.83:3307/test_db";//DBMS접속할 db명


}
