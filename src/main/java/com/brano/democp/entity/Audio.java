package com.brano.democp.entity;

import lombok.*;

import jakarta.persistence.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long audioId;

    @Column(columnDefinition = "mediumblob not null")
    private byte[] audio;

    @Column(columnDefinition = "varchar(32) unique not null")
    private String hash;

    @PrePersist
    private void setHash() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] hash = messageDigest.digest(audio);
        this.hash = new String(hash, StandardCharsets.US_ASCII);
    }
}
