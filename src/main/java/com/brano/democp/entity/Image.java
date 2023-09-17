package com.brano.democp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Image {

    @Id
    @GeneratedValue
    private Long imageId;

    @Column(columnDefinition = "mediumblob not null")
    private byte[] image;

    @Column(columnDefinition = "varchar(32) unique not null")
    private String hash;

    @PrePersist
    private void setHash() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] hash = messageDigest.digest(image);
        this.hash = new String(hash, StandardCharsets.US_ASCII);
    }

}
