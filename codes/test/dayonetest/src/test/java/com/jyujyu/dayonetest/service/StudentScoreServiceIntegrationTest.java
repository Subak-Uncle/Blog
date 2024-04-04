package com.jyujyu.dayonetest.service;

import com.jyujyu.dayonetest.IntegrationTest;
import com.jyujyu.dayonetest.MyCalculator;
import com.jyujyu.dayonetest.model.StudentScoreFixture;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentScoreServiceIntegrationTest extends IntegrationTest {

    @Autowired
    private StudentScoreService studentScoreService;
    @Autowired
    private EntityManager entityManager;

    @Test
    void savePassedStudentScoreTest() {
        // given
        var studentScore = StudentScoreFixture.passed();

        // when
        studentScoreService.saveScore(
                studentScore.getStudentName(),
                studentScore.getExam(),
                studentScore.getKorScore(),
                studentScore.getEnglishScore(),
                studentScore.getMathScore()
        );
        entityManager.flush();
        entityManager.clear();

        // then
        var passdStudentResponses = studentScoreService.getPassStudentList(studentScore.getExam());

        Assertions.assertEquals(1, passdStudentResponses.size());

        var passedStudentResponse = passdStudentResponses.get(0);

        var calculator = new MyCalculator(0.0);

        Assertions.assertEquals(studentScore.getStudentName(), passedStudentResponse.getStudentName());
        Assertions.assertEquals(
                calculator
                        .add(studentScore.getKorScore().doubleValue())
                        .add(studentScore.getEnglishScore().doubleValue())
                        .add(studentScore.getMathScore().doubleValue())
                        .divide(3.0)
                        .getResult(),
                passedStudentResponse.getAvgScore()
        );
    }

    @Test
    void saveFailedStudentScoreTest() {
        // given
        var studentScore = StudentScoreFixture.failed();

        // when
        studentScoreService.saveScore(
                studentScore.getStudentName(),
                studentScore.getExam(),
                studentScore.getKorScore(),
                studentScore.getEnglishScore(),
                studentScore.getMathScore()
        );
        entityManager.flush();
        entityManager.clear();

        // then
        var failedStuentResponses = studentScoreService.getFailStudentList(studentScore.getExam());
        Assertions.assertEquals(1, failedStuentResponses.size());

        var failedStudentResponse = failedStuentResponses.get(0);
        var calculator = new MyCalculator(0.0);

        Assertions.assertEquals(studentScore.getStudentName(), failedStudentResponse.getStudentName());
        Assertions.assertEquals(
                calculator
                        .add(studentScore.getKorScore().doubleValue())
                        .add(studentScore.getEnglishScore().doubleValue())
                        .add(studentScore.getMathScore().doubleValue())
                        .divide(3.0)
                        .getResult(),
                failedStudentResponse.getAvgScore()
        );
    }
}
