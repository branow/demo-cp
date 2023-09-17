package com.brano.democp.service;

import com.brano.democp.entity.Score;
import com.brano.democp.entity.auxilary.StudyTypeName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ScoreAggregator {
    Map<StudyTypeName, Integer> aggregate(List<Score> scores);

}
