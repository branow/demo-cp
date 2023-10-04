package com.brano.democp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scoreId;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne()
    @JoinColumn(name = "studyType", referencedColumnName = "studyTypeId", foreignKey = @ForeignKey(name = "fk_score_study_type"))
    private StudyType studyType;


}
