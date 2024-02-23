---
layout: single
title: "[Web] : Servlet - LifeCycle, Method"

categories: Web
tags: [web, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: ture
date: 2023-06-01
last_modified_at: 2023-07-01
sidebar:
  nav: "docs"
---



# Servlet Method



## index.html

~~~html
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>service() 메소드의 역할</h1>
<h3>GET 방식의 요청</h3>
<h4>a태그의 href 속성값 변경</h4>
<a href="request-service">서비스 메소드 요청하기</a>

<h4>form 태그의 method 속성을 get으로 설정</h4>
<form action="request-service" method="GET">
    <input type="submit" value="GET 방식 요청 전송">
</form>

<h3>POST 방식의 요청</h3>
<h4>form 태그의 method 속성을 post로 설정</h4>
<form action="request-service" method="POST">
    <input type="submit" value="POST 방식 요청 전송">
</form>


</body>
</html>
~~~



## ServiceMethodTestServlet

~~~java
package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("service() 메소드 호출됨...");

        String httpMethod = req.getMethod();
        System.out.println("httpMethod = " + httpMethod);

        if("GET".equals(httpMethod)) {
            doGet(req, resp);
        } else if("POST".equals(httpMethod)) {
            doPost(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}
~~~

### 결과

- <a>링크 시

~~~java
service() 메소드 호출됨...
httpMethod = GET
GET 요청을 처리할 메소드 호출
~~~

- Get 버튼 클릭 시

~~~java
service() 메소드 호출됨...
httpMethod = GET
GET 요청을 처리할 메소드 호출
~~~

- POST 버튼 클릭 시

~~~java
service() 메소드 호출됨...
httpMethod = POST
POST 요청을 처리할 메소드 호출
~~~

> 특이점

<a>링크를 통해 들어와도 GET 방식으로 이동됨.

