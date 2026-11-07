package com.klef.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.practice.entity.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long>
{
    // Find Taxes By Name
    List<Tax> findByName(String name);

    // Find Taxes By Type
    List<Tax> findByType(String type);
}