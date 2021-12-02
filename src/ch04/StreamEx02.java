package ch04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

	public static void main(String[] args) {
		InputStream in = System.in; //키보드에 연결된 스트림
		 
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		try {
			
			String data = br.readLine();
			System.out.println(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
