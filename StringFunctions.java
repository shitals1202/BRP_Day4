package classwork.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringFunctions{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two strings: ");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int len = str1.length();
		isAnagram(str1,str2);
		ispalindrom(str1);
		generatePermutation(str1,0,len);
		findPermutationIterative(str1);
		checkEquality();
		sc.close();
	}


	private static void checkEquality() {
		String[] array1 = new String[] {"mango", "grapes", "plum", "watermelon", "apple"};   
		String[] array2 = new String[] {"mango", "grapes", "plum", "watermelon", "apple"};  
		
		if (Arrays.equals(array1, array2))   
		System.out.println("Arrays are equal.");   
		else  
		System.out.println("Arrays are not equal.");   
	}   	
	


	private static void findPermutationIterative(String str1) {
		String str = str1.toLowerCase();
		if (str == null || str.length() == 0) {
			return;
		}

		List<String> partial = new ArrayList<>();
		partial.add(String.valueOf(str.charAt(0)));

		for (int i = 1; i < str.length(); i++)
		{
			for (int j = partial.size() - 1; j >= 0; j--)
			{
				String s = partial.remove(j);
				for (int k = 0; k <= s.length(); k++)
				{
					partial.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
				}
			}
		}

		System.out.println(partial);
	}


	private static void generatePermutation(String str1, int start, int end) {
		
		if(start == end-1) {
			System.out.println(str1);
		}
		else {
			for(int i = start;i<end;i++) {
				str1 = swapString(str1,start,i);
				generatePermutation(str1,start+1,end);  
				str1 = swapString(str1,start,i);  

			}
		}
		
	}


	private static String swapString(String a, int i, int j) {
		char[] b =a.toCharArray();  
        char ch;  
        ch = b[i];  
        b[i] = b[j];  
        b[j] = ch;  
        return String.valueOf(b);  
	}


	private static void ispalindrom(String str1) {
		boolean flag =true;
		String string = str1.toLowerCase();
		
		for(int i=0;i<string.length()/2;i++) {
			if(string.charAt(i) != string.charAt(string.length()-i-1)) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("This string is Palindrom");
		}
		else {
			System.out.println("This string is not palindrom");
		}
	}


	private static void isAnagram(String str1, String str2) {
		String s1 = str1.replaceAll("\\s", "");
		String s2 = str2.replaceAll("\\s", "");
		boolean status = true;
		if(s1.length() != s2.length()) {
			status = false;
		}
		else {
			char[] arrays1 = s1.toLowerCase().toCharArray();
			char[] arrays2 = s2.toLowerCase().toCharArray();
			Arrays.sort(arrays1);
			Arrays.sort(arrays2);
			status = Arrays.equals(arrays1, arrays2);
			
			if(status) {
				System.out.println(s1+" and "+s2+ " are anagram");
			}
			else {
				System.out.println(s1+" and "+s2+ " are not anagram");
			}
		}
		
	}
}