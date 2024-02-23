### Redirect

<img width="647" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/45a0c710-0838-42fe-bdff-c6154e2b84d1">



# Cookie

![image-20230612113029022](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230612113029022.png)





### HTTP 특성

- 무 상태성(Stateless)
- 무 연결성(Connectless)



### 로그인 할 때 쓰는 방법

- 세션 - RESTAPI 에선 무상태성을 고려하여 session 기반의 로그인을 지양함.
- JWT
- OAuth(3자 인증 방법 - ex) 카카오 로그인, 구글 로그인) 토큰 발행 서버가 따로 존재



트래픽 몰릴 때 

1. 서버 성능 업 , 스케일 업(램 추가)

2. 서버 증설, 스케일 아웃(pc 추가) -> 서버 증설 시 서버마다 세션이 상이하므로 정보 불러오기 힘듦 -> 세션 클러스트르

분배기 역할 - 로들 밸런서 => 트래픽 분산 : 로드 밸런싱(라운드 로빈 방식으로 분산해줌. 서버들에 각각 한번 씩 보내줌)





### 토큰(출입증 - 유효기간 인증)

클라이언트에 보관됨(서버가 증설되더라도 이용이 쉬움) -> 보안 약함.(민감한 개인정보를 제외한 가벼운 정보들을 보관함.) -> 만료 시간을  짧게 설정해야 함. 

RestAPI에서는 토큰을 이용해 로그인 인증을 함.





트레이드 오프???





### 필터

필터 체이닝(Filter chain)- 여러 서블렛을 필터링한다.

필터는 프로젝트 시작고 ㅏ함께 먼저 동작한다.





# jsp(Java Server Page)

<img width="365" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/39a0c83a-23a6-42c6-9518-a0eb39fc027f">

webapp이 root 임 . 

localhost:8080/ -> '/'가 root를 가르킴

/jsp/... 절대 경로 -> root로부터 파일을 찾을 때

jsp/... 상대 경로



JSP : html -> java 로 컴파일해주는  것 = jsp컨테이너(jsp ->servlet : Translation) < 컨텍스트(컨테이너 조작하기 위한)



jsp 실행 과정 :

Translation(jsp -> servlet) =>compile(.java -> .class) => servlet => 동적 웹페이지 생성service => 응답 전송



# Session



### index.jsp

~~~jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>session</title>
</head>
<body>
    <h1>session</h1>
    <form action="session" method="post">
        <label>firstName : </label>
        <input type="text" name="firstName">
        <br>
        <label>lastName : </label>
        <input type="text" name="lastName">
        <br>
        <input type="submit" value="전송">
    </form>

    <%--설명. 세션과 토큰을 트레이드오프--%>
    <a href="delete">세션 데이터 지우기</a>
</body>
</html>
~~~



### SessionHandlerServlet

~~~java
package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // 필기. 내 고유 ID : 이 키 값을 알아야 value를 전달할 수 있음.
        HttpSession session = req.getSession();
        System.out.println("session.getId() = " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");
    }
}
~~~



### RedirectServlet

~~~java
package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("redirect servlet session id = " + session.getId());

        String firstName = String.valueOf(session.getAttribute("firstName"));
        String lastName = String.valueOf(session.getAttribute("lastName"));

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
    }
}
~~~



### DeleteSessionDataServlet

~~~java
package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames(); // 필기. 세션 목록 조회
        while (sessionNames.hasMoreElements()) {    // 다음 element가 있다면
            System.out.println("sessionNames.nextElement() = " + sessionNames.nextElement());
        }

        /* 필기.
        *   세션의 데이터를 지우는 방법
        *   1. 세션에 만료 시간 설정
        *   2. removeAttribute() 로 session의 attribute를 제거한다.
        *   3. invalidate() 를 호출하면 세션이 만료된다.
        * */
        
        // 필기. 1. 세션에 만료 시간 설정
//        session.setMaxInactiveInterval(600);    // 10분
        
        // 필기. 2. removeAttribute() 세션 제거
        session.removeAttribute("firstName");
        Enumeration<String> remain = session.getAttributeNames();
        while (remain.hasMoreElements()) {
            System.out.println("remain.hasMoreElements() = " + remain.hasMoreElements());
        }
        
        // 필기. 3. invalidate() 세션 제거
        session.invalidate();
        Enumeration<String> remain2 = session.getAttributeNames();  // 필기. 세션이 존재하지 않으므로 getAttributeNames 실행 안됨 -> 500번 에러 발생
        while (remain2.hasMoreElements()) {
            System.out.println("remain2.getId() = " + session.getId());
        }
        
    }
}

~~~



## 직 무

- 차별성 : 어떤 회사에서 채용을 하는 지, 어떤 분야에서 채용하는 지.

- 종류 :
  - SI	-	IT 서비스/ 소프트웨어 공급
    - 클라이언트 요구 사항(개발 회사 / 개인) - RFP
    - 프리랜서 개발자가 많다.
    - 안정적인 삶
    - 납기일o -> 속도전!
    - 자바 90!
  - 솔루션  -  유지보수, sm
    - 안정적인 삶, 연봉상승률이 낮음
  - 서비스(인터넷 서비스) - 자체 개발, 납기일x
    - 꼼꼼함
