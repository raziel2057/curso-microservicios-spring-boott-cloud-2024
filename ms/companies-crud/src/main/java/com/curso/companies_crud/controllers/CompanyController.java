package com.curso.companies_crud.controllers;

import com.curso.companies_crud.entities.Company;
import com.curso.companies_crud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "Get a company from DB given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("GET: company {}",name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @Operation(summary = "Save in DB a company given a company from body")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company){
        log.info("POST: company {}",company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
    }

    @Operation(summary = "Update in DB a company given a company from body and a company name")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name){
        log.info("PUT: company {}",name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

    @Operation(summary = "Delete in DB a company given a company name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        log.info("DELETE: company {}",name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
