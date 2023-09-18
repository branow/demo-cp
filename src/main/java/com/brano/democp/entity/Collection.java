package com.brano.democp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Collection {

    @Id
    @GeneratedValue
    private Long collectionId;

    @Column(length = 100, nullable = false)
    private String collectionName;

    @Column(nullable = false)
    private Long module;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "collection", referencedColumnName = "collectionID", foreignKey = @ForeignKey(name = "fk_flashcard_collection"))
    private List<FlashCard> flashCards;

}
