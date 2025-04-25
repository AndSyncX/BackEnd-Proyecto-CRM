package com.j_d_solutions.crm.opportunity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE opportunities SET
            title = :title,
            idclient = :idclient,
            status = :status,
            value = :value,
            close_date = :close_date
            WHERE idopportunity = :idopportunity
            """, nativeQuery = true)
    void updateParcialOpportunity(
            @Param("title") String title,
            @Param("idclient") Integer idclient,
            @Param("status") String status,
            @Param("value") Double value,
            @Param("close_date") Date close_date,
            @Param("idopportunity") Integer idopportunity
    );
}
