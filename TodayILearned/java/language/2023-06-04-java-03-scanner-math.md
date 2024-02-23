# Math 클래스



###### 💡 Math 클래스는 수학에서 자주 사용하는 상수들과 함수 들을 미리 구현해 놓은 클래스이다. API문서를 확인해보자.(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html) Math 클래스는 static member로만 구성되어 있다. 즉, Math.메소드() 와 같이 Math 클래스에서 제공하는 API를 사용할 수 있다.



## Math 클래스 활용



### Math 클래스 절대값

~~~java
package com.ohgiraffers.section03.math;

public class Application1 {

	public static void main(String[] args) {

		/* 수업목표. Math 클래스에서 제공하는 static 메소드를 호출할 수 있다. */
		/* 필기.
		 *  API란?
		 *  Application Programming Interface는 응용프로그램에서 사용할 수 있도록,
		 *  운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있도록 만든 인터페이스를 뜻한다.
		 *  쉽게 말해 우리가 구현할 수 없거나 구현하기 번거로운 기능들을 JDK를 설치하면 사용할 수 있도록 제공해놓은 소스코드(클래스나 인터페이스)들을 의미한다.
		 *  더 쉽게 말해 누가 작성해놓은 소스코드이니 가져다 쓰는 방법을 본다는 말이다.
		 *  모든 코드를 우리가 다 외울 수 없으니 API 문서를 별도로 제공해주고 있다.
		 * */
		
		/* 필기.
		 *  java.lang.Math
		 *  Math 클래스는 수학에서 자주 사용하는 상수들과 함수 들을 미리 구현해놓은 클래스 이다.
		 *  모든 메소드는 static 메소드로 작성되어 있다.
		 *  (객체의 상태를 관리하지 않고 기능만 제공하는 경우 메모리를 효율적으로 사용하기 위해 자주 사용되는 기법이다.)
		 * */
		
		/* 목차. 1. 절대값 출력 */
		/* 목차. 1-1. 클래스의 full-name을 다 적은 경우 */
		System.out.println("-7의 절대값 : " + (java.lang.Math.abs(-7)));
		
		/* 목차. 1-2. import를 해서 사용 */
		/* 설명.
		 *  클래스의 full-name 말고 클래스명만 작성하려면 import를 해야 한다고 배웠다.
		 *  하지만 Math 클래스는 import 하지 않아도 쓸 수 있다.
		 *  java.lang 패키지에 속한 클래스이기 때문이다.
		 *  System, String 또한 지금까지 따로 import를 하지 않고 사용할 수 있었던 것은 두 클래스 또한 java.lang패키지에 속하기 때문이다.
		 *  워낙 자주 사용하는 패키지이다 보니 import 하지 않고 사용할 수 있도록 해 놓았다.
		 *  컴파일러가 import java.lang.*; 이 코드를 자동으로 추가해서 컴파일을 하기 때문이다.
		 * */
		System.out.println("-1.25의 절대값 : " + (Math.abs(-1.25)));
		
		/* 목차. 2. 최대값, 최솟값 출력 */
		System.out.println("10과 20중 더 작은 것은 : " + Math.min(10, 20));
		System.out.println("20과 30중 더 큰 것은 : " + Math.max(20, 30));
		
		/* 설명.
		 *  수학적으로 많이 사용하는 고정된 값들도 이미 Math 안에 정의된 것이 있다.
		 *  필드 라는 것을 이용한 것인데 이 부분은 나중에 다루게 되니 걱정하지 말자
		 * */
		System.out.println("원주율 : " + Math.PI);

		/* 목차. 3. 난수 출력 */
		/* 설명.
		 *  0부터 1 전까지의 실수 형태의 난수를 발생시킨다.
		 *  호출할 때마다 다른 값을 가진다.
		 *  난수는 프로그래밍에서 꽤나 자주 사용되는 편이다.
		 * */
		System.out.println("난수 발생 : " + Math.random());
	}
}
~~~

##### 결과

~~~java
-7의 절대값 : 7
-1.25의 절대값 : 1.25
10과 20중 더 작은 것은 : 10
20과 30중 더 큰 것은 : 30
원주율 : 3.141592653589793
난수 발생 : 0.27646885881098116
~~~



### 난수

~~~java
package com.ohgiraffers.section03.math;

public class Application2 {

	public static void main(String[] args) {

		/* 수업목표. 사용자 지정 범위의 난수를 발생시킬 수 있다.*/
		/* 필기.
		 *  난수의 활용
		 *  Math.random()을 이용해 발생한 난수는 0부터 1전까지의 실수 범위의 난수값을 반환한다.
		 *  필요에 따라 정수 형태의 값을 원하는 범위 만큼 발생시켜야 하는 경우들이 존재한다.
		 * */
		
		/* 필기.
		 *  원하는 범위의 난수를 구하는 공식
		 *  (int) (Math.random * 구하려는 난수의 갯수) + 구하려는 난수의 최소값
		 * */
		
		/* 목차. 1. 0 ~ 9까지의 난수 발생 */
		int random1 = (int) (Math.random() * 10);
		System.out.println("0 부터 9 사이의 난수 : " + random1);
		
		/* 목차. 2. 1 ~ 10까지의 난수 발생 */
		int random2 = (int) (Math.random() * 10) + 1;
		System.out.println("1 부터 10 사이의 난수 : " + random2);
		
		/* 목차. 3. 10 ~ 15까지의 난수 발생 */
		int random3 = (int) (Math.random() * 6) + 10;
		System.out.println("10 부터 15 사이의 난수 : " + random3);
		
		/* 목차. 4. -128 ~ 127까지의 난수 발생 */
		//int random4 = (int) (Math.random() * 256) + (-128);		
		int random4 = (int) (Math.random() * 256) - 128;
		System.out.println("-128 부터 127까지의 난수 발생 : " + random4);
	}
}
~~~



# Scanner(스캐너)



###### 💡 스캐너(Scanner)란 java.util.Scanner 클래스를 말한다. 이 클래스는 읽은 바이트를 문자, 숫자, 실수, boolean, 문자열 등 다양한 타입으로 변환하여 리턴하는 클래스이다.

Scanner는 “토큰 단위”로 데이터를 읽어 온다. (토큰 : 공백문자 - Spacebar/Tab/Enter 로 구분 되는 요소)

<img width="344" alt="image" src="https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/d5a2be03-ef04-4629-9d7b-b05ebb9c2226">



## 스캐너 활용



### 기본 활용

~~~java
package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {

	public static void main(String[] args) {
		
		/* 수업목표. java.util.Scanner를 이용한 다양한 자료형 값 입력 받기 */
		/* 설명.
		 *  콘솔 화면에 값을 입력 받아 출력해보기
		 *  이런 어려운 기능 또한 미리 JDK를 설치하면 손쉽게 사용할 수 있도록 구현 해 놓았다.
		 * */
		
		/* 목차. 1. Scanner 객체 생성 */
		/* 목차. 1-1. 원래 이렇게 Scanner 객체를 만들어야 한다. */
		//java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
		
		/* 목차. 1-2. 하지만 java.lang은 패키지이름 생략 가능하다. */
		//java.util.Scanner sc = new java.util.Scanner(System.in);
		
		/* 목차. 1-3. 다른 패키지에 있는 클래스 사용 시 패키지명 생략하기 위해 사용하는 구문사용 (import) */
		Scanner sc = new Scanner(System.in);		//java.util.Scanner import하면 사용 준비 끝
		
		/* 목차. 2. 자료형별 값 입력받기 */
		/* 설명.
		 *  입력받을 때 안내문구는 별도로 출력해주지 않으니 우리가 작성해줘야 한다.
		 *  print와 println은 줄 바꿈 차이 이다.
		 *  다음 줄에 입력을 대기시키는 것이 아니고 줄바꿈하지 않고 입력받게 하기 위해 print를 사용했다
		 * */

		/* 목차. 2-1. 문자열 입력 받기 */
		/* 필기. nextLine() : 입력받은 값을 문자열로 반환해줌 */
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.println("입력하신 이름은 " + name + "입니다.");
		
		/* 목차. 2-2. 정수형 값 입력 받기 */
		/* 필기. nextInt() : 입력받은 값을 int형으로 반환한다. */

		/* 설명.
		 *  nextByte()/nextShort()는 생략한다.
		 *  매개변수로 사용할 수 있는 radix는 진법을 지정할 수 있다.
		 *  숫자가 아닌 값을 입력하게 되면 InputMismatchException이 발생한다.
		 *  int 범위를 초과한 값을 입력받게 되면 역시 InputMismatchException이 발생한다.
		 *  Exception은 나중에 다시 다루게 되겠지만 쉽게 표현하자면 에러 같은 개념이라고 생각하자.
		 * */
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println("입력하신 나이는 " + age + "입니다.");
		
		/* 필기.
		 *  nextLong() : 입력받은 값을 long 형으로 반환한다.
		 *  nextInt와 Exception이 발생하는 이유는 동일하다.
		 * */
		System.out.print("금액을 입력해주세요 : ");		//만약 안내 구문을 작성하지 않으면 그냥 멈춘것 처럼 보인다. 사실 기다리는 중이다.
		long money = sc.nextLong();
		System.out.println("입력하신 금액은 " + money + "원 입니다.");
		
		/* 목차. 2-3. 실수형 값 입력 받기 */
		/* 필기. nextFloat() : 입력받은 값을 float 형으로 반환한다. */
		/* 설명.
		 *  정수 형태로 입력받으면 실수로 변환 후 정상 동작
		 *  숫자형태의 값이 아닌 경우 InputMismatchException 발생
		 * */
		System.out.print("키를 입력해주세요 : ");
		float height = sc.nextFloat();
		System.out.println("입력하신 키는 " + height + "cm 입니다.");
		
		/* 필기. nextDouble() : 입력받은 값을 double 형으로 반환한다. */
		/* 설명.
		 *  정수 형태로 입력받으면 실수로 변환 후 정상 동작
		 *  숫자형태의 값이 아닌 경우 InputMismatchException 발생
		 * */
		System.out.print("원하는 실수를 입력하세요 : ");
		double number = sc.nextDouble();
		System.out.println("입력하신 실수는 " + number + "입니다.");
		
		/* 목차. 2-4. 논리형 값 입력받기 */
		/* 필기. nextBoolean() : 입력받은 값을 boolean형으로 반환한다. */
		/* 설명. true or false 외에 다른 값을 입력하게 되면 InputMismatchException 발생함 */
		System.out.print("참과 거짓 중에 한 가지를 true or false로 입력해주세요 : ");
		boolean isTrue = sc.nextBoolean();
		System.out.println("입력하신 논리 값은 " + isTrue + "입니다.");
		
		/* 목차. 2-5. 문자형 값 입력받기 */
		/* 설명.
		 *  아쉽게도 문자를 직접 입력 받는 기능을 제공하지는 않는다.
		 *  따라서 문자열로 입력을 받고, 입력받은 문자에서 원하는 순번째 문자를 분리해서 사용해야 한다.
		 *  java.lang.String에 charAt(int index)를 사용한다.
		 *  index를 정수형으로 입력하면 문자열에서 해당 인덱스에 있는 한 문자를 문자 형으로 반환해주는 기능을 한다.
		 *  index는 0부터 시작하는 숫자 체계이며 컴퓨터에서 주로 사용되는 방식이다.
		 *  만약 존재하지 않는 인덱스를 입력하게 되면 IndexOutOfBoundsException이 발생한다.
		 * */
		sc.nextLine();
		System.out.print("아무 문자나 입력 해주세요 : ");
		char ch = sc.nextLine().charAt(0);
		System.out.println("입력하신 문자는 " + ch + "입니다.");
	}
}
~~~



## nextLine(), next()

~~~java
package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application2 {

public static void main(String[] args) {
		
		/* 수업목표. Scanner의 nextLine()과 next()에 대해 구분하여 사용할 수 있다. */
		/* 필기.
		 *  nextLine() : 공백을 포함한 한 줄을 입력을 위한 개행문자 전 까지 읽어서 문자열로 반환한다. (공백문자 포함)
		 *  next() : 공백문자나 개행문자 전 까지를 읽어서 문자열로 반환한다. (공백문자 포함하지 않음)
		 * */
		
		/* 목차. 1. Scanner 객체 생성 */
		Scanner sc = new Scanner(System.in);
		
		/* 목차. 2. 문자열 입력 */
		/* 목차. 2-1. nextLine() */
		System.out.print("인사말을 입력해주세요 : ");
		String greeting1 = sc.nextLine();		//안녕하세요 반갑습니다 <- 입력
		
		System.out.println(greeting1);			//안녕하세요 반갑습니다
		
		/* 목차. 2-2. next() */
		System.out.print("인사말을 입력해주세요 : ");
		String greeting2 = sc.next();			//안녕하세요 반갑습니다
		
		System.out.println(greeting2);			//안녕하세요
	}
}
~~~



## nextLine() 특징

~~~java
package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application3 {

public static void main(String[] args) {
		
		/* 수업목표. 스캐너 사용 시 주의 사항에 대해 이해하고 사용 시 주의사항을 고려하여 사용할 수 있다. */
		/* 필기.
		 *  스캐너의 next 메소드들은 입력한 내용을 버퍼로부터 토큰단위로 분리해서 읽어온다.
		 *  그래서 크게 두 가지 사항을 주의해야 한다.
		 *  1. next()로 문자열 입력 받은 후 정수, 실수, 논리값 입력 받을 때
		 *  2. 정수, 실수, 논리값 입력 후 next()로 문자열 입력받을 때
		 * */
		
		/* 필기. 스캐너 객체 생성 */
		Scanner sc = new Scanner(System.in);
		
		/* 목차. 1. next()로 문자열 입력 받은 후 정수, 실수, 논리값 입력 받을 때  */
		System.out.print("문자열을 입력해주세요 : ");
		String str1 = sc.next();				//공백이나 개행문자 전 까지를 읽어온다.
		System.out.println("str1 : " + str1);
		
		System.out.print("숫자를 입력해주세요 : ");
		int num1 = sc.nextInt();				//정수 값을 읽어온다.
		System.out.println("num1 : " + num1);
		
		/* 설명.
		 *  여기까지 작성하고 나면 작성상에(compile 시)는 문제되지 않는다.
		 *  처음 실행할 때 문자열에 "안녕" 이라고 입력하고 정수를 입력하면 정상적으로 동작한다.
		 *  하지만, "안녕하세요 반갑습니다" 입력 하면 동작 시(Runtime) 숫자를 입력하기도 전에 InputMismatchException이 발생한다.
		 *  		 *
		 * 설명.
		 *  "안녕하세요 반갑습니다" <- 입력 시 공백을 기준으로 두 개의 토큰 "안녕하세요"와 "반갑습니다"로 분리가 된다.
		 *  next()는 다음 토큰인 "안녕하세요"를 읽었고, nextInt()는 다음 토큰을 정수로 읽어야 하는데 "반갑습니다"가 나왔다.
		 *  정수를 입력해야 하는데 "반갑습니다"를 읽으면 당연히 InputMismatchException이 발생하게 된다.
		 *  공백이 있는 문자열을 받을거면 nextLine()을 이용하자
		 *
		 * 설명.
		 *  혹은 입력받은 버퍼틑 줄 단위로 토큰을 분리하기 때문에 해당 라인의 토큰을 다 읽고 다음 줄로 이동시키고 싶을 때는
		 *  한 라인의 모든 토큰을 읽어오는 sc.nextLine(); 호출을 중간에 한 번 넣어줘도 해결은 된다.
		 * */
		
		/* 목차. 2. 정수, 실수, 논리값 입력 후 nextLine()로 문자열 입력받을 때 */
		System.out.print("다시 숫자를 입력해주세요 : ");
		int num2 = sc.nextInt();
		System.out.println("num2 : " + num2);
		
		System.out.print("공백이 있는 문자열을 하나 입력해주세요 : ");	// 입력 받지 않고 넘어 감. nextInt()에는 정수 값을 입력 받은 후에도
		
//		sc.nextLine();

		String str2 = sc.nextLine();
		System.out.println("str2 : " + str2);		
		
		/* 설명.
		 *  입력받을 시 nextLine()을 호출한 것이 아직 행을 바꾸지 않고 한 라인을 읽어드린다고 판단해서 아무 것도 읽지 못하고 넘어간 뒤
		 *  다음 출력구문을 실행시킨 것이다.
		 *  이걸 해결하기 위해서는 sc.nextLine() 호출 전에 미리 sc.nextLine()을 한 번 호출 하면
		 *  그 행을 읽어드리는걸 다음 행으로 넘기게 되고, 그 이후 새로 입력받은 한 라인을 읽어와서 str2에 저장하게 되므로 정상 동작하게 된다.
		 * */
	}
}
~~~



##### 결과

~~~java
문자열을 입력해주세요 : 안녕하세요
str1 : 안녕하세요
숫자를 입력해주세요 : 1
num1 : 1
다시 숫자를 입력해주세요 : 2
num2 : 2
공백이 있는 문자열을 하나 입력해주세요 : str2 : 
~~~

