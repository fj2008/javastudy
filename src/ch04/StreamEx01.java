package ch04;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx01 {

	public static void main(String[] args) {
		InputStream in = System.in; //키보드에 연결된 스트림
		//Byte Stream이 연결됐다. 
		InputStreamReader ir = new InputStreamReader(in);// 97을 a로 부호화시켜준다.
		//InputStreamReader의 단점은 데이터를 가변적으로 받을수 없다는 단점이 있다.
		
		try {
		int data = 	in.read(); //2진수를 10진수로 변환해서 읽어진다.
		System.out.println(data);
		} catch (IOException e) {
			//IOException은 데이터가 전류를 통해서 이동하는 와중에 전선에 문제가 생기거나해서
			//생길수 있는 오류를 미연에 방지하는 예외처리이다
			e.printStackTrace();
		} 
	}
}
