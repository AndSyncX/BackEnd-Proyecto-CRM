package com.j_d_solutions.crm.task;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE tasks SET
            title = :title,
            idclient = :idclient,
            type = :type,
            due_date = :due_date,
            notes = :notes
            WHERE idtask = :idtask
            """, nativeQuery = true)
    void updateParcialTask(
            @Param("title") String title,
            @Param("idclient") Integer idclient,
            @Param("type") String type,
            @Param("due_date") Date due_date,
            @Param("notes") String notes,
            @Param("idtask") Integer idtask
    );
}
