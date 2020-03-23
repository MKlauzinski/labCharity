package pl.coderslab.charity.donation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 1, max = 2147483647, message = "Ile worków z darami chciałbyś przekazać?")
    private int quantity;

    @NotEmpty(message = "Wybierz przynajmniej jedną kategorię.")
    @ManyToMany
    @JoinTable(name = "categories_donations",
            joinColumns = @JoinColumn(name = "categories_id"),
            inverseJoinColumns = @JoinColumn(name = "donations_id"))
    private List<Category> categories;

    @ManyToOne
    @NotNull(message = "Wybierz organizację której chcesz przekazać dary.")
    private Institution institution;

    @NotEmpty(message = "Podaj adres z którego kurier odbierze dary.")
    private String street;

    @NotEmpty(message = "W jakim mieście chcesz ofiarować swój dar.")
    private String city;

    @NotEmpty(message = "Kod pocztowy ułatwi wyszukanie odpowiedniego kuriera.")
    private String zipCode;

    @NotEmpty(message = "Kurier potrzebuje telefonu kontaktowego przedzić Cię o swoim przyjeździe.")
    private String phoneNumber;

    @NotNull(message = "W jaki dzień możemy zgłosić się po dar.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull(message = "O której godzinie będziesz oczekiwał kuriera.")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    private String pickUpComment;

    //@ManyToOne
    //private User user;
}
