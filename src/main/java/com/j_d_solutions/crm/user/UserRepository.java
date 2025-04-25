package com.j_d_solutions.crm.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE users SET
            username = :username,
            password = :password,
            role = :role
            WHERE id = :id
            """, nativeQuery = true)
    void UpdateUserParcial(
            @Param("username") String username,
            @Param("password") String password,
            @Param("role") String role,
            @Param("id") Integer id
    );

    // Buscar por nombre
    Optional<User> findByUsername(String username);
}
