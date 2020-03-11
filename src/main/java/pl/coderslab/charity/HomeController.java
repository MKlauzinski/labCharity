package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.institution.InstitutionJpaRepository;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InstitutionJpaRepository institutionJpaRepository;

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionJpaRepository.findAll());
        return "index";
    }
}
