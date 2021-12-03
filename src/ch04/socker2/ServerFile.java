package ch04.socker2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	// 클라이언트 연결을 받는소켓
	ServerSocket serverSocket;
	// 실재 통신을 하는 소캣
	Socket socket;
	BufferedReader br;

	public ServerFile() {
		System.out.println("1. 서버소켓 시작-------------------------------------------------------");
		try {
			serverSocket = new ServerSocket(10000);

			System.out.println("2. 서버소켓 생성완료 : 클라이언트 접속 대기중 ----------------------------------------------");
			socket = serverSocket.accept();// 클라이언트 접속 대기중....
			System.out
					.println("3. 클라이언트 연결완료 -buffer 연결완료 (읽기 버퍼)-----------------------------------------------------");

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// socket.getInputStream()는 클라이언트 소켓을 ByteSream으로 연결후 br에 버퍼를 달았다.
			//버퍼를 계속 만들필요는없기때문에 메시지를 받는곳만 반복
			while (true) {
				
				String msg = br.readLine();
				System.out.println("4. 클라이언트로 부터 받은 메시지 : " + msg);
			}

		} catch (Exception e) {
			System.out.println("서버소켓 에러 발생함 : " + e.getMessage());
		}
	}

	public static void main(String[] args) {

		new ServerFile();

	}

}
