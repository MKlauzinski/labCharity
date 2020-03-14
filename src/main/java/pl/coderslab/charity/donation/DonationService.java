package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationJpaRepository donationJpaRepository;

    public Long bagsQuantity () {
        return donationJpaRepository.sumAllBags();
    }

    public Long donationsQuantity () {
        return donationJpaRepository.countAllDonations();
    }
}
