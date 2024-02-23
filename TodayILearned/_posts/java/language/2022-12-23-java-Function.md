## Function

```java
package sample15;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {
		/*
			함수 : 	function. 독립적인 처리자
					method. == 함수   class에 소속되어 있는 함수

			형식:
			return값 함수명(parameters, , , ){

				처리코드

				return 값;
			}

			void -> 자료형이 없는 것.

			구성요소
			parameter   (들어 가는 값)
			return value(나오는(산출되는) 값)

			Application Programming Interface - API
		*/

		functionName();  // 함수 호출 방법

		functionOne(123); // 123 -> argument

		String s = functionTwo();
		System.out.println(s);

		int arrNum[] = functionThree();
		System.out.println(Arrays.toString(arrNum));

		int num = functionFour(7);
		System.out.println("num = " + num);

		String str = "world";
		boolean b = str.equals("world");

		int n = functionFive('e', "hello");
		System.out.println("n = " + n);

		char c = 'A';
		System.out.println( c );
		System.out.println( (int)c );	// A의 아스키코드 출력

		int cNum = 65;
		System.out.println((char)cNum);

		char c1 = 'H';
		char rc = lowerCase(c1);
		System.out.println("rc = " + rc);


		// random(난수, 무작위)
		int rnum = (int)(Math.random() * 3);  // 0 1 2
		System.out.println("rnum = " + rnum);

		// 0 ~ 9
		rnum = (int)(Math.random() * 10);

		// 10 20 30 40 50   0 1 2 3 4 + 1 -> 1 2 3 4 5
		rnum = ((int)(Math.random() * 5) + 1) * 10;

		String str1 = "abc*abc*abc";
		String replaceStr = str1.replace("*", "-");
		System.out.println(replaceStr);

		char c2 = 'A';
		String str2 = c2 + "";

		int n2 = 123;
		String str3 = n2 + "";
	}

	static void functionName(  ) {
		System.out.println("functionName 호출");
	}

	static void functionOne( int n ) {	// n -> parameter  -> 매개변수
		System.out.println("functionOne 호출 n = " + n);
	}

	static String functionTwo( ) {
		String str = "hello";

		return str;
	}

	static int[] functionThree( ) {
		int number[] = { 100, 200, 300 };
		return number;
	}

	static int functionFour(int n) {
		int r;
		r = n * 2;

		return r;
	}

//	static boolean equals(String str) {
//	}

	static int functionFive(char c, String s) {
		int r = s.indexOf(c + "");
		return r;
	}

	/*
		알파벳 A, B, C... -> a, b, c
		     65            97
		대문자를 소문자로 변경해서 돌려주는 함수
	*/
	static char lowerCase(char c) {
		int n = (int)c;
		int r = n + 32;

		return (char)r;
	}

//	static String replace(String s1, String s2) {
//	}

}
```

## Function2

```java
package sample16_func2;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		/*
		  	함수의 매개변수로 넘겨주는 경우
		  	static void func1( int num )     -> value를 넘겨준다

		  	static void func2( int array[] ) -> address를 넘겨준다

		 */

		// 실제로 사용(호출)
		int num = 3;
		funcOne(num);
		System.out.println("main함수 num = " + num);

		int arr[] = new int[1];
		arr[0] = 3;
		funcTwo(arr);
		System.out.println("arr[0] = " + arr[0]);


		int arrNum[] = { 1, 2, 3, 4, 5 };

		funcThree(arrNum);

		System.out.println( Arrays.toString(arrNum) );

	}

	static void funcOne(int num) {  // 함수의 정의
		num = num * 2;
		System.out.println("함수안 num = " + num);
	}

	static void funcTwo(int array[]) { // 함수의 정의
		array[0] = array[0] * 2;
		System.out.println("array[0] = " + array[0]);
	}

	static void funcThree(int arrNum[]) {
		for(int i = 0;i < arrNum.length; i++) {
			arrNum[i] = arrNum[i] * 2;
		}
	}

}
```

## 과제

### 계산기

```java
package work05;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// calculator(계산기)
		int number1, number2, result = 0;
		String operator;

		while(true) {

			// 1. 숫자입력
			number1 = numberInput("첫번째");
			//System.out.print("첫번째 숫자 >> ");
			//number1 = sc.nextInt();

			// 2. 연산기호(+,-,*,/)
			System.out.print("연산자(+, -, *, /) >> ");
			operator = sc.next();

			// 3. 숫자입력
			number2 = numberInput("두번째");
			//System.out.print("두번째 숫자 >> ");
			//number2 = sc.nextInt();

			// 4. 연산
			result = calculator(number1, number2, operator);


			// 5. 결과출력
			System.out.println(number1 + " " + operator + " " + number2 + " = " + result);

			// 6. replay
			System.out.print("다시 시작하시겠습니까?(y/n) = ");
			String replay = sc.next();

			if(replay.equals("y")) {
				System.out.println("다시 시작합니다");
			}else {
				break;
			}
		}
	}

	static int numberInput(String n) {
		Scanner sc = new Scanner(System.in);

		System.out.print(n + " 숫자 >> ");
		int number = sc.nextInt();

		return number;
	}

	static int calculator(int number1, int number2, String operator) {
		int result = 0;

		if(operator.equals("+")) {
			result = number1 + number2;
		}
		else if(operator.equals("-")) {
			result = number1 - number2;
		}
		else if(operator.equals("*")) {
			result = number1 * number2;
		}
		else if(operator.equals("/")) {
			result = number1 / number2;
		}

		return result;
	}


}
```

> **과제 1 : 두 점 사이의 거리를 구하라**.

![image-20230120144124309]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120144124309.png)

```java
package problem_12_23;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// 12월 23일 problem 1
		// 두  점  (x,y)와  (x1,y1)간의  거리를  구하는 함수 만들기.

		double num1 = getNum("첫 번째 x 값 : ");
		double num2 = getNum("첫 번째 y 값 : ");
		double num3 = getNum("두 번째 x 값 : ");
		double num4 = getNum("두 번째 y 값 : ");

		System.out.println(getDistance(num1, num2, num3, num4));




	}

	static double getDistance(double x, double y, double x1, double y1) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		double r1 = Math.pow((x1-x), 2.0);	// Math.pow 승수를 구하는 함수
		double r2 = Math.pow((y1-y), 2.0);	// pow = power
		// pow는 double 형태로 기입해주어야 함.

		double distance = Math.sqrt((r1+r2));	// root를 구하는 함수

		return distance;
	}

	static double getNum(String n) {
		Scanner sc = new Scanner(System.in);
		System.out.print(n);
		double num = sc.nextDouble();

		return num;
	}


}
```

> **과제 2 : shuffle 메소드를 구현하라**

![image-20230120144731031]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120144731031.png)

![image-20230120151454970]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120151454970.png)

```java
package work06;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

        int original[] = { 1,2,3,4,5,6,7,8,9 };
		System.out.println(Arrays.toString(original));

		int result[] = shuffle(original);
		System.out.println(Arrays.toString(result));

		System.out.println(Arrays.toString(original));
   }

    static int[] shuffle(int original[]) {
		int temp;

		for(int i = 0;i < 5000; i++) {

			int x = (int)(Math.random() * 9);  // 0 ~ 8
			int y = (int)(Math.random() * 9);  // 0 ~ 8

			// swap
			temp = original[x];
			original[x] = original[y];
			original[y] = temp;
		}

		return original;
	}
}
```

> **과제 3 : max 메소드를 작성하시오.**

![image-20230120151632920]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120151632920.png)

![image-20230120151655670]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120151655670.png)

```java
package work06;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

	//	int[] data = { 3,2,9,4,7 };
		int[] data = { -3,-2,-9,-4,-7 };
		int m = max(data);
		System.out.println("최대값:" + m);

		int emptyArray[] = null;
		int m1 = max(emptyArray);
		System.out.println("m1 = " + m1);

	}

	// TODO: 3번문제
	static int max(int data[]) {

		// 배열의 이상이 있는 경우
		if(data == null || data.length == 0) {
			return -999999;
		}

		int m = data[0];

		// 3,2,9,4,7
		for(int i = 0;i < data.length; i++) {
			if(m < data[i]) {
				m = data[i];
			}
		}
		return m;
	}

}
```

> **과제 4 : isNumber 메소드**

![image-20230120151840648]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120151840648.png)

![image-20230120151854714]({{site.url}}/images/2022-12-23-java-sample15-16/image-20230120151854714.png)

```java
package work06;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		String str = "123";
		boolean b = isNumber(str);
		System.out.println(str + "는 숫자입니까? "+ b);

		str = "1234o";
		System.out.println(str + "는 숫자입니까? "+ isNumber(str));

	}

	// ASCII 코드를 사용    123a4
	static boolean isNumber(String str) {
		boolean b = true;

		for(int i = 0;i < str.length(); i++) {
			char c = str.charAt(i);
			// System.out.println(c);
			int n = (int)c;
			if(n < 48 || n > 57) {
				b = false;
			}
		}

		return b;
	}

}
```

> **과제 5 : 배열 각 인덱스 값을 2배 연산하는 메소드**

<img src="{{site.url}}/images/2022-12-23-java-sample15-16/image-20230120152025561.png" alt="image-20230120152025561" style="zoom:80%;" />

```java
package work06;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		// 5.
		int num1[] = {1, 2, 3, 4, 5};
		getDouble(num1);
		System.out.println(Arrays.toString(num1));

	}

	// *2를 하는 함수
	static void getDouble(int num1[]) {
		for(int i = 0;i < num1.length; i++) {
			num1[i] = num1[i] * 2;
		}
	}

}
```

> 과제 6 : 몫과 나머지 메소드

<img src="{{site.url}}/images/2022-12-23-java-sample15-16/image-20230120152212467.png" alt="image-20230120152212467" style="zoom:80%;" />

```java
package work06;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		// 6.
		int number1, number2;
		int res, tag[];  // res = 몫, tag = 나머지

		number1 = 29;
		number2 = 4;
		tag = new int[1];

		res = getResult(number1, number2, tag);
		System.out.println("몫:" + res + " 나머지:" + tag[0]);
	}

	//     몫                                         나머지
	static int getResult(int number1, int number2, int tag[]) {
		// 몫
		int res = number1 / number2;
		// 나머지
		tag[0] = number1 % number2;

		return res;
	}

}
```
