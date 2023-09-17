package com.brano.democp.table;

import com.brano.democp.entity.Audio;
import com.brano.democp.entity.Image;
import com.brano.democp.repository.AudioRepository;
import com.brano.democp.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

import static com.brano.democp.table.EntityFactory.image;

@SpringBootTest
public class ImageTableTest extends TableTest<Image, Long> {


    @Autowired
    public ImageTableTest(ImageRepository repository) {
        super(repository, Image.class, Image::getImageId);
    }

    @Test
    void tableMustAcceptAudio() {
        tableMustAcceptValue(image());
    }

    @Test
    void hashMustHaveDefaultValue() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustHaveDefaultValue(image(), "hash");
    }

    @Test
    void audioMustBeUnique() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeUnique(image(), image(), "image", byte[].class);
    }

    @Test
    void audioMustBeNotNull() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeNotNull(image(), "image", byte[].class);
    }

}
