package com.aaron.radwords.repository;

import com.aaron.radwords.domain.Radword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Radword, String> {

    @Query(value = "SELECT radword FROM Radword radword WHERE radword.id = :id")
    Optional<Radword> findById(@Param("id") String id);
}
