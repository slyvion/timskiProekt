package timski.proekt.backend.Service.impl;

import org.springframework.stereotype.Service;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.Review;
import timski.proekt.backend.Model.User;
import timski.proekt.backend.Repository.CompanyRepository;
import timski.proekt.backend.Repository.ReviewRepository;
import timski.proekt.backend.Repository.UserRepository;
import timski.proekt.backend.Service.ReviewService;
import timski.proekt.backend.exceptions.InvalidCompanyIdException;
import timski.proekt.backend.exceptions.InvalidReviewIdException;
import timski.proekt.backend.exceptions.InvalidUserIdException;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Review create(String title, Long userId, Long companyId, Long rating, String comment, Date postDate) {
        User user = userRepository.findById(userId).orElseThrow(InvalidUserIdException::new);
        Company company = companyRepository.findById(companyId).orElseThrow(InvalidCompanyIdException::new);
        Review review = new Review(title, user, company, rating, comment, postDate);

        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long id, String title, Long rating, String comment, Date postDate) {

        Review review = this.findById(id);
        review.setTitle(title);
        review.setComment(comment);
        review.setRating(rating);
        review.setPostDate(postDate);

        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(InvalidReviewIdException::new);
    }

    @Override
    public List<Review> findByDate(Date postDate) {
        return reviewRepository.findReviewsByPostDate(postDate);
    }

    @Override
    public List<Review> findByCompany(Company company) {
        return reviewRepository.findReviewsByCompany(company);
    }

    @Override
    public List<Review> findByUser(User user) {
        return reviewRepository.findReviewsByUser(user);
    }

    @Override
    public List<Review> findByRatingGreaterThan(int rating) {
        return reviewRepository.findReviewsByRatingGreaterThan(rating);
    }
}
