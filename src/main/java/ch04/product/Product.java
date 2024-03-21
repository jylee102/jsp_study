package ch04.product;

// DO(혹은 DTO 파일) => 컨트롤러와 모델이 데이터를 주고 받을 때 데이터를 감싸는 택배상자와 같은 역할
public class Product {
	private String id; // 상품코드
	private String name; // 상품명
	private String maker; // 제조사
	private int price; // 상품가격
	private String date; // 상품 등록일

	public Product(String id, String name, String maker, int price, String date) {
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
