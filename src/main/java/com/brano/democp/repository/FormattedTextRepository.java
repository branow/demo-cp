package com.brano.democp.repository;

import com.brano.democp.entity.FormattedText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormattedTextRepository extends JpaRepository<FormattedText, Long> {
}
