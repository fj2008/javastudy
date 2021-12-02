package ch04;

public class StringEx01 {

	public static void main(String[] args) {
		String s1 = new String("바다");
		String s2 = new String("바다");
		
		System.out.println(s1 == s2);
		
		String s3 ="바다";
		String s4 ="바다";
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s3 == s4);
	}
}
