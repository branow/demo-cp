package com.brano.democp.entity.auxilary;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextFormat {

    enum Format {
        BOLD, ITALIC, CROSS, UNDERLINED
    }

    private List<StringFormat> formats;

}
