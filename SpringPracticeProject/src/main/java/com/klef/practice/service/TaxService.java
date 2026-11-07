package com.klef.practice.service;

import java.util.List;

import com.klef.practice.dto.TaxDTO;

public interface TaxService 
{
    TaxDTO insertTax(TaxDTO tax);
    List<TaxDTO> displayAllTaxes();
    TaxDTO updateTax(TaxDTO tax);
    TaxDTO displayTaxById(Long id);
    String deleteTax(Long id);
    List<TaxDTO> findByName(String name);
    List<TaxDTO> findByType(String type);
}