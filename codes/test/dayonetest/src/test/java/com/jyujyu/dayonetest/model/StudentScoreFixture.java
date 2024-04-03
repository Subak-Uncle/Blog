package com.jyujyu.dayonetest.model;

public class StudentScoreFixture {

    public static StudentScore passed() {
        return StudentScore.builder()
                .exam("defaultExam")
                .studentName("defaultName")
                .korScore(90)
                .mathScore(80)
                .englishScore(70)
                .build();
    }

    public static StudentScore failed() {
        return StudentScore.builder()
                .exam("defaultExam")
                .studentName("defaultName")
                .korScore(40)
                .englishScore(60)
                .mathScore(50)
                .build();
    }
}
