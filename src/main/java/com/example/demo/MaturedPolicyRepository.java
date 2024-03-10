package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.QueryHint;

@Repository
@Transactional


	
	
	public interface MaturedPolicyRepository extends JpaRepository<MaturedPolicy, Long> {
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "false"))
	    @Query("SELECT m FROM MaturedPolicy m WHERE m.endDate = m.maturityDate")
	    List<MaturedPolicy> findByEndDateAndMaturityDate(LocalDate endDate);
	    List<MaturedPolicy> findByMaturityDateBetween(LocalDate startDate, LocalDate endDate);

	}
