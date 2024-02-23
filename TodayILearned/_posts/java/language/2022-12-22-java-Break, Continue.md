## Break

```java
package sample13_break;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	break : loop 정지 -> escape

		 	loop문과 같이 사용한다(for, while, do while, switch)

		 	switch(변수){
		 		case 값1 :
		 			처리1
		 			break;
		 		case 값2 :
		 			처리2
		 			break;
		 		}

		 		형식:
		 			for(int i=0; i<10; i++){
		 					처리1
		 			if(조건){	// 원하는 조건이 아니면 루프를 탈출하기 위해
		 			break;
		 			}
		 					처리2
		 			}

		 			w=0;
		 			while(w<10){
		 					처리 1
		 				if(조건){
		 					break;
		 					}
		 					처리 2
		 					w++;
		 			}
		 */

		for(int i=0; i<10; i++) {
			System.out.println("for loop " + i);

			if(i == 5) {
				System.out.println("i == 5, 탈출!");
				break;
			}
		}


		int number[] = { 13, 45, 27, -36, 78 };
		for(int i=0; i<number.length; i++) {
			System.out.println("number[" + i + "] = " + number[i]);

			if(number[i] < 0) {
				break;
			}
		}

		/*
		// 2중 for
		for(int i=0; i<10; i++) {
			System.out.println("i = " + i);

			for(int j=0; j<8; j++) {
				System.out.println("/tj = " + j);

				if(i == 5 && j ==4) {
					break;	// break 실행 안됨 -> 루프문 수와 break 수가 맞아야 함.
				}
			}
		}
		*/


		/* 해결책 */
		// 1. loop문 수에 맞춰서 break를 설정한다.
		boolean b = false;

		for(int i=0; i<10; i++) {
			System.out.println("i = " + i);

			for(int j=0; j<8; j++) {
				System.out.println("/tj = " + j);

				if(i == 5 && j ==4) {
					b = true;
				}
				if(b == true) {
					break;
				}
			}
			if(b == true) {
				break; // break 클릭 시 어느 loop문인지 알 수 있음.
			}
		}

		// 2. break 설정
		out : for(int i=0; i<10; i++) { // out : 사용자 지정
			System.out.println("i = " + i);

			for(int j=0; j<8; j++) {
				System.out.println("/tj = " + j);

				if(i == 5 && j ==4) {
					break out;		// 어느 루프를 탈출하는지 설정하는 것.
			}
		}
		}



	}

}
```

## Continue

```java
package sample14_continue;

import java.util.Scanner;
import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	continue : skip(생략)
		 	break도 단독으로 사용 불가.

		 	loop문과 같이 사용

		 	while(조건){

		 		처리 1

		 		if(조건){
		 			continue;	// 다시 loop문으로 들어감
		 			}

		 		처리 2

		 		연산식
		 		}

		 */

		for(int i =0; i<10; i++) {
			System.out.println("i = " + i);

			System.out.println("for 처리1");

			if(i>5) {
				continue;	// 조건 충족 시 continue 밑에 있는 처리들은 생략 후 loop문 재돌입
			}
			System.out.println("for 처리2");
		}

		/////////////////////////////////////////////////////
		int array[] = { 2, -6, 3, -4, 5 };

		for(int i=0; i<array.length; i++) {

			if(array[i] <= 0 ) { // 음수였을 때 출력 제외
				continue;
			}
			System.out.printf("arry[%s] = %s %n", i, array[i]);
		}


		/////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);

		int number;
		/*
		for(int i=0; i<3; i++) {
			System.out.print("number " + i + "= ");
			number = sc.nextInt();

			if(number <= 0) {
				continue;
			}
			System.out.println("/tnumber = " + number);
		}
		*/
		/////////////////////////////////////////////////////////
		/*
		int w = 0;
		while(w<3) {
			System.out.print("number" + w + " = ");
			number = sc.nextInt();

			if(number <= 0) {
				continue;
			}

			System.out.println("/tnumber : " + number);
			w++;	 // 여기 적으면 continue 시 연산 안됨.
		}
		*/

		///////////////////////////////////////////////////////
		// 양수로 된 숫자 5개 -> 배열에 저장해서 출력

		int numArr[] = new int[5];
		int num, w1;


		w1=0;
		while(w1<numArr.length) {
			System.out.print( (w1+1) +"번째 수 = ");
			num = sc.nextInt();

			if(num <= 0) {
				System.out.println("양수만 입력하시오.");
				continue;
			}
			System.out.println("/tnumArr[" + w1 + "] = " + num);

			numArr[w1] = num;
			w1++;
		}

		System.out.println( Arrays.toString(numArr));


	}

}
```

## 과제 #2

![image-2022-12-22-problem01]({{site.url}}/images/2022-12-22-java-sample13-14/image-2022-12-22-problem01.png)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {


	public static void main(String[] args) {
		// problem 1
		// 1 ~ 1000 사이에 수를 전부 합친 값을 출력하라.

		int num=0;
		for(int i=1; i<1001; i++ ) {
			num=num+i;
		}
		System.out.println("1부터 1000 사이 수의 합은 : " + num);

		////////////////////////////////////////////////////

		int sum = 0;
		int n = 0;
		for(int i=0; i<1000; i++) {
			n++;
			sum = sum + n;
		}
		System.out.println("합계 : " + sum);


	}

}

```

![image-2022-12-22-problem02]({{site.url}}/images/2022-12-22-java-sample13-14/image-2022-12-22-problem02.png)

```java
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// problem2
		// 하나의 수를 입력 받고 입력 받은 수는 어느 범위에 있는지 출력되는
		// 프로그램을 작성하라. (0 ~ 100 사이의 수)
				Scanner sc = new Scanner(System.in);

				System.out.print("숫자를 입력하시오. /n >>");
				int num2 = sc.nextInt();
				System.out.println("number : " + num2);

				for(int i = 0; i < 101; i = i+10) {
					if(num2 >= i && num2 < i+10) {
						System.out.printf("입력한 수는 %s 보다 크고 %s 보다 작다.", i, i+10);
					}
				}

				///////////////////////////////////////////////////////
			int boundNum = 0;	// 0 10 20 30 40 ~ 90

			for(int i = 0; i < 10; i++) {
				boundNum = 10 * i;

				if(num2 > boundNum && num2 <= (boundNum + 10)) {
					System.out.println("number는 " + boundNum + "보다 크고" + (boundNum+10)+ "보다 작거나 같다");
				}
			}
	}

}
```

![image-2022-12-22-problem03](../images/2022-12-22-java-sample13-14/image-2022-12-22-problem03.png)

```java

public class MainClass {

	public static void main(String[] args) {
		for(int i=0; i<9; i++) {

			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println("/tLine number" + (i+1));
		}

	//////////////////////////////////////////////////////



	}

}
```

![image-20230104024400744]({{site.url}}/images/2022-12-22-java-sample13-14/image-2022-12-22-problem04.png)

```java

public class MainClass {

	public static void main(String[] args) {
		// problem03
		/*
		char a = '*';

		for(int i=1; i<10; i++) {
			if(i<=5) {
				for(int j=1; j<=i; j++) {
					System.out.print(a);
				}
				System.out.println();
			}
			else {
				for(int j=10; j>i; j--) {
					System.out.print(a);
				}
				if(i==9) {
					continue;
				}
				System.out.println();
			}
		}
		*/

		int t = 0;
		for(int i=0; i<9; i++) {

			if(i<5) t++;
			else	t--;

			for(int j=0; j<t; j++) {
				System.out.print("*");
			}
			if(i==8) {
				continue;
			}
			System.out.println();
		}

	}

}
```

![image-2022-12-22-problem05]({{site.url}}/images/2022-12-22-java-sample13-14/image-2022-12-22-problem05.png)

```java

public class MainClass {

	public static void main(String[] args) {
		// problem5
		// 임의 수를 입력 받고 그 해당하는 수의 구구단을 출력하는 프로그램을 작성하라.
		int ans;

		for(int i=1; i < 10; i++) {

			for(int j=1; j<10; j++) {
				ans = i * j;
				System.out.printf("%s * %s = %s/t", i, j, ans);
			}
			System.out.println();
		}
		System.out.println();
	}

}
```

![image-2022-12-22-problem06]({{site.url}}/images/2022-12-22-java-sample13-14/image-2022-12-22-problem06.png)

```java
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// problem6
		// 임의 수를 입력 받고 그 해당하는 수의 구구단을 출력하는 프로그램을 작성하라.
				Scanner sc = new Scanner(System.in);
				int a, b;
				System.out.print("출력하고 싶은 구구단을 입력하시오. : ");
				a = sc.nextInt();

				for(int i=1; i < 10; i++) {
					b = a * i;
					System.out.printf("%s x %s = %s /n", a, i, b);
				}
	}

}
```

![image-2022-12-22-problem07]({{site.url}}/images/2022-12-22-java-sample13-14/image-2022-12-22-problem07.png)

```java

public class MainClass {

	public static void main(String[] args) {
		/*
		  problem 07

		  	1 ~ 100 사이에 짝수의 합과 홀수의 합을 각각 출력하도록 작성하라.
			1부터  100 사이  짝수의  합은:
			1부터  100 사이  홀수의  합은:
		 */
		int a=0, b=0;

		for(int i=1; i<101; i++ ) {
			if (i % 2 == 0) {
				a = a + i;
			}
			else if(i % 2 ==1) {
				b = b + i;
			}
		}
		System.out.println("1부터 1000 사이 짝수의 합은 : " + a);
		System.out.println("1부터 1000 사이 홀수의 합은 : " + b);



	}

}
```
