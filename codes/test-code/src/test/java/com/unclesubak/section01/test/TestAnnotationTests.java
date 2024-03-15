package com.unclesubak.section01.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestAnnotationTests {

    /* 수업목표.
        JUnit5의 기본 어노테이션을 사용할 수 있습니다.*/
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
        @Test메소드는 단독으로 실행이 가능하다.f
    */
    @Test
    /* 필기. 기본적으로 테스트 이름은 메소드 이름을 따라가지만 @DisplayName에 설정한 이름으로 테스트의 이름을 표기해준다. */
    @DisplayName("테스트 메소드1")
    public void testMethod() {
    }

    /* 설명. 과거에는 공백문자를 언더 바로 표기한 한글 메소드 형태로 테스트메소드를 작성하기도 했다. */
    @Test
    public void 테스트_메소드2() {
        /* 필기.
         *   클래스 레벨에 @DisplayNameGenerator를 붙이게 되면 언더 바를 공백으로 처리하여 테스트 이름을 부여해준다.
         *   단, @DisplayName과 중복 작성 시에는 @DisplayName에 부여한 테스트 이름이 우선권을 가진다.
         */
    }

    @Test
    @DisplayName("displayName 우선순위 테스트")
    public void 테스트_메소드3() {
    }

    /* 필기. 각각의 테스트는 실행 순서를 작성 순서로 보장해주지 않는다. */
}
