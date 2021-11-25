package ch2;

class 프로토스유닛{
	String name = "프로토스유닛";
	void 기본공격(프로토스유닛 e1) {
		
		System.out.println("프로토스유닛 메서드");
		
	}
	String 이름확인 () {
		return "";
		
	}
}

class 질럿 extends 프로토스유닛 {
	String name ="질럿";
	void 기본공격(프로토스유닛 e1) {
//		System.out.println("질럿 메서드");
		System.out.println("질럿이 "+e1.이름확인()+" 공격합니다");
	}
}
class 드라군 extends 프로토스유닛{
	String name = "드라군";
}
class 다크템플러 extends 프로토스유닛{
	String name = "다크탬플러";
}

public class OOPEx06 {

	public static void main(String[] args) {
	
		프로토스유닛 u1 = new 질럿();// heap영역에(질럿, 프로토스 유닛)이뜨고 프로토스유닛을 바라본다
		프로토스유닛 u2 = new 드라군();// heap영역에(드라군, 프로토스 유닛)이뜨고 프로토스유닛을 바라본다
		프로토스유닛 u3 = new 다크템플러();// heap영역에(다크탬플러, 프로토스 유닛)이뜨고 프로토스유닛을 바라본다
		
		u1.기본공격(u2);
	}

}
