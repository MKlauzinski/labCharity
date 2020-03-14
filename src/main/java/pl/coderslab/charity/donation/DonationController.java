package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donation")
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;

    @RequestMapping("/form")
    public String homeAction(Model model) {
        model.addAttribute("institutions", donationService.institutionList());
        model.addAttribute("categorieslist", donationService.categoryList());
        model.addAttribute("donation", new Donation());
        return "donation/form";
    }

}
