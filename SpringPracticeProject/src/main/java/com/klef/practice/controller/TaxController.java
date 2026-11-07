package com.klef.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.practice.dto.TaxDTO;
import com.klef.practice.service.TaxService;

@RestController
@RequestMapping("/tax")
public class TaxController
{
@Autowired
private TaxService service;

@GetMapping
public String test()
{
    return "Tax Service Project";
}

// Insert Tax
@PostMapping("/insert") 
public ResponseEntity<TaxDTO> insertTax(@RequestBody TaxDTO tax) 
{ 
    TaxDTO t = service.insertTax(tax); 
    return ResponseEntity.status(201).body(t); 
}

// Display All Taxes
@GetMapping("/displayall")
public ResponseEntity<List<TaxDTO>> displayAllTaxes()
{
    List<TaxDTO> taxes = service.displayAllTaxes(); 
    return ResponseEntity.status(200).body(taxes);
}

// Display Tax By ID
@GetMapping("/display")
public ResponseEntity<?> displayTaxById(@RequestParam Long id)
{
    TaxDTO tax = service.displayTaxById(id);

    if(tax != null)
    {
        return ResponseEntity.status(200).body(tax);
    }
    else
    {
        return ResponseEntity.status(404).body("Tax ID Not Found");
    }
}

// Update Tax
@PutMapping("/update")
public ResponseEntity<?> updateTax(@RequestBody TaxDTO tax)
{
    TaxDTO t = service.updateTax(tax);

    if(t != null)
    {
        return ResponseEntity.ok(t);
    }
    else
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tax ID Not Found");
    }
}

// Delete Tax By ID
@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteTaxById(@PathVariable Long id)
{
    String message = service.deleteTax(id);

    return new ResponseEntity<>(message, HttpStatus.OK);
}


}