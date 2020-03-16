package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;

    @GetMapping
    public String getForm(Model model){
        model.addAttribute("institutions", donationService.institutionList());
        model.addAttribute("categorieslist", donationService.categoryList());
        model.addAttribute("donation", new Donation());
        return "donation/form";
    }

    @RequestMapping("/form-confirmation")
    public String formConfirmation() {
        return "donation/form-confirmation";
    }

    @PostMapping
    public String saveForm(@ModelAttribute @Valid Donation donation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "donation/form";
        }
        /** control section
         * System.out.println(donation.getQuantity());
        System.out.println(donation.getCategories().get(0).getName());
        System.out.println(donation.getInstitution().getName());
        System.out.println(donation.getStreet());
        System.out.println(donation.getCity());
        System.out.println(donation.getZipCode());
        System.out.println(donation.getPhoneNumber());
        System.out.println(donation.getPickUpDate());
        System.out.println(donation.getPickUpTime());
        System.out.println(donation.getPickUpComment());*/
        donationService.save(donation);
        return "redirect:/donation/form-confirmation";
    }
}
