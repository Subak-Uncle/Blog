package com.jyujyu.dayonetest.model;

public class StudentScoreTestDataBuilder {

    // 미리 초기화된 빌더 클래스를 리턴
    public static StudentScore.StudentScoreBuilder passed () {
        return StudentScore.builder()
                .studentName("defaultNmae")
                .exam("defaultExam")
                .korScore(80)
                .englishScore(100)
                .mathScore(90);
    }

    public static StudentScore.StudentScoreBuilder failed() {
        return StudentScore.builder()
                .studentName("defaultName")
                .exam("defaultExam")
                .korScore(50)
                .englishScore(50)
                .mathScore(30);
    }
}
