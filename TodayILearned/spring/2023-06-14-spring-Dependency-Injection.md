---
layout: single
title: "[자바, 스프링] Dependency Injection"

categories: Java, Spring
tags: [java, spring, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: ture
date: 2023-06-14
last_modified_at: 2023-06-14
sidebar:
  nav: "docs"
---

#  1. Dependency Injection

## 1-1. Dependency Injection이란?

### 1-1-1. Dependency Injection

>  Dependency Injection(의존성 주입, 이하 DI)은 객체 간의 ***의존 관계***를 빈 설정 정보를 바탕으로 컨테이너가 자동적으로 연결해주는 것을 말한다. 이를 통해 객체 간의 ***결합도***를 낮출 수 있으며 이로 인해 ***유지보수성***과 ***유연성***이 증가한다.

### 1-1-2. 의존 관계와 결합도

객체 넣는 방법

1. 생성자

   new ClassA(new ClassB());

2. setter

​	ClassA a = new ClassA();
​	a,setB(new ClassB());

~~~java
public class A {
	
	private B b = new B();

}

public class B {

}
~~~

class A 가 class B 를 필드로 가질 때 A는 B에 의존하게 된다. 

~~~java
public class A {

	/* 컴파일 에러 발생 */
	private B b = new B();

}

/* 클래스명이 B에서 NewB로 변경 */
public class NewB {
	
}
~~~

의존성이 강하다는 것은 한 객체가 변경되면 이에 의존하는 다른 객체들도 함께 변경되어야 한다는 것을 의미한다. ***B***가 ***NewB*** 로 변경되면 해당 클래스를 필드로 가지고 있는 ***A*** 도 변경되어야 할 것이다. 이처럼 객체 간의 의존 관계가 강하게 묶여있을 때 ***결합도*** 가 높다고 표현한다. 이로 인해 유지보수성과 유연성이 저하될 수 있다. 

~~~java
public class A {

	/* 상위 타입을 필드로 설정 */
	private B b;

	/* 직접 객체를 생성하지 않고 생성자를 통해 전달 받음 */
	public A(B b) {
		this.b = b;
	}

}

/* 상위 타입으로 사용할 인터페이스 */
public interface B {

}

/* 인터페이스의 구현 클래스 */
public class NewB implements B {

}
~~~

이전의 코드와 비교하면 ***NewB*** 라는 구체적인 구현체의 타입을 사용하는 대신 ***B*** 라는 상위 인터페이스 타입으로 필드를 선언했다. 또한 직접 객체를 생성하는 구문도 없어졌고 생성자를 통해 전달 받도록 했다. 이렇게 변경하면 실제로 사용하는 구현체가 ***NewB*** 에서 또 다른 타입으로 변경 되더라도 ***A*** 의 코드는 변경 될 필요가 없다. 의존 관계가 느슨해지고 결합도가 낮아졌다고 할 수 있다.

# 2. DI 방법 알아보기

## 공동

### Account 인터페이스

~~~java
package com.ohgiraffers.common;

public interface Account {

    /* 잔액조회 */
    String getBalance();

    /* 입금 */
    boolean deposit(int money);

    /* 출금 */
    boolean withdraw(int money);
}
~~~

### Member 클래스(DTO)

~~~java
package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {

    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;
}
~~~



### PersonalAccount ( Account 인터페이스 상속) 클래스

~~~java
package com.ohgiraffers.common;

public class PersonalAccount implements Account{

    private String accNo;   // 계좌 번호
    private int balance;    // 잔액

    public PersonalAccount() {}

    public PersonalAccount(String accNo, int balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    @Override
    public String getBalance() {

        /* Int -> String */
//        return Integer.toString(this.balance);
//        return this.balance + "";
        return String.valueOf(this.balance);
    }

    @Override
    public boolean deposit(int money) {

        if (money <= 0) {
            throw new IllegalArgumentException("입금할 금액이 잘못되었습니다.");
        }

        this.balance += money;

        return true;
    }

    @Override
    public boolean withdraw(int money) {

        if (money > this.balance) {
            throw new IllegalArgumentException("잔액보다 큰 금액을 출금할 수 없습니다.");
        }
        this.balance -= money;

        return true;
    }
}
~~~





## xml로 빈 등록

<hr>


### spring-context.xml

~~~java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean 태그의 class 속성은 인터페이스 타입이 아닌 구현 클래스 타입으로 작성해야 한다.-->
    <bean id="account" class="com.ohgiraffers.common.PersonalAccount">
        <constructor-arg index="0"><value>123-456-789012</value></constructor-arg>
        <constructor-arg index="1"><value>0</value></constructor-arg>
    </bean>



    <!-- setter 주입 -->
    <bean id="member" class="com.ohgiraffers.common.Member">
        <property name="sequence" value="1"/>    <!--name은 setter에 대한 이름과 일치해야 함-->
        <property name="name" value="홍길동"/>
        <property name="phone" value="010-1234-5678"/>
        <property name="email" value="hong123@gmail.com"/>
        <property name="personalAccount" ref="account"/>
    </bean>

</beans>



<!--
     생성자 주입
<bean id="member" class="com.ohgiraffers.common.Member">
<constructor-arg name="sequence" value="1"/>
<constructor-arg name="name" value="홍길동"/>
<constructor-arg name="phone" value="010-1234-5678"/>
<constructor-arg name="email" value="hong123@gmail.com"/>
<constructor-arg name="personalAccount" ref="account"/> 의존성 주입
</bean>
-->
~~~



### Application.java

~~~java
package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        /* 필기. 주입된 빈의 멤버 확인 */
        Member member = context.getBean(Member.class);
        System.out.println("member = " + member);

        /* 설명. 해당 멤버의 계좌 확인*/
        Account account = member.getPersonalAccount();
        System.out.println("계좌 잔액 확인 : " + account.getBalance());
        System.out.println("1만원 입금 ~~ 되었는가~?  " + account.deposit(10000));
        System.out.println("계좌 잔액 확인 : " + account.getBalance());
        System.out.println("5천원 출금 ~~~ 되었는가~?  " + account.withdraw(5000));
        System.out.println("계좌 잔액 확인 : " + account.getBalance());
    }
}
~~~



## java로 bean 등록

<hr>


### ContextConfiguration

~~~java
package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {

        return new PersonalAccount("111-222-333333", 1000); // 계좌에 천원을 넣고 생성
    }

    @Bean
    public Member memberGenerator() {
//        return new Member(1,
//                "홍길동",
//                "010-1234-5678",
//                "hong123@gmail.com",
//                accountGenerator());

        Member member = new Member();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong123@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
~~~



### Application 자바

~~~java
package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 필기. 주입된 빈의 멤버 확인 */
        Member member = context.getBean(Member.class);
        System.out.println("member = " + member);

        /* 설명. 해당 멤버의 계좌 확인*/
        Account account = member.getPersonalAccount();
        System.out.println("계좌 잔액 확인 : " + account.getBalance());
        System.out.println("1만원 입금 ~~ 되었는가~?  " + account.deposit(10000));
        System.out.println("계좌 잔액 확인 : " + account.getBalance());
        System.out.println("5천원 출금 ~~~ 되었는가~?  " + account.withdraw(5000));
        System.out.println("계좌 잔액 확인 : " + account.getBalance());
    }
}
~~~

