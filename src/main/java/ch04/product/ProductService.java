package ch04.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// model(모델)
// 1. 직접적으로 Database와 대화를 한다. (데이터 저장, 수정, 삭제, 조회 요구)
// 2. 컨트롤러에게 요청을 받아 Database에서 가져온 데이터를 전달해준다.
public class ProductService {
	// 데이터베이스를 연결하지 않았으므로 데이터를 임의로 만들어준다.
	// 데이터베이스에서 select 해온 상품 리스트(라고 가정)
	Map<String, Product> products = new HashMap<>();

	// 생성자
	public ProductService() {
		Product p = new Product("101", "애플사과폰 12", "애플전자", 120000, "2020.12.12");
		products.put("101", p);
		p = new Product("102", "삼성우주폰 21", "삼성전자", 130000, "2021.2.2");
		products.put("102", p);
		p = new Product("103", "엘스듀얼폰", "엘스전자", 150000, "2021.3.3");
		products.put("103", p);
	}

	// 상품리스트를 리턴해주는 메소드
	public List<Product> findAll() {
		// product 객체가 저장된 HashMap -> ArrayList로 변경 후 리턴
		return new ArrayList<>(products.values()); // product 객체가 담긴 ArrayList 리턴
	}

	// 상품코드로 상품 객체를 리턴해주는 메소드
	public Product find(String id) {
		return products.get(id); // 상품코드(key값)를 이용해서 product 객체를 받아온다.
	}
}
