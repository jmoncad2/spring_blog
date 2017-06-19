package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewsController {

    @GetMapping("/resume")
    public String resumePage() {
        return "resume";
    }

    @GetMapping("/portfolio")
    public String portfolioPage() {
        return "portfolio";
    }

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        model.addAttribute("n", n);
        return "roll-dice";
    }

}
