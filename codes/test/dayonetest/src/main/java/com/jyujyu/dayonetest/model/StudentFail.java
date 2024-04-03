package com.jyujyu.dayonetest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_fail")
@Entity
public class StudentFail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_fail_id")
    private Long id;

    @Column
    private String exam;

    @Column
    private String studentName;

    @Column
    private Double avgScore;

}
