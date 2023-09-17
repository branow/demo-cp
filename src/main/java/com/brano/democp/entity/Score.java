package com.brano.democp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Score {

    @Id
    @GeneratedValue
    private Integer scoreId;

    @Size(min = 0, max = 100)
    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne()
    @JoinColumn(name = "studyType", referencedColumnName = "studyTypeId", foreignKey = @ForeignKey(name = "fk_score_study_type"))
    private StudyType studyType;


}
