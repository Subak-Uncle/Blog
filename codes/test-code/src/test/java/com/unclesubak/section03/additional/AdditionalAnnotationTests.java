package com.unclesubak.section03.additional;

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
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
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
