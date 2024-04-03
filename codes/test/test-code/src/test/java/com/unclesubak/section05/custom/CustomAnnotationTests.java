package com.unclesubak.section05.custom;

public class CustomAnnotationTests {
    
    /* 수업목표.
        원하는 어노테이션을 조합하여 커스텀 어노테이션을 만들어서 사용할 수 있습니다. */
    @WindowsTest
    public void testOnWindowsOs() {}

    @MacTest
    public void testOnMacOS() {}

    @DevelopmentTest
    public void testDevelopmentCustomTag() {}

    @ProductionTest
    public void testProductionCustomTag() {}


}
