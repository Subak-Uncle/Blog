# **📝HTTP (Hypertext Transfer Protocol)**

- HTTP는 [World Wide Web](https://ko.wikipedia.org/wiki/월드_와이드_웹)에서 정보를 주고 받을 수 있게 해주는 프로토콜이다.
- 웹에서 송수신 되는 정보는 HTML, CSS, JS, 이미지 등이 있다.
- HTTP는 TCP 기반에서 동작하며, 80번 포트를 사용한다. (HTTP 3는 UDP 기반에서 동작한다.)

## **📌 Client-Server Model**

!https://jujubebat.github.io/assets/images/2020-07-16-15-02-18.png

- HTTP는 클라이언트와 서버로 구현된다.
- 클라이언트가 서버에게 HTTP 요청을 보내면, 서버는 요청에 대한 HTTP 응답을 되돌려준다.
  - 예를들어 클라이언트인 웹 브라우저가 HTTP를 사용해서 서버에게 HTML이나 이미지 등을 요청하면
  - 서버는 필요한 정보를 해당 브라우저에게 전달하며, 요청에 응답한다.
  - 브라우저는 서버로부터 응답받은 정보를 화면에 렌더링하여 모니터를 통해 사용자가 시각적으로 정보를 볼 수 있게 한다.
- HTTP 클라이언트로는 Chrome, Internet Explore, Fire Fox 등의 웹 브라우저가 있다.

## **📌 HTTP Request**

- HTTP는 **HTTP 메서드**라고 불리는 여러 종류의 요청 명령을 지원한다.
- HTTP 요청 메세지는 한 개의 HTTP 메서드를 갖는다.
- HTTP 메서드는 서버가 어떤 동작을 취해야 하는지 알려준다.

| HTTP 메서드 | 설명                                        |
| ----------- | ------------------------------------------- |
| GET         | 서버에게 데이터 전송을 요청                 |
| POST        | 클라이언트에서 서버로 데이터 전송           |
| DELETE      | 서버의 데이터 삭제 요청                     |
| PUT         | 클라이언트에서 서버로 데이터 전체 갱신 요청 |
| PATCH       | 클라이언트에서 서버로 데이터 일부 갱신 요청 |
| HEAD        | 서버에게 헤더 요청                          |

## **📌 HTTP response**

- 모든 HTTP 응답 메세지는 **HTTP 상태 코드**와 함께 반환된다.
- 상태 코드는 클라이언트에게 요청이 성공했는지, 실패했는지, 추가 조치가 필요한지 등을 알려주는 3자리 숫자다.

| HTTP 상태코드                    | 설명                                              |
| -------------------------------- | ------------------------------------------------- |
| 200 (OK)                         | 요청이 성공적으로 되었다.                         |
| 201 (Moved Permanently)          | 요청 객체가 영원히 이동 되었다.                   |
| 400 (Bad Request)                | 서버가 요청을 이해할 수 없는 오류 코드            |
| 404 (Not Found)                  | 서버에서 요청받은 리소스를 찾을 수 없다.          |
| 505 (HTTP VErsion Not Supported) | 요청 HTTP 프로토콜 버전을 서버가 지원하지 않는다. |

## **📌 HTTP 메세지 포멧**

- HTTP Message는 [ASCII](https://ko.wikipedia.org/wiki/ASCII)로 쓰여있어서 사람이 읽을 수 있다.
- HTTP Message의 각 줄은 CR과 LF로 구별된다. 마지막 줄은 추가 CR과 LF가 요구된다.

### **📜 HTTP Request Massage**

!https://k.kakaocdn.net/dn/wV0EA/btqEwgRhKO2/7xN5bqLTcqmS6BC3R714z1/img.png

### **🔎 분석**

- HTTP Request Massage의 첫 줄은 request line이다. HTTP Method, URL, HTTP 버전 필드를 갖는다.
- `request line` : HTTP 버전은 1.1이고 /index.html 객체를 GET 방식으로 요청하고 있다.
- `Host` : 객체가 존재하는 호스트는 [www-net.cs.umass.edu](http://www-net.cs.umass.edu) 이다.
- `User-Agent` : Server에게 요청하는 브라우저 타입이다. Firefox 3.6.10 버전임을 알 수 있다.
- `Accept-Language` : 요청하는 객체의 언어 버전이다. 영어(미국), 영어 버전을 요청한다.
- `Accept-Encoding` : 응답 객체를 gzip 또는 deflate 압축 알고리즘으로 압축해서 보내도 됨을 나타낸다.
- `Accept-Charset` : 클라이언트가 지원하는 인코딩을 나타낸다. 클라이언트가 ISO-8859-1 또는 utf-8 인코딩을 지원함을 알 수 있다.
- `Connection` : keep-alive로 되어있다. Persistent Connection 연결을 사용한다.
- `Keep-Alive` : Persistent Connection 연결 지속 시간이다. (초단위) 115초의 time out을 갖는다.

### **📜 HTTP Response Massage**

!https://k.kakaocdn.net/dn/deZToA/btqEv62s7K4/H6F2IWAfJCz9DbBFUzSAHK/img.png

### **🔎 분석**

- HTTP Response Massage의 첫 줄은 Status Line이다. HTTP 버전, 상태 코드, 상태 메세지 필드를 갖는다.
- `Status Line` : HTTP 1.1 버전을 사용하고 있고 요청이 성공적으로 되었음을 상태 코드를 통해 알 수 있다.
- `Date` : Response Message를 보낸 시간을 의미한다. 2010년 9월 26일 일요일 20:09:20 GMT에 응답 메세지를 보냈다.
- `Server` : Response Message가 Apache 웹 서버에 의해 만들어졌음을 나타낸다. Request Message의 User-agent와 비슷하다.
- `Last-Modified` : 객체가 생성되거나 마지막으로 수정된 시간과 날짜를 나타낸다. 프록시 서버에서 캐싱을 할때 매우 중요하다. 2007년 10월 30일 수요일 17:00:02 GMT에 마지막으로 수정됐음을 알 수 있다.
- `Content-Length` : 송신되는 객체의 바이트 수를 1 나타낸다. 객체의 크기는 2652 Byte이다.
- `Content-Type` : 객체의 타입을 나타낸다. html text임을 알 수 있다.

## **📌 Connectionless Protocol(비연결성 프로토콜)**

- HTTP 클라이언트와 서버는 TCP 연결을 맺고, 클라이언트 요청과 서버의 응답이 오간다.
- Connectionless란 한 번의 요청과 응답이 오간 후에 맺었던 연결을 끊어 버리는 성질을 말한다.
- 장점 : 서버는 다수의 불특정 클라이언트와 연결을 유지 하지 않아도 된다.
- 단점 : 서버는 매번 다수의 클라이언트에 대해 새로운 연결을 맺어야 하는 오버헤드가 발생한다.
- HTTP 1.0부터 추가된 KeepAlive 헤더를 통해 HTTP 연결이 지속되게 할 수 있다.
- 연결을 유지하느냐 안 하느냐에 따라 HTTP 연결은 아래와 같이 구분된다.
  - Non-Persistent Connection
    - 한 번의 TCP 연결에, 하나의 객체를 전송할 수 있다. 각각의 모든 요청에 대한 TCP 연결이 필요하다.
    - 모든 Request/Response에 대한 TCP 사전 연결을 설정을 하고, 연결을 유지 해야한다.
    - 이러한 방식은 Client와 Server에 심각한 부담을 준다.
  - Persistent Connection
    - 한 번의 TCP 연결에, 여러 개의 객체를 전송할 수 있다. Sever가 Client에게 Response를 보낸 후에 TCP 연결을 그대로 유지한다. (연결은 일정시간 사용되지 않으면 종료된다.)
    - Persistent Connection을 사용하면 HTTP 파이프라이닝이 가능하다는 장점이 있다.
    - HTTP/1.1부터 디폴트로 지원된다.

## **📌 Stateless Protocol(무상태 프로토콜)**

- HTTP 서버는 클라이언트의 요청 내역을 기억하지 않는다.
- 따라서 서버는 클라이언트가 누구인지 식별하지 못한다.
- 클라이언트가 누구인지 식별 해야하는 경우 상태유지기술인 쿠키와 세션을 사용한다.