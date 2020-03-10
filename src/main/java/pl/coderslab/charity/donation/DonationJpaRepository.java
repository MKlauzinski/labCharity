package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationJpaRepository extends JpaRepository<Donation, Long> {
}
