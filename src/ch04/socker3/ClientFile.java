package ch04.socker3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {

	Socket socket;
	BufferedWriter bw;
	BufferedReader keyboard;

	// 읽기 버퍼
	// 세로운 스레드 필요
	BufferedReader br;

	public ClientFile() {
		System.out.println("1. 클라이언트소켓 시작-------------------------------------------------------");
		try {
			socket = new Socket("localhost", 10000);// 해당 소스코드 실행시 서버소켓의 accept() 메서드 호출
			// 내컴퓨터가 서버와 클라이언트를 같이 일을하니까 localhost로 설정
			// 포트번호는 서버와 같이 10000으로 잡아준다.

			System.out.println("2. 버퍼(write)연결 완료-------------------------------------------------------");
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 클라이언트는 써야하기때문에 Output해줘야한다.

			// 키보드 연결
			System.out.println("3.키보드 스트림 + 버퍼(read) 연결완료-------------------------------------------------------");
			keyboard = new BufferedReader(new InputStreamReader(System.in));

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));// 읽는 버퍼

			// 서브스레드(글 읽기 역할)
			ReadThread rt = new ReadThread();
			Thread t1 = new Thread(rt);
			t1.start();

			// 메인스레드(글쓰기 역할)
			// 버퍼를 계속 만들 필요는 없기때문에 메시지를 쓰는부분만 반복
			while (true) {
				System.out.println("4. 키보드 메시지 입력 대기중-------------------------------------------------------");
				String keyboardMsg = keyboard.readLine();
				// 통신의 규칙!!
				// 메세지 끝을 알려줘야한다. \n

				bw.write(keyboardMsg + "\n");
				// 버퍼의 남는 공간을 비워줘야한다.
				bw.flush();

			}

		} catch (Exception e) {
			System.out.println("클라이언트 소켓 에러 발생함 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	class ReadThread implements Runnable {

		@Override
		public void run() {
			// 이번에는 글을 읽어야한다.
			while (true) {
				try {
					String msg = br.readLine();
					System.out.println("서버로 부터 받은 메시지 : " + msg);
				} catch (IOException e) {
					System.out.println("클라이언트 소켓쪽에서 서버소켓 메시지를 입력받는중 오류가 발생했습니다." + e.getMessage());
					e.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) {

		new ClientFile();
	}

}
