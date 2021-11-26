package ch2;

abstract class Animal {
	abstract void speak() ; //추상메서드 몸체인 {}가 없다.
		
	
}

class Dog extends Animal {
	void speak() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	void speak() {
		System.out.println("야옹");
	}
}

public class OOPEx07 {

	public static void main(String[] args) {
		
		Animal d1 = new Dog();
		Animal c1 = new Cat();
		
		d1.speak();
		c1.speak();

	}

}
