package timski.proekt.backend.Service;

import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Review;
import timski.proekt.backend.Model.User;

import java.util.Date;
import java.util.List;

public interface ReviewService {


    Review create(String title, Long userId, Long companyId, Long rating, String comment, Date postDate);

    Review update(Long id, String title, Long rating, String comment, Date postDate);

    Review findById(Long id);
    List<Review> findByDate(Date postDate);

    List<Review> findByCompany(Company company);

    List<Review> findByUser(User user);
    List<Review> findByRatingGreaterThan(int rating);
}
