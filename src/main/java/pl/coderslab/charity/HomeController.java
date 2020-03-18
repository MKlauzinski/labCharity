package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;


@Controller
@RequiredArgsConstructor

public class HomeController {
    private final DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", donationService.institutionList());
        model.addAttribute("bagsQuantity", donationService.bagsQuantity());
        model.addAttribute("donationsQuantity", donationService.donationsQuantity());
        return "index";
    }

    @RequestMapping("/login")
    public String loginAction() {
        return "login";
    }
}
