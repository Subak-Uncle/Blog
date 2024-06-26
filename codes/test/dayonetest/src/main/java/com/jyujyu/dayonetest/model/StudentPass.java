package com.jyujyu.dayonetest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_pass")
@Entity
public class StudentPass {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_pass_id")
    private Long id;

    @Column
    private String exam;

    @Column
    private String studentName;

    @Column
    private Double avgScore;

}
