---
layout: single
title: "[JAVA] 풀스택 과정 2일 차 : Input, Cast, Operator, Array, 첫 과제"

categories: JAVA
tags: [java, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2022-12-20
last_modified_at: 2023-01-03

sidebar:
  nav: "docs"
---

## [JAVA] 풀스택 과정 2일 차

오늘은 자바에서 사용하는 **입력(Input)**과 **변환(cast)**, 그리고 각종 **연산(Operator)**

## Input

```java
package sample03_input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass_sample03_input {

	public static void main(String[] args)throws Exception {

		// input(입력) - console (현재)
		// GUI : Graphic User Interface
		Scanner sc = new Scanner(System.in);

		// boolean
		boolean b;	// 입력한 데이터를 보관할 변수
		System.out.print("b = ");	// 입력할 데이터를 명시
		b = sc.nextBoolean();
		System.out.println("b:" + b);	// 입력한 결과 출력


		// integer
		int number;
		System.out.print("number = ");
		number = sc.nextInt();
		System.out.println("number :" + number);

		// double
		double d;
		System.out.print("d=");
		d = sc.nextDouble();
		System.out.println("d:"+ d);

		// string
		String str;
		System.out.print("str = ");
		str = sc.next();	// space 키를 인식 못 함.
		// "hello world"를 입력 받을 시 "hello"만 출력
		// -> scanner 대신 BufferedReader 사용.
		System.out.println("str:" + str);
		// str 숫자를 넣어도 출력됨 -> 숫자도 문자열 범위에 포함해줌

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1;
		System.out.print("str1 = ");
		str1 = br.readLine();
		System.out.println("str1:" + str1);

		// Scanner : next~ , BufferedReader : read~ 쓰임새 <
	}

}

```

## Cast

```java
package sample04;

public class MainClass {

	public static void main(String[] args) {
		// 자료형 변환
		// 자료형 : short(2), int(4), long(8), double(8),
		// String(?), char(2)

		short sh;
		sh = 128;

		int i;

		// 자동 (자료)형 변환(cast)
		i = sh;
		System.out.println("i = " + i);

		// 강제 (자료)형 변환(cast)
		i = 12345;
		sh = (short)i;
		System.out.println("sh = " + sh);

		int number1, number2;
		number1 = 3;
		number2 = 2;

		float f, f1;
		// f = number1 / number2 -> f = 1.0
		f = (float)number1 / number2; // -> 3.0 / 2
		// f = number1 / (float)number2; = 1.5
		System.out.println("f = " + f);


	}

}
```

## Operator

```java
package sample05;

public class MainCalss {

	public static void main(String[] args) {
		/*
		 연산자(operator) : + - * / %

		 */

		int num1, num2;
		num1 = 7;
		num2 = 2;

		int result;
		result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result );

		result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result );

		result = num1 / num2;	// 분모가 0이 안되게 주의
		System.out.println(num1 + " / " + num2 + " = " + result );
		// 7 / 2 = 3 으로 나옴

		result = num1 % num2; // % -> 뒷 숫자 나눈 뒤 나머지
		System.out.println(num1 + " % " + num2 + " = " + result );

		int money = 13500;
		int m = money % 1000;
		System.out.println("m = " + m);

		// increment(++) decrement(--)
		int number1;
		number1 = 0;

		// increment
		// number1 = number1 + 1;
		number1++; // ++number; 도 가능
		System.out.println("number1 = " + number1);

		// decrement
		// number1 = number1 - 1;
		number1--; // --number;

		/* 주의할 점 */

		int number2;
		number2 = 0;

		int number3;
		number3 = number2++;	// number3 = number2 를 적용하고 연산.
		// number3 = 0, number2 = 1
		System.out.println("number3 = " + number3);
		// number3=0

		int number_3;
		number2 = 0;
		number_3 = ++number2;	// number2 연산하고 number3 적용
		// number2 = 1, number3 = 1
		System.out.println("number_3 = " + number_3);


		// 논리(true/false) 연산자
		// && and	0 0 = 0, 0 1 = 0, 1 0 = 0, 1 1 = 1
		// || or	0 0 = 0, 0 1 = 1, 1 0 = 1, 1 1 = 1
		// ! not
		// < > <= >= 범위
		// number == 10

		int number4 = 5;
		System.out.println( number4 < 10 );
		System.out.println(number4 < 0 && number4 < 10);
		System.out.println(number4 < 0 || number4 > 10);
		System.out.println( !(number4 < 10) );	// number4 >= 10
		System.out.println( number4 = 5 );
		System.out.println( number4 == 5 );
		System.out.println( number4 != 5 );


		//	삼항 연산자
		//	변수 = (조건) ? 값1 : 값2 ; -> lambda
		//	참이다 -> 값1 대입, 거짓이다 -> 값2 대입
		int n;
		n = (number4 > 0) ? 11 : 22;
		System.out.println("n = " + n);

		char c;
		c = (number4 > 10) ? 'Y' : 'N';
		System.out.println("c = " + c);

		String s;
		s = (number4 > 4) ? "4보다 크다." : "4보다 작다.";
		System.out.println("s = " + s);

	}

}
```

## Array

```java
package sample05;

public class MainCalss {

	public static void main(String[] args) {
		/*
		 연산자(operator) : + - * / %

		 */

		int num1, num2;
		num1 = 7;
		num2 = 2;

		int result;
		result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result );

		result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result );

		result = num1 / num2;	// 분모가 0이 안되게 주의
		System.out.println(num1 + " / " + num2 + " = " + result );
		// 7 / 2 = 3 으로 나옴

		result = num1 % num2; // % -> 뒷 숫자 나눈 뒤 나머지
		System.out.println(num1 + " % " + num2 + " = " + result );

		int money = 13500;
		int m = money % 1000;
		System.out.println("m = " + m);

		// increment(++) decrement(--)
		int number1;
		number1 = 0;

		// increment
		// number1 = number1 + 1;
		number1++; // ++number; 도 가능
		System.out.println("number1 = " + number1);

		// decrement
		// number1 = number1 - 1;
		number1--; // --number;

		/* 주의할 점 */

		int number2;
		number2 = 0;

		int number3;
		number3 = number2++;	// number3 = number2 를 적용하고 연산.
		// number3 = 0, number2 = 1
		System.out.println("number3 = " + number3);
		// number3=0

		int number_3;
		number2 = 0;
		number_3 = ++number2;	// number2 연산하고 number3 적용
		// number2 = 1, number3 = 1
		System.out.println("number_3 = " + number_3);


		// 논리(true/false) 연산자
		// && and	0 0 = 0, 0 1 = 0, 1 0 = 0, 1 1 = 1
		// || or	0 0 = 0, 0 1 = 1, 1 0 = 1, 1 1 = 1
		// ! not
		// < > <= >= 범위
		// number == 10

		int number4 = 5;
		System.out.println( number4 < 10 );
		System.out.println(number4 < 0 && number4 < 10);
		System.out.println(number4 < 0 || number4 > 10);
		System.out.println( !(number4 < 10) );	// number4 >= 10
		System.out.println( number4 = 5 );
		System.out.println( number4 == 5 );
		System.out.println( number4 != 5 );


		//	삼항 연산자
		//	변수 = (조건) ? 값1 : 값2 ; -> lambda
		//	참이다 -> 값1 대입, 거짓이다 -> 값2 대입
		int n;
		n = (number4 > 0) ? 11 : 22;
		System.out.println("n = " + n);

		char c;
		c = (number4 > 10) ? 'Y' : 'N';
		System.out.println("c = " + c);

		String s;
		s = (number4 > 4) ? "4보다 크다." : "4보다 작다.";
		System.out.println("s = " + s);

	}

}
```

=======================================================================================

## 과제 #1![image-2022-12-20-problem01]({{site.url}}/images/2022-12-20-java-input/image-2022-12-20-problem01.png)

```java
package problem01;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("================================================================");
		System.out.println("\\ name\t\tage\tman\tphone\t\theght\taddress \\");
		System.out.println("================================================================");
		System.out.println("\\ \"홍길동\"\t20\ttrue\t010-111-2222\t175.12\t\"경기도\" \\");
		System.out.println("\\ \"일지매\"\t18\ttrue\t02-123-4567\t180.01\t\"서울\"\t\\");
		System.out.println("\\ \"장옥정\"\t14\ttrue\t02-345-7890\t155.78\t\"부산\"\t\\");
		System.out.println("================================================================");

	}

}
```

![image-2022-12-20-problem02]({{site.url}}/images/2022-12-20-java-input/image-2022-12-20-problem02.png)

```java
package problem02;

import java.util.Scanner;

public class MainClass_problem02 {
	public static void main(String[] args) {

		String name1, name2, name3;
		name1 = "홍길동";
		name2 = "일지매";
		name3 = "장옥정";

		int age1, age2, age3;
		age1 = 20;
		age2 = 18;
		age3 = 14;

		boolean a, b, c;
		a = true;
		b = true;
		c = false;

		String phone1, phone2, phone3;
		phone1 = "010-111-2222";
		phone2 = "02-123-4567";
		phone3 = "02-345-7890";

		double height1, height2, height3;
		height1 = 175.12;
		height2 = 180.01;
		height3 = 155.78;

		String address1, address2, address3;
		address1 = "경기도";
		address2 = "서울";
		address3 = "부산";

		System.out.println("================================================================");
		System.out.println("\\ name\t\tage\tman\tphone\t\theght address \\");
		System.out.println("================================================================");
		System.out.printf("\\ \"%s\"\t%s\t%s\t%s\t%s\t\"%s\" \\\n", name1, age1, a, phone1, height1, address1);
		System.out.printf("\\ \"%s\"\t%s\t%s\t%s\t%s\t\"%s\"\t\\\n", name2, age2, b, phone2, height2, address2);
		System.out.printf("\\ \"%s\"\t%s\t%s\t%s\t%s\t\"%s\"\t\\\n", name3, age3, c, phone3, height3, address3);
		System.out.println("================================================================");
	}

}
```

![image-2022-12-20-problem03]({{site.url}}/images/2022-12-20-java-input/
image-2022-12-20-problem03.png)

```java
package problem03;

import java.util.Scanner;

public class MainClass_problem03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name;
		System.out.print("name = ");
		name = sc.next();

		int age;
		System.out.print("age = ");
		age = sc.nextInt();


		String gender;
		System.out.print("What's your gender = ");
		gender = sc.next();


		String phone;
		System.out.print("What's your Phone Number = ");
		phone = sc.next();


		double height;
		System.out.print("Height = ");
		height = sc.nextDouble();


		String address;
		System.out.print("Address = ");
		address = sc.next();

		System.out.println("================================================================");
		System.out.println("Name = " + name);
		System.out.println("Age = " + age);
		System.out.println("Gender = " + gender);
		System.out.println("Phone = " + phone);
		System.out.println("Height = " + height);
		System.out.println("Adress = " + address);

	}

}

```

![image-2022-12-20-problem04]({{site.url}}/images/2022-12-20-java-input/image-2022-12-20-problem04.png)

```java
package problem03;

import java.util.Scanner;

public class MainClass_problem03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name;
		System.out.print("name = ");
		name = sc.next();

		int age;
		System.out.print("age = ");
		age = sc.nextInt();


		String gender;
		System.out.print("What's your gender = ");
		gender = sc.next();


		String phone;
		System.out.print("What's your Phone Number = ");
		phone = sc.next();


		double height;
		System.out.print("Height = ");
		height = sc.nextDouble();


		String address;
		System.out.print("Address = ");
		address = sc.next();

		System.out.println("================================================================");
		System.out.println("Name = " + name);
		System.out.println("Age = " + age);
		System.out.println("Gender = " + gender);
		System.out.println("Phone = " + phone);
		System.out.println("Height = " + height);
		System.out.println("Adress = " + address);

	}

}
```
