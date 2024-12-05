package com.uzcard.cardmanagement.controller;

import com.uzcard.cardmanagement.dto.CompanyDTO;
import com.uzcard.cardmanagement.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public void create(@RequestBody  CompanyDTO companyDTO) {
        companyService.save(companyDTO);
    }

    @PutMapping("/update{id}")
    @PreAuthorize("hasRole('Admin')")
    public void update(@PathVariable String id ,@RequestBody CompanyDTO companyDTO) {
        companyService.update(id,companyDTO);
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Page<CompanyDTO>> all(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        Page<CompanyDTO> companies = companyService.findAll(page, size);
        return ResponseEntity.ok(companies);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> deleteCompany(@PathVariable String id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Company has been successfully deleted.");
    }
}
