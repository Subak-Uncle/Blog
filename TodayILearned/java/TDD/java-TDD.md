# TDD(Test Driven Development)

~~~java
package com.ohgiraffers.section01.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestAnnotationTests {

    /* 수업목표. JUnit5의 기본 어노테이션을 사용할 수 있다. */
    /* 필기.
    *   JUnit5는 세 개의 서브프로젝트로 이루어져 있다.
    *   1. JUnit Platform
    *    - JVM에서 테스트 프레임워크를 실행하기 위한 테스트 엔진을 제공한다.
    *   2. JUnit Jupiter
    *    - JUnit5에서 테스트를 작성하고 실행하기 위한 엔진을 제공한다.
    *   3. JUnit Vintage
    *    - JUnit3, 4를 기반으로 돌아가는 테스트 엔진을 제공해준다. (하위 호환용)
    *  */

    /* 설명. JUnit5를 기반으로 테스트코드를 작성할 때 기본적으로 알아야 할 어노테이션과 동작 흐름에 대해 살펴보자 */

    /* 필기.
    *    테스트 클래스는 적어도 한 개 이상의 @Test 어노테이션이 달린 메소드를 가진 클래스이다.
    *    테스트 클래스는 abstract이면 안되고, 한 개의 생성자를 가지고 있어야 한다. 
    *    (두 개 이상 작성하면 런타임 시 PreconditionViolationException이 발생한다.)
    *    아무런 생성자도 작성하지 않으면 기본 생성자는 컴파일러가 자동으로 추가한다.
    *  */
    public TestAnnotationTests() {}

//    public TestAnnotationTests(int value) {}

    /* 필기.
        기본적인 테스트 메소드를 만들기 위해 사용하는 어노테이션이다.
    *   @Test메소드는 단독으로 실행이 가능하다.
    *  */
    @Test
    /* 필기. 기본적으로 테스트 이름은 메소드 이름을 따라가지만 @DisplayName에 설정한 이름으로 테스트의 이름을 표기해준다. */
    @DisplayName("테스트 메소드1")
    public void testMethod1() {

    }

    /* 설명. 과거에는 공백문자를 언더바로 표기한 한글 메소드 형태로 테스트메소드를 작성하기도 했다. */
    @Test
    @DisplayName("displayName 우선순위 테스트")
    public void 테스트_메소드2() {
        /* 필기.
        *   클래스 레벨에 @DisplayNameGenerator를 붙이게 되면 언더바를 공백으로 처리하여 테스트 이름을 부여해준다.
        *   단, @DisplayName과 중복 작성 시에는 @DisplayName에 부여한 테스트 이름이 우선권을 가진다.
        */
    }

    /* 필기. 각각의 테스트는 실행 순서를 작성 순서로 보장해주지 않는다. */
}
~~~



## LifeCycle

~~~java
package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleAnnotationTests {

    /* 수업목표. 테스트 메소드의 실행 전 후에 동작하는 어노테이션을 사용할 수 있다. */

    /* 설명.
    *   모든 테스트 메소드와 라이프사이클 관련 메소드는 abstract이면 안되고, void 형으로 작성해야 한다.
    *   또한 접근제한자는 사용하지 않아도 되지만(default), private이면 안된다.
    * */

    /* 필기. 테스트가 실행되기 전 딱 한 번만 실행된다. */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    /* 필기.
    *   각각의 테스트 메소드가 실행되기 전 실행된다.
    *   @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 실행되기 전에 동작한다.
    *   주로 테스트 하기 전에 필요한 목업 데이터를 미리 세팅해 줄 목적으로 사용한다.
    * */
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    /* 필기.
    *   각각의 테스트 메소드가 동작한 직후 동작한다.
    *   @Test, @RepeatedTest, @ParameterizedTest, @TestFactory가 실행된 이후 동작한다.
    *   주로 단위 테스트들이 수행된 이후 사용한 자원을 해제할 목적으로 사용한다.
    * */
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    /* 필기.
    *   모든 단위 테스트가 완전히 끝난 후 딱 한 번만 실행된다.
    * */
    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }
}
~~~



## additional

~~~java
package com.ohgiraffers.section03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTests {


    /* 수업목표. Junit에서 제공하는 테스트 관련 추가 어노테이션을 사용할 수 있다. */
    /* 필기.
    *   해당 테스트를 무시할 때 사용하는 어노테이션이다.
    *   JUnit4에서의 @Ignore와 동일한 기능을 제공한다.
    * */
    @Disabled
    @Test
    public void testIgnore() {}

    /* 필기.
    *   주어진 시간 안에 테스트가 끝나지 않으면 테스트가 실패한다.
    *   value에는 시간을 정수형으로, unit에는 사용할 시간 단위를 기술한다.
    *  */
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)    // 필기. 1000까진 통과
    public void testTimeout() throws InterruptedException {

        Thread.sleep(900);
    }

    /* 필기. @Tag 태그를 이용하여 테스트를 필터링 할 수 있다. */
    /* 설명.
    *   1. 우측 상단 실행버튼 옆 드롭다운 박스를 클릭하여 Edit Configurations를 선택한다.
    *   2. 모듈을 해당 프로젝트의 테스트 경로로 설정한다. (프로젝트로 설정하면 버퍼 용량 초과 에러 발생한다.)
    *   3. Debug/Run Configurations 창 왼쪽 상단에 + 버튼을 눌러서 JUnit을 추가한다.
    *   4. 필터 이름 설정 후 build and run 부분의 세 번째 드롭다운박스를 선택해서 Tags를 선택하고 필터링할 태그 이름을 입력한다.
    *   5. 실행하려 하면 설정을 다시 할 것인지 묻는 창이 나오는데 무시하고 그냥 실행하면 해당 태그로 필터링된 테스트만 실행하게 된다.
    * */

    /* 필기.
    *   @Tag를 사용하기 위한 규칙
    *   1. 태그는 공백이나 null이 있으면 안됨
    *   2. 다음 글자를 포함하면 안된다. : , ( ) & ! |
    *  */
    @Test
    @Tag("development")
    public void testTag1() {}

    @Test
    @Tag("production")
    public void testTag2() {}

    @Test
    @Tags(value = {@Tag("development"), @Tag("performance")})
    public void testTag3() {}

    /* 필기.
    *   테스트 메소드는 실행 순서가 보장되지 않지만 경우에 따라서는 (통합테스트 환경 등) 테스트의 순서가 중요한 경우도 있다.
    *   클래스 레벨에 @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 어노테이션을 추가하고
    *   각 테스트 메소드에 @Order 어노테이션으로 순서를 지정하면 테스트 순서를 설정할 수 있다.
    *   클래스에 작성한 테스트 메소드의 순서는 MethodOrderer에 DisplayName, MethodName, OrderAnnotation, Random 등이 있다.
    *  */
    @Test
    @Order(1)
    public void testFirst() {}

    @Test
    @Order(2)
    public void testSecond() {}

    @Test
    @Order(3)
    public void testThird() {}

    /* 필기.
    *   RepeatedTest는 명시된 숫자로 얼마나 테스트를 반복할 것인지를 지정해서 사용한다.
    *   반복된 테스트 메소드의 호출은 보통의 @Test 메소드들이랑 똑같이 동작한다.
    *  */
    @RepeatedTest(10)
    public void testRepeat() {}

}
~~~



## enviroment

~~~java
package com.ohgiraffers.section04.environment;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class EnvironmentAnnotationTests {

    /* 수업목표. 운영체제, JRE, 환경변수에 따라 테스트 수행을 할 수 있다. */
    /* 필기.
     *   테스트 메소드는 특정 OS 환경에서만 테스트를 수행할 수 있다.
     *   이 때, 특정 OS에서 무시되는 사유를 disabledReason에 기술하여
     *   테스트코드가 무시되는 사유를 다른 사람도 함께 알아볼 수 있도록 작성해준다.
     *  */
    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "맥 에서만 테스트 합니다.")
    public void testMAC() {}

    @Test
    @EnabledOnOs(value = {OS.WINDOWS, OS.LINUX}, disabledReason = "윈도우와 리눅스만 테스트 합니다.")
    public void testWindowsAndLinux() {}

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "윈도우 환경에서는 테스트를 무시합니다.")
    public void testDisabledOnWindows() {}

    /* 필기.
     *   @EnabledOnJre를 이용하여 특정 JRE 버전에서만 테스트 하는 것도 가능하다.
     *   @DisabledOnJre를 이용하여 특정 JRE 버전에서만 테스트를 Disabled 하는 것도 가능하다.
     *   @EnabledForJreRange를 이용하면 min과 max 속성 사이의 버젼에서 테스트 하는 것도 가능하다.
     *   (min만 작성 시 min~최신버전까지, max만 작성 시 이전 버젼부터 max까지만 테스트한다.)
     *   @DisalbedForJreRange를 이용하면 특정 범위 사이의 JRE환경에서의 테스트를 Disabled 할 수 있다.
     *  */
    @Test
    @EnabledOnJre(value = JRE.JAVA_8, disabledReason = "JRE 1.8환경에서만 테스트합니다.")
    public void testJRE8() {}

    @Test
    @EnabledOnJre(value = {JRE.JAVA_8, JRE.JAVA_11})
    public void testJRE8AndJRE11() {}

    @Test
    @DisabledOnJre(value = JRE.JAVA_8)
    public void testDisabledJRE8() {}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    public void testFromJRE8ToJRE11() {}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    public void testDisabledFromJRE8ToJRE11() {}

    /* 필기.
     *   운영체제의 시스템 환경변수에 따라 테스트를 활성화 또는 비활성화 할 수 있다.
     *   cmd에서 set 명령으로 시스템 환경변수값을 확인해볼 수 있다.
     *   시스템 변수의 이름은 대소문자를 구분하지 않지만 값은 대소문자를 구분한다.
     *  */
    @Test
    @EnabledIfEnvironmentVariable(named = "username", matches="jinho")
    public void testEnvironmentVariable() {}

    @Test
    @EnabledIfEnvironmentVariable(named = "username", matches="user")
    public void testEnvironmentVariable2() {}

    @Test
    @DisabledIfEnvironmentVariable(named = "username", matches = "gildong")
    public void testDisabledEnvironmentVariable() {}
}
~~~



## Custom

### Tests

~~~java
package com.ohgiraffers.section05.custom;

public class CustomAnnotationTests {
    
    /* 수업목표. 원하는 어노테이션을 조합하여 커스텀 어노테이션을 만들어서 사용할 수 있다. */
    @WindowsTest
    public void testOnWindowsOs() {}

    @DevelopmentTest
    public void testDevelopmentCustomTag() {}

    @ProductionTest
    public void testProductionCustomTag() {}
}
~~~



### DevelopmentTest

~~~java
package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 필기. 주석이 유지되는 기간을 나타냄
@Target(ElementType.METHOD)
@Tag("development")
@Test
public @interface DevelopmentTest {
}
~~~



### ProductionTest

~~~java
package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Tag("production")
@Test
public @interface ProductionTest {
}
~~~



### WindowsTest

~~~java
package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EnabledOnOs(OS.WINDOWS)
@Test
public @interface WindowsTest {
}
~~~

