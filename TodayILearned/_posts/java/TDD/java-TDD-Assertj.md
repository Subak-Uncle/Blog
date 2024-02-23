# TDD(Test Driven Development)



## Jupiter



### Caculator

~~~java
package com.ohgiraffers.assertions.section01.jupiter;

public class Calculator {

    public int plusTwoNumbers(int firstNum, int secondNum) {

        return firstNum + secondNum;
    }
}
~~~



### Person

~~~java
package com.ohgiraffers.assertions.section01.jupiter;

public class Person {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
~~~



### PositiveNumberValidator

~~~java
package com.ohgiraffers.assertions.section01.jupiter;

public class PositiveNumberValidator {
    public void checkDividableNumbers(int firstNum, int secondNum) {

        if(secondNum == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
~~~



### Test Jupiter

~~~java
package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JupiterAssertionsTests {

    /* 수업목표. JUnit5(Jupiter)에서 제공하는 Assertions 메소드에 대해 이해할 수 있다. */
    /* 필기.
    *   JUnit Jupiter는 JUnit4로부터 온 assertion 메소드와 새롭게 자바 8 람다 표현식으로 추가된 메소드를 제공한다.
    *   모든 Jupiter Assertions의 메소드는 정적(static) 메소드 형태로 제공하고 있다.
    * */

    /* 설명.
    *   테스트코드를 작성할 때 가장 많이 사용하는 패턴은 given when then 패턴이다.
    *   // given : 테스트 시 필요한 파라미터를 준비한다.
    *   // when : 테스트를 할 메소드를 호출한다.
    *   // then : 실행 결과를 검증한다.
    *   단, 하나의 테스트 메소드에는 한 가지를 검증할 수 있도록 작성하는 것이 좋다.
    *   간혹 테스트할 메소드와 검증을 동시에 진행하는 경우도 존재한다. (when & then)
    *  */

    /* 목차. 1. assertEquals */
    /* 필기. assertEquals(expected, actual) 메소드는 실제 값과 기대 값의 일치 여부를 동일성으로 판단한다. */
    @Test
    @DisplayName("더하기 기능 테스트")
    void testAssertEquals() {

        //given
        int firstNum = 10;
        int secondNum = 20;
        int expected = 30;

        //when
        /* 설명. src/main/java에 동일한 패키지 위치에 Calculator 클래스를 만들어서 테스트한다. */
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumbers(firstNum, secondNum);

        //then
//        Assertions.assertEquals(expected, result);

        /* 설명. 3번째 인자는 delta라고 불리는데, 이는 허용할 오차 범위를 의미한다. */
//        Assertions.assertEquals(expected, result, 1);

        /* 설명. 3번째 인자로 문자열로 테스트 실패 시 보여줄 메세지를 작성할 수 있다. */
//        Assertions.assertEquals(expected, result, "실패할 때 보여줄 메세지");

        /* 설명. 람다를 이용해도 결과는 동일하지만 불필요한 경우 메세지를 만들지 않도록 지연로딩을 이용한다. */
        Assertions.assertEquals(expected, result, () -> "실패할 때 보여줄 메세지");
    }

    /* 목차. 2. assertNotEquals */
    /* 필기. assertNotEquals(expected, actual) 메소드는 실제 값과 기대 값의 불일치 여부를 동일성(같인주소)으로 판단한다. */
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstances() {

        //given
        Object obj1 = new Object();

        //when
        Object obj2 = new Object();

        //then
        /* 설명. 단, equals와 hashcode가 오버라이딩 되어 있는 경우는 같다고 판단함 (내부에서 equals 호출함) */
        Assertions.assertNotEquals(obj1, obj2);
    }

    /* 목차. 3. assertNull */
    /* 필기. assertNull(actual) 메소드는 레퍼런스 변수가 null값을 가지는지를 판단한다. */
    @Test
    @DisplayName("null 인지 테스트")
    void testAssertNull() {

        //given
        String str;

        //when
        str = null;

        //then
        Assertions.assertNull(str);
    }

    /* 목차. 4. assertNotNull */
    /* 필기. assertNotNull(actual) 메소드는 레퍼런스 변수가 null값을 가지지 않는지를 판단한다. */
    @Test
    @DisplayName("null이 아닌지 테스트")
    void testAssertNotNull() {

        //given
        String str;

        //when
        str = "java";

        //then
        Assertions.assertNotNull(str);
    }

    /* 목차. 5. assertTrue */
    /* 필기. assertTrue(actual) 메소드는 결과값이 true인지를 확인한다. */
    @Test
    @DisplayName("두 값이 같은지 확인")
    void testAssertTrue() {

        //given
        int num1 = 10;
        int num2 = 10;

        //when
        boolean result = num1 == num2;

        //then
        /* assertEquals로 true값과 일치하는지를 확인하는 기능과 동일하다 */
//        Assertions.assertEquals(true, result);
        Assertions.assertTrue(result);
    }

    /* 목차. 6. assertFalse */
    /* 필기. assertFalse(actual) 메소드는 결과값이 false인지 확인한다. */
    @Test
    @DisplayName("두 값이 다른지 확인")
    void testAssertFalse() {

        //given
        int num1 = 10;
        int num2 = 20;

        //when
        boolean result = num1 == num2;

        //then
        /* assertEquals로 false값과 일치하는지를 확인하는 기능과 동일하다 */
//        Assertions.assertEquals(false, result);
        Assertions.assertFalse(result);
    }

    /* 목차. 7. assertAll */
    /* 필기. assertAll(Executable...) 모든 Assertion이 실행되고 실패가 함께 보고되는 그룹화된 Assertion */
    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll() {

        //given
        String firstName = "길동";
        String lastName = "홍";

        //when
        Person person = new Person(firstName, lastName);

        //then
        Assertions.assertAll(
                "그룹화된 테스트의 이름(테스트 실패 시 보여짐)",
                () -> Assertions.assertEquals(firstName, person.getFirstName(), () -> "firstName이 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getLastName(), () -> "lastName이 잘못됨")
        );
    }

    @Test
    @DisplayName("인스턴스의 타입에 대한 검증을 수행하는 경우")
    void testAssertType() {

        //given
        String firstName = "길동";
        String lastName = "홍";

        //when
        Person person = new Person(firstName, lastName);

        //then
//        Assertions.assertInstanceOf(Person.class, person);

        /* 설명. 모든 클래스는 Object의 후손이다. */
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(Person.class, person),
                () -> Assertions.assertInstanceOf(Object.class, person)
        );
    }

    /* 목차. 8. assertDoesNotThrow */
    /* 필기. assertDoesNotThrow(excutable) 메소드 호출 시 아무런 예외가 발생하지 않는지 확인 */
    @Test
    @DisplayName("void 메소드의 경우 exception 발생 없이 정상적으로 동작하는지 테스트")
    void testAssertDoesNotThrow() {

        //given
        int firstNum = 10;
        int secondNum = 3;

        //when & then
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertDoesNotThrow(
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );
    }

    /* 목차. 9. assertThrows */
    /* 필기. assertThrows(Class, excutable) 메소드 호출 시 특정한 예외가 발생하는지 확인 */
    @Test
    @DisplayName("void 메소드의 경우 exception 발생하는지 테스트")
    void testAssertThrows() {

        //given
        int firstNum = 10;
        int secondNum = 0;
        String expectedErrorMessage = "0으로 나눌 수 없습니다.";

        //when & then
//        PositiveNumberValidator validator = new PositiveNumberValidator();
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> validator.checkDividableNumbers(firstNum, secondNum)
//        );

        //when
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        //then
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception, () -> "예외 타입이 일치하지 않음"),
                () -> Assertions.assertEquals(expectedErrorMessage, exception.getMessage(), () -> "예외 메세지가 일치하지 않음")
        );
    }

    /* 목차. 10. assertLinesMatch */
    /* 필기. assertLinesMatch(list, list) 두 개의 문자열 목록이 같은지 확인(문자열만 가능함) */
    @Test
    @DisplayName("예상 목록이 실제 목록과 일치하는지 확인")
    void testAssertLinesMatch() {

        //given
        List<String> expected = Arrays.asList("java", "database", "spring");

        //when
        List<String> actual = Arrays.asList("java", "database", "spring");

        //then
        Assertions.assertLinesMatch(expected, actual, () -> "두 리스트의 값이 일치하지 않음");
    }
}
~~~



## Assertj

### Member

~~~java
package com.ohgiraffers.assertions.section02.assertj;

public class Member {

    private int sequence;
    private String id;
    private String name;
    private int age;

    public Member(int sequence, String id, String name, int age) {
        this.sequence = sequence;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getSequence() {
        return sequence;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
~~~



### Test Assertj

#### build.gradle

~~~properties
plugins {
    id 'java'
}

group 'org.ohgiraffers'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation 'org.assertj:assertj-core:3.23.1'

}

test {
    useJUnitPlatform()
}
~~~

#### 예외처리 클래스

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/b0df394b-790a-41e8-9c5f-27a539792892)

> 출처 : https://compogetters.tistory.com/71#google_vignette



~~~java
package com.ohgiraffers.assertions.section02.assertj;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.data.Offset;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class AssertJTests {

    /* 수업목표. test third party lib 중 AssertJ의 사용법에 대해 이해할 수 있다. */
    /*  사전조건.
    *    gradle에 라이브러리 의존성을 추가해야 한다. assertj-core 모듈 추가해야 하며,
    *    7버전 이하는 2.x버전을 이용하고, 8버전 이상은 3.x 버전을 이용해야 한다.
    * */

    /* 필기.
    *   AssertJ는 메소드 체이닝을 지원하기 때문에 좀 더 깔끔하고 읽기 쉬운 테스트코드를 작성할 수 있다.
    *   개발자가 테스트를 하면서 필요하다고 생각하는 거의 모든 기능을 메소드로 제공하고 있다.
    *   참고로 Hamcrest, Truth 등도 사용하는 용법이나 컨셉이 비슷하지만 보통 AssertJ를 많이 사용한다.
    *   가장 직관적이고 편하며, JUInit5 팀에서도 공식적으로 추천하고 있는 third party lib 이다.
    *  */

    /* 목차. 1. 문자열 테스트 하기 */
    /* 필기. 문자열의 패턴들로 검증을 하기 때문에 일치성 여부만 판단하는 것 보다 다양한 테스트를 할 수 있다. */
    @Test
    @DisplayName("문자열 테스트 하기")
    void testStringValidation() {

        //given
        String expected = "hello world";

        //when
        String actual = new String(expected);

        //then
        Assertions.assertThat(actual)
                .isNotEmpty()
                .isNotBlank()
                .contains("hello")
                .doesNotContain("hahaha")
                .startsWith("h")
                .endsWith("d")
                .isEqualTo("hello world");
    }

    /* 목차. 2. 숫자 테스트 하기 */
    /* 필기. 숫자 또한 일치여부가 아닌 범위값도 검증하는 단정 메소드를 통해 다양한 테스트를 수행할 수 있다. */
    @Test
    @DisplayName("숫자 테스트 하기")
    void testIntegerValidation() {

        //given
        double pi = Math.PI;

        //when
        Double actual = Double.valueOf(pi);

        //then
        Assertions.assertThat(actual)
                .isPositive()
                .isGreaterThan(3)
                .isLessThan(4)
                .isEqualTo(Math.PI);
    }

    /* 목차. 3. 날짜 테스트 하기 */
    /* 필기. 날짜 객체가 가지는 년,월,일,시,분,초,밀리초,나노초 까지도 검증이 가능하며, 특정 날짜 범위, 이전, 이후 내용도 검증이 가능하다. */
    @Test
    @DisplayName("날짜 테스트 하기")
    void testLocalDateTimeValidation() {

        //given
        String birthday = "2014-09-18T16:42:00.000";

        //when
        LocalDateTime thatDay = LocalDateTime.parse(birthday);
        System.out.println("thatDay = " + thatDay);

        //then
        Assertions.assertThat(thatDay)
                .hasYear(2014)
                .hasMonthValue(9)
                .hasMonth(Month.SEPTEMBER)
                .hasDayOfMonth(18)
                .isBetween("2014-01-01T00:00:00.000", "2014-12-31T23:59:59.999")
                .isBefore(LocalDateTime.now());
    }

    /* 목차. 4. 예외 테스트 하기 */
    /* 필기. 예외 내용을 검증하는 것 또한 예외 타입, 예외 메세지 등을 검증할 수 있다. */
    @Test
    @DisplayName("예외 테스트 하기")
    void testExceptionValidation() {
        
        //given
        
        //when
        Throwable thrown = AssertionsForClassTypes.catchThrowable(() -> { throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다."); });

        //then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("파라미터");
    }

    @Test
    @DisplayName("예외 테스트 하기2")
    void testExceptionValidation2() {

        //given

        //when & then
//        Assertions.assertThatThrownBy(() -> { throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다.");})
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("파라미터");

        /* 필기.
        *   자주 사용하는 예외처리에 대한 정의된 함수를 제공한다.
        *   1. assertThatNullPointerException
        *   2. assertThatIllegalArgumentException
        *   3. assertThatIllegalStateException
        *   4. assertThatIOException
        *  */
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다.");
                }).withMessageContaining("파라미터");
    }

    /* 목차. 5. 예외를 던지지 않는 메소드의 경우 테스트 하기 */
    /* 필기. 예외를 던지지 않는 메소드가 호출될 시 예외가 발생하지 않는지를 검증하는 단정 메소드도 제공하고 있다. */
    @Test
    @DisplayName("예외를 던지지 않는 경우 테스트하기")
    void testNoneExceptionValidation() {

        //given

        //when & then
        Assertions.assertThatCode(() -> {

            //예외 발생하지 않는 로직 작성
        }).doesNotThrowAnyException();
    }

    /* 목차. 6. filter를 이용한 단정문 테스트 하기 */
    /* 필기. 특정 filter를 자바 람다식을 이용하여 표현할 수 있는 유용한 기능이다. */
    @Test
    @DisplayName("filtering assertions 테스트하기")
    void testFilteringAssertions() {

        //given
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        //when
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        //then
        /* 회원 3과 4가 성인인지 확인 */
        Assertions.assertThat(members)
                .filteredOn(member -> member.getAge() > 20)
                .containsOnly(member3, member4);
    }

    /* 목차. 7. 객체 프로퍼티 검증 하기 */
    /* 필기. 객체의 프로퍼티를 추출하여 filter를 할 수 있다. 이 때 getter함수가 존재하지 않아도 프로프터 필터링이 가능하다. */
    @Test
    @DisplayName("객체의 프로퍼티 검증 테스트하기")
    void testPropertyValidation() {

        //given
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        //when
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        //then
        /* 설명. property를 확인하는 것은 getter 메소드가 필요하지 않다. */
        Assertions.assertThat(members)
                .filteredOn("age", 20)
                .containsOnly(member1);
    }

    /* 목차. 8. 객체 프로퍼티 추출 하기 */
    /* 필기. 객체의 특정 프로퍼티를 추출하여 List를 이용한 검증을 할 수 있다. */
    @Test
    @DisplayName("프로퍼티 추출 테스트하기")
    void testExtractProperty() {

        //given
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        List<String> expected = Arrays.asList("홍길동", "유관순", "이순신", "신사임당", "임꺽정");

        //when
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        //then
        Assertions.assertThat(members)
                .extracting("name", String.class)
                .containsAll(expected);
    }

    /* 목차. 9. 객체의 프로퍼티를 여러 개 튜플로 추출하기 */
    /* 필기. 객체의 여러 프로퍼티들을 추출하여 튜플로 생성하고, 튜플을 이용하여 검증할 수 있는 기능을 제공하고 있다. */
    @Test
    @DisplayName("튜플로 추출하여 테스트하기😂")
    void testExtractPropertyTuple() {

        //given
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        //when
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        //then
        Assertions.assertThat(members)
                .extracting("name", "age")
                .contains(
                        Tuple.tuple("홍길동", 20),
                        Tuple.tuple("유관순", 16)
                );
    }
}
~~~

 