package com.j_d_solutions.crm.client;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client , Integer> {
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE clients SET
            name = :name,
            company = :company,
            email = :email,
            phone = :phone,
            notes = :notes,
            iduser = :iduser
            WHERE idclient = :idclient
            """, nativeQuery = true)
    void updateParcialClient(
            @Param("name") String name,
            @Param("company") String company,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("notes") String notes,
            @Param("iduser") Integer iduser,
            @Param("idclient") Integer idclient
    );
}
