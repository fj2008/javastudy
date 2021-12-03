package ch04.socker3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	// 클라이언트 연결을 받는소켓
	ServerSocket serverSocket;
	// 실재 통신을 하는 소캣
	Socket socket;
	BufferedReader br;

	// 서버에서 쓰기 버퍼
	// 이미 서버는 읽기를 하고 있기때문에 이를 수행하기위해선 새로운 스레드가 필요하다.
	BufferedWriter bw;
	BufferedReader keyboard;// 키보드로 읽는 버퍼 이역시 새로운 스레드가 필요하다.

	public ServerFile() {
		System.out.println("1. 서버소켓 시작-------------------------------------------------------");
		try {
			serverSocket = new ServerSocket(10000);

			System.out.println("2. 서버소켓 생성완료 : 클라이언트 접속 대기중 ----------------------------------------------");
			socket = serverSocket.accept();// 클라이언트 접속 대기중....
			System.out
					.println("3. 클라이언트 연결완료 -buffer 연결완료 (읽기 버퍼)-----------------------------------------------------");

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));// 읽는 버퍼
			// socket.getInputStream()는 클라이언트 소켓을 ByteSream으로 연결후 br에 버퍼를 달았다.
			// 버퍼를 계속 만들필요는없기때문에 메시지를 받는곳만 반복

			keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드 버퍼
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));// 쓰는버퍼
			// 스레드 생성
			// 글 쓰기 스레드
			WriteThread wt = new WriteThread();
			Thread t1 = new Thread(wt);
			t1.start();

			// 메인스래드
			// 글읽기 스레드
			while (true) {

				String msg = br.readLine();
				System.out.println("4. 클라이언트로 부터 받은 메시지 : " + msg);
			}

		} catch (Exception e) {
			System.out.println("서버소켓 에러 발생함 : " + e.getMessage());
		}
	}

	// 내부 클래스
	class WriteThread implements Runnable {

		@Override
		public void run() {
			while (true) {

				try {
					System.out.println("키보드 메시지 입력 대기중--------------------------------");
					String keyboardMsg = keyboard.readLine();

					bw.write(keyboardMsg + "\n");// 메시지끝에 \n으로 끝을 알려준다 통신규칙!
					bw.flush();// 버퍼 비우기
				} catch (Exception e) {
					System.out.println("서버소켓쪽에서 키보드 입력받는 중 오류가 발생했습니다 : " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {

		new ServerFile();

	}

}
