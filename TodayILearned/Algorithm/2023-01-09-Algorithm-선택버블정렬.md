---
layout: single
title: "[Algorithm] 1일 차 : 선택 정렬, 버블 정렬"

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

## Algorithm

## 버블정렬

![image-20230109134231273]({{site.url}}/image-2023-01-09-bubbleSort.png)

## 선택정렬

![image-20230109134624651]({{site.url}}/image-2023-01-09-selectionSort134624651.png)

소수 첫 째자리에서 반올림 : 0.5 더하고 int형변환 -> int는 버림이기 때문에

## [SWEA 1966 : 정렬하기](https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYWPlU-KVQgDFAQK&contestProbId=AV5PrmyKAWEDFAUq&probBoxId=AYWPlU-KVQkDFAQK&type=PROBLEM&problemBoxTitle=230109_%EB%B0%B0%EC%97%B4_%EC%A0%95%EB%A0%AC&problemBoxCnt=3)

```java
package swea_1966;

import java.util.Scanner;

public class SWEA_1966 {
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int testCase = sc.nextInt();	// test 개수

	        for (int tc = 0; tc < testCase; tc++) {
	            System.out.print("#"+ (tc+1) + " ");
	            int n = sc.nextInt();
	            int[] arr = new int[n];

	            for (int i = 0; i < arr.length; i++) {
	                int temp = sc.nextInt();
	                arr[i] = temp;
	            }

	            for (int i = 0; i < arr.length; i++) {
	                for(int j=i+1; j < arr.length; j++) {
	                if(arr[i] > arr[j]) {
	                    int tmp = arr[j];
	                    arr[j] = arr[i];
	                    arr[i] = tmp;
	                }
	                }
	            }
	            for (int i = 0; i < arr.length; i++) {
	                System.out.print(arr[i] + " ");
	            }
	            System.out.println();
	        }
	    }
}
```

## [SWEA 1984 : 중간 평균 값 구하기](https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYWPlU-KVQgDFAQK&contestProbId=AV5Pw_-KAdcDFAUq&probBoxId=AYWPlU-KVQkDFAQK&type=PROBLEM&problemBoxTitle=230109_%EB%B0%B0%EC%97%B4_%EC%A0%95%EB%A0%AC&problemBoxCnt=3)

```java
package swea_1984;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1984_sol {

	public static void main(String[] args) {
		// 입력을 받으며 누적합, 최댓값, 최솟값을 동시에 찾는다지만
		// 누적합에서 최댓값, 최솟값을 빼고 나눈다 ( !! 주의 실수로 나눌것 !! )
		// 반올림해서 뽑는다. (0.5를 더한후 int로 형변환해서 반올림 시키겠다!!)
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int sum = 0;
			int maxi = -1;
			int mini = 50000;
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				int temp = sc.nextInt();
				arr[i] = temp;
			} // end for : 10개 입력 완료!
//				System.out.println(Arrays.toString(arr));

			for (int i = 0; i < 10; i++) {
				sum += arr[i];
			}
			for (int i = 0; i < 10; i++) {
				if (maxi < arr[i]) {
					maxi = arr[i];
				}
			}
			for (int i = 0; i < 10; i++) {
				if (mini > arr[i]) {
					mini = arr[i];
				}
			}

			double answer = (sum - maxi - mini) / (double) (arr.length - 2);
			int ans = (int) (answer + 0.5);
			System.out.println("#" + tc + " " + ans);

		}

	}
}

```

## [SWEA 2068 : 최댓값 구하기](https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYWPlU-KVQgDFAQK&contestProbId=AV5QQhbqA4QDFAUq&probBoxId=AYWPlU-KVQkDFAQK&type=PROBLEM&problemBoxTitle=230109_%EB%B0%B0%EC%97%B4_%EC%A0%95%EB%A0%AC&problemBoxCnt=3)

```java
package swea_2068;

import java.util.Scanner;

public class SWEA_2068 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 0; tc < testCase; tc++) {
			int[] arr = new int[10];
			int max = 0;
			System.out.print("#" + (tc + 1) + " ");

			for (int i = 0; i < arr.length; i++) {
				int temp = sc.nextInt();
				arr[i] = temp;
			}
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			System.out.print(max);
			System.out.println();
		}
	}
}
```
