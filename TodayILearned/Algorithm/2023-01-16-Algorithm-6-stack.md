---
layout: single
title: "[Algorithm] 6일 차 : 재귀 함수, 스택, SWEA 8931 : 제로, SWEA 1222 : 후위 계산기"

categories: Algorithm
tags: [java, Algorithm, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-01-09
last_modified_at: 2023-01-11
sidebar:
  nav: "docs"
---

## 재귀 함수

```java
package stack;

public class Stack_01 {

	public static void main(String[] args) {
		// stack
		recursivePrint(0,4);
	}

	static void recursivePrint (int level, int end) {

		if (level == end) {
			System.out.println(level);
			return;
		}

		System.out.println(level);
		recursivePrint(level + 1, end);
		System.out.println(level);
	}

}
// >> 0 1 2 3 4 3 2 1 0
```

![image-20230118111313364]({{site.url}}/images/2023-01-16-Algorithm-6/image-20230118111313364.png)

![image-20230118111335562]({{site.url}}/images/2023-01-16-Algorithm-6/image-20230118111335562.png)

## [SWEA 8931 : 제로](https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYWPlU-KVQgDFAQK&contestProbId=AW5jBWLq7jwDFATQ&probBoxId=AYW3uLoKSCcDFAQK&type=PROBLEM&problemBoxTitle=230116_%EC%8A%A4%ED%83%9D&problemBoxCnt=2)

> Input

```
2
6
10000
10000
0
0
100000
0
10
1
3
5
4
0
0
7
0
0
6
```

> Output

```
#1 0
#2 7
```

> 내 풀이

```java
package swea_8931;

import java.util.Scanner;

public class SWEA_8931 {

	public static void main(String[] args) {
		// 장부 관리, 금액 적기
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		// 실행
		for (int tc = 1; tc <= testCase; tc++) {
			int k = sc.nextInt();	// 사이즈
			int[] sum = new int[k];
			int rSum = 0;
			int num = 0;

			// 배열 Input
			for (int i = 0; i < k; i++) {
				num = sc.nextInt();

				// 0일 시 최근 input 제거
				if (num == 0) {
					for (int j = i - 1; j >= 0; j--) {

						if(sum[j] != 0) {
							sum[j] = 0;
							break;
						}
					}
				} // end 제거 for문

				// 배열에 숫자 input
				sum[i] = num;
			}	// end 배열 input for문

			// 실제 합계 더하기
			for (int r = 0; r < sum.length; r++) {
				rSum += sum[r];
			}

			System.out.println("#" + tc + " " + rSum);
		}	// end 실행 for문

	}
}
```

> 강사님 풀이 : 배열 풀이

```java
package swea_8931;

import java.util.Scanner;

public class sol {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			int[] st = new int[K]; // 배열로 스택 구현
			int top = -1;
			for (int i = 0; i < K; i++) {
				int temp = sc.nextInt();
				if (temp == 0 && top != -1) {
					--top;
				} else {
					st[++top] = temp;
				}
			} // end for i
			int sum = 0;
			for (int i = 0; i <= top; i++) {
				sum += st[i];
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}

}
```

> 강사님 풀이 : stack 사용

```java
package swea_8931;

import java.util.Scanner;
import java.util.Stack;

public class sol2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			int size = sc.nextInt();
			int sum = 0;
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < size; i++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					stack.pop();
				} else {
					stack.push(temp);
				}
			} // end for : size만큼 입력 온라ㅛ

			// sum 구하기
			for (int i = 0; i < stack.size(); i++) {
				sum += stack.get(i);
			}
			System.out.println("#" + tc + " " + sum);

		}

	}
}
```

## [SWEA 1222 : 후위식 계산기](https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYWPlU-KVQgDFAQK&contestProbId=AV14mbSaAEwCFAYD&probBoxId=AYW3uLoKSCcDFAQK&type=PROBLEM&problemBoxTitle=230116_%EC%8A%A4%ED%83%9D&problemBoxCnt=2)

> Input

```
101
9+8+5+9+2+4+1+8+3+9+3+8+7+8+6+8+9+4+1+1+7+6+1+5+8+7+6+9+6+3+1+3+1+7+5+9+2+8+4+3+7+3+4+7+3+4+8+3+2+6+6
83
7+4+8+3+4+8+5+5+3+6+7+1+2+5+6+5+5+6+1+6+7+8+6+4+7+4+3+1+6+1+2+1+6+8+6+9+2+7+4+3+2+3
119
9+4+7+9+1+3+5+4+7+4+1+3+3+4+9+9+6+2+7+7+3+4+4+7+2+7+9+7+9+9+4+5+9+2+9+8+4+8+8+2+4+6+8+7+5+3+7+7+6+9+8+3+3+4+6+8+3+8+7+9
61
3+7+9+5+6+4+9+3+4+2+1+3+6+5+3+6+5+7+1+7+7+4+5+2+1+9+2+4+3+7+9
67
9+3+8+7+2+6+1+1+3+8+2+9+3+9+1+9+3+5+3+2+1+6+2+4+3+5+6+1+2+7+7+5+4+2
83
6+1+4+4+7+6+3+9+6+9+2+5+7+7+8+8+9+6+2+3+3+9+7+2+5+1+3+7+9+4+7+3+2+9+3+3+8+1+4+4+3+4
63
4+5+3+3+1+2+9+9+3+9+9+7+5+6+1+1+7+1+8+8+2+9+8+8+8+7+7+5+9+3+4+9
89
6+1+2+1+6+8+6+8+8+9+5+7+2+1+3+4+8+5+2+2+5+5+4+8+5+3+4+5+9+5+9+2+9+4+7+2+6+8+9+6+3+2+1+2+4
69
6+3+3+1+8+2+4+2+5+5+4+9+2+2+1+3+5+9+3+6+4+7+1+9+1+9+3+4+2+7+2+6+9+6+5
65
4+3+6+8+9+5+9+4+4+9+1+9+8+9+9+2+4+6+8+6+9+5+3+9+7+3+9+5+6+5+9+7+5
```

> Output

```
#1 267
#2 197
#3 345
#4 149
#5 149
#6 213
#7 180
#8 221
#9 158
#10 205
```

> 내 풀이 : 배열 이용

```java
package swea_1222;

import java.util.Scanner;

public class SWEA_1222 {

	public static void main(String[] args) {
		// 후위 표기식 계산기 only +, 배열 버전
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = sc.nextInt();
			char[] arr = new char[n / 2 + 1];
			char[] plus = new char[n / 2];
			int ind = 0;
			int indP = 0;
			int result = 0;
			String input = sc.next();

			// 배열 input
			for (int i = 0; i < n; i++) {
				char temp = input.charAt(i);

				if (temp == '+') {
					plus[indP] = temp;
					indP++;
				} else {
					arr[ind] = temp;
					if (ind != n/2) {
						ind++;
					}
				}
			} // end 배열 for문

			for (int i = ind; i >= 0; i--) {
				result += arr[i] - '0';
			}
			System.out.println("#" + testCase + " " + result);

		}
	}

}
```

> 내 풀이 : stack 이용

```java
package swea_1222;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1222_stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			Stack<Character> stack = new Stack<>(); // + 기호 저장 stack
			int n = sc.nextInt(); // index 개수
			char[] input = sc.next().toCharArray(); // 배열 input 받기
			char[] arr = new char[input.length]; // 출력장?
			int index = 0;

			// 후위 표기식 변환
			for (int i = 0; i < input.length; i++) {
				// +표시 stack에 넣고 뺴기.
				if (input[i] == '+') {
					if (!stack.isEmpty()) { // 동등한 순위의 연산자 등장으로 이전 연산자 추출
						arr[index] = stack.pop();
						index++;
					}
					stack.push(input[i]); // 첫 번째 +, stack 바닥에 저장.

				} else { // 숫자, 배열에 input
					arr[index] = input[i];
					index++;
				}
			} // end 배열 Input for문
			arr[index] = stack.pop(); // 마지막 + 연산 추출.

			// 후위 표기식 계산
			Stack<Integer> intStack = new Stack<>();
			for (int i = 0; i <= index; i++) {
				if (arr[i] != '+') {
					intStack.push(arr[i] - '0'); // 바닥부터 문자 -> 숫자 변환 후 새로운 stack에 저장
				} else { // +를 만났을 때
					int x = intStack.pop();
					int y = intStack.pop();
					intStack.push(x + y); // 결과 값 다시 바닥에 저장.
				}
			}
			System.out.println("#" + testCase + " " + intStack.pop());
		} // end 실행 for문

	}
}
```

> 강사님 sol

```java
package swea_1222;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1222_sol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String input = sc.next();
			Stack<Character> stack = new Stack<>();
			String postFix = "";

			for (int i = 0; i < N; i++) {
				char now = input.charAt(i);
				if (now == '+') {
					if (!stack.isEmpty()) {
						char temp = stack.pop();
						postFix += temp;
					}
					stack.push(now);
				} else {
					postFix += now;
				}
			}
//      System.out.println(stack.toString());
			while (!stack.isEmpty()) {
				postFix += stack.pop();
			}

			Stack<Integer> intStack = new Stack<>();
			for (char now : postFix.toCharArray()) {
				if (now != '+') {
					intStack.push(now - '0');
				} else {
					int right = intStack.pop();
					int left = intStack.pop();
					intStack.push(left + right);
				}
			}
			System.out.printf("#%d %d\n", t, intStack.pop());
		}
	}
}

```
