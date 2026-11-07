package com.klef.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.practice.dto.TaxDTO;
import com.klef.practice.entity.Tax;
import com.klef.practice.repository.TaxRepository;

@Service
public class TaxServiceImpl implements TaxService
{
@Autowired
private TaxRepository repo;

@Override
public TaxDTO insertTax(TaxDTO tax)
{
    Tax t = new Tax();

    t.setName(tax.getName());
    t.setType(tax.getType());
    t.setStatus(tax.getStatus());
    t.setLocation(tax.getLocation());

    Tax savedTax = repo.save(t);

    TaxDTO dto = new TaxDTO();

    dto.setTaxId(savedTax.getTaxId());
    dto.setName(savedTax.getName());
    dto.setType(savedTax.getType());
    dto.setStatus(savedTax.getStatus());
    dto.setLocation(savedTax.getLocation());
    dto.setCreatedAt(savedTax.getCreatedAt());
    dto.setUpdatedAt(savedTax.getUpdatedAt());

    return dto;
}

@Override
public List<TaxDTO> displayAllTaxes()
{
    List<Tax> taxes = repo.findAll();

    List<TaxDTO> dtoList = new ArrayList<>();

    for(Tax t : taxes)
    {
        TaxDTO dto = new TaxDTO();

        dto.setTaxId(t.getTaxId());
        dto.setName(t.getName());
        dto.setType(t.getType());
        dto.setStatus(t.getStatus());
        dto.setLocation(t.getLocation());
        dto.setCreatedAt(t.getCreatedAt());
        dto.setUpdatedAt(t.getUpdatedAt());

        dtoList.add(dto);
    }

    return dtoList;
}

@Override
public TaxDTO updateTax(TaxDTO tax)
{
    Optional<Tax> optional = repo.findById(tax.getTaxId());

    if(optional.isPresent())
    {
        Tax t = optional.get();

        t.setName(tax.getName());
        t.setType(tax.getType());
        t.setStatus(tax.getStatus());
        t.setLocation(tax.getLocation());

        Tax updatedTax = repo.save(t);

        TaxDTO dto = new TaxDTO();

        dto.setTaxId(updatedTax.getTaxId());
        dto.setName(updatedTax.getName());
        dto.setType(updatedTax.getType());
        dto.setStatus(updatedTax.getStatus());
        dto.setLocation(updatedTax.getLocation());
        dto.setCreatedAt(updatedTax.getCreatedAt());
        dto.setUpdatedAt(updatedTax.getUpdatedAt());

        return dto;
    }
    else
    {
        return null;
    }
}

@Override
public TaxDTO displayTaxById(Long id)
{
    Optional<Tax> optional = repo.findById(id);

    if(optional.isPresent())
    {
        Tax t = optional.get();

        TaxDTO dto = new TaxDTO();

        dto.setTaxId(t.getTaxId());
        dto.setName(t.getName());
        dto.setType(t.getType());
        dto.setStatus(t.getStatus());
        dto.setLocation(t.getLocation());
        dto.setCreatedAt(t.getCreatedAt());
        dto.setUpdatedAt(t.getUpdatedAt());

        return dto;
    }
    else
    {
        return null;
    }
}

@Override
public String deleteTax(Long id)
{
    boolean status = repo.existsById(id);

    if(status)
    {
        repo.deleteById(id);
        return "Tax Deleted Successfully";
    }
    else
    {
        return "Tax Id Not Found";
    }
}

@Override
public List<TaxDTO> findByName(String name)
{
    List<Tax> taxes = repo.findByName(name);

    List<TaxDTO> dtoList = new ArrayList<>();

    for(Tax t : taxes)
    {
        TaxDTO dto = new TaxDTO();

        dto.setTaxId(t.getTaxId());
        dto.setName(t.getName());
        dto.setType(t.getType());
        dto.setStatus(t.getStatus());
        dto.setLocation(t.getLocation());
        dto.setCreatedAt(t.getCreatedAt());
        dto.setUpdatedAt(t.getUpdatedAt());

        dtoList.add(dto);
    }

    return dtoList;
}

@Override
public List<TaxDTO> findByType(String type)
{
    List<Tax> taxes = repo.findByType(type);

    List<TaxDTO> dtoList = new ArrayList<>();

    for(Tax t : taxes)
    {
        TaxDTO dto = new TaxDTO();

        dto.setTaxId(t.getTaxId());
        dto.setName(t.getName());
        dto.setType(t.getType());
        dto.setStatus(t.getStatus());
        dto.setLocation(t.getLocation());
        dto.setCreatedAt(t.getCreatedAt());
        dto.setUpdatedAt(t.getUpdatedAt());

        dtoList.add(dto);
    }

    return dtoList;
}

}