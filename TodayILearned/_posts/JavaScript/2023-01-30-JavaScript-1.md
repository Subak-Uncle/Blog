---
layout: single
title: "[JavaScript] 1일 차 : internal/external, variable, tag, button, 자료형 변환, 시간 다루기, Attribute"

categories: JavaScript
tags: [JavaScript, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-01-30
last_modified_at: 2023-01-30
sidebar:
  nav: "docs"
---

<style type="text/css">
  .center {
      display : block;
      margin : auto;
  }
  </style>

### JavaScript

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>JavaScript 기본</title>

    <script type="text/javascript">
      // java script의 영역
    </scrip>
  </head>
  <body>
    <!--
		Java Script(front-end) == Client(Web) 처리 언어
		목적 :	web resource에 접근하고 처리하기 위한 스크립트
				tag들을 접근해서 데이터를 취득, 수정, 검색
				컴파일을 하지 않는다 -> (처리 속도)가 빠르다 -> 가볍다

		예) 회원가입 -> 빈칸 조사, id의 글자나 종류, password 검사
			CSS를 제어하는 것도 가능하다.
			Timer를 설정하고 특수 효과도 구현이 가능

		Java Script -> Jquery ->	angular.js
					   ajax			react.js	axios
									vue.js

		variable
		function
		class

		tag의 접근자 Attribute(속성), Property(특성)

		<p id="pid">Hello</p>
		<h2 class="hcls">World</h2>
		<p class="hcls">Hello</p>
		<input type="text" name="food">

		id		: Java Script에서 접근하기 위해서 주로 사용. 1개만 적용
		class	: CSS를 적용하는 경우 사용. 다수
		name	: 값을 넘겨줄 경우에 사용. 다수

 -->

    <p id="demo">안녕하세요 JavaScript</p>

    <script type="text/javascript">
      // java script 영역

      /*
	 범위 주석문
 */
	
      // 콘솔에 입력
      console.log("Java Script가 실행되었음");

      // 윈도우 알림 창
      // window.alert("Java Script 실행");

      // getter
      var demo = document.getElementById("demo").innerHTML; // HTML 형태로 데이터 가져옴
      alert(demo);

      document.getElementById("demo").innerHTML = "hi 자바스크립트";
    </script>
  </body>
</html>
```

### Internal , External

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Internal / External</title>

    <!-- 
		internal : 내장
		external : 외부파일
 -->

    <!--  internal 방식. head 영역이나 body 둘 다 써도 됨
 <script type="text/javascript">
 function btnFunc() {
//	alert("btnFunc() 호출");
	
	var demo = document.getElementById("demo").innerHTML;
	
	document.getElementById("data").innerHTML = demo;
} 
</script>
-->

    <!-- external 방식, 외부 파일에서 불러옴 -->
    <script type="text/javascript" src="./js/myjs.js"></script>
  </head>
  <body>
    <h3 id="demo">Hello 자바 스크립트</h3>

    <button type="button" onclick="btnFunc()">클릭</button>
    <br />

    <p id="data"></p>
  </body>
</html>
```

```javascript
function btnFunc() {
  //	alert("btnFunc() 호출");

  var demo = document.getElementById("demo").innerHTML;

  document.getElementById("data").innerHTML = demo;
}
```

<br><br>



### 변수(variable)

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>변수(variable)</title>
  </head>
  <body>
    변수(variable)
    <br />

    <p id="demo"></p>

    <script type="text/javascript">
      // Integer, Double, String, Character, Boolean, Array, Class in java

      /*
	MyClass mcls = new MyClass();
	YouClass ycls = new YouClass();
	
	Object obj = new MyClass();
	
	자바스크립트에서 object 역할 : var
	var v = 123;
	var v1 = "hello";
	*/

      /* 	
    변수의 종류
	
	var		let		const
      
    var v;
	v = 123;
	alert(v);
	
	var v = 345;
	// alert(v);
	
	// 요즘은 var 보다 let을 더 선호, let은 중복 허용x
	let l;
	l = 234;
	alert(l);
	
	let l = 456;
	//alert(l);
	
	const : 1번 선언하면 변경 불가
 */

      let number = 123;
      let pi = 3.141592;
      let name = "홍길동";
      let answer = true; // false(0)/true(1)

      // alert(number + pi);  // >> 126.141592
      // alert(number + answer);  // >> 124

      number = 234 + 345;
      // alert(number); // >> 579

      // java에선 오류! 문자열 + 숫자
      number = name + pi;
      // alert(number);	// >> 홍길동3.141592

      number = "hello";

      number = "5" + 3 + 1;
      // alert(number); 	// >> 531

      number = 5 + 3 + "1";
      // alert(number); 	// >> 81

      // Array == object
      /*
 		In Java
 		int array[] = new int[5];
 		int array[] = { 1, 2, 3, 4, 5 };
	*/

      //	let cars = [];
      let cars = ["benz", "bmw", "audi"];
      console.log(cars[1]);

      let arrNum = new Array(5);
      arrNum[0] = 11;
      arrNum[1] = 22;
      arrNum[2] = 33;
      arrNum[3] = 44;
      arrNum[4] = 55;
      console.log(arrNum[2]);
      console.log(arrNum);

      for (i = 0; i < arrNum.length; i++) {
        console.log(arrNum[i]);
      }

      // in java : for ( i : c)
      for (i in cars) {
        console.log(i);
      }

      // 람다식
      cars.forEach((element) => console.log(element));

      // key:value
      let myobj = {
        firstname: "길동",
        lastname: "홍",
        age: 24,
        print: function () {
          console.log("print() 호출");
        },
      };

      console.log(myobj.firstname);
      console.log(myobj.age);

      myobj.print();

      // class
      class Person {
        constructor(name, age) {
          this.name = name;
          this.age = age;
        }
        print() {
          console.log(this.name + " " + this.age);
        }
      }

      let p = new Person("성춘향", 16);
      console.log(p.name);
      p.print();
	  
      
      document.getElementById("demo").innerHTML =
        "홍길동" +
        typeof "홍길동" +
        "<br>" +
        "325 " +
        typeof 325 +
        "<br>" +
        "3.14 " +
        typeof 3.14 +
        "<br>" +
        "true " +
        typeof true +
        "<br>" +
        "array " +
        typeof cars +
        "<br>" +
        "object " +
        typeof { num: 1, name: "abc" };
    </script>
  </body>
</html>
```

![image](https://user-images.githubusercontent.com/115992753/215430134-fba57484-34b9-46db-a5d3-adc1ac6a0de5.png)

![image](https://user-images.githubusercontent.com/115992753/215430791-15ea66a7-9a6d-45ff-897b-7024b8b0f9c5.png)

<br>



### Tags

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Tags</title>
  </head>
  <body>
    <!-- 
	tag :	일반태그	: h1 ~ h6, p, pre
			입출력태그	: input type="text, radio, checkbox"
					  textarea
			event태그: button, input type="button"

 -->

    <h3 id="demo">Hello JS</h3>

    <p id="demo">p tag</p>

    <input type="text" id="text" size="20" value="초기 값" placeholder="입력" />
    <br /><br />

    <!-- <button type="button" onclick="">클릭</button>-->
    <input type="button" value="클릭" onclick="buttonClick()" />

    <script type="text/javascript">
      function buttonClick() {
        //	alert("buttonClick() 호출");
        // id는 하나만 인식한다
          
        /* innerHTML 과 innerText의 차이
           innerHTML은 innerText과 달리 연산이 가능하다.
           ~.innerHTML = "1+2" -> 3
           ~.innerText = "1+2" -> 1+2
        */
        //	document.getElementById("demo").innerHTML = "버튼 클릭!";
        document.getElementById("demo").innerText = "버튼 클릭!";

        document.getElementById("text").value = "안녕하세요";
      }
    </script>
  </body>
</html>
```

**before** 



![image](https://user-images.githubusercontent.com/115992753/215433638-e23820e6-a900-41b3-b1f3-783af744b51d.png)



**after**

 ![image](https://user-images.githubusercontent.com/115992753/215434087-62425818-9ffb-4132-b3cb-575fabcc9f70.png)

<br>



### Button

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Button</title>
  </head>
  <body>
    function(함수)
    <br /><br />

    <buttton type="button" onclick="func()">함수호출</buttton>

    <script type="text/javascript">
      function func() {
        console.log("func() 호출");
      }

      //func();

      let num1 = 10;
      let num2 = 3;

      function multi(n1, n2) {
        return n1 * n2;
      }

      let r = multi(num1, num2);
      console.log(r);
    </script>

    <br /><br />

    <button type="button" onclick="btnclick( 1 )">버튼 one</button>
    <button type="button" onclick="btnclick( 2 )">버튼 two</button>
    <button type="button" onclick="btnclick( 3 )">버튼 three</button>

    <script type="text/javascript">
      function btnclick(n) {
        if (n == 1) {
          console.log("버튼 one을 클릭했습니다.");
        } else if (n == 2) {
          console.log("버튼 two 를 클릭했습니다.");
        } else if (n == 3) {
          console.log("버튼 three 을 클릭했습니다.");
        }
      }
    </script>

    <br /><br />

    <button type="button" onclick="btnclick1( 'one' )">버튼 'one'</button>
    <button type="button" onclick="btnclick1( 'two' )">버튼 'two'</button>
    <button type="button" onclick="btnclick1( 'three' )">버튼 'three'</button>

    <script type="text/javascript">
      function btnclick1(n) {
        if (n == "one") {
          console.log("버튼 one을 클릭했습니다.");
        } else if (n == "two") {
          console.log("버튼 two 를 클릭했습니다.");
        } else if (n == "three") {
          console.log("버튼 three 을 클릭했습니다.");
        }
      }
    </script>
  </body>
</html>
```

![image](https://user-images.githubusercontent.com/115992753/215543177-62017f43-2489-4a10-8214-b48ca7f51804.png)

![image](https://user-images.githubusercontent.com/115992753/215544655-1bb7ed35-dce7-43f4-8b40-69cd1a2580d2.png)





### 시간 다루기

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>시간 다루기</title>
  </head>
  <body>
    <p id="demo"></p>
    <br />

    <script type="text/javascript">
      function displayDate() {
        document.getElementById("demo").innerHTML = Date();
      }

      // displayDate() 함수만으론 자체 업데이트 안됨 -> 실시간 업데이트
      setInterval("displayDate()", 1000);
    </script>

    <br /><br />

    <h3 id="date"></h3>

    <script type="text/javascript">
      // 현재 시간
      let d = new Date();

      // 시간 설정, 월이 0 ~ 11로 이루어져 있음. 0 -> january
      //	d = new Date(2023, 1 - 1, 28, 12, 26, 0, 0)	// setter

      //	d = new Date("October 12, 2023 14:45:12");

      document.getElementById("date").innerHTML = d;

      document.getElementById("date").innerHTML = d.getFullYear();
      document.getElementById("date").innerHTML = d.getMonth() + 1;
      document.getElementById("date").innerHTML = d.getDate();
      document.getElementById("date").innerHTML = d.getDay(); // 요일
      document.getElementById("date").innerHTML = d.getHours();
      document.getElementById("date").innerHTML = d.getMinutes();
      document.getElementById("date").innerHTML = d.getSeconds();
    </script>
  </body>
</html>
```

<br>

### 자료형 변환(문자열, 숫자)

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>자료형 변환</title>
  </head>
  <body>
    10진수 -> 문자열
    <br /><br />
    문자열 -> 숫자(10진수) Integer.parseInt()
    <br /><br />

    입력:<input type="text" id="num" size="20" />
    <button type="button" onclick="cast()">변환</button>
    <br /><br />
    결과:<input type="text" id="result" />

    <script type="text/javascript">
      function cast() {
        let strNum = document.getElementById("num").value;

        // 문자열 -> 숫자
        let num = parseInt(strNum);
        num = num * 10;

        document.getElementById("result").value = num;

        // 숫자 -> 문자열
        //	let numStr = num + "";
        let numStr = num.toString();
        alert(numStr + 12);
      }
    </script>
  </body>
</html>
```

<img style="border: solid 1px" src="https://user-images.githubusercontent.com/115992753/215550957-8f157405-5415-4cb2-a52a-770c8be883ac.png" align="left"><img style=" border: solid 1px" src="https://user-images.githubusercontent.com/115992753/215551183-b74d74d6-a7ca-4360-a99b-c9b0a3165b8d.png">

<br>



### Attribute(id, class, name)

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Attribute(id, class, name)</title>
  </head>
  <body>
    <!-- 
		Acess Attribute
		
		id:		Java Script
		class: 	CSS
		name:	데이터 전송용  

 -->

    <p id="pid">p tag 입니다.</p>
    <br />

    <p class="cls">p tag class</p>
    <!-- 0번지 -->
    <h3 class="cls">h3 tag class</h3>
    <!-- 1번지 -->
    <br />

    <input type="text" name="name" value="hello" /><br />
    <input type="text" name="name" value="world" /><br />

    <button type="button" onclick="btnClick()">버튼</button>

    <script type="text/javascript">
      function btnClick() {
        // id
        // 버튼 누르면 'pid' 태그 문구 변경됨.
        document.getElementById("pid").innerHTML = "p 태그 값을 출력";

        // class
        // 버튼 누르면 'cls' 태그 문구 변경됨.
        document.getElementsByClassName("cls")[0].innerHTML =
          "class에 값을 대입";

        //	alert(arrClass[0].innerHTML);

        // class 요소들 함수에 삽입
        let arrClass = document.getElementsByClassName("cls");
        for (i = 0; i < arrClass.length; i++) {
          console.log(arrClass[i].innerHTML);
        }

        // name
        document.getElementsByName("name")[0].value = "hihi";

        document.getElementsByTagName("p")[0].innerHTML = " i can do it";
      }
    </script>
  </body>
</html>
```

![image](https://user-images.githubusercontent.com/115992753/215556454-04283b8f-bd69-4dac-98a5-0fb34866a6a7.png)

---

![image](https://user-images.githubusercontent.com/115992753/215556664-67cb89ad-2a87-4bc2-ad49-5e424d518038.png)

---

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>문구 변경 버튼</title>
  </head>
  <body>
    <div id="demo" style="background-color: #ffffff">Hello JavaScript CSS</div>

    <button type="button" onclick="proc()">적용</button>

    <script type="text/javascript">
      function proc() {
        let obj = document.getElementById("demo");

        obj.style.color = "white";
        obj.style.backgroundColor = "#0000ff";
        obj.style.textAlign = "center";
        obj.style.borderStyle = "double";
        obj.style.frontFamily = "MS PGothic";
        obj.style.fontSize = "24pt";
      }
    </script>
  </body>
</html>
```

![image](https://user-images.githubusercontent.com/115992753/215555554-c9e58909-4033-4a89-9179-fd99831e09f9.png){: center}

=>

![img](https://user-images.githubusercontent.com/115992753/215555940-40f085f8-99fa-4a4c-9b85-44a1f09a857d.png)

