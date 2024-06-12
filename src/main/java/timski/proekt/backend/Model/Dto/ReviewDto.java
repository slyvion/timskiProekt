package timski.proekt.backend.Model.Dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import timski.proekt.backend.Model.Company;
import timski.proekt.backend.Model.User;

import java.util.Date;

@Data
public class ReviewDto {
    private String title;
    @ManyToOne
    private User user;

    @ManyToOne
    private Company company;

    private Long rating; // req

    private String comment; // non-required

    private Date postDate;

    public ReviewDto() {
    }

    public ReviewDto(String title, User user, Company company, Long rating, String comment, Date postDate) {
        this.title = title;
        this.user = user;
        this.company = company;
        this.rating = rating;
        this.comment = comment;
        this.postDate = postDate;
    }
}
