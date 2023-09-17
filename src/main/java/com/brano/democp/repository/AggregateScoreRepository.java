package com.brano.democp.repository;

import com.brano.democp.entity.AggregateScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AggregateScoreRepository extends JpaRepository<AggregateScore, AggregateScore.AggregateScoreId> {
}
