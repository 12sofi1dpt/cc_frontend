package de.hftstuttgart.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class ThymeleafController {

    @Value("${persons.endpoint}")
    private String personEndpoint;

    @GetMapping("/")
    public String displayPage(Model model) {

        Person[] persons = WebClient
            .create(personEndpoint)
            .get()
            .retrieve()
            .bodyToMono(Person[].class)
            .block();

        model.addAttribute("persons", persons);

        return "index";
    }
}