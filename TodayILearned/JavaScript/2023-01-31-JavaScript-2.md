---

layout: single
title: "[JavaScript] 2일 차 : 링크 이동, onload, onblur, onchange"

categories: JavaScript
tags: [JavaScript, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-01-31
last_modified_at: 2023-01-31
sidebar:
  nav: "docs"
---

<style type="text/css">
  .center {
      display : block;
      margin : auto;
  }
  </style>




### view

---

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View One</title>
</head>

<body>

<!-- 
	Link
	
	Html
			<a href=""
			
			<form action=""

	Java Script
			location.href=""
 -->

<h1>View One</h1>

<a href="viewTwo.html">view two로 이동</a>

<script type="text/javascript">

document.bgColor = "royalblue";
/*
	Document 객체는 웹 페이지 그 자체를 의미합니다.
	웹 페이지에 존재하는 HTML 요소에 접근하고자 할 때는 
	반드시 Document 객체부터 시작해야 합니다.
	*/
</script>



</body>
</html>
~~~

<img src="https://user-images.githubusercontent.com/115992753/215800923-6ba3a071-904c-4bd3-912b-7d1154057bdd.png" alt="image" style="zoom:80%;" />

<br>

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="green">

<h1>View Two</h1>

<input type="button" value="이전" onclick="back()">

<input type="button" value="현재페이지 갱신" onclick="reload()">

<input type="button" value="진행" onclick="forward()">

<input type="button" value="view three로 이동" onclick="gopage()">

<script type="text/javascript">
function back() {
	history.back();
//  history.go(-1);, 현재 페이지 index는 0
// 	history.length;, 페이지 history 길이   
}
function reload() {
	location.reload();
}
function forward() {  // 앞으로 가기
	history.forward();
}
function gopage() {
	location.href = "viewThree.html";
}
</script>

</body>
</html>
~~~

![image](https://user-images.githubusercontent.com/115992753/215801791-592e49c4-95af-4090-97f5-3b101b8d66ac.png)

<br>



~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Three</title>
</head>
<body>

<h1>View Three</h1>



</body>
</html>
~~~

![image](https://user-images.githubusercontent.com/115992753/215802037-fad77af2-7ce6-4833-b2a0-5e87182e280a.png)

### 데이터 입력 받을 시

---



### index.html

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- form -->
	<form action="NewFile.jsp">
		이름:
		<input type="text" name="name"> <br> 
		나이:
		<input type="text" name="age"> <br>
		 <input type="submit" value="이동">
	</form>
	<br>
	<br>

	<!-- a -->
	<a href="NewFile.jsp?name=성춘향&age=16">NewFile.jsp로 이동</a>
	<br>
	<br>
	<br>

	<!--  java script -->
	<h3>자바스크립트 버전</h3>
	
	이름:
	<input type="text" id="name">
	<br> 
	나이:
	<input type="text" id="age">
	<br>
	<button type="button" onclick="move()">이동</button>

	<script type="text/javascript">
		function move() {
			let name = document.getElementById("name").value;
			let age = document.getElementById("age").value;

			// 빈칸일 시
			if (name.trim() == "") {	// trim : 공백 제거
				alert("이름을 입력해 주십시오");
				return;
			}
			// 한 글자만 입력 시
			if (name.trim().length < 2) {
				alert("이름을 정상적으로 기입해 주십시오");
				return;
			}
			// 나이 빈칸일 시
			if (age.trim() == "") {
				alert("나이를 입력해 주십시오");
				return;
			}

			// jsp 파일로 이동
			location.href = "NewFile.jsp?name=" + name + "&age=" + age;
		}
	</script>
</body>
</html>
~~~



### NewFile.jsp

~~~jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	int age = Integer.parseInt( request.getParameter("age") );
	
	System.out.println("name:" + name);
	System.out.println("age:" + age);
%>
~~~





## Onload

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!--
<body onload="checkMessage()">

onload: 현 html이 실행시에 한번만 실행 

<script type="text/javascript">
function checkMessage() {
	alert("checkMessage() 호출");	
}
</script>
-->

 <!-- 자동 스크롤 만들기 -->
<body onload="viewScroll()"> 

<pre>
최근 10년간 우리나라 중산층 비중은 60%대까지 늘어났지만 '노력하면 사회경제적 지위가 높아진다'는 
기대는 줄었다는 분석이 나왔다.

특정 기간의 소득 변화 정도를 보여주는 소득 이동성도 낮아진데다 부동산 자산을 중심으로 한 자산 
불평등이 커져 '계층 이동의 사다리'에 대한 희망이 줄어드는 모습이다.

이영욱 한국개발연구원(KDI) 재정·사회정책연구부장은 31일 이런 내용의 
'우리나라 중산층의 현주소와 정책과제' 보고서를 발표했다.

디지털 전환과 일자리 감소 등으로 중산층 축소 우려가 커지고 있지만, 
실제 중산층 비중은 최근 10년간 늘거나 유지되고 있다.

통계청에서 주로 활용하는 중산층 개념인 '중위소득 50∼150%' 
비중은 처분가능소득 기준으로 2011년 54.9%에서 61.1%로 높아졌다.

다만 시장소득 기준으로는 10년간 50% 안팎을 유지 중이다.

시장소득은 근로·사업소득 등 '일해서 번 돈'이고, 
처분가능소득은 시장소득은 연금·지원금 등 정부의 이전지출까지 포함한 소득이다.

시장소득 기준 중산층이 50%대를 유지하고 있으나 
처분가능소득 기준 중산층은 60% 이상으로 늘었다는 것은 
최근 10년간 정부의 복지혜택이 중산층 확대에 영향을 줬다는 의미로 풀이된다.

경제협력개발기구(OECD)가 쓰는 중산층 기준인 '중위소득 75∼200%'로 보면 
우리나라 중산층 비중은 2021년 61.1%로 OECD 평균 61.5%와 유사한 수준이다.

다만 중위소득 50% 아래인 빈곤층이 15.1%로 OECD 평균 11.4%보다 높은데, 
이는 특히 심각한 노인 빈곤 문제가 반영된 결과로 보인다고 보고서는 지적했다.

처분가능소득 기준 중산층 비중이 실제 늘었을 뿐 아니라, 
스스로 '나의 사회경제적 지위는 중산층'이라고 생각하는 사람의 비중도 
2013년 51.4%에서 2021년 58.8%로 높아졌다.

그러나 '계층 이동 사다리'에 대한 믿음은 줄어드는 모습이다. 
개인의 노력으로 더 높은 계층으로 올라갈 수 있을 것이라는 기대가 줄어들고 있다는 것이다.

'우리 사회에서 노력한다면 개인의 사회경제적 지위가 높아질 가능성'에 대한 질문에 
'매우 높다'와 '비교적 높다'로 응답한 비율은 2011년 28.8%에서 2021년 25.2%로 감소했다.

'자녀세대의 사회경제적 지위가 높아질 가능성이 높다'고 
응답한 비율은 2011년 41.7%에서 2021년 30.3%로 낮아졌다.

실제 2011년부터 2015년까지 시장소득, 처분가능소득 모두 소득 이동성이 줄어든 것으로 나타났다. 
소득이 달라지는 정도가 크지 않았다는 뜻이다.

여기에 부동산 자산을 중심으로 자산 불평등도 커지고 있다. 
소득 이동성 감소와 자산 불평등 확대는 세대 간 계층 대물림, 교육격차 확대로 이어지는 중이다.

보고서는 가구 내 취업자 수가 늘고 가구주 근로소득이 증가하면 
빈곤층이 중산층으로 올라갈 가능성이 높다고 분석했다.

이를 바탕으로 보고서는 "정부의 이전지출을 통한 중산층 확대만으로는 
지속가능성에 대한 우려가 있으며 계층 상향이동에 대한 기대로 이어지지 못하는 한계가 뚜렷하다"며 
"생산적인 활동을 통해 상향이동 가능성을 높이는 중산층 강화 방안이 필요하다"고 강조했다.

보고서는 구체적으로 양질의 일자리 창출, 은퇴 중·고령층의 고용 기간 연장 유도, 
여성 배우자 취업 장애요인 해소와 일 가정 양립 지원 내실화가 필요하다고 제언했다.
</pre>

   
<script type="text/javascript">
let posY = 0;
function viewScroll() {
	window.scroll(0, posY);
	
	posY = posY + 2;
	if(posY == 300) posY = 0;	// posY 300이 되면, 다시 처음부터 스크롤
	
    // setTimeout : 시간 예약. 
	setTimeout("viewScroll()", 100); // 100 ms 후에 함수 실행.
}
</script>

 
</body>

</html>
~~~



## Onblur, Onchange

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>


	onblur : focus가 이동시 실행
	<br> 나이:
	<input type="text" onblur="onBlurFunc()" maxlength="2">세
	<br>
	<br>

	<script type="text/javascript">
		function onBlurFunc() {
			alert('onblur 실행');
		}
	</script>

	onchange : 입력값이 변경되고 포커스가 이동했을 시
	<br>우편번호:
	<input type="text" maxlength="3" size="5" onchange="isPostNum(this)">
	-
	<input type="text" maxlength="3" size="5" onchange="isPostNum(this)">
	<br>
	<br>

	<script type="text/javascript">
		function isPostNum(obj) {
			let str = obj.value;
			alert(str);

			// 숫자가 아닌 문자가 포함되었을 경우
			// [^0-9] : NOT 0 ~ 9, /[^0-9]/g : 숫자 제외. 문자만 선택하는 정규식 
			if (str.match(/[^0-9]/g)) {
				alert("문자가 포함되어 있습니다");
			}
		}
	</script>

	<select id="sel" onchange="changeVal()">
		<option value="apple">사과</option>
		<option value="pear">배</option>
		<option value="banana" selected>바나나</option>
	</select>

	<script type="text/javascript">
		// 값이 바뀌면 바뀐 value를 알리는 함수
		function changeVal() {
			// alert("changeVal");

			let value = document.getElementById("sel").value;
			alert(value);
		}
	</script>
	<br>
	<br> onkeydown : 모든 키가 다 인식 EX) Home, Alt
      , onkeypress : 숫자, 문자 기호 등 출력 가능한 키만 인식
      , onkeyup : 눌렀던 키가 놓아졌을 때
	<br>

	<input type="text" name="title">

	<script type="text/javascript">
		/* 
		 document.getElementsByName("title")[0].onkeydown = function (event) {
		 console.log("keycode:" + event.keyCode);
		 }
		 */
		document.getElementsByName("title")[0].onkeypress = function(event) {
			console.log("keycode:" + event.keyCode);
		}
	</script>

	<br>
	<br> onMouseDown : 마우스 눌렸을 때, onMouseUp : 마우스가 눌린 후 놓일 때
       , onMouseOver : 마우스가 경계 안으로 들어올 때, onMouseOut : 경계 밖으로 나갈 때
	<br>
	<input type="image" src="./images/san0.gif" id="textImg"
		onmousedown="mousedown()" onmouseup="mouseup()"
		onmouseover="mouseover()" onmouseout="mouseout()">

	<script type="text/javascript">
		function mousedown() {
			document.getElementById("textImg").src = "./images/san1.gif";
		}
		function mouseup() {
			document.getElementById("textImg").src = "./images/san0.gif";
		}
		function mouseover() {
			document.getElementById("textImg").src = "./images/san2.gif";
		}
		function mouseout() {
			document.getElementById("textImg").src = "./images/san0.gif";
		}
	</script>

	<br>
	<br>

	<a href="#" onmouseover="mOver()" onmouseout="mOut()"> <img alt=""
		src="./images/box.gif" id="img">
	</a>

	<script type="text/javascript">
		function mOver() {
			document.getElementById("img").src = "./images/surprise.gif";
		}
		function mOut() {
			document.getElementById("img").src = "./images/box.gif";
		}
	</script>

</body>
</html>
~~~





