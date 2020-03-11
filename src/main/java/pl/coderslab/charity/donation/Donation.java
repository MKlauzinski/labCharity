package pl.coderslab.charity.donation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 1, max = 2147483647)
    private int quantity;

    @ManyToOne
    private Category categories;

    @ManyToOne
    private Institution institution;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate pickUpDate;

    @NotEmpty
    @DateTimeFormat(pattern = "hh")
    private LocalTime pickUpTime;

    private String pickUpComment;
}
