package ch04;

class SubThread implements Runnable {

	// 자바의 서브 스레드
	@Override
	public void run() {

		for (int i = 1; i < 6; i++) {
			try {
				System.out.print("서브스레드 : " + i + " ");
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx01 {
	// 자바의 메인 스레드
	public static void main(String[] args) {

		SubThread st = new SubThread();
		// 서브스레드 실행조건
		// Thread 객체 만들기
		Thread t1 = new Thread(st);

		t1.start();
		for (int i = 1; i < 6; i++) {
			try {
				System.out.print("메인스레드 : " + i + " ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
