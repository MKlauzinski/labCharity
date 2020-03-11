package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionJpaRepository;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InstitutionJpaRepository institutionJpaRepository;
    private final DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionJpaRepository.findAll());
        model.addAttribute("bagsQuantity", donationService.bagsQuantity());
        model.addAttribute("donationsQuantity", donationService.donationsQuantity());
        return "index";
    }
}
