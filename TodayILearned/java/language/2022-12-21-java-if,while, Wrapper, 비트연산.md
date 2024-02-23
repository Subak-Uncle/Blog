---
layout: single
title: "[JAVA] 풀스택 과정 3일 차 :Bit연산, Wrapper, If, Switch, For, While"

categories: JAVA
tags: [java, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2022-12-21
last_modified_at: 2023-01-03

sidebar:
  nav: "docs"
---



## Bit Operator

~~~java
package sample07_BiOperator;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	bit 연산
		 	정수 타입의 데이터를 2진수로 계산하는 연산자
		 	bit : 0, 1
		 	
		 	&	AND
		 	|	OR
		 	^	XOR	사용빈도 수 제일 높음
		 	<<	Left Shift
		 	>>	Right Shift
		 	~	NOT
		 	
		 */
		
		//	AND
		int number = 0x71 & 0x8a;	// 0111	0001 AND 1000 1010
		System.out.println("number = " + number);	// 0, 0000 0000
		
		//	OR
		int number1 = 0x71 | 0x8a;	// 0111 0001 OR 1000 1010 = 1111 1011
		System.out.println("number1 = " + number1);	//	10진수 251
		System.out.printf("number1 16진수 = 0x%x \n", number1);	//	16진수 0xfb
		
		//	XOR	-> 보안	*같은 비트일 때 0, 다른 비트일 때 1
		int number2 = 0x71 ^ 0x85;	// 0111 0001 XOR 1000 0101 = 1111 0100
		System.out.println("number2 = " + number2); // 10진수 244
		System.out.printf("number2 16진수 = 0x%x \n", number2); // 16진수 0x71
		
		int number3 = 0xf4 ^ 0x85; // 1111 0010 XOR 1000 0101 = 0111 0111 
		System.out.println("number3 = " +number3); // 10진수 113
		System.out.printf("number3 16진수 = 0x%x \n", number3); // 16진수 0x71
		
		//	left shift == *2
		short sh;
		sh = 0x1 << 3;	// 0001 왼쪽으로 shift 3 = 1000
		System.out.println(sh);	// 10진수 8
		
		// right shift == /2
		sh = 0x8 >> 1;	// 1000 오른쪽으로 shift 1 = 0100
		System.out.println(sh); // 10진수 4
		
		//	~ 반전 0 -> 1	1 -> 0
		byte by = ~0x55; // 0101 0101 not -> 1010 1010
		System.out.printf("%x \n", by); // 16진수 AA
	}

}
~~~



## Wrapper

~~~java
package sample08_wrapper;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	wrapper class	*활용도 높음!
		 	일반 자료형(int, char, long)을 class로 만들어 놓은 것
		 	
		 	일반 자료형		wrapper class   // 일반 자동차		튜닝한 자동차
		 	boolean			Boolean
		 	byte			Byte
		 	short			Short
		 	int				Integer			--->
		 	long			Long
		 	float			Float
		 	double			Double			--->
		 	char			Character
		 	char[]			String			--->
		 	
		 	class 사용 시에는 동적 할당
		 	
		 	클래스명 변수(클래스) = new 클래스명();
		 	클래스명 변수(클래스) = 값;
		 	String str = "hello";
		 */
		
		char c = 'a';
		char cArr[] = { 'h', 'e', 'l', 'l', 'o'};
		System.out.println(cArr);
		
		//// 위는 일반 변수, 아래는 래퍼클래스
		int i = 123;
		Integer iobj = 123;
		Integer iobj2 = new Integer(123);	// 버전이 높아지면서 윗 줄처럼 사용하길 권장
		
		System.out.println("i = " + i);
		System.out.println("iobj = " + iobj);
		System.out.println("iobj2 = " + iobj2);
		
		double d = 123.456;
		Double dobj = 123.456;
		System.out.println("d = " + d);
		System.out.println("dobj = " + dobj);
		
		String str = "hello world"; //	제일 많이 씀.
		str = "I can do it";
		System.out.println("str = " + str);
		
		//	문자열 -> 숫자
		String numStr = "123"; // 문자열
		int number = Integer.parseInt(numStr);	//	숫자로 변환
		System.out.println("number = " + number);
		
		/* 
		 	문자열 많이 쓰는 이유
			: 숫자는 메모리 한계가 존재.
			
			long l = 12; -> 메모리 과대포장
			int n = 123154342231 -> error
			String n = "123154342231" -> 가능
		 */
		
		
		//	숫자 -> 문자열
		Integer oNumber = 12345;
		// String str1 = oNumber.toString();	// 안 써도 상관x
		String str1 = oNumber + "";		// 이것도 가능(이걸 더 많이 씀)
		System.out.println("str1 = " + str1);
		
		// 10진수 -> 2진수(문자열)
		int number1 = 67;
		String str2 = Integer.toBinaryString(number1);
		// 10진수를 2진수 문자열 모양으로 넘겨줄게~
		System.out.println("str2 = " + str2);	// 100 0011
		
		// 10진수 -> 16진수(문자열)
		String str3 = Integer.toHexString(number1);
		System.out.println("str3 = " + str3);
		
		// Integer
		// 2진수 -> 10진수
		int num2 = Integer.parseInt(str2, 2);
		System.out.println("num2 = " + num2);
		
		// 16진수 -> 10진수
		
		// String : 문자열의 저장, 편집, 정보취득
		// String str4 = "";
		String str4 = null;
		System.out.println(str4);
		
		String str5 = new String("hello");
		String str6 = "world";

		
		// 문자열 합하기
		String str7 = str5 + str6;
		System.out.println(str7);
		
		String str8 = str5.concat(str6); // connect cat
		System.out.println(str8);
		
		
		//	문자열 비교
		String str9 = "world";
		String str10 = "world";
		
		boolean b = str9.equals(str10);
		System.out.println(b);
		
		//	문자의 위치
		String str11 = "abcabcabc";
		int n = str11.indexOf("c"); // 문자의 위치 값 저장
		System.out.println("n = " + n);	// 0번부터 시작하므로 n=2
		
		int n1 = str11.lastIndexOf("c");
		System.out.println("n1 = " + n1);
		
		//	문자열의 길이
		int len = str11.length();
		System.out.println("len = " + len);
		
		//	문자열을 수정
		String str12 = "A*B*C*D";	// *을 없애주고 싶다.
		String replaceStr = str12.replace("*", "-");	// -로 변경
		System.out.println(replaceStr);
		String replaceStr1 = str12.replace("*", "");		// *지우기
		System.out.println(replaceStr1);
		String str12_1 = "새벽 눈에 종종걸음 출근길";
		String replaceStr_1 = str12_1.replace(" ", "");
		System.out.println(replaceStr_1);
		
		
		//	문자열 자르기
		String str13 = "홍길동-24-2001/10/16-서울시";
		
		// 범위 
		String subStr = str13.substring(4, 6);
		// 4,5열만 가지고 오고 싶을 때 (시작, 끝) 6 미포함
		System.out.println(subStr);
		
		String subStr1 = str13.substring(7);
		// (시작점) 시작점(포함)부터 끝까지 추출
		System.out.println(subStr1);
		
		
		// token(기호) -> '-', '*', '/' 등
		String split[] = str13.split("-");	// split -> 토큰을 기준으로 번지를 나누다.
		System.out.println(split.length);	// 번지 수
		
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
		System.out.println(split[3]);
		
		
		//	공백을 제거
		String str14 = "  java java    java      ";
		String trimStr = str14.trim();	// 문자열 앞 뒤 공백을 제거. 검색을 예로 듦.
		System.out.println(trimStr);
		
		//	?번째인지 숫자를 넣으면 위치값에 해당되는 문자를 돌려준다
		String str15 = "가나다라마";
		char c1 = str15.charAt(2);
		System.out.println("c1 = " + c1);
	
		// 문자를 (비교)탐색
		String str16 = "서울시 강남구 역삼동";
		boolean b1 = str16.contains("강남"); // 해당 문구가 들어있는지 확인
		System.out.println(b1);
				
		
	}

}
~~~



## IF

~~~java
package sample09_if;

public class MainClass {

	public static void main(String[] args) 
	{
		
		// if
		/*
		 	>, <, >=, <=, ==, != 대소비교, 값을 비교
		 	&&. ||, ! 논리 연산자와 같이 사용하는 경우가 많다.
		 	
		 	형식 :
		 		if( 조건 ) // -> 논리(true/false)
		 		{	조건 true -> {} 실행
		 		
		 		}
		 		조건 false 시 {} 건너 뜀.
		 		
		 */
		
		int number = 7;
		
		if(number > 0) { 
			System.out.println("number은 0보다 큽니다.");
		}

		if(number == 7) {
			System.out.println("number은 7 입니다.");
		}
		if(number < 6) {	// false -> if문 안 거침~
			System.out.println("number은 6보다 작습니다.");
		}
		
		if (number > 0 && number <= 10) { // 1~10 범위
			System.out.println("number은 1~10 사이 어딘가~");
			
		}
		if (number > 0 || number <= 5){
			System.out.println("뀨?");
		}
		
		/*
		 * if( 조건 ) {
		 * 		처리1
		 * }
		 * else {
		 * 		처리2
		 * }
		 */
		
		int count = 8;
		
		if (count < 6) {
			System.out.println("number은 6보다 작습니다.");
		}
		else {
			System.out.println("number은 6보다 크거나 같습니다.");
		}
		
		
		char c = 'A';
		
		if (c == 'a') {
			System.out.println("Nope!");
		}
		else {
			System.out.println("c = 'a'가 아닙니다.");
		}
		
		
		// 삼항연산자
		String str = (c == 'a' ) ? "c= 'a'입니다":"c = 'a'가 아닙니다";
		System.out.println(str);
		
		
		// else if
		count = 85;
		
		if (count >= 90) {
			System.out.println("A 학점입니다.");
		}
		else if (count >= 80) {
			System.out.println("B 학점입니다.");
		}
		else if (count >= 70) {
			System.out.println("C 학점입니다.");
		}
		else {
			System.out.println("재시험 대상자입니다.");	
		}
		
		boolean b;
		b = true;
		if (b == true) {
			System.out.println("b == true 입니다.");
		}
		if (b) {
			System.out.println("b == true 입니다.");
		}
		
		b = false;
		if (b == false) {
			System.out.println("b == false");
		}
		if (!b) {
			System.out.println("b == false");
		}
		
		
		String str1 = "worl";
		str1 = str1 + "d";
		System.out.println("str1 = "+ str1);
		
		
		// 이러면 if문 실행 안됨.
		// 한 자 한자 비교하는 것이 아님. 문장 끝나고 붙는 것이 있음.	
		 if (str1 == "world") {
			System.out.println("str1은 world 입니다.");
		}
		
		
		// equals #문자열 비교는 equals를 사용하자!
		if (str1.equals("world") == true) { // == true 생략 가능
			System.out.println("equals str1은 world 입니다.");
		}
		
		
		// 이중 if문
		count = 95;
		
		if (count >= 90) {
			if (count >=95) {
				System.out.println("A+");
			}
			else {
				System.out.println("A");
			}
		}
		
		if(count >= 90 && count <= 100) {
			System.out.println("A+");
		}
		else if (count >= 90 && count <95) {
			System.out.println("A");
		}
		
		
		
		}

	}
~~~





## Switch

~~~java
package sample10_switch;

public class MainClass {
	public static void main(String[] args) {
		
		/*
		  	switch	조건 분기 제어문
		  	
				값이 명확해야 한다.
				범위 설정 불가.
				소수(실수)값을 사용할 수 없다.
				조건문 보다 속도가 빠르다.
				
				형식 :
				
				switch( 변수 ){
					case 1:		1 == 값		=> if(변수 ==1)
						처리1
						break;
					case 2:
						처리2
						break;
						 :
						 :
					case n:
						처리n
						break;
					default:	// if문의 else 역할 ㅣ 나머지 조건
						해당되는 값을 없을 시에 실행
						생략이 가능
			
					}
				
		 
		 */
		
		
		int choice;
		
		choice = 2;
		// case 순서는 섞여도 상관 없다.
		switch (choice) {
			case 1:
				System.out.println("처리1");
				break;
			case 2:
				System.out.println("처리2");
				break; // break 빼먹을 시 해당 case와 밑에 case가 동시 실행
			case 3:
				System.out.println("처리3");
				break;
			default:
				System.out.println("1~3이 아닙니다.");
				break;
		}
		
		
		/*
		 범위 설정 불가하다.
		 switch( choice ) {
		 	case choice > 2:
		 		break;
		 }
		 */
		
		/*
		double d = 1.2;
		swich(d){
			case 1
		}
		*/
		
		}
	}
~~~



## for

~~~java
package sample11_for;

import java.util.Iterator;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	for : 루프문, 순환문
		 	
		 	목적 : 원할(조건이 참) 때까지 반복처리하는 제어문
		 	
		 	형식 :
		 			for( 초기화 ; 조건식 ; 연산식 ){
		 					처 리
		 			}
		 			
		 			int i;
		 			for( i=0 ; i < 5 ; i++){
		 					처 리
		 			}
		 				
		 				배열 변수 -> 변수 선언에 저장
		 			for( 변수 선언 : 배열 변수) {
		 				실행문
		 			}
		 			
		 */
		
		int i;
		
		for (i=0 ; i<5 ; i++) {
			System.out.println("for loop i = " + i);
		}
		System.out.println("i = " + i);
		
		/*
		for(i =1; i <= 100; i++) {
			System.out.println("for loop "+ i);
		}
		*/
		
		for (i = 0; i < 10; i = i + 2) {
			System.out.println("for loop"+ i);
		}
		
		for ( i = 10; i > 0; i--) {
			System.out.println("for loop "+ i);
		}
		
		/* 무한 루프
		 for (i = 0; ; i++) {	// 오류는 안 뜸.
		 	System.out.println("for loop" + i);
		 	}
		 */
		for(int j=0 ; j<10; j++) { // for문 안에서만 j 이용가능
			System.out.println("for loop " + j);
		}
		
		// 2중 for
		for(int n = 0; n < 5; n++) { // n = 0 1 2 3 4
			System.out.println("for n = " + n);
			
			for(int k=0; k<3; k++) { // k = 0 1 2
				System.out.println("\tfor k = "+ k);
			}
		}
		
		// for + if + array
		
		int array[] = { 2, 4, 5, 6, 8 };
		
		for(i = 0; i < 5; i++)	{
			System.out.println(array[i]);
		}
		
		
		for( i = 0; i < array.length; i++) {
			if(array[i] == 6) {
				System.out.println("6 찾았습니다.");
			}
			else {
				System.out.println(array[i]);
			}
		}
		
		// 홀수 찾기
		for(i = 0; i < array.length; i++) {
			if(array[i] % 2 ==0) {
			System.out.println("홀수는 " + array[i] + "입니다.");
			}
		}
			
		
		
		
		
		
		
		
	}

}
~~~





## While

~~~java
package sample12_while;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	while : loop 문
		 	
		 	형식 :
		 		초기화
		 		
		 		while(조건) {		if(조건){
		 		
		 			처리					처리
		 			
		 			연산식
		 			}
		 			}
		 */
		
		int w;
		
		w = 0;	//	초기화
		while(w < 5) {
			System.out.println("while loop" + w);
			
			w++; // 연산식 필수! -> 없으면 무한루프
		}
		
		/* 무한루프 돌릴 때는 while true를 쓴다.
		while(true){
		}
		*/
		
		// 2중 while문
		
		// for문과 비교
		for(int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
			for(int j =0; j < 3; j++) {
				System.out.println("\tj = "+ j);
			}
		}
		
		int w1 , w2;
		w1=0;
		
		while( w1 < 5) {
			System.out.println("w1 = " + w1);
			w2=0;	// w2 while문을 실행시키기 위한 조건 초기화
			while(w2 < 3) {
				System.out.println("\tw2 = " + w2);
				w2++;
			}
			w1++;
		}
		
		/*
		 	do while문   *거의 안 씀;
		 	
		 	형식 : 
		 			do{
		 				처리
		 				
		 				연산식
		 				}while(조건);
		 */
		
		int w3;
		w3 = 0;
		
		do {
			System.out.println("do while " + w3);
			
			w3++;
			
		}while(w3 < 5);
		/* 많이 안 쓰는 이유 :
		 	조건이 뒤에 있어서 조건이 안 맞는 경우에도 루프문이 한번은 실행됨.
		 */
		
		// while, if, array 합
		int array[] = { 2, 4, 5, 6, 7, 8}, i;
		i=0;
		
		while(i<array.length) {
			System.out.println(" array = " + array[i]);
			i++;
		}
		
		i=0;
		while(i<array.length) {
			if(array[i] % 2 == 1) {
				System.out.printf("array[%x]의 값은 %x이므로 홀수입니다.\n", i, array[i]);
			}
			else if(array[i] % 2 == 0){
			System.out.printf("array[%x]의 값은 %x이므로 짝수입니다.\n", i, array[i]);
			}
			i++;
		}
		
		
		} // 끝
}
~~~

