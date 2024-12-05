package com.uzcard.cardmanagement.service;

import com.uzcard.cardmanagement.dto.CompanyDTO;
import com.uzcard.cardmanagement.enams.Company;
import com.uzcard.cardmanagement.entity.CompanyEntity;
import com.uzcard.cardmanagement.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public void save(CompanyDTO company) {

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(company.getName());
        companyEntity.setAddress(company.getAddress());
        companyEntity.setContact(company.getContact());
        companyEntity.setCode(company.getCode());
        companyEntity.setPassword(company.getPassword());
        companyEntity.setRole(Company.BANK);
        companyEntity.setVisible(company.isVisible());
        companyEntity.setUsername(company.getUsername());
        companyRepository.save(companyEntity);

    }
    public void update(String id ,CompanyDTO company) {
        CompanyEntity company1 = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        company1.setName(company.getName());
        company1.setAddress(company.getAddress());
        company1.setContact(company.getContact());
        company1.setCode(company.getCode());
        company1.setPassword(company.getPassword());
        company1.setRole(Company.BANK);
        company1.setVisible(company.isVisible());
        company1.setUsername(company.getUsername());
        companyRepository.save(company1);
    }
    public Page<CompanyDTO> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CompanyEntity> companies = companyRepository.findAll(pageRequest);

         return companies.map(CompanyService::tocompanyDTO);
    }

    public void deleteCompany(String id) {
        CompanyEntity company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        company.setVisible(false);
        companyRepository.save(company);
    }



    public static CompanyDTO tocompanyDTO(CompanyEntity companyEntity) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName(companyEntity.getName());
        companyDTO.setAddress(companyEntity.getAddress());
        companyDTO.setContact(companyEntity.getContact());
        companyDTO.setCode(companyEntity.getCode());
        companyDTO.setPassword(companyEntity.getPassword());
        companyDTO.setVisible(companyEntity.isVisible());
        companyDTO.setUsername(companyEntity.getUsername());
        return companyDTO;
    }
}
