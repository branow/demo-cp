package com.brano.democp.entity;

import com.brano.democp.entity.auxilary.StudyTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StudyType {

    @Id
    @GeneratedValue
    private Long studyTypeId;

    @Column(length = 100, unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyTypeName studyTypeName;

}
