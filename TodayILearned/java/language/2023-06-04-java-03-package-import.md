# package(패키지) 



💡 패키지란 서로 관련 있는 클래스 또는 인터페이스 등을 모아 하나의 묶음(그룹)으로 단위를 구성하는 것을 말한다.



- 같은 패키지 내에서는 동일한 이름의 클래스를 만들 수 없지만, 패키지가 다르면 동일한 이름을 가진 클래스를 만들 수도 있다. 
- 클래스명은 원래 패키지명을 포함하고 있다. 예) kr.ac.samhyook.method.Calculator (이게 클래스명)
- 지금까지 클래스 명에 패키지 명을 함께 사용하지 않은 이유는 동일한 패키지 내에서 사용했기 때문이다. 그렇기 때문에 서로 다른 패키지에 존재하는 클래스를 사용하는 경우에는 클래스명 앞에 패키지명을 명시해서 풀 클래스 이름으로 사용해야 한다.



## package의 선언

~~~java
package 패키지명;
~~~

- 클래스나 인터페이스의 소스파일( .java )의 최상단에 선언되어야 한다. 
- 클래스 명명규칙과 다르게 소문자로만 작성하는 것을 원칙으로 한다. 
- 패키지 명을 지정하지 않으면 자동적으로 이름 없는 패키지에 속하게 된다



## package 확인

~~~java
package com.ohgiraffers.section02.package_and_import;

public class Application1 {

	public static void main(String[] args) {

		/* 수업목표. 패키지에 대해 이해할 수 있다. */
		
		/* 설명. 이전에 만든 Calculator 클래스를 재사용해서 static method와 non-static 메소드를 호출해보자 */
		/* 목차. 1. non-static 메소드의 경우 */
	    com.ohgiraffers.section01.method.Calculator calc = new com.ohgiraffers.section01.method.Calculator();
		int min = calc.minNumberOf(30, 20);
		
		System.out.println("30과 20중 더 작은 값은 : " + min);
		
		/* 목차. 2. static 메소드의 경우 */
		int max = com.ohgiraffers.section01.method.Calculator.maxNumberOf(30, 20);
		
		System.out.println("30과 20중 더 큰 값은 : " + max);
		
	}
}
~~~



# import(임포트)



###### 💡 서로 다른 패키지에 존재하는 클래스를 사용하는 경우 패키지명을 포함한 풀 클래스 이름을 사용해야 한다. 하지만 매번 다른 클래스의 패키지명까지 기술하기에는 번거롭다. 그래서 패키지명을 생략하고 사용할 수 있도록 한 구문이 import 구문이다



## import 선언

~~~java
package 패키지명;

import 패키지명.*;
import 패키지명.클래스명;
import static 패키지명.클래스명;

...클래스

~~~

- import 문은 여러 개 명시할 수 있다. 
- import 는 package 선언문과 class 선언문 사이에 작성하며 어떠한 패키지 내에 있는 클래스를 사용할 것인지에 대해 미 리 선언하는 효과를 가진다. 
- static import 문은 static 메소드를 호출할 때 사용한다



## import 확인

~~~java
package com.ohgiraffers.section02.package_and_import;

/* 설명. 사용하려는 클래스까지를 작성해야 한다. */
import com.ohgiraffers.section01.method.Calculator;
/* static import의 경우 사용하려는 static method까지 전부 써줘야 한다. */
import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;

public class Application2 {

	public static void main(String[] args) {
		
		/* 수업목표. 임포트에 대해 이해할 수 있다. */
		/* 필기.
		 *  임포트란?
		 *   서로 다른 패키지에 존재하는 클래스를 사용하는 경우 패키지명을 포함한 풀 클래스 이름을 사용해야 한다.
		 *   하지만 매번 다른 클래스의 패키지명까지 기술하기에는 번거롭다.
		 *   그래서 패키지명을 생략하고 사용할 수 있도록 한 구문이 import 구문이다.
		 *   import는 package 선언문과 class 선언문 사이에 작성하며
		 *   어떠한 패키지 내에 있는 클래스를 사용할 것인지에 대해 미리 선언하는 효과를 가진다.
		 * */
		
		/* 설명. 다시 한 번 Calculator를 사용해서 메소드를 호출해보자 */
		/* 목차. 1. non-static method의 경우 */
		Calculator calc = new Calculator();			//임포트구문 추가할 것
		int min = calc.minNumberOf(50, 60);
		
		System.out.println("50과 60 중 더 작은 값은 : " + min);
		
		/* 목차. 2. static method의 경우 */
		int max = Calculator.maxNumberOf(50, 60);
		
		System.out.println("50과 60 중 더 큰 값은 : " + max);
		
		/* 목차. 3. static 메소드를 호출할 때 클래스명도 생략하고 사용(import static) */
		int max2 = maxNumberOf(100, 200);			//static import 수문 수동 추가
		
		System.out.println("100과 200 중 더 큰 값은 : " + max2);
	}
}

~~~

