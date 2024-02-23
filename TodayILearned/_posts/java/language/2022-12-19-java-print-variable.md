---
layout: single
title: "[JAVA] 풀스택 과정 1일 차 : Print, Variable"

categories: JAVA
tags: [java, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2022-12-19
last_modified_at: 2023-01-02

sidebar:
  nav: "docs"
---

## Java


오늘부터 멀티캠퍼스에서 운영하는 "채용연계형 JAVA 풀스택 과정 11회차"를 학습하게 되었습니다. 배운 과정을 최대한 정리해서 올려보겠습니다!

JAVA 과정에서는 JAVA17 버전과 eclips 편집기를 활용하여 진행하였습니다.

첫 날은 설정 환경 세팅과 **input** 과 **variable** 에 대해 배웠습니다.



## Print

```java
package sample01;

public class MainClass

public static void main(String[] args) {
	System.out.println("헬로우 자바");
	System.out.println("Hello World"); // ln은 줄 바꿈
	System.out.print("Hello"); // 커서 위치 확인(줄 바꿈 없음)
	System.out.print("월드");
	// 기능 : escape sequence
	//		\n(개행) : 행 바꿔라.
	//		\b(backspace) : 한 칸 앞으로

	System.out.print("World \n");
	System.out.println("헬로우");

	// 		\" : "가 있는 채로 출력
	System.out.println("\"Hello world\"");

	//		\t : 띄어 쓰기
	System.out.println("\tHello\tworld");
	System.out.println("\t월드\t헬로");

	// \를 표현하고 싶으면? -> \\로 쓰면 됨
	System.out.println("\\헬로우 월드\\");

	System.out.printf("--%s--\n", "Hello"); // Hello == 문자열(String)
	// 					표현자료형     값
	/*
	 * %b : boolean 형식으로 출력
	 * %d : 정수 형식
	 * %o : 8진수
	 * %x : 16진수
	 * %f : 소수점 형식
	 * %c : 문자형식
	 * %s : 문자열 형식
	 * %n : 줄바꿈 기능
	 * %e : 지수 표현식
	 */
	System.out.println( 1024 ); // 숫자 출력

	System.out.println("Hello" + "World");
	}
	}

// 한 줄 주석문
/*
	범위 주석문
	Html	<!-- -->
	JSP		<%-- --%>
	mySQL 	--
	python # """주석문 """
*/

```



## Variable

```java
package sample02;

public class MainClass {
	public static void main(String[] args) {
		/*

   * 숫자(상수) :
       	* 2진수 : 0, 1
          * 8진수 : 0~7, 8은 10으로 취급,
         	10 -> 12 -> 012
          * 10진수: 0~9
          * 16진수: 0~9 A B C D E F(15)
          	0x000000 -> black
          * 0xffffff -> white
          * 2진수 to 16진수
          * 1010 1100 -> 2진수
          * 8421 8421
          * 8+2=A  8+4=C -> 16진수 -> 0xAC
          *
          * 16진수 to 2진수
          * 0xE5 한 자리 문자마다 2진수 네자리
          * 8421 8421
          * 1110 0101
          * E=1110 5=0101
          *
          * 변수(variable) :
          * 빈 통(공간)에 데이터를 저장할 수 있는 수
          * 데이터의 종류도 다양하다.
          
          변수 선언
          [데이터 타입] 변수 명 = 값
             */

	/* 데이터 종류
		
	1. 일반 타입 
		1) 논리 타입
			True/False로만 값을 가지는 데이터 표현
			boolean, 1 byte
		2) 문자 타입
			char, 2 byte
			한 글자의 값만 가지는 데이터 표현
		3) 정수 타입
			byte, 1 byte, -128 ~ 127
			short, 2 bytes, -32,768 ~ 32,767
			int, 4 bytes, -2,147,483,648 ~ 2,147,483,647
			long, 8 bytes, -2^63 ~ (2^63 -1)
		4) 실수 타입
			float, 4 bytes
			double, 8 bytes
	
    2. 참조 타입
    	메모리 주소 값을 갖는 변수
    	String
       

	  /* 숫자 */

	  // 정수 (byte, short, int, long)
	  // 자료형(byte) 변수(by)
	  byte by;	// 1 byte == 8 bit == 0000 0000
      // byte는 범위가 작아 잘 사용 안 함.
	  by = 12; // 대입
	  by = 25; // <- 값
	  // by = 255; -> error, 8bit에서 첫 번째 칸 : 부호
	  by = -128;// -128 ~ 127

	  short sh; // -> 2byte == 16 bit == 0000 0000 0000 0000
      // 계산기 프로그램에서 word
	  sh = 134;

	  int i; // -> 4byte	short int=2 long int=4 in C
      // 계산기에서 Dword
	  i= 1234567890;

	  long l; // -> 8byte
	  // l = 1234567890123; ->
      //  error 컴파일러에서 int로 인식
	  l = 1234567890123L;

	  //실수(소수) (float, double)
	  float f; // -> 4 byte
	  f = 123.456789f; //f를 붙여줘야 함.
      // f = 123.45679 , 소수점 5자리까지만 출력 == float 4 byte

	  double d; // -> 8 byte
	  d= 234.5678901234;

	  /* 문자열 */

	  //	문자(char) 한 개
	  char c;	// 2 byte
      // character == 2 byte 한 글자 -> ASCII (A~Z, a~z, 특수문자) -> 1 byte
	  c = 'A';  // ''로 해야함, not ""
	  c = '한';
      // c = 'ab'; -> 오류 뜸 : 두 글자

	  //	문자열(String) -> (wrapper)class
	  String str;	// 5 byte
	  str = "Hello";
	  str = "World";

	  //	논리 (true/false)
	  boolean b;	// byte == 1

	  b = false; // = 0 b=0으로 대입하면 안됨.
	  b = true; // =1
      // b = "true", b = 1 -> error

	  /* 변수명 규칙 */
	  int hh; // x
	  int humanHeight; // 권장

	  // int 1abc; -> 숫자가 앞으로 오지 않게!
	  int da;
	  // int char; -> x
	  // int ch sfge; -> 띄어쓰기 안됨
	  // int ABC; 대문자만 쓰는 건 final로 씀
	  int charPositionXdot; // 이슈마다 대문자O
	  int char_position_xdot; // 가능은 함. 하지만 권장x

	  int charPosXdot; //알아볼 수 있을 정도만 축약

	  System.out.println("by=" + by);
	  System.out.println("sh=" + sh);
	  System.out.println("i =" + i);
	  System.out.println("l=" + l);

	  System.out.println("f =" + f);
	  System.out.println("d =" + d);

	  System.out.println(b);

}

```

