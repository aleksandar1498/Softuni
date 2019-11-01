package com.dxc.internship;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

final class Signature {
	
	private Signature() {
		// Utility Class 
	}
	public static void signData(InputStream in,PrintStream out) {
		Scanner scanner = new Scanner(in);
		while(scanner.hasNext()) {
			String word = scanner.next();
			String [] elaborated = word.split(""); 
			Arrays.sort(elaborated); 
			out.print(String.join("",elaborated)+" "+word+"\n");
		} 
	}
	
	/*public static void main(String[] args) throws IOException{
		//Tying with redirect java com.dxc.internship.Signature < ../input.txt | sort  | java com.dxc.internship.Squash | find " " > ../output.txt
		Scanner scanner = new Scanner(System.in);
		signData(System.in, System.out);
	}*/

}
