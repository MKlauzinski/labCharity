package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryJpaRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationJpaRepository donationJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;
    private final InstitutionJpaRepository institutionJpaRepository;

    public Long bagsQuantity () {
        return donationJpaRepository.sumAllBags();
    }

    public Long donationsQuantity () {
        return donationJpaRepository.countAllDonations();
    }

    public List<Category> categoryList() {
        return categoryJpaRepository.findAll();
    }

    public List<Institution> institutionList() {
        return institutionJpaRepository.findAll();
    }
}
