package backtracking;

import java.util.Scanner;

public class Permutation {
	String swapInteger(String aString, int left, int right)
	{
		char[] charArray =aString.toCharArray();
		char temp=charArray[left];
		charArray[left]= charArray[right];
		charArray[left] = temp;
		return String.valueOf(charArray);
		
	}
	void permute(String aString, int left, int right)
	{
		if(left==right)
		{
			System.out.println(aString);
		}
		for(int i =left;i<=right;i++)
		{
			aString=swapInteger(aString, i, left);
			permute(aString, left + 1, right);
			aString = swapInteger(aString, i,left);
		}
		
	}
	public static void main(String[] args)
	{
		System.out.println("Enter String: ");
		Scanner sc = new Scanner(System.in);
		String testCase = sc.nextLine();
		Permutation permutation = new Permutation();
		permutation.permute(testCase, 0,testCase.length() - 1) ;
		
	}

}
