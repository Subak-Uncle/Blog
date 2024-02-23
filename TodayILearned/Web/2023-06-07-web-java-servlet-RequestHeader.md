# Request Header : 요청 헤더 값 출력하기



## index.jsp

~~~jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>RequestHeaders</title>
</head>
<body>
    <h1>RequestHeader</h1>
    <a href="headers">요청 헤더값 출력해보기</a>  <%-- 필기. URL로 servlet 이동--%>
</body>
</html>
~~~



## RequestHeaderPrintServlet

~~~java
package com.ohgiraffers.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> headerNames = req.getHeaderNames();   // 필기. 헤더 요청들을 키 값으로 Enumeration으로 반환해줌
        while (headerNames.hasMoreElements()) { // 필기. hasMoreElements : 다음 요청 값이 있는 지
            System.out.println(headerNames.nextElement());
        }

        System.out.println("accept : " + req.getHeader("accept"));
        System.out.println("cookie : " + req.getHeader("cookie"));
    }
}

~~~



### 결과

~~~java
host
connection
sec-ch-ua
sec-ch-ua-mobile
sec-ch-ua-platform
upgrade-insecure-requests
user-agent
accept
sec-fetch-site
sec-fetch-mode
sec-fetch-user
sec-fetch-dest
referer
accept-encoding
accept-language
cookie
accept : text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
cookie : JSESSIONID=53BF1CB98D1357C3E0E04998C34EA4E2

~~~

