package ch03;

class 호랑이 {
	String name = "호랑이";
}

class 사자 {
	String name = "사자";
}

class 큰바구니<T> {
	T data;
}

public class GenericEx02 {

	public static void main(String[] args) {

		큰바구니<호랑이> s1 = new 큰바구니<>();

		s1.data = new 호랑이();
		System.out.println(s1.data.name);

		큰바구니<사자> s2 = new 큰바구니<>();
		s2.data = new 사자();
		System.out.println(s2.data.name);
	}

}
