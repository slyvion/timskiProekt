package timski.proekt.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Getter
@Setter
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    @ManyToOne
    private User user;

    @ManyToOne
    private Company company;

    private Long rating; // req

    private String comment; // non-required

    private Date postDate;

    public Review() {
    }

    public Review(String title, User user, Company company, Long rating, String comment, Date postDate) {
        this.title = title;
        this.user = user;
        this.company = company;
        this.rating = rating;
        this.comment = comment;
        this.postDate = postDate;
    }


}
