---
layout: single
title: "[JAVA] double, object 형 변환"

categories: JAVA
tags: [java, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-07-14
last_modified_at: 2023-07-14

sidebar:
  nav: "docs"
---



# Double 형 변환

## String -> Double

~~~java
Double.parseDouble();
Double.valueof();
~~~



## Object -> Double

Object->String으로 형 변환 이후에 double 형으로 형 변환을 해야 한다.

~~~java
Object str = "1234";
Double dbl = Double.parseDouble(String.valueof(str));
>> 1234.0
~~~



## null과 오토박싱(Auto-boxing)

`Integer`나 `Double`과 같은 래퍼(Wrapper) 클래스 레퍼런스가 `null`을 참조하고 있을 때, 이를 기본형 타입으로 언박싱(unboxing)하는 경우 `NullPointerException`이 발생한다. 컴파일 시점에서 확인할 수 없기 때문에 주의해야 한다.

> 출처 : [블로그](https://madplay.github.io/post/what-is-null-in-java)
