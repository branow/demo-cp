package com.brano.democp.entity;

import com.brano.democp.config.ServiceBeans;
import com.brano.democp.entity.auxilary.StudyTypeName;
import com.brano.democp.service.ScoreAggregator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FlashCard {

    @Id
    @GeneratedValue
    private Long flashCardId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "front_side", referencedColumnName = "formattedTextId", foreignKey = @ForeignKey(name = "fk_flashcard_fs_formatted_text"))
    private FormattedText frontSide;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "back_side", referencedColumnName = "formattedTextId", foreignKey = @ForeignKey(name = "fk_flashcard_bs_formatted_text"))
    private FormattedText backSide;

    @Column(nullable = false)
    private Long collection;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "flash_card",
            referencedColumnName = "flashCardId"
    )
    private List<Score> scores;

    @Transient
    private Map<StudyTypeName, Integer> aggregateScores;

    @PrePersist
    @PostLoad
    private void calcAggregateScores() {//????????????????????????????
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceBeans.class);
        ScoreAggregator scoreAggregator = context.getBean(ScoreAggregator.class);
    }

}
