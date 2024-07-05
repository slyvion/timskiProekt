package timski.proekt.backend.Service.impl;

import org.springframework.stereotype.Service;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Dto.CompanyDto;
import timski.proekt.backend.Repository.CompanyRepository;
import timski.proekt.backend.Service.CompanyService;
import timski.proekt.backend.exceptions.InvalidCompanyIdException;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> listAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findAllByLocation(String location) {
        return companyRepository.findCompaniesByLocation(location);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(InvalidCompanyIdException::new);
    }

    @Override
    public List<Company> findByName(String name) {
        return companyRepository.findCompaniesByCompanyName(name);
    }

    @Override
    public Company create(CompanyDto companyDto) {
        Company company = new Company(
                companyDto.getCompanyName(),
                companyDto.getEmail(),
                companyDto.getPassword(),
                companyDto.getWebsite(),
                companyDto.getDescription(),
                companyDto.getLocation()
        );
        return companyRepository.save(company);
    }

    @Override
    public Company update(Long id, CompanyDto companyDto) {
        Company company = this.findById(id);
        company.setCompanyName(company.getCompanyName());
        company.setEmail(companyDto.getEmail());
        company.setWebsite(companyDto.getWebsite());
        company.setPassword(companyDto.getPassword());
        company.setDescription(companyDto.getDescription());
        company.setLocation(companyDto.getLocation());

        return companyRepository.save(company);
    }



    @Override
    public Company delete(Long id) {
        Company company = this.findById(id);
        companyRepository.delete(company);
        return company;
    }
}
