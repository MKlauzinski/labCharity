package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationJpaRepository donationJpaRepository;

    public int bagsQuantity () {
        List<Donation> donations = donationJpaRepository.findAll();
        int bags = 0;
        for (Donation donation: donations) {
            bags += donation.getQuantity();
        }
        return bags;
    }

    public int donationsQuantity () {
        List<Donation> donations = donationJpaRepository.findAll();
        return donations.size();
    }
}
