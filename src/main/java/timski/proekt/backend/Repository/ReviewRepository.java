package timski.proekt.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Review;
import timski.proekt.backend.Model.User;

import java.util.Date;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByPostDate(Date postDate);
    List<Review> findReviewsByUser(User user);
    List<Review> findReviewsByCompany(Company company);

    List<Review> findReviewsByRatingGreaterThan(int rating);

    List<Review> findReviewsByTitle(String title);
}
