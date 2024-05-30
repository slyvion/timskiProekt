package timski.proekt.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timski.proekt.backend.Model.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findCompaniesByLocation(String location);

    List<Company> findCompaniesByCompanyName(String name);


}
