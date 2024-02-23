# Thread 와 Network



## Thread

~~~java
package com.ohgiraffers.section01.thread;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 쓰레드에 대해 이해할 수 있다. */
        /* 필기.
            프로세스(process)란 실행중인 프로그램이라고 할 수 있다.
            즉, 프로그램을 운영체제의 메모리와 cpu를 할당받아 실행되는 단위

            필기.
             쓰레드(thread)란 프로세스 내에서 실제로 작업을 수행하는 주체를 의미한다.
             모든 프로세스는 한 개 이상의 스레드를 가진다.
             두 개 이상의 쓰레드를 가지는 프로세스를 멀티쓰레드라고 한다.
        * */

        /* 필기.
         *  쓰레드를 만드는 방법
         *   1. Thread 클래스를 상속받는 방법
         *   2. Runnable 인터페이스를 상속받는 방법
        * */

        // 설명. Car와 Tank, Plane 객체 만들기
        Car car = new Car();
        Tank tank = new Tank();
        Plane plane = new Plane();

        Thread t1 = new Car();  // 필기. Thread t1 = car; 과 같다.
        Thread t2 = new Tank(); // 필기. Thread t2 = tank;
        Thread t3 = new Thread(new Plane());  // 필기. Thread 메소드는 기본 생성자와 Runnable를 매개변수로 받는 생성자가 존재.

        // 설명. 단일 쓰레드 => 하나의 쓰레드가 하나의 프로세스 씩 실행. 하나의 스택 메모리 같은 칸 이용.
//        t1.run();
//        t2.run();
//        t3.run();

        // 설명. 멀티 쓰레드 => 여러 스택에서 하나의 프로세스 씩 실행. (메인 스택 메모리는 실행 후 바로 삭제됨.)
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main()이 종료됨...");


    }
}
~~~



## Network

종이컵 전화기

소켓(프로그램), 스트림(줄), 포트(귀에 대는지), IP주소(누군지 특정짓기)

## TCP / UDP

TCP: {전화? - 상대방이 전화 받은 지 확인 할 수 있음(신뢰도), 전화 연결되는데 시간 걸림(속도)}  = http

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/334ad04b-b47f-4872-9b93-ac93f791df64)

- 프로토콜(신뢰도가 높은 프로토콜)
- 속도 느림
- 연결 지향 프로토콜

UDP: (소포 - 상대방이 받은지 안 받은지 모름(신뢰도), 택배 부치면 끝(속도))

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/b532f335-dd8b-4068-98a7-aed46af47ab3)

- 신뢰도 낮음
- 속도 높음
- 비연결 지향 프로토콜



### 내부/외부 IP



같은 네트워크 상에선 내부 IP만으로 통신 가능.

하지만 다른 네트워크에서 해당 pc로 통신하기 위해서는 외부 IP를 알고 접근해야 가능하다.



### HTTP

- 헤더

  1. General Header
  2. Request Header
  3. Response Header
  4. Entity Header

- 바디

  





## Tomcat

![image-20230605150058026](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230605150058026.png)

> https://tomcat.apache.org/whichversion.html 참고

우리는 JDK 11.0.15 버전을 사용하므로 10.1.9 버전 사용. 
(참고로 톰캣 10버전부터 **'javaEE'**가 **'jakartaEE'**로 명칭이 변경되었습니다.)

![image-20230605142236225](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230605142236225.png)

주소창이 더러움. 

![image-20230605142345077](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230605142345077.png)

-> 인텔리제이 우측 상단 톰캣 클릭 - Edit Configurations을 누르면 아래 창이 뜹니다.

![image-20230605145542082](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230605145542082.png)

여기서 VM options에 "**-Dfile.encoding=UTF-8**"라고 적어줍니다.



다음으로, Deployment 탭에서 

![image-20230605142500247](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230605142500247.png)

Application context(프로젝트  루트!) 부분을 **'/'**로 바꿔줘야 url이 깔끔해집니다.

이렇게까지 하면

![image-20230605145907030](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230605145907030.png)

localhost 뒤에 url이 깔끔해집니다.







##### 자바 필수 코스 (우선 순위)

- 객체
- 상속 (중요)
- 다형성 (중요)
- 컬렉션(HashMap), 제네릭스(급함)
- 입출력
- 람다, 스트림
- parser, StringBuilder, 이스케이프 문자, split,  - 자주 쓰는 API