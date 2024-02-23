---
layout: single
title: "[MySQL] MySQL Publickey 설정"

categories: MySQL
tags: [MySQL]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-07-20
last_modified_at: 2023-07-20
sidebar:
  nav: "docs"


---



# MySQL Publickey 설정

매 번 프로젝트를 불러와서 실행할 때마다 database가 연동이 되어 있지 않아 에러가 발생하였습니다.

원래는 DATABASE 연결 후,
~~~mysql
use {DB Schema 명};
~~~

을 해줬어야 했지만!

MySQL의 경우, publickey 설정을 통해 해결이 가능했습니다.

application.yml 파일에 아래 코드를 추가!

~~~properties
spring.datasource.url=jdbc:mysql://localhost:3306/{DB Schema명}?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul
~~~

