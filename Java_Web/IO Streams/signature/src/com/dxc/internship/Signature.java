package com.dxc.internship;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Signature {

	public static void main(String[] args) throws IOException{
		//File fileInput = new File("../input.txt");
		//Tying with redirect java com.dxc.internship.Signature < ../input.txt | sort  | java com.dxc.internship.Squash | find " " > ../output.txt
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
				String word = scanner.next();
				String [] elaborated = word.split(""); 
				Arrays.sort(elaborated); 
				System.out.println(String.join("",elaborated)+" "+word);
				
				
			} 
	}

}
