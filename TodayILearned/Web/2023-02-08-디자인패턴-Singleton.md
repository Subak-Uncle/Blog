---
layout: single
title: "[Web] : 디자인패턴 - Singleton"

categories: Web
tags: [web, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: ture
date: 2023-02-08
last_modified_at: 2023-02-08
sidebar:
  nav: "docs"
---



## 디자인 패턴 - Singleton

![image](https://user-images.githubusercontent.com/115992753/217443181-308eace9-66b8-498b-9bfb-2fb73a7034ac.png)

### Main Class

~~~java
package main;

import cls.HeClass;
import cls.MyClass;
import cls.YouClass;

public class MainClass {
	public static void main(String[] args) {
		
		MyClass mycls = new MyClass();
		YouClass youcls = new YouClass();
		
		/*
		int number = mycls.getNumber();
		youcls.setNumber(number);
		*/
		
		// 디자인 패턴(singleton)
		mycls.myMethod();
		youcls.youMethod();
		
		System.out.println(youcls.toString());
		
		// 클래스끼리 데이터 공유
		HeClass hc = new HeClass();

		youcls.youName();
		hc.func();
		hc.heName();
		System.out.println(hc.toString());
	}

}
~~~



### Sington

~~~java
package single;

public class Singleton {
	
	private static Singleton single = null;
	
	public int number;
	public String name;

	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if(single == null) {
			single = new Singleton();
		}
		return single;
	}		

}
~~~



### My Class

~~~java
package cls;

import single.Singleton;

public class MyClass {

	private int number;
	private String name;
	
	public MyClass () {
		number = 256;
	}
	
	/*
	public int getNumber() {
		return number;
	}
	*/

	public void myMethod() {
		Singleton si = Singleton.getInstance();
		si.number = number;
	}
	
	public void myName() {
		Singleton si = Singleton.getInstance();
		name = si.name;
	}
		
}
~~~



### Your Class

~~~java
package cls;

import single.Singleton;

public class MyClass {

	private int number;
	private String name;
	
	public MyClass () {
		number = 256;
	}
	
	/*
	public int getNumber() {
		return number;
	}
	*/

	public void myMethod() {
		Singleton si = Singleton.getInstance();
		si.number = number;
	}
	
	public void myName() {
		Singleton si = Singleton.getInstance();
		name = si.name;
	}
		
}
~~~



### His Class

~~~java
package cls;

import single.Singleton;

public class HeClass {

	private int number;
	private String name;

	public HeClass() {
	}

	public void func() {
		Singleton si = Singleton.getInstance();
		number = si.number;
	}
	
	public void heName() {
		Singleton si = Singleton.getInstance();
		name = si.name;
	}

	@Override
	public String toString() {
		return "HeClass [number=" + number + ", name=" + name + "]";
	}

	
	
}
~~~



### Result

~~~java
>>YouClass [name=홍두께, number=256]
>>HeClass [number=256, name=홍두께]
~~~

