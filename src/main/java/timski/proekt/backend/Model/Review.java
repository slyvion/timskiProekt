package timski.proekt.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long Id;

    private String title;

    @ManyToOne
    private User user;

    @ManyToOne
    private Company company;

    private Long rating; // req

    private String comment; // non-required

    private Date postDate;

    public Review(String title, User user, Company company, Long rating, String comment, Date postDate) {
        this.title = title;
        this.user = user;
        this.company = company;
        this.rating = rating;
        this.comment = comment;
        this.postDate = postDate;
    }
}
