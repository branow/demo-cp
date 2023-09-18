package com.brano.democp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @NotEmpty
    @NotBlank
    @Column(length = 50, nullable = false, unique = true)
    private String userName;

    @Email
    @Column(length = 320, nullable = false, unique = true)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 300)
    private String description;

    @Column(nullable = false, columnDefinition = "bit(1) not null default 0")
    private boolean enable;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "fk_module_user"))
    private List<Module> modules;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private VerificationToken verificationToken;

}
