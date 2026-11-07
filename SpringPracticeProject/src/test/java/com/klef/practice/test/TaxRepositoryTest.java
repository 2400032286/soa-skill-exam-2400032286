package com.klef.practice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.practice.entity.Tax;
import com.klef.practice.repository.TaxRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaxRepositoryTest
{
    @Autowired
    private TaxRepository repository;

    @Test // Test 1 
    void testFindAllTaxes()
    {
        List<Tax> taxes = repository.findAll();
        assertNotNull(taxes);
    }

    @Test // Test 2 
    void testFindTaxById()
    {
        Optional<Tax> tax = repository.findById(1L);
        assertTrue(tax.isPresent());
        assertEquals(1L, tax.get().getTaxId());

        Optional<Tax> invalidTax = repository.findById(999L);
        assertFalse(invalidTax.isPresent());
    }

    @Test // Test 3 
    void testFindTaxByName()
    {
        List<Tax> taxes = repository.findByName("Radha");
        assertFalse(taxes.isEmpty());
        assertEquals("Radha", taxes.get(0).getName());
    }

    @Test // Test 4 
    void testTotalTaxCount()
    {
        long count = repository.count();
        assertTrue(count >= 1);
    }

    @Test // Test 5
    void testTaxDetails()
    {
        Optional<Tax> tax = repository.findById(1L);
        assertTrue(tax.isPresent());

        Tax foundTax = tax.get();

        assertNotNull(foundTax.getName());
        assertNotNull(foundTax.getType());
        assertNotNull(foundTax.getStatus());
        assertNotNull(foundTax.getLocation());
        assertNotNull(foundTax.getCreatedAt());
        assertNotNull(foundTax.getUpdatedAt());

        List<Tax> taxes = repository.findByType("Income Tax");
        assertFalse(taxes.isEmpty());
        assertEquals("Income Tax", taxes.get(0).getType());
    }
}
