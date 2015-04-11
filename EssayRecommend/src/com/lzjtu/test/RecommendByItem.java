package com.lzjtu.test;

public class RecommendByItem {
	public static void main(String[] args) {
		String ss = "  s s s s  s s      ";
		String[] s1 = ss.split(" ");
		System.out.println(s1.length);
		System.out.println("".isEmpty());
		for (int i = 0; i < s1.length; i++) {
			
			if(s1[i] != "") System.out.println(s1[i]);
		}
		
	}
}
