---
layout: single
title: "[자바] 자바11, intelliJ 설치 및 환경 세팅"

categories: JAVA
tags: [JSP, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: ture
date: 2023-05-30
last_modified_at: 2023-05-30
sidebar:
  nav: "docs"
---



## 자바11 설치

[JDK 설치 깃허브](https://github.com/ojdkbuild/ojdkbuild)

1. 해당 링크에서 아래로 내리다보면 있는 msi파일을 다운로드 한다.
2. 파일 실행 후 next로 다운을 완료한다.
3. 다운한 파일 경로를 bin이 보이는 경로를 복사.
4. 이후에 압축 해제한 jdk를 시스템 환경 변수에 등록을 해주어야 한다.  Windows + R 버튼을 눌러 실행창이 열리면 sysdm.cpl ,3 을 입력한다.  시스템 속성 창이 열리면 환경 변수 버튼을 누른다. (or Window 키 누르고 환경 변수 검색)
   ![image](https://github.com/Subak-Uncle/Wanny/assets/115992753/9bd93c8b-f981-4e17-927b-7dedda937aa5)

​	![image](https://github.com/Subak-Uncle/Wanny/assets/115992753/cb979c28-5ebd-4390-bc10-35e61efa2601)

혹은

내 pc 우클릭 - 속성을 통해 위 사진에 해당하는 창을 확인할 수 있다.

5.  환경변수 창이 열리면 시스템 변수 탭에 새로 만들기를 눌러 열린 창에 아래 사진과 같이 입력해준 후 확인을 누른다.
   - 변수 이름 : JAVA_HOME
   - 변수 값 : JDK 압축해제한 경로(bin 폴더 보이는 위치까지)

![image](https://www.notion.so/691b64689b6f4df5abb29eab31613c56?pvs=4#87d1ca7bbe2e4115a24b453f2affaabc)







