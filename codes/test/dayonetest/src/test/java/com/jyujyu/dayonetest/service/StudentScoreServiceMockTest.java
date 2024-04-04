package com.jyujyu.dayonetest.service;

import com.jyujyu.dayonetest.dto.response.ExamFailStudentResponse;
import com.jyujyu.dayonetest.dto.response.ExamPassStudentResponse;
import com.jyujyu.dayonetest.model.*;
import com.jyujyu.dayonetest.repository.StudentFailRepository;
import com.jyujyu.dayonetest.repository.StudentPassRepository;
import com.jyujyu.dayonetest.repository.StudentScoreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

public class StudentScoreServiceMockTest {

    private StudentScoreService studentScoreService;

    private StudentScoreRepository studentScoreRepository;
    private StudentPassRepository studentPassRepository;
    private StudentFailRepository studentFailRepository;

    @BeforeEach
    public void beforeEach() {
        studentScoreRepository = Mockito.mock(StudentScoreRepository.class);
        studentPassRepository = Mockito.mock(StudentPassRepository.class);
        studentFailRepository = Mockito.mock(StudentFailRepository.class);
        studentScoreService = new StudentScoreService(
                studentScoreRepository,
                studentPassRepository,
                studentFailRepository
        );
    }

    @Test
    @DisplayName("첫 번째 Mock 테스트")
    public void firstSaveScoreMockTest() {

        // given
        String givenStudentName = "jyujyu";
        String givenExam = "testexam";
        Integer givenKorScore = 80;
        Integer givenEnglishScore = 100;
        Integer givenMathScore = 60;

        // when
        studentScoreService.saveScore(
                givenStudentName,
                givenExam,
                givenKorScore,
                givenEnglishScore,
                givenMathScore
        );
    }

    @Test
    @DisplayName("성적 저장 로직 검증 / 60점 이상인 경우")
    void saveScoreMockTest() {

        // given : 평균점수가 60점 이상인 경우
        StudentScore expectStudentScore = StudentScoreTestDataBuilder.passed()
                .studentName("new Student Name")    // 오버라이딩 가능
                .build();
        StudentPass expectStudentPass = StudentPassFixture.create(expectStudentScore);

        ArgumentCaptor<StudentScore> studentScoreArgumentCaptor = ArgumentCaptor.forClass(StudentScore.class);
        ArgumentCaptor<StudentPass> studentPassArgumentCaptor = ArgumentCaptor.forClass(StudentPass.class);

        // when
        studentScoreService.saveScore(
                expectStudentScore.getStudentName(),
                expectStudentScore.getExam(),
                expectStudentScore.getKorScore(),
                expectStudentScore.getEnglishScore(),
                expectStudentScore.getMathScore()
        );

        // then
        Mockito.verify(studentScoreRepository, Mockito.times(1)).save(studentScoreArgumentCaptor.capture());
        StudentScore capturedStudentScore =  studentScoreArgumentCaptor.getValue();
        Assertions.assertEquals(expectStudentScore.getStudentName(), capturedStudentScore.getStudentName());
        Assertions.assertEquals(expectStudentScore.getExam(), capturedStudentScore.getExam());
        Assertions.assertEquals(expectStudentScore.getKorScore(), capturedStudentScore.getKorScore());
        Assertions.assertEquals(expectStudentScore.getEnglishScore(), capturedStudentScore.getEnglishScore());
        Assertions.assertEquals(expectStudentScore.getMathScore(), capturedStudentScore.getMathScore());

        Mockito.verify(studentPassRepository, Mockito.times(1)).save(studentPassArgumentCaptor.capture());
        StudentPass capturedStudentPass = studentPassArgumentCaptor.getValue();
        Assertions.assertEquals(expectStudentPass.getStudentName(), capturedStudentPass.getStudentName());
        Assertions.assertEquals(expectStudentPass.getExam(), capturedStudentPass.getExam());
        Assertions.assertEquals(expectStudentPass.getAvgScore(), capturedStudentPass.getAvgScore());

        Mockito.verify(studentFailRepository, Mockito.times(0)).save(Mockito.any());

    }

    @Test
    @DisplayName("성적 저장 로직 검증 / 60점 미만인 경우")
    void saveScoreMockTest2() {

        // given : 평균 점수가 60점 미만인 경우
        StudentScore expectStudentScore = StudentScoreFixture.failed();
        StudentFail expectStudentFail = StudentFailFixture.create(expectStudentScore);

        ArgumentCaptor<StudentScore> studentScoreArgumentCaptor = ArgumentCaptor.forClass(StudentScore.class);
        ArgumentCaptor<StudentFail> studentFailArgumentCaptor = ArgumentCaptor.forClass(StudentFail.class);

        // when
        studentScoreService.saveScore(
                expectStudentScore.getStudentName(),
                expectStudentScore.getExam(),
                expectStudentScore.getKorScore(),
                expectStudentScore.getEnglishScore(),
                expectStudentScore.getMathScore()
        );

        // then
        Mockito.verify(studentScoreRepository, Mockito.times(1)).save(studentScoreArgumentCaptor.capture());
        StudentScore capturedStudentScore = studentScoreArgumentCaptor.getValue();
        Assertions.assertEquals(expectStudentScore.getStudentName(), capturedStudentScore.getStudentName());
        Assertions.assertEquals(expectStudentScore.getExam(), capturedStudentScore.getExam());
        Assertions.assertEquals(expectStudentScore.getKorScore(), capturedStudentScore.getKorScore());
        Assertions.assertEquals(expectStudentScore.getEnglishScore(), capturedStudentScore.getEnglishScore());
        Assertions.assertEquals(expectStudentScore.getMathScore(), capturedStudentScore.getMathScore());

        Mockito.verify(studentPassRepository, Mockito.times(0)).save(Mockito.any());
        Mockito.verify(studentFailRepository, Mockito.times(1)).save(studentFailArgumentCaptor.capture());
        StudentFail capturedStudentFail = studentFailArgumentCaptor.getValue();
        Assertions.assertEquals(expectStudentFail.getStudentName(), capturedStudentFail.getStudentName());
        Assertions.assertEquals(expectStudentFail.getExam(), capturedStudentFail.getExam());
        Assertions.assertEquals(expectStudentFail.getAvgScore(), capturedStudentFail.getAvgScore());

    }

    @Test
    @DisplayName("합격자 명단 가져오기 검증")
    void getPassStudentsListTest() {
        // given
        String givenTestExam = "testexam";
        StudentPass expectedStudent1 = StudentPassFixture.create("jyujyu", givenTestExam);
        StudentPass expectedStudent2 = StudentPassFixture.create("testName", givenTestExam);
        StudentPass notExpectedStudent3 = StudentPassFixture.create("anotherStudent", "anotherExam");

        Mockito.when(studentPassRepository.findAll()).thenReturn(List.of(
                expectedStudent1,
                expectedStudent2,
                notExpectedStudent3
        )); // 필기. -> "studentPassRepository.findAll이 실행된다면 설정한 값으로 리턴해준다."고 고정시키는 것임.

        // when
        var expectResponses =  List.of(expectedStudent1, expectedStudent2)
                .stream()
                .map( (pass) -> new ExamPassStudentResponse(pass.getStudentName(), pass.getAvgScore()))
                .toList();
        List<ExamPassStudentResponse> responses = studentScoreService.getPassStudentList(givenTestExam);

        // then
        Assertions.assertIterableEquals(expectResponses, responses);
    }

    @Test
    @DisplayName("불합격자 명단 가져오기 검증")
    void getFailStudentList() {
        // given
        String givenTestExam = "testexam";

        StudentFail notExpectedStudent3 = StudentFailFixture.create("jyujyu", "anotherExam");
        StudentFail expectedStudent1 = StudentFailFixture.create("testName", givenTestExam);
        StudentFail expectedStudent2 = StudentFailFixture.create("testName2", givenTestExam);

        Mockito.when(studentFailRepository.findAll()).thenReturn(List.of(
                expectedStudent1,
                expectedStudent2,
                notExpectedStudent3
        )); // 필기. -> "studentPassRepository.findAll이 실행된다면 설정한 값으로 리턴해준다."고 고정시키는 것임.

        // when
        var expectFailList = List.of(expectedStudent1, expectedStudent2)
                .stream().map(
                        (fail) -> new ExamFailStudentResponse(fail.getStudentName(), fail.getAvgScore())
                ).toList();
        List<ExamFailStudentResponse> responses = studentScoreService.getFailStudentList(givenTestExam);

        // then
        Assertions.assertIterableEquals(expectFailList, responses);

    }
}
