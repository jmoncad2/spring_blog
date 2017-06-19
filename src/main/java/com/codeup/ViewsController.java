package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
