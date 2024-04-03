package com.unclesubak.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

class jupiterAssertionsTests {

    /* 수업목표.
        JUnit5(Jupiter)에서 제공하는 Assertions 메소드에 대해 이해할 수 있습니다.
     */

    /* 필기.
        JUnit Jupitersms JUnit4로부터 온 assertion 메소드와 새롭게 자바 8 람다 표현식으로 추가된 메소드를 제공합니다.
        모든 Jupiter Assertions의 메소드는 정적(static) 메소드 형태로 제공하고 있습니다.
     */

    /* 설명.
        테스트 코드를 작성할 때 가장 많이 사용하는 패턴은 given / when / then 패턴입니다.
        // given : 테스트 시 필요한 파라미터를 준비합니다.
        // when : 테스트를 할 메소드를 호출합니다.
        // then : 실행 결과를 검증합니다.
        단, 하나의 테스트 메소드에는 한 가지를 검증할 수 있도록 작성하는 것이 좋습니다.
        간혹 테스트할 메소드의 검증을 동시에 진행하는 경우도 존재합니다. (when & then)
     */

    /* 목차.
        1. assertEquals */
    /* 필기. assertEquals(expected, actual) 메소드는 실제 값과 기대 값의 일치 여부를 동일성으로 판단합니다. */
    @Test
    @DisplayName("더하기 기능 테스트")
    void testAssertEquals () {

        // given
        int firstNum = 10;
        int secondNum = 20;
        int expected = 30;
        int expectedDelta = 28;

        // when
        /* 설명. src/main/java에 동일한 패키지 위치에 Calculator 클래스를 만들어서 테스트합니다. */
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumber(firstNum, secondNum);

        // then
//        Assertions.assertEquals(result, expected);

        /* 설명. 세 번째 인자는 delta라고 불리는데, 이는 허용할 오차 범위를 의미합니다. */
//        Assertions.assertEquals(expectedDelta, result, 1);

        /* 설명. 세 번째 인자는 문자열로 테스트 실패 시 보여줄 메세지를 작성할 수 있습니다. */
//        Assertions.assertEquals(expectedDelta, result, "실패할 때 보여줄 메세지"); // 실패
//        Assertions.assertEquals(expected, result, "실패할 때 보여줄 메세지");   // 성공

        /* 설명. 람다를 이용해도 결과는 동일하지만 불필요한 경우 메세지를 만들지 않도록 지연로딩을 이용합니다. */
//        Assertions.assertEquals(expectedDelta, result, () -> "실패할 때 보여줄 메세지");    // 실패
        Assertions.assertEquals(expected, result, () -> "실패할 때 보여줄 메세지");

    }

    /* 목차.
    *   2. assertNotEquals */
    /* 필기. assertNotEquals(expected, actual) 메소드는 실제 값과 기대 값의 불일치 여부를 동일성(같은 주소)로 판단합니다.*/
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstance() {

        // given
        Object obj1 = new Object();

        // when
        Object obj2 = new Object();

        // then
        /* 설명. 단, equals 와 hashcode가 오버라이딩 되어 있는 경우는 같다고 판단합니다. (내부에서 equals 호출함) */
        Assertions.assertNotEquals(obj1, obj2); // 같지 않으면 통과
    }

    /* 목차.
        3. assertNull */
    /* 필기. assertNull(actual) 메소드는 래퍼런스 변수가 null 값을 가지는 지를 판단합니다. */
    @Test
    @DisplayName("null인 지 테스트")
    void testAssertNull () {

        // given
        String str;

        // when
        str = null;

        // then
        Assertions.assertNull(str);

    }

    /* 목차.
        4. assertNotNull */
    /* 필기. assertNotNull(actual) 메소드는 레퍼런스 변수가 null값을 가지지 않는지를 판단합니다. */
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

    /* 목차.
        5. assertTrue */
    /* 필기. assertTrue(actual) 메소드는 결과값이 true인지를 확인합니다. */
    @Test
    @DisplayName("두 값이 같은지 확인")
    void testAssertTrue() {

        //given
        int num1 = 10;
        int num2 = 10;

        //when
        boolean result = num1 == num2;

        //then
        /* assertEquals로 true값과 일치하는지를 확인하는 기능과 동일합니다 */
//        Assertions.assertEquals(true, result);
        Assertions.assertTrue(result);
    }

    /* 목차. 6. assertFalse */
    /* 필기. assertFalse(actual) 메소드는 결과값이 false인지 확인합니다. */
    @Test
    @DisplayName("두 값이 다른지 확인")
    void testAssertFalse() {

        //given
        int num1 = 10;
        int num2 = 20;

        //when
        boolean result = num1 == num2;

        //then
        /* assertEquals로 false값과 일치하는지를 확인하는 기능과 동일합니다 */
//        Assertions.assertEquals(false, result);
        Assertions.assertFalse(result);
    }

    /* 목차.
        7. assertAll */
    /* 필기. assertAll(Exeutable...) 모든 Assertion이 실행되고 실패가 함께 보고되는 그룹화된 Assertion */
    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll() {

        // given
        String firstName = "길동";
        String lastName = "홍";

        // when
        Person person = new Person(firstName, lastName);

        // then
        Assertions.assertAll(
                "그룹화된 테스트 이름(한 개 이상의 테스트 실패 시 보여짐)",
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
        Assertions.assertInstanceOf(Person.class, person);

        /* 설명. 모든 클래스는 Object의 후손입니다. */
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(Person.class, person),
                () -> Assertions.assertInstanceOf(Object.class, person)
        );
    }

    /* 목차.
        8. assertDoesNotThrow */
    /* 필기. assertDoesNotThrow(excutable) 메소드 호출 시 아무런 예외가 발생하지 않는지 확인 */
    @Test
    @DisplayName("void 메소드의 경우 exception 발생 없이 정상적으로 동작하는 지 테스트")
    void testAssertDoesNotThrow() {

        // given
        int firstNum = 10;
        int secondNum = 3;

        // when & then
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertDoesNotThrow(
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

    }

    /* 목차.
        9. assertThrows */
    /* 필기. assertThrows(Class, excutable) 메소드 호출 시 특정한 예외가 발생하는 지 확인 */
    @Test
    @DisplayName("void 메소드의 경우 exception 발생하는 지 테스트")
    void testAssertThrows() {

        // given
        int firstNum = 10;
        int secondNum = 0;
        String expectedErrorMessage = "0으로 나눌 수 없습니다.";

        // when & then
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        // when
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        // then
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception, () -> "예외 타입이 일치하지 않습니다."),
                () -> Assertions.assertEquals(expectedErrorMessage, exception.getMessage(), () -> "예외 메세지가 일치하지 않습니다.")
        );
    }

    /* 목차.
        10. assertLinesMatch*/
    /* 필기. assertLinesMatch(list, list) 두 개의 문자열 목록이 같은 지 확인(문자열만 가능합니다.) */
    @Test
    @DisplayName("예상 목록이 실제 목록과 일치하는 지 확인")
    void testAssertLinesMatch() {

        // given
        List<String> expected = Arrays.asList("java", "database", "spring");

        // when
        List<String> actual = Arrays.asList("java", "database", "spring");

        // then
        Assertions.assertLinesMatch(expected, actual, () -> "두 리스트의 값이 일치하지 않습니다.");
    }
}