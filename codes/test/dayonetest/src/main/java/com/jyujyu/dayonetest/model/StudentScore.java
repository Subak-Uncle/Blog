package com.jyujyu.dayonetest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_score")
@Entity
public class StudentScore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Long id;

    @Column
    private String exam;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "kor_score")
    private Integer korScore;

    @Column(name = "english_score")
    private Integer englishScore;

    @Column(name = "math_score")
    private Integer mathScore;

}
