---
layout: single
title: "[Git] 기존 프로젝트 레포지토리에 연동"

categories: Git
tags: [Git]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-08-24
last_modified_at: 2023-08-24
sidebar:
  nav: "docs"


---

# 기존 프로젝트 레포지토리에 연동



1. 폴더로 이동

   ~~~
   cd ./{폴더}
   ~~~

2. git 초기화

   ~~~
   git init
   ~~~

3. git 레포지토리 연결

   ~~~
   git remote add origin {레포지토리 주소}
   ~~~

4. 원격 레포지토리로 commit & push

   ~~~
   git add .
   git commit -m '첫번째 커밋'
   git push origin main(or master)
   ~~~




이미지는 base64를 이용하면 was를 거치지 않고 이미지 업로드가 가능하다 해당 url을 텍스트와 함께 이미지를 db에 longTEXT로 저장하고 쓰면 됨