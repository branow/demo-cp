package com.brano.democp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Module {

    @Id
    @GeneratedValue
    private Long moduleId;

    @Column(length = 100, nullable = false)
    private String moduleName;

    @Column(length = 1000)
    private String description;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "access_type", referencedColumnName = "accessTypeId", foreignKey = @ForeignKey(name = "fk_module_access_type"))
    private AccessType accessType;

    @Column(nullable = false)
    private Long user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module", referencedColumnName = "moduleId", foreignKey = @ForeignKey(name = "fk_collection_module"))
    private List<Collection> collections;


}
