package timski.proekt.backend.Service;

import timski.proekt.backend.Model.Company;

import java.util.List;

public interface CompanyService {


    Company findById(Long id);

    List<Company> findByName(String name);

    Company create(String name, String email, String password, String website, String description, String location);

    Company update(Long id, String Name, String email,String Password, String website,String Description, String Location);

    Company delete(Long id);

    List<Company> listAll();

    List<Company> findAllByLocation(String Location);

}
