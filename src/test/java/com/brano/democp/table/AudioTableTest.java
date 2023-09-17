package com.brano.democp.table;

import com.brano.democp.entity.Audio;
import com.brano.democp.repository.AudioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

import static com.brano.democp.table.EntityFactory.audio;

@SpringBootTest
public class AudioTableTest extends TableTest<Audio, Long>{

    @Autowired
    public AudioTableTest(AudioRepository repository) {
        super(repository, Audio.class, Audio::getAudioId);
    }

    @Test
    void tableMustAcceptAudio() {
        tableMustAcceptValue(audio());
    }

    @Test
    void hashMustHaveDefaultValue() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustHaveDefaultValue(audio(), "hash");
    }

    @Test
    void audioMustBeUnique() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeUnique(audio(), audio(), "audio", byte[].class);
    }

    @Test
    void audioMustBeNotNull() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeNotNull(audio(), "audio", byte[].class);
    }
}
