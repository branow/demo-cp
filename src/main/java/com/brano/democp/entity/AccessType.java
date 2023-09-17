package com.brano.democp.entity;

import com.brano.democp.entity.auxilary.Access;
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
public class AccessType {

    @Id
    @GeneratedValue
    private Long accessTypeId;

    @Column(length = 100, unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Access access;

}