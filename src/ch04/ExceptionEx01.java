package ch04;

public class ExceptionEx01 {

	public static void main(String[] args) {
		// 컴파일 예외
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			int[] nums = {1,2,3};
			System.out.println(nums[3]);
		}catch (ArrayIndexOutOfBoundsException e) {
			//catch의 역할은 try 실행도중 예외가 발생하면 어떻게 처리할지를 정의하는 영역이다.
			System.out.println("그냥 진행해 버려!!");
			System.out.println("오류 메시지 : "+e.getMessage());
			e.printStackTrace();//printStackTrace는 오류 추적로고가 찍힌다.
		}
		
		
		
		
		
		System.out.println("메인스레드 종료");
	}

}
