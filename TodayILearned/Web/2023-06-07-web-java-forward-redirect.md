---
layout: single
title: "[Web] : Servlet Forward, Redirect"

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

# Web 전체 구조

<img width="818" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/dd509835-8423-4a80-b6ae-d08f07c95372">



# Servlet

## forward / sendRedirect Servlet



Servlet에는 두 가지 Request 요청 처리 방법이 있다. 

1. forward
2. Redirect



### forward(RequestDispatcher)

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/212a8b76-fd38-4e95-9d6c-75ca2e888c5d)

> 출처 : https://kgvovc.tistory.com/41



#### 실행 순서

Client -> Request -> Servlet1 -> Request -> Servlet2 -> Response -> Client



#### Index.jsp(클라이언트)

~~~jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forward</title>
</head>
<body>
    <h1>Forward</h1>

    <form action="forward" method="post">
        <label>아이디 : </label>
        <input type="text" name="userId">
        <br>
        <label>패스워드 : </label>
        <input type="password" name="password">
        <br>
        <button type="submit">로그인</button>
    </form>
</body>
</html>
~~~

##### 화면

<img width="234" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/33bca9e3-6347-474e-ae1f-7efcf11c8e59">



#### Receive Information Servlet(Servlet 1)

~~~java
package com.ohgiraffers.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        // 데이터베이스 조회
        // 추가적인 로직...

        req.setAttribute("userId", userId);

        RequestDispatcher rd = req.getRequestDispatcher("print");   // 필기. 요청의 위치를 설정해준다.
        rd.forward(req, resp);  // 'print' servlet으로 위임
    }
}

~~~

##### 결과

~~~java
userId = dodo
password = dodo1
~~~

##### 화면

<img width="316" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/7724c914-f0c3-4577-8996-3fec1b3afd71">



#### PrintLoginSuccessServlet(Servlet 2)

~~~java
package com.ohgiraffers.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = (String) req.getAttribute("userId");

        System.out.println("print servlet userId = " + userId);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")    // <h3 align="center">
                .append(userId)
                .append("님 환영합니다.</h3>")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(responseText.toString());

        out.flush();
        out.close();

    }
}
~~~

##### 결과

~~~java
print servlet userId = dodo
~~~

##### 주의

Response Status Code **"200"**!! => 새로 고침 시 계속해서 요청이 전송됨. 

새로 고침 시 thread가 생성되어 하나의 요청을 처리함.

#### 새로고침 시

**"forward"** 방식은 새로고침 시 하나의 Thread가 할당되어 다시 처음부터 request와 response를 보냄.
여기서 문제가 되는데, DB에 같은 정보를 여러 번 저장하게 되는 상황이 발생함. 그래서 보통 "forward"는 단순 조회 용도로만 사용된다.

##### 결과

~~~java
userId = dododo
password = dodo11
print servlet userId = dododo
    새로고침
userId = dododo	
password = dodo11
print servlet userId = dododo
    새로고침
userId = dododo
password = dodo11
print servlet userId = dododo
~~~







### Redirect

![image-20230607150719610](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230607150719610.png)

#### 실행 순서

Client -> Request -> Servlet 1 -> DB -> Servlet 1 -> Response(301 status code) -> Client -> Request -> Servlet 2 -> Response -> Client



#### 특이점

- 새로고침 시 "/response"(servlet 2)로만 재요청이 되어 결과값만 리턴된다.
- servlet 1의 응답으로 302번 status code가 나온다.
- servlet 간 데이터를 나누는 방법이 "forward"와 차이가 있다.



#### 서블릿 간에 데이터 공유 방법

전체 과정에서  "/redirect"(servlet 1)에서 "/response"로 response를 전달하는 방법 세 가지.

![image-20230607151624403](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230607151624403.png)



1. URL로 데이터 전송
2. 쿠키를 통한 데이터 전송
3. 세션을 통한 데이터 전송

보안 상에 이유로 보통 세션으로 전달함.



#### index.jsp(클라이언트)

~~~jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>redirect</title>
</head>
<body>
    <h1>redirect</h1>
    <nl>
        <li><a href="othersite">다른 웹 사이트로 리다이렉트</a></li>
        <li><a href="otherservlet">다른 서블릿으로 리다이렉트</a></li>
    </nl>
</body>
</html>
~~~

##### 화면

<img width="233" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/fe66b714-cbdd-4671-bfc5-4c73ad10cf29">



#### OtherSiteRedirectServlet(다른 사이트 이동 Redirect)

~~~java
package com.ohgiraffers.section01.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("get 요청 후 naver 사이트로 redirect");

        resp.sendRedirect("http://www.naver.com");
    }
}
~~~

##### 화면

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/efed7885-5a3b-40ff-92c0-29cd10377814)

> 개발자 도구 - network 페이지

위 화면에 보이다시피 Servlet 1을 통해 응답에 대한 Status Code가 302번인 것을 확인할 수 있고, Location이 **naver.com**으로 되어 있는 것을 볼 수 있다.

또한,
<img width="443" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/9ee4e920-bbaa-4de5-ba73-211efb23085e">

네이버에 대한 네트워크 페이지에서도 Status Code가 302번인 것을 알 수 있다.



#### OtherServletRedirectTestServlet (Servlet 1)

~~~java
package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/otherservlet")
public class OtherServletRedirectTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("get 요청 정상 수락");

        Logic logic = new Logic();
        logic.registData();
        
        resp.sendRedirect("redirect?name=gildong&age=20");  // 필기. "redirect"라는 경로의 servlet한테 위임. location Header 정보 변경
        // 필기. 네트워크 탭에 location header에 'redirect'로 나와 있음.
    }
}
~~~



##### 화면

<img width="1220" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/fa3bdcbe-6e2c-46a0-a158-59bde0f50054">



여기서, Servlet 1에선 html문이 작성되지 않았고, URL에 **"/otherservlet"**이 아닌 **"/redirect"**로 되어 있다.  그 이유는 "OtherServletRedirectTestServlet "에서 logic에 대한 리턴 값을 받고, **"sendRedirect"**를 통해 URL로 데이터와 함께 "/redirect"로 매핑해주었다.



#### Logic

~~~java
package com.ohgiraffers.section02.otherservlet;

public class Logic {

    public void registData() {

        System.out.println("DB에 데이터를 생성했습니다.");
    }
}
~~~



#### RedirectServlet (Servlet 2)

~~~java
package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // 필기. "redirect" 형식으로 받아 오기 때문에 무조건 GET 방식임
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 성공!");     // 필기. 새로고침 시에도 현재의 서블릿만 실행됨.

        String name = req.getParameter("name");     // 필기. 받은 데이터 짐 풀기
        int age = Integer.parseInt(req.getParameter("age"));    // 필기. getParameter는 Object 타입이므로 Parsing이 필요함

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        StringBuilder redirectText = new StringBuilder();   // 필기. String을 더하는 느낌
        redirectText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(redirectText);

        out.flush();
        out.close();

    }
}
~~~



##### 결과

~~~java
get 요청 정상 수락
DB에 데이터를 생성했습니다.
이 서블릿으로 redirect 성공!
name = gildong
age = 20
~~~



#### 새로고침 시 

RedirectServlet (Servlet 2) 에게만 요청하므로 **"OtherServeletRedirectTestServlet"**에 있는 출력문이 실행이 되지 않는다.

##### 결과

~~~java
get 요청 정상 수락
DB에 데이터를 생성했습니다.
이 서블릿으로 redirect 성공!
name = gildong
age = 20
    새로고침
이 서블릿으로 redirect 성공!
name = gildong
age = 20
    새로고침
이 서블릿으로 redirect 성공!
name = gildong
age = 20

~~~



