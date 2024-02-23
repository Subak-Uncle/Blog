---
layout: single
title: "[Web] : Servlet GET, POST"

categories: Web
tags: [web, servlet, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: ture
date: 2023-06-07
last_modified_at: 2023-06-07
sidebar:
  nav: "docs"
---



# Servlet doGet/doPost



### index.jsp

~~~jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>RequestParameter</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Request Parameter</h1>

    <h3>GET 방식의 요청</h3>

    <h4>form 태그를 이용한 get 방식 요청</h4>   <!--필기. 원하는 태그명 입력 후 Tab키 입력 시 자동 태그 생성-->
    <form action="querystring" method="get">
        <!-- 필기. inline 요소와 block 요소가 존재. label, input은 inline 요소임 -->
        <label>이름 : </label>    <!-- 필기. label: 하나의 태그로 영역을 만들기 위해 사용 -->
        <input type="text" name="name"> <!-- 필기. form형태로 데이터를 전송할 때 MAP형태로 보내지기 때문에 키 값을 설정해야 함 -> name으로 키값 설정 -->
        <br>
        <label>나이 : </label>
        <input type="number" name="age" value="21"> <%-- 필기. value를 정의해주어도 텍스트를 받으면 value가 변경됨--%>
        <br>
        <label>생일 : </label>
        <input type="date" name="birthday">
        <br>
        <label>성별 : </label>
        <%-- 필기. name으로 묶지 않으면 다중 선택이 가능해지므로 주의.--%>
        <input type="radio" name="gender" id="male" value="M">
        <label for="male">남자</label>    <%-- 필기. label을 눌러도 radio가 작동하도록 input 태그에 id, label 태그에 for 작성--%>
        <input type="radio" name="gender" id="female" value="F">    <%--필기. value는 값 전달을 위해 설정--%>
        <label for="female">여자</label>
        <br>

        <%--설명. selectBox - 단일 선택--%>
        <label>국적 : </label>
        <select name="national">
            <option value="ko">한국</option>
            <option value="ch">중국</option>
            <option value="jp">일본</option>
            <option value="etc">기타</option>
        </select>
        <br>

        <%--설명. checkBox - 다중 선택 가능--%>
        <label>취미 : </label>
        <input type="checkbox" id="movie" value="movie" name="hobbies"><label for="movie">영화</label>
        <input type="checkbox" id="music" value="music" name="hobbies"><label for="music">음악</label>
        <input type="checkbox" id="sleep" value="sleep" name="hobbies"><label for="sleep">취침</label>
        <br>

        <input type="submit" value="GET 요청">    <%-- 필기. servlet 설정이 안되어 있으면 404에러가 발생 --%>
        <%-- 필기. querystring 뒤에 ? 뒤에 데이터, {키값} = {속성} 이 들어있고 &으로 구분--%>
    </form>

    <h4>a 태그의 href 속성에 직접 파라미터를 쿼리스트링 형태로 작성하여 get방식 요청</h4>
    <a href="querystring?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=21&birthday=2023-06-07&gender=M&national=ko&hobbies=movie&hobbies=music">쿼리스트링을 이용한 get</a>
    <%--필기. a 태그에서 url을 넣을 시 인코딩에 의해 한글이 깨짐, GET 방식은 Read를 위한 요청--%>

    <h3>POST 방식의 요청</h3>

    <h4>form 태그를 이용한 post 방식의 요청</h4>
    <form action="formdata" method="post">  <%--필기. form 태그에 method를 설정해주지 않으면 기본인 GET으로 보내짐.--%>
        <label>이름 : </label>    <!-- 필기. label: 하나의 태그로 영역을 만들기 위해 사용 -->
        <input type="text" name="name"> <!-- 필기. form형태로 데이터를 전송할 때 MAP형태로 보내지기 때문에 키 값을 설정해야 함 -> name으로 키값 설정 -->
        <br>
        <label>나이 : </label>
        <input type="number" name="age" value="21"> <%-- 필기. value를 정의해주어도 텍스트를 받으면 value가 변경됨--%>
        <br>
        <label>생일 : </label>
        <input type="date" name="birthday">
        <br>
        <label>성별 : </label>
        <%-- 필기. name으로 묶지 않으면 다중 선택이 가능해지므로 주의.--%>
        <input type="radio" name="gender" id="male2" value="M">
        <label for="male2">남자</label>    <%-- 필기. label을 눌러도 radio가 작동하도록 input 태그에 id, label 태그에 for 작성--%>
        <input type="radio" name="gender" id="female2" value="F">    <%--필기. value는 값 전달을 위해 설정--%>
        <label for="female2">여자</label>
        <br>

        <%--설명. selectBox - 단일 선택--%>
        <label>국적 : </label>
        <select name="national">
            <option value="ko">한국</option>
            <option value="ch">중국</option>
            <option value="jp">일본</option>
            <option value="etc">기타</option>
        </select>
        <br>

        <%--설명. checkBox - 다중 선택 가능--%>
        <label>취미 : </label>
        <input type="checkbox" id="movie2" value="movie" name="hobbies"><label for="movie2">영화</label>
        <input type="checkbox" id="music2" value="music" name="hobbies"><label for="music2">음악</label>
        <input type="checkbox" id="sleep2" value="sleep" name="hobbies"><label for="sleep2">취침</label>
        <br>

        <input type="submit" value="POST 요청">    <%-- 필기. servlet 설정이 안되어 있으면 404에러가 발생 --%>
    </form>


</body>
</html>
~~~

#### 화면

<img width="504" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/656f3591-d4a4-4bff-a2e5-7d04fd71e65d">



## GET

### QueryStringTestServlet.java (GET)

~~~java
package com.ohgiraffers.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    // 필기. GET 방식은 Header에 소속되어 있는 URL에 데이터를 담아서 보냄. URL 인코딩으로 데이터를 보내므로 인코딩 설정 별도로 할 필요 없음.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");   // 필기. getParameter 안에는 string 형태로 매개변수가 들어감.
        System.out.println("name = " + name);

        int age = Integer.parseInt(request.getParameter("age"));    // 필기. getParameter는 string으로 리턴되기 때문에 원하는 타입으로 parsing 필요함.
        System.out.println("age = " + age);

        // 설명. 날짜 객체 생성
//        java.sql.Date birthday = request.getParameter("birthday");
        // 필기. Date 오버로딩 중 년월일을 매개변수로 넣는 메소드가 존재하지만 @Deprecated 가 있어 사용자제(삭제 가능성 있음). -> 다른 오버로딩 중 long 타입 매개변수를 넣는 메소드 이용.

        // 설명. "2023-06-07" -> 년도/월/일로 parsing, 직접 날짜 객체를 생성하는 방법
//        String tempDate = request.getParameter("birthday");   // "2023-06-07"
//        String[] arr = tempDate.split("-");
//        int year = Integer.parseInt(arr[0]);  // 2023
//        System.out.println("year = " + year);
//        int month = Integer.parseInt(arr[1]); // 6
//        System.out.println("month = " + month);
//        int date = Integer.parseInt(arr[2]);  // 7
//        System.out.println("date = " + date);
//
//        Calendar calendar = new GregorianCalendar(year, month-1, date);   // 필기. month가 0부터 시작함 -> 'month-1'로 넣어야 우리가 원하는 month를 얻음
//        // 필기. month 범위 0~11
//        System.out.println("calendar.getTimeInMillis = " + calendar.getTimeInMillis()); // 1686063600000
//        java.sql.Date birthday = new java.sql.Date(calendar.getTimeInMillis()); // 필기. TimeMillis : 1000분의 1초로 계산. 즉, 밀리세컨드로 나타냄.
//
//        System.out.println("birthday = " + birthday);

        // 설명. 라이브러리를 활용하여 날짜 객체 생성하는 방법
        java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
        System.out.println("birthday = " + birthday);
        System.out.println(birthday instanceof java.sql.Date);

        // 성별
        String gender = request.getParameter("gender");
        System.out.println("gender = " + gender);

        // 국적
        String national = request.getParameter("national");
        System.out.println("national = " + national);

        // 취미
        String[] hobbies = request.getParameterValues("hobbies");
        for (String hobby : hobbies) {
            System.out.println("hobby = " + hobby);
        }
    }

}
~~~



#### 결과

~~~java
name = 홍길동
age = 212
birthday = 2023-06-07
true
gender = F
national = ko
hobby = movie
hobby = music
hobby = sleep
~~~



#### 화면

<img width="718" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/170695f9-b6cf-420e-a95b-8ceeb1fde250">

위 화면과 같이 URL에 모든 데이터가 들어가 있다.

>  URL/{서블릿 url}? {키 값} : {value} &  {키 값} : {value} &  {키 값} : {value}



## POST

### FormDAtaTestServlet.java (POST)

~~~java
package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    // 필기. POST 방식은 meta 인코딩 방식을 참고하여 데이터를 보냄. 데이터는 Body에서 formdata에 데이터를 담아서 보냄.
    //  payload = HTTP 메세지 본문
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(request.getCharacterEncoding());
//        request.setCharacterEncoding("UTF-8");  // 필기. 톰캣 10 버전부터는 encoding 설정을 자동으로 UTF-8로 해줌, POST 요청에선 인코딩 설정이 필수였음.
                
        String name = request.getParameter("name");
        System.out.println("name = " + name);

    }
}
~~~



### 화면

<img width="818" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/5179b064-f208-4b7f-8360-31a15fd1333d">

위 사진에서처럼 **"POST"** 방식으로 데이터를 보냈으므로 URL엔 데이터가 없고 **본문(HTTP에서 Payload)**에 정상적으로 데이터가 옮겨져 있는 것을 확인할 수 있다.





