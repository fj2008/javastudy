package ch2;

class 요리사 {
	String name = "요리사";
}

//요리사를 상속받으면 다형성이 생겨서
//해당클래스는 홍길동이기도하고 요리사이기도 한 상태가 된다.
class 홍길동 extends 요리사{
	String name = "홍길동";
}

public class OOPEx03 {

	public static void main(String[] args) {
		
		홍길동 h1  = new 홍길동(); // heap (홍길동, 요리사)로 떴지만 타입이 홍길동이기때문에 홍길동을 바라본다
		System.out.println(h1.name);
		
		요리사 y1 = new 홍길동(); //heap (홍길동, 요리사)로 떴지만 타입이 요리사이기때문에 요리사를 바라본다.
		System.out.println(y1.name);
		
		
		
	}

}
