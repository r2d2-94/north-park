package graphs;
import java.util.Scanner;

public class kmp {
	public static void main(String[] args)
	{
		String aString,patternString;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter parent String");
		aString = sc.nextLine();
		
		patternString = sc.nextLine();
		
		int[] preArray = new int[patternString.length()];
		
		int i=0;
		generatepreArray(preArray,patternString);
		for(i=0;i<patternString.length();i++)
			System.out.println(preArray[i]);
		
	}
	static void generatepreArray(int[] preArray,String patternString)
	{
		int i=0;
		int length = patternString.length()-1;
		for(i=0;i<patternString.length();i++)
		{
			
			int j;
			int match=0;
			for (j=0;j<=i;j++)
			{
				if(patternString.regionMatches(0, patternString, length, i))
				{
					match++;
				}
				else 
					break;
			}
			preArray[i]=match;
			match=0;
		}
	}

}
