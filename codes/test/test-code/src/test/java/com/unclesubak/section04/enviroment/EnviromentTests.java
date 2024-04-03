package com.unclesubak.section04.enviroment;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnviromentTests {

    /* 수업목표.
        운영체제, JRE, 환경변수에 따라 테스트 수행을 할 수 있다. */

    /* 필기.
     *   테스트 메소드는 특정 OS 환경에서만 테스트를 수행할 수 있다.
     *   이 때, 특정 OS에서 무시되는 사유를 disabledReason에 기술하여
     *   테스트코드가 무시되는 사유를 다른 사람도 함께 알아볼 수 있도록 작성해준다.
     *  */
    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "맥 OS 환경에서만 테스트가 가능합니다.")
    @Order(1)
    public void testMAC() {}

    @Test
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Window 환경에서만 테스트가 가능합니다.")
    @Order(2)
    public void testWindow() {}

    @Test
    @EnabledOnOs(value = {OS.LINUX, OS.WINDOWS}, disabledReason = "Linux 혹은 Window 환경에서만 테스트가 가능합니다.")
    @Order(3)
    public void testLinuxAndWindow() {}

    @Test
    @DisabledOnOs(value = OS.MAC, disabledReason = "MAC 환경에서는 테스트가 불가능합니다.")
    @Order(4)
    public void testDisabledOnMAC() {}

    /* 필기.
     *   @EnabledOnJre를 이용하여 특정 JRE 버전에서만 테스트 하는 것도 가능하다.
     *   @DisabledOnJre를 이용하여 특정 JRE 버전에서만 테스트를 Disabled 하는 것도 가능하다.
     *   @EnabledForJreRange를 이용하면 min과 max 속성 사이의 버젼에서 테스트 하는 것도 가능하다.
     *   (min만 작성 시 min~최신버전까지, max만 작성 시 이전 버젼부터 max까지만 테스트한다.)
     *   @DisalbedForJreRange를 이용하면 특정 범위 사이의 JRE환경에서의 테스트를 Disabled 할 수 있다.
     *  */
    @Test
    @EnabledOnJre(value = JRE.JAVA_8, disabledReason = "JRE 1.8 환경에서만 테스트가 수행됩니다.")
    @Order(5)
    public void testJRE8() {}

    @Test
    @EnabledOnJre(value = {JRE.JAVA_8, JRE.JAVA_11}, disabledReason = "JRE 1.8 과 1.11 환경에서만 테스트가 수행됩니다.")
    @Order(6)
    public void testJRE8AndJRE11() {}

    @Test
    @DisabledOnJre(value = JRE.JAVA_11, disabledReason = "JRE 1.11를 제외한 환경에서만 테스트가 수행됩니다.")
    @Order(7)
    public void testDiabledOnJRE11() {}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    @Order(8)
    public void testFromJRE8To17() {}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    @Order(9)
    public void testDiabledFromJRE8To17() {}

    /* 필기.
     *   운영체제의 시스템 환경변수에 따라 테스트를 활성화 또는 비활성화 할 수 있다.
     *   cmd에서 set 명령으로 시스템 환경변수값을 확인해볼 수 있다.
     *   시스템 변수의 이름은 대소문자를 구분하지 않지만 값은 대소문자를 구분한다.
     *  */
    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "kimjong-wan")
    @Order(10)
    public void testEnviromentVariable() {}

    @Test
    @DisabledIfEnvironmentVariable(named = "USER", matches = "kimjong-wan")
    @Order(11 )
    public void testDisabledEnviromentVariable() {}
}
