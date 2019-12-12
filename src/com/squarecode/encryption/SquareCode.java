package com.squarecode.encryption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SquareCode {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		String s = sc.nextLine();
		
		sc.close();
		
		String str= s.trim().toLowerCase().replaceAll("( )+","");
	
		String[] arrStr= str.split("");
		
		final int ARRAY_SPLIT_SIZE=8;
		
		List<String> liArrStrings = new LinkedList<String>(Arrays.asList(arrStr));
				
		int noOfArrays = arrStr.length/ARRAY_SPLIT_SIZE;
		
		Map<Integer,List<String>> mp = new HashMap<Integer,List<String>>();
		
		for(int i=0;i<noOfArrays;i++)
		{
			List<String> li = new LinkedList<String>();
			
			while(!liArrStrings.isEmpty())
			{
				if(li.size()<ARRAY_SPLIT_SIZE)
				{
					li.add(liArrStrings.get(0));
					
					liArrStrings.remove(0);
				}
				else
				{
					break;
				}
			}
			
			mp.put(i, li);
		}
	
		for(int i=0;i<ARRAY_SPLIT_SIZE;i++)
		{
			for(int k :mp.keySet())
			{
				List<String> liMap = mp.get(k);
				if(liMap.size()<ARRAY_SPLIT_SIZE)
				{
					int diff=ARRAY_SPLIT_SIZE-liMap.size();
					for(int j =1;j<=diff;j++)
					liMap.add(liMap.size()+1, "");
					System.out.print(liMap.get(i));
				}
				else
				{
				System.out.print(liMap.get(i));
				}
			}
			
			System.out.print(" ");
		}
		
		
	}

}
