package ch1;

public class People {

	String name;
	int age;
	
	//디폴트 생성자는.java가 .class파일로 컴파일할때 java가 자동으로 만들어준다.
	
	public People(String name, int age) {
		System.out.println(" 메서드 스택 name : " + name);
		System.out.println(" 메서드 스택 age : " + age);
	}
}
