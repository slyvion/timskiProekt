package timski.proekt.backend.Service.impl;

import org.springframework.stereotype.Service;
import timski.proekt.backend.Model.Company;
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
    public Company create(String companyName, String email, String password, String website, String description, String location) {
        Company company = new Company(companyName, email, password, website ,description, location);
        return companyRepository.save(company);
    }

    @Override
    public Company update(Long id, String Name, String email, String Password, String website, String Description, String Location) {
        Company company = this.findById(id);
        company.setCompanyName(Name);
        company.setEmail(email);
        company.setWebsite(website);
        company.setPassword(Password);
        company.setDescription(Description);
        company.setLocation(Location);
        return companyRepository.save(company);
    }


    @Override
    public Company delete(Long id) {
        Company company = this.findById(id);
        companyRepository.delete(company);
        return company;
    }
}
