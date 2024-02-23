---
layout: single
title: "[자바, 스프링] IoC 컨테이너"

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

# 1. IoC 컨테이너(의존 관계 주입)

![IoC Container](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/9b71e3dc-d686-414b-bb22-458081667b3d)

## 1-1. IoC 컨테이너란?

> 🐹 제어의 역전(IoC, Inversion of Control)은 일반적인 프로그래밍에서, 프로그램의 제어 흐름 구조가 뒤바뀌는 것을 의미한다.
>
> IoC Container는 IoC를 구현한 구체적인 프레임워크를 말한다.  
>
> IoC Container를 사용하면 객체의 **생성, 초기화, 의존성 처리** 등을 자동으로 수행할 수 있다. 

⇒ 대표적인 IoC Container로는 Spring Framework의 **ApplicationContext**가 있다.



## 1-2 Spring IoC Container

### 1-2-1 Bean이란?

~~~
Bean은 Spring IoC Container에서 관리되는 객체를 말한다. 
~~~

⇒ 스프링은 Bean을 **생성**하고, **초기화**하고, **의존성 주입**하고, **제거**하는 등의 일을 IoC Container를 통해 자동으로 처리할 수 있다.

### 1-2-2. Bean Factory란?

~~~
🐝 BeanFactory는 Spring IoC Container의 가장 기본적인 형태로, Bean의 생성, 초기화, 연결, 제거 등의 라이프사이클을 관리한다. 
~~~

⇒ 이를 위해 **Configuration Metadata**를 사용한다. 

### 1-2-3. Configuration Metadata란?

~~~
⭐️ BeanFactory가 IoC를 적용하기 위해 사용하는 설정 정보이다.
~~~

⇒ 설정 메타 정보는 IoC 컨테이너에 의해 관리 되는 Bean 객체를 생성하고 구성할 때 사용 된다.

![스프링 IoC Container](https://docs.spring.io/spring-framework/reference/_images/container-magic.png)

> 출처 : https://docs.spring.io/spring-framework/reference/core/beans/basics.html

### 1-2-4. Application Context란?

~~~
⭐️ BeanFactory를 확장한 IoC 컨테이너로 Bean을 등록하고 관리하는 기능은 BeanFactory와 동일하지만 스프링이 제공하는 각종 부가 기능을 추가로 제공한다.
~~~

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/019adba9-8c67-4d7e-af4a-8f0061b955b7)

<img width="1013" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/2dafc5bd-de7b-480f-aaaf-5ab30e2437c9">





## 2. IoC 컨테이너 이용해보기

### 공동

#### Member

~~~java
package com.ohgiraffers.common;

import lombok.*;

// lombok 라이브러리 사용 시 어노테이션

// @NonNull : null인지 체크
// @RequiredArgsConstructor : @NonNull 필드에 대한 생성자 자동 생성


// 필기. @Data : @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor를 자동완성
// 위 어노테이션을 합친 것이 @Data, 하지만 사용을 지양함(이유. EqualsAndHashCode가 오버라이딩 되어 있음)
//@Data
//@EqualsAndHashCode

@NoArgsConstructor    // 필기. 매개변수가 없는 기본 생성자 자동 생성
@AllArgsConstructor   // 필기. 모든 필드에 대한 생성자 자동 생성
@Getter
@Setter
@ToString
public class Member {
    // dto 패키지는 보통 common으로 사용함

    private int sequence;
    private String id;
    private String pwd;
    private String name;


}
~~~



#### MemberDAO

~~~java
package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// @Component
// @Controller
// @Service
//@Repository("dao") // 필기. 빈의 이름을 설정할 수 있다.
@Repository // 필기. Component를 상속 받아 사용. Component와 비슷
public class MemberDAO {

    private final Map<Integer, Member> memberMap;

    public MemberDAO() {
        this.memberMap = new HashMap<>();

        this.memberMap.put(1, new Member(1, "user01", "pass01", "홍길동"));
        this.memberMap.put(2, new Member(2, "user02", "pass02", "유관순"));
    }

    public Member findMemberBySequence(int sequence) {

        return  memberMap.get(sequence);
    }

    public boolean save(Member member) {

        int before = memberMap.size();

        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return after > before? true : false;
    }
}

~~~



### 2-1. xml 등록 방법

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Member member = new Member(1, "user01", "pass01", "홍길동"; 아래 입력으로 해당 줄을 입력한 것과 같은 기능-->
    <bean id="member" class="com.ohgiraffers.common.Member">
        <constructor-arg index="0" value="1"/>
        <constructor-arg name="id" value="user01"/>
        <constructor-arg index="2"><value>pass01</value></constructor-arg>
<!--        <constructor-arg index="2"><value>"pass01"</value></constructor-arg>  >> "pass01"로 나옴-->
        <constructor-arg name="name"><value>홍길동</value></constructor-arg>
    </bean>

</beans>
~~~

<constructor-arg>는 생성자 주입 방법임.

<img width="1018" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/f229af2c-5098-4f61-8cb4-656132585edf">



#### Application

~~~java
package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

//        BeanFactory : 최상위

        ApplicationContext context =
                    new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

//        Member member = (Member) context.getBean("member"); // 필기. Bean의 이름으로 가져오기. getBean은 Object 타입

//        Member member = context.getBean(Member.class);  // 필기. Bean클래스의 메타 정보로 가져오기

        Member member = context.getBean("member", Member.class);    // 필기. ("이름", 제네릭(타입 정보))

        System.out.println("member = " + member);
    }
}

~~~

#### 결과

~~~java
member = Member(sequence=1, id=user01, pwd=pass01, name=홍길동)
~~~



### 2-2. Java 설정

#### ContextConfiguration

~~~java
package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean   // 필기. 자동으로 빈을 등록해줌
    public Member getMember() { // 필기. 메소드 이름이 빈의 이름이 된다

        return new Member(1, "user01","pass01", "홍길동");
    }
}
~~~

<img width="679" alt="스크린샷 2023-07-02 오후 8 29 02" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/165f9601-5337-42a7-aef1-125f4a826ed7">

#### Application

~~~java
package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* 설명. AnnotationConfigApplicationContext클래스를 사용하여 ApplicationContext를 생성한다.
         *  생성자에 @Configuration 어노테이션이 달린 설정 클래스의 메타 정보를 전달한다. */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class); // ContextConfiguration.class : 해당 클래스의 정보를 모두 꺼낸다

        Member member = context.getBean("getMember", Member.class); // 필기. getBean -> Beans의 instance를 반환해줌
        // 필기. 빈을 "getBean"으로 등록해두었기 때문

        System.out.println("member = " + member);
    }
}
~~~

#### 결과

~~~java
member = Member(sequence=1, id=user01, pwd=pass01, name=홍길동)
~~~



### 2-3. Annotation 설정

#### ContextConfiguration

~~~java
package com.ohgiraffers.section03.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 설명. @Configuration : 설정 파일로 인식
//@ComponentScan  // 설명. 해당 어노테이션이 적힌 클래스부터 상위 패키지를 스캔, @Component를 객체로 인식하여 보관
@ComponentScan(basePackages = "com.ohgiraffers")    // 필기. 패키지 명을 적어 해당 패키지를 모두 스캔, basePackages : 스캔 범위 설정
public class ContextConfiguration {

}
~~~

<img width="809" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/ede3a596-8ce7-4b68-9b16-830dcd098eb0">

#### Application

~~~java
package com.ohgiraffers.section03.subsection01.java;

import com.ohgiraffers.common.Member;
import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();   // 문자열 배열 형태로 이름만 반환
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);    // 필기. 빈의 이름은 보통 해당 클래스 이름의 소문자

        System.out.println(memberDAO.findMemberBySequence(1));
        System.out.println(memberDAO.save(new Member(3, "user03", "pass03", "신사임당")));
        System.out.println(memberDAO.findMemberBySequence(3));

    }
}

~~~

#### 결과

~~~java
beanName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
beanName = org.springframework.context.annotation.internalAutowiredAnnotationProcessor
beanName = org.springframework.context.event.internalEventListenerProcessor
beanName = org.springframework.context.event.internalEventListenerFactory
beanName = contextConfiguration
beanName = memberDAO
Member(sequence=1, id=user01, pwd=pass01, name=홍길동)
true
Member(sequence=3, id=user03, pwd=pass03, name=신사임당)
~~~

## 3. 테스트 결과

~~~java
package com.ohgiraffers.common;

import com.ohgiraffers.section03.subsection01.java.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})  // 필기. 내가 만든 ContextConfiguration으로 import 되는 지 필히 확인!
public class MemberDAOTests {

    @Autowired  // 타입을 자동으로 찾아 설정됨
    private MemberDAO memberDAO;

    @Test
    public void testCreateMemberDAO() {

        assertNotNull(memberDAO);
    }

    @Test
    public void testFindMemberbySequence() {

        // given
        int sequence = 1;

        // when
//        MemberDAO memberDAO = new MemberDAO();
        Member foundMember = memberDAO.findMemberBySequence(sequence);

        // then
        assertEquals("홍길동", foundMember.getName());
    }

    @Test
    public void testSave() {

        //given
        Member member = new Member(3, "user03", "pass03", "유관순");

        //when
        boolean result = memberDAO.save(member);

        //then
        assertTrue(result);
    }
}
~~~



## 주제 : 텍스트 기반 RPG 게임

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/800d3114-3218-4a83-a2cc-d04d19437804)

레이어드 아키텍처(도메인 주도 개발방식, 단일 채) CQRS 패턴

com.ohgiraffers.princessmaker.member

.alba

dao = repository



뷰에서만 Scanner,
뷰에서 메인 메소드에 한 줄 초과 하지 않기.



단위 test 많은 곳 : 도메인 서비스 > Application 서비스, 컨트롤러 단위 기능



private static, Map



![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/4b33d293-1938-4571-a7cd-b8fecf94d22f)

