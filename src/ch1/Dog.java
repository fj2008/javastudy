package ch1;


public class Dog {

	int age; 
	String name; 
	
  
    //이렇게 강아지라는 클래스를 가지고 필드는 초기화 하지 않고 
    //Dog가 태어날때마다 생성자를 통해서 다양성을 가질수 있도록 해야한다.
    //java에서 Dog가 태어날려면 new연산자를 사용해야한다
    public Dog(String n, int a ) {
		//생성자
    	//Dog() 생성자를 디폴트 생성자라고 한다.
    	//개발자가 직접 적지 않아도 되는것
    	//개발자가 직접 생성자를 구현하게 되면 디폴트 생성자가 생략될 수 없다.
    	System.out.println("고양이 탄생함");
    	System.out.println(" N :" + n);
    	System.out.println("a : "+ a);
    	
	}
}
