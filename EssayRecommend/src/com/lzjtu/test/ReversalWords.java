package com.lzjtu.test;

import java.util.Scanner;

public class ReversalWords {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String output = reversal(input);
		System.out.println(output);
	}

	private static String reversal(String input) {
		String[] ss = input.split(" ");
		StringBuilder ssb = new StringBuilder();
		for(int i = ss.length - 1 ; i > 0 ; i --) {
			ssb.append(ss[i]).append(" ");
		}
		ssb.append(ss[0]);
		return ssb.toString();
	}
}
