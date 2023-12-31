package com.brano.democp.entity;

import com.brano.democp.entity.auxilary.TextFormat;
import com.brano.democp.service.impl.TextFormatConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FormattedText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formattedTextId;

    @Size(max = 2000)
    @Column(length = 2000)
    private String text;

    @Size(max = 2000)
    @Column(length = 2000)
    @Convert(converter = TextFormatConverter.class)
    private TextFormat format;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image", referencedColumnName = "imageId", foreignKey = @ForeignKey(name = "fk_formatted_text_image"))
    private Image image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "audio", referencedColumnName = "audioId", foreignKey = @ForeignKey(name = "fk_formatted_text_audio"))
    private Audio audio;

}
