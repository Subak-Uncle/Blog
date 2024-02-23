# 연산자

<img width="637" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/1fd377b4-f929-4c63-90ab-078532475b10">



## 연산자의 종류

<img width="862" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/9788d9b2-d29e-4962-9221-db278e9a836d">

### 연산자의 우선순위와 결합 규칙

a. 연산식에 사용되는 연산자가 둘 이상일 때, 연산 순서는 연산자의 우선순위를 따른다.

 b. 단항 연산자(unary operator)는 이항 연산자(binary operator)보다 우선순위가 높다. 

c. 만약 기존에 지정된 우선순위 외에 개발자가 임의로 우선순위를 지정하고 싶다면 () 괄호로 묶어주면 우선순위가 제일 높아진다.

 d. 연산자의 흐름은 왼쪽에서 오른쪽으로 흐르지만, 대입 연산자의 경우 오른쪽에서 왼쪽으로 흐른다.

<img width="852" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/ef922691-c5e0-4644-a0cb-8392c950ca60">

### 연산자 우선 순위

<img width="842" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/0479bc87-daae-44aa-9cd1-049b1726b997">



### 산술 연산자

~~~java
package com.ohgiraffers.section01.arithmetic;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 산술연산자에 대해 이해하고 활용할 수 있다. */
        /* 필기.
         *  산술 연산자
         *  산술 연산자는 주로 사칙연산과 관련된 연산자로 가장 기본적이면서도 많이 사용되는 연산자이다.
         *  연산의 실행이 가능하기 위해 필요한 값이나 변수가 두 개인 이항 연산자로 분류되며
         *  피연산자들의 연산 방향은 왼쪽에서 오른쪽이다.
         * */

        /* 필기.
         *  산술연산자의 종류
         *  '+' : 왼쪽의 피연산자에 오른쪽의 피연산자를 더함
         *  '-' : 왼쪽의 피연산자에 오른쪽의 피연산자를 뺌
         *  '*' : 왼쪽의 피연산자에 오른쪽의 피연산자를 곱함
         *  '/' : 왼쪽의 피연산자를 오른쪽의 피연산자로 나눔
         *  '%' : 왼쪽의 피연산자를 오른쪽의 피연산자로 나눈 나머지를 반환
         * */

        /* 필기.
         *  산술 연산자의 우선순위
         *  수학의 개념과 유사하게 곱하기와 나누기 연산이 더하기와 빼기 연산보다 우선적으로 동작한다.
         *  우선순위가 같은 경우 연산자의 결합 방향에 의해 실행 순서가 결정된다.
         * */

        int num1 = 20;
        int num2 = 7;

        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));
        System.out.println("num1 / num2 = " + (num1 / num2));
        System.out.println("num1 % num2 = " + (num1 % num2));
    }
}
~~~



### 대입 연산자

~~~java
package com.ohgiraffers.section02.assignment;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 대입연산자와 산술 복합 대입 연산자를 이해하고 활용할 수 있다. */
        /* 필기.
         *  연산자의 흐름은 왼쪽에서 오른쪽으로 흐르지만, 대입 연산자의 경우 오른쪽에서 왼쪽으로 흐른다.
         *  대입연산자와 산술 복합 대입 연산자
         *  '='  : 왼쪽의 피연산자에 오른쪽의 피연산자를 대입함
         *  '+=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 더한 결과를 왼쪽의 피연산자에 대입함
         *  '-=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 뺀 결과를 왼쪽의 피연산자에 대입함
         *  '*=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 곱한 결과를 왼쪽의 피연산자에 대입함
         *  '/=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 나눈 결과를 왼쪽의 피연산자에 대입함
         *  '%=' : 왼족의 피연산자에 오른쪽의 피연산자를 나눈 나머지 결과를 왼쪽의 피연산자에 대입함
         * */
        int num = 12;

        System.out.println("num : " +num);

        //3증가시
        num = num + 3;							//대입연산자의 오른쪽에는 값, 왼쪽에는 공간의 의미이다.
        System.out.println("num : " + num);

        num += 3;  								//num = num + 3; 과 같은 의미임
        System.out.println("num : " + num);

        num -= 5;  								//num = num - 5;
        System.out.println("num : " + num);

        num *= 2;  								//num값 2배 증가
        System.out.println("num : " + num);

        num /= 2;  								//num값 2배 감소
        System.out.println("num : " + num);

        /* 주의사항.
         *  산술 복합 대입연산자의 작성 순서에 주의해야 한다.
         *  산술 대입 연산자가 아닌 '-5'를 num에 대입한 것이다.
         * */
        num =- 5;
        System.out.println("num : " + num);
        num =+ 5;
        System.out.println("num : " + num);
    }
}

~~~



### 증감 연산자

~~~java
package com.ohgiraffers.section03.increment;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 증감연산자에 대해 이해하고 활용할 수 있다. */
        /* 필기.
         *  증감연산자
         *  피연산자의 앞 or 뒤에 사용이 가능하다.
         *  '++' : 1 증가의 의미
         *  '--' : 1 감소의 의미
         * */

        /* 목차. 1. 증감연산자를 단항으로만 사용 */
        /* 필기. 단항으로 사용될 때는 1 증가/1 감소의 의미를 가진다. */
        int num = 20;
        System.out.println("num : " + num);

        num++;		//1 증가
        System.out.println("num : " + num);

        ++num;		//1 증가
        System.out.println("num : " + num);

        num--;		//1 감소
        System.out.println("num : " + num);

        --num;		//1 감소
        System.out.println("num : " + num);

        /* 목차 2. 증감연산자를 다른 연산자와 함께 사용 */
        /* 주의사항.
         *  증감연산자는 다른 연산자와 함께 사용할 때 의미가 달라진다는 것이다.
         *  다른 연산자와 함께 사용할 때 증감 연산자의 의미
         *  '++var' : 피연산자의 값을 먼저 1을 증가시킨 후 다른 연산을 진행함
         *  'var++' : 다른 연산을 먼저 진행하고 난 뒤 마지막에 피연산자의 값을 1 증가시킴
         *  '--var' : 피연산자의 값을 먼저 1 감소 시킨 후 다른 연산을 진행함
         *  'var--' : 다른 연산을 먼저 진행하고 난 뒤 마지막에 피연산자의 값을 1 감소시킴
         * */
        int firstNum = 20;

        int result1 = firstNum++ * 3;			//다른 연산을 먼저 처리 하고 난 뒤 마지막에 증가 처리가 됨

        System.out.println("result1 : " + result1);
        System.out.println("firstNum : " + firstNum);

        int secondNum = 20;

        int result2 = ++secondNum * 3;			//증가를 먼저 처리하고 난 뒤 다른 연산을 함

        System.out.println("result2 : " + result2);
        System.out.println("secondNum : " + secondNum);

        int num1 = 10;
        int addNum = num1++;
        System.out.println("addNum : " + addNum);
    }
}
~~~

##### 결과

~~~java
num : 20
num : 21
num : 22
num : 21
num : 20
result1 : 60
firstNum : 21
result2 : 63
secondNum : 21
addNum : 10
~~~



### 비교 연산자

~~~java
package com.ohgiraffers.section04.comparison;

public class Application1 {

	public static void main(String[] args) {

		/* 수업목표. 비교연산자에 대해 이해하고 활용할 수 있다. */
		/* 필기.
		 *  비교연산자
		 *  비교연산자는 피연산자 사이에서 상대적인 크기를 판단하여 참 혹은 거짓을 반환하는 연산자이다.
		 *  연산자 중 참 혹은 거짓을 반환하는 연산자는 삼항연산자의 조건식이나 조건문의 조건절에 많이 사용된다. (충분히 연습이 필요함)

		/* 필기.
		 *  비교연산자의 종류
		 *  '==' : 왼쪽의 피연산자와 오른쪽의 피연산자가 같으면 true 다르면 false를 반환
		 *  '!=' : 왼쪽의 피연산자와 오른쪽의 피연산자가 다르면 true 같으면 false를 반환
		 *  '>'  : 왼쪽의 피연산자가 오른쪽의 피연산자보다 크면 true 아니면 false를 반환
		 *  '>=' : 왼쪽의 피연산자가 오른쪽의 피연산자보다 크거나 같으면 true 아니면 false를 반환
		 *  '<'  : 왼쪽의 피연산자가 오른쪽의 피연산자보다 작으면 true 아니면 false를 반환
		 *  '<=' : 왼쪽의 피연산자가 오른쪽의 피연산자보다 작거나 같으면 true 아니면 false를 반환
		 * */
		
		/* 목차. 1. 숫자값 비교 */
		/* 목차. 1-1. 정수 비교 */
		int inum1 = 10;
		int inum2 = 20;
		
		System.out.println("============== 정수값 비교 ===============");
		System.out.println("inum1과 inum2가 같은지 비교 : " + (inum1 == inum2));
		System.out.println("inum1과 inum2가 같지 않은지 비교 : " + (inum1 != inum2));
		System.out.println("inum1이 inum2보다 큰지 비교 : " + (inum1 > inum2));
		System.out.println("inum1이 inum2보다 크거나 같은지 비교 : " + (inum1 >= inum2));
		System.out.println("inum1이 inum2보다 작은지 비교 : " + (inum1 < inum2));
		System.out.println("inum1이 inum2보다 작은거나 같은지 비교 : " + (inum1 <= inum2));
		
		/* 목차. 1-2. 실수 비교 */
		double dnum1 = 10.0;
		double dnum2 = 20.0;
		
		System.out.println("============== 실수값 비교 ===============");
		System.out.println("dnum1과 dnum2가 같은지 비교 : " + (dnum1 == dnum2));
		System.out.println("dnum1과 dnum2가 같지 않은지 비교 : " + (dnum1 != dnum2));
		System.out.println("dnum1이 dnum2보다 큰지 비교 : " + (dnum1 > dnum2));
		System.out.println("dnum1이 dnum2보다 크거나 같은지 비교 : " + (dnum1 >= dnum2));
		System.out.println("dnum1이 dnum2보다 작은지 비교 : " + (dnum1 < dnum2));
		System.out.println("dnum1이 dnum2보다 작은거나 같은지 비교 : " + (dnum1 <= dnum2));
		
		/* 목차. 2. 문자값 비교 */
		char ch1 = 'a';
		char ch2 = 'A';
		
		System.out.println("============== 문자값 비교 ===============");
		System.out.println("ch1과 ch2가 같은지 비교 : " + (ch1 == ch2));
		System.out.println("ch1과 ch2가 같지 않은지 비교 : " + (ch1 != ch2));
		System.out.println("ch1이 ch2보다 큰지 비교 : " + (ch1 > ch2));
		System.out.println("ch1이 ch2보다 크거나 같은지 비교 : " + (ch1 >= ch2));
		System.out.println("ch1이 ch2보다 작은지 비교 : " + (ch1 < ch2));
		System.out.println("ch1이 ch2보다 작은거나 같은지 비교 : " + (ch1 <= ch2));
		
		/* 목차. 3. 논리값 비교 */
		/* 필기. ==과 !=은 비교 가능하지만 대소비교는 불가능하다. */
		boolean bool1 = true;
		boolean bool2 = false;
		
		System.out.println("============== 논리값 비교 ===============");
		System.out.println("bool1과 bool2가 같은지 비교 : " + (bool1 == bool2));
		System.out.println("bool1과 bool2가 같지 않은지 비교 : " + (bool1 != bool2));
		//System.out.println("bool1이 bool2보다 큰지 비교 : " + (bool1 > bool2));
		//System.out.println("bool1이 bool2보다 크거나 같은지 비교 : " + (bool1 >= bool2));
		//System.out.println("bool1이 bool2보다 작은지 비교 : " + (bool1 < bool2));
		//System.out.println("bool1이 bool2보다 작은거나 같은지 비교 : " + (bool1 <= bool2));
		
		/* 목차. 4. 문자열값 비교 */
		/* 필기. 문자열도 ==과 !=은 비교 가능하지만 대소 비교는 불가능하다. */
		String str1 = "java";
		String str2 = "java";
		
		System.out.println("============== 문자값 비교 ===============");
		System.out.println("str1과 str2가 같은지 비교 : " + (str1 == str2));
		System.out.println("str1과 str2가 같지 않은지 비교 : " + (str1 != str2));
		//System.out.println("str1이 str2보다 큰지 비교 : " + (str1 > str2));
		//System.out.println("str1이 str2보다 크거나 같은지 비교 : " + (str1 >= str2));
		//System.out.println("str1이 str2보다 작은지 비교 : " + (str1 < str2));
		//System.out.println("str1이 str2보다 작은거나 같은지 비교 : " + (str1 <= str2));
		int x = 10;
		int y = 11;

		boolean result = x <= y;
		System.out.println("result의 값은 : " + result);
	}
}

~~~



##### 결과

~~~java
============== 정수값 비교 ===============
inum1과 inum2가 같은지 비교 : false
inum1과 inum2가 같지 않은지 비교 : true
inum1이 inum2보다 큰지 비교 : false
inum1이 inum2보다 크거나 같은지 비교 : false
inum1이 inum2보다 작은지 비교 : true
inum1이 inum2보다 작은거나 같은지 비교 : true
============== 실수값 비교 ===============
dnum1과 dnum2가 같은지 비교 : false
dnum1과 dnum2가 같지 않은지 비교 : true
dnum1이 dnum2보다 큰지 비교 : false
dnum1이 dnum2보다 크거나 같은지 비교 : false
dnum1이 dnum2보다 작은지 비교 : true
dnum1이 dnum2보다 작은거나 같은지 비교 : true
============== 문자값 비교 ===============
ch1과 ch2가 같은지 비교 : false
ch1과 ch2가 같지 않은지 비교 : true
ch1이 ch2보다 큰지 비교 : true
ch1이 ch2보다 크거나 같은지 비교 : true
ch1이 ch2보다 작은지 비교 : false
ch1이 ch2보다 작은거나 같은지 비교 : false
============== 논리값 비교 ===============
bool1과 bool2가 같은지 비교 : false
bool1과 bool2가 같지 않은지 비교 : true
============== 문자값 비교 ===============
str1과 str2가 같은지 비교 : true
str1과 str2가 같지 않은지 비교 : false
result의 값은 : true
~~~



### 논리 연산자

~~~java
package com.ohgiraffers.section05.logical;

public class Application1 {

	public static void main(String[] args) {

		/* 수업목표. 논리연산자에 대해 이해하고 활용할 수 있다. */
		/* 필기.
		 *  논리 연산자
		 *  논리값(true or false)를 취급하는 연산자이다.
		 *
		 * 필기.
		 *  논리 연산자의 종류
		 *   1. 논리 연결 연산자 : 두 개의 피연산자를 가지는 이항 연산자이며, 연산자의 결함 방향은 왼쪽에서 오른쪽이다. 두 개의 논리 식을 판단하여 참과 거짓을 판단한다.
		 *    1-1. &&(논리 AND) 연산자 : 두 개의 논리식 모두 참 일 경우 참을 반환, 둘 중 한 개라도 거짓인 경우 거짓을 반환하는 연산자이다.
		 *    1-2. ||(논리 OR) 연산자 : 두 개의 논리식 중 둘 중 하나라도 참 일 경우 참을 반환, 둘 다 모두 거짓일 경우 거짓을 반환한다.
		 *   2. 논리 부정 연산자 : 피연산자가 하나인 단항연산자로, 피연산자의 결합 방향은 왼쪽에서 오른쪽이다.
		 *    1-1. !(논리 NOT) 연산자 : 논리식의 결과가 참이면 거짓을, 거짓이면 참을 반환한다.
		 * */
		
		/* 목차. 1. 논리 연산자 결과값 확인 */
		System.out.println("true와 true의 논리 and 연산 : " + (true && true));
		System.out.println("true와 false의 논리 and 연산 : " + (true && false));
		System.out.println("false와 true의 논리 and 연산 : " + (false && true));
		System.out.println("false와 false의 논리 and 연산 : " + (false && false));
		
		System.out.println("true와 true의 논리 or 연산 : " + (true || true));
		System.out.println("true와 false의 논리 or 연산 : " + (true || false));
		System.out.println("false와 true의 논리 or 연산 : " + (false || true));
		System.out.println("false와 false의 논리 or 연산 : " + (false || false));
		
		System.out.println("true의 논리 not 연산 : " + (!true));
		System.out.println("false의 논리 not 연산 : " + (!false));
		
		/* 목차. 2. 논리식에 논리연산자 활용 */
		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40;
		
		System.out.println("a가 b보다 작으면서 c가 d보다 작은지 확인 : " + (a < b && c < d));
		System.out.println("a가 b보다 작으면서 c가 d보다 큰지 확인 : " + (a < b && c > d));
		System.out.println("a가 b보다 크면서 c가 d보다 작은 확인 : " + (a > b && c < d));
		System.out.println("a가 b보다 크면서 c가 d보다 큰지 확인 : " + (a > b && c > d));
		
		System.out.println("a가 b보다 작거나 c가 d보다 작은지 확인 : " + (a < b || c < d));
		System.out.println("a가 b보다 작거나 c가 d보다 큰지 확인 : " + (a < b || c > d));
		System.out.println("a가 b보다 크거나 c가 d보다 작은 확인 : " + (a > b || c < d));
		System.out.println("a가 b보다 크거나 c가 d보다 큰지 확인 : " + (a > b || c > d));
	}
}
~~~



##### 결과

~~~java
true와 true의 논리 and 연산 : true
true와 false의 논리 and 연산 : false
false와 true의 논리 and 연산 : false
false와 false의 논리 and 연산 : false
true와 true의 논리 or 연산 : true
true와 false의 논리 or 연산 : true
false와 true의 논리 or 연산 : true
false와 false의 논리 or 연산 : false
true의 논리 not 연산 : false
false의 논리 not 연산 : true
a가 b보다 작으면서 c가 d보다 작은지 확인 : true
a가 b보다 작으면서 c가 d보다 큰지 확인 : false
a가 b보다 크면서 c가 d보다 작은 확인 : false
a가 b보다 크면서 c가 d보다 큰지 확인 : false
a가 b보다 작거나 c가 d보다 작은지 확인 : true
a가 b보다 작거나 c가 d보다 큰지 확인 : true
a가 b보다 크거나 c가 d보다 작은 확인 : true
a가 b보다 크거나 c가 d보다 큰지 확인 : false
~~~



#### 논리 연산자 우선 순위

~~~java
package com.ohgiraffers.section05.logical;

public class Application2 {

	public static void main(String[] args) {
		
		/* 수업목표. 논리연산자의 우선순위에 대해 이해하고 이를 활용할 수 있다. */
		/* 필기.
		 *  논리 연산자의 우선순위와 활용
		 *  논리 and 연산자와 논리 or 연산자의 우선선위
		 *  && : 11순위
		 *  || : 12순위
		 *  논리 and 연산자 우선순위가 논리 or 연산자 우선순위보다 높다
		 * */

		/* 목차. 1. 1부터 100 사이의 값인지 확인 */
		/* 필기. 1 <= 변수 <= 100 이렇게는 사용 못함  --> 변수 >= 1 && 변수 <= 100 이렇게 사용해야 한다. */
		int num1 = 55;
		System.out.println("1부터 100 사이인지 확인 : " + (num1 >= 1 && num1 <= 100));
		
		int num2 = 166;
		System.out.println("1부터 100 사이인지 확인 : " + (num2 >= 1 && num2 <= 100));
		
		/* 목차. 2. 영어 대문자인지 확인 */
		/* 필기. 영어 대문자냐? --> 문자변수 >= 'A' && 문자변수 <= 'Z' */
		char ch1 = 'G';
		System.out.println("영어 대문자인지 확인 : " + (ch1 >= 'A' && ch1 <= 'Z'));	// 아스키 코드로 비교
		
		char ch2 = 'g';
		System.out.println("영어 대문자인지 확인 : " + (ch2 >= 'A' && ch2 <= 'Z'));
		
		/* 목차. 3. 대소문자 상관 없이 영문자 y인지 확인 */
		/* 필기. 문자변수 == 'y' || 문자변수 == 'Y' */
		char ch3 = 'Y';
		System.out.println("영문자 y인지 확인 : " + (ch3 == 'y' || ch3 == 'Y'));
		
		char ch4 = 'y';
		System.out.println("영문자 y인지 확인 : " + (ch4 == 'y' || ch4 == 'Y'));
		
		/* 목차. 4. 영문자인지 확인 */
		/* 필기. A : 65, Z : 90, a : 97, z : 122 (중간에 91 ~ 96까지는 영문자가 아님) */
		/* 설명.
		 *  연산자 우선순위를 고려한다면 논리 and 연산이 먼저 수행되기 때문에 괄호는 묶지 않아도 된다.
		 *  하지만 연산자 우선순위를 디테일하게 학습하고 개발하는 개발자가 적은 현실로 인해
		 *  논리적으로 먼저 실행하는 내용을 괄호로 묶어 주는게 좋다.
		 * */
		char ch5 = 'f';
		System.out.println("영문자인지 확인 : " + ((ch5 >= 'A' && ch5 <= 'Z') || (ch5 >= 'a' && ch5 <= 'z')));
		System.out.println("영문자인지 확인 : " + ((ch5 >= 65 && ch5 <= 90) || (ch5 >= 97 && ch5 <= 122)));
		
		char ch6 = 'F';
		System.out.println("영문자인지 확인 : " + ((ch6 >= 'A' && ch6 <= 'Z') || (ch6 >= 'a' && ch6 <= 'z')));
		System.out.println("영문자인지 확인 : " + ((ch6 >= 65 && ch6 <= 90) || (ch6 >= 97 && ch6 <= 122)));
	}
}
~~~



##### 결과

~~~java
1부터 100 사이인지 확인 : true
1부터 100 사이인지 확인 : false
영어 대문자인지 확인 : true
영어 대문자인지 확인 : false
영문자 y인지 확인 : true
영문자 y인지 확인 : true
영문자인지 확인 : true
영문자인지 확인 : true
영문자인지 확인 : true
영문자인지 확인 : true
~~~



#### And 연산과 OR 연산의 특징

~~~java
package com.ohgiraffers.section05.logical;

public class Application3 {

	public static void main(String[] args) {

		/* 수업목표. 논리연결연산자의 진리표에 대해 이해할 수 있다. */
		/* 필기.
		 *  AND 연산과 OR 연산의 특징
		 *  논리식 && 논리식 : 앞의 결과가 false이면 뒤를 실행 안함
		 *  논리식 || 논리식 : 앞의 결과가 true이면 뒤를 실행 안함
		 * */
		
		/* 목차. 1. 논리식 && 논리식 : 앞의 결과가 false이면 뒤를 실행 안함  */
		/* 필기.
		 *  조건식 두 개가 모두 만족해야 true를 반환하지만 앞에서 미리 false가 나오게 되면
		 *  뒤의 조건을 확인할 필요 없이 false를 반환한다.
		 *  따라서 연산 횟수를 줄이기 위해서는 &&연산의 경우 앞에 false가 나올 가능성이 높은 조건을 작성하는 편이 좋다.
		 * */
		int num1 = 10;
		
		/* 설명.
		 *  앞에 조건이 false로 강제화 해 두고 && 뒤의 조건은 선치 증가로 값을 증가시킨 후 별 의미 없는 조건식으로 만들어놓았다.
		 *  num1 선치 증가 코드가 동작했다면 result1은 11일 것이고, 동작하지 않았다면 결과는 10일 것이다.
		 * */
		int result1 = (false && ++num1 > 0)? num1 : num1;
		
		System.out.println("&&실행 확인 : " + result1);		//10
		
		/* 목차. 2. 논리식 || 논리식 : 앞의 결과가 true이면 뒤를 실행 안함 */
		/* 필기.
		 *  조건식 둘 중 하나라도 true를 반환하면 true를 반환하기 때문에 앞에서 미리 true가 나오게 되면
		 *  뒤의 조건을 확인할 필요 없이 true를 반환한다.
		 *  따라서 연산 횟수를 줄이기 위해서는 ||연산의 경우 앞에 true가 나올 가능성이 높은 조건을 작성하는 편이 좋다.
		 * */
		int num2 = 10;
		
		/* 설명.
		 *  앞에 조건을 true로 강제화 해 두고 || 뒤의 조건은 선치 증가로 값을 증가시킨 후 별 의미 없는 조건식으로 만들어놓았다.
		 *  num1 선치 증가 코드가 동작했다면 result2는 11일 것이고, 동작하지 않았다면 결과는 10일 것이다.
		 * */
		int result2 = (true || ++num2 > 0)? num2 : num2;
		
		System.out.println("||실행 확인 : " + result2);		//10
	}
}

~~~



##### 결과

~~~java
&&실행 확인 : 10
||실행 확인 : 10
~~~



### 삼항 연산자

~~~java
package com.ohgiraffers.section06.ternary;

public class Application1 {

	public static void main(String[] args) {

		/* 수업목표. 삼항연산자에 대해 이해하고 활용할 수 있다. */
		/* 필기.
		 *  삼항 연산자
		 *  자바에서 유일하게 피연산자 항목이 3개인 연산자이다.
		 *  항목이 3개임 : (조건식)? 참일 때 사용할 값1: 거짓일 때 사용할 값2
		 *  조건식은 반드시 결과가 true 또는 false가 나오게끔 작성해야 함
		 *  비교/논리연산자가 주로 사용됨
		 */

		/* 목차. 1. 삼항연산자 단독 사용 */
		int num1 = 10;
		int num2 = -10;
		String result1 = (num1 > 0)? "양수다.": "양수가 아니다.";
		String result2 = (num2 > 0)? "양수다.": "양수가 아니다.";
		
		System.out.println("num1은 " + result1);
		System.out.println("num2는 " + result2);
		
		/* 목차. 2. 삼항연산자 중접 사용 */
		int num3 = 5;
		int num4 = 0;
		int num5 = -5;
		
		String result3 = (num3 > 0)? "양수다.": (num3 == 0)? "0이다.":"음수다.";
		String result4 = (num4 > 0)? "양수다.": (num4 == 0)? "0이다.":"음수다.";
		String result5 = (num5 > 0)? "양수다.": (num5 == 0)? "0이다.":"음수다.";
		
		System.out.println("num3은 " + result3);
		System.out.println("num4는 " + result4);
		System.out.println("num5는 " + result5);
	}
}
~~~



##### 결과

~~~java
num1은 양수다.
num2는 양수가 아니다.
num3은 양수다.
num4는 0이다.
num5는 음수다.
~~~

