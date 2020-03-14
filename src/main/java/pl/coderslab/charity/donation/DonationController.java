package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donation")
@RequiredArgsConstructor
public class DonationController {

    @RequestMapping("/form")
    public String homeAction(Model model) {
        return "donation/form";
    }
}
