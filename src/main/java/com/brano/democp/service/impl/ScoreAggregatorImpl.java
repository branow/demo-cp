package com.brano.democp.service.impl;

import com.brano.democp.entity.Score;
import com.brano.democp.entity.auxilary.StudyTypeName;
import com.brano.democp.service.ScoreAggregator;

import java.util.List;
import java.util.Map;

public class ScoreAggregatorImpl implements ScoreAggregator {
    @Override
    public Map<StudyTypeName, Integer> aggregate(List<Score> scores) {
        return null;
    }
}
