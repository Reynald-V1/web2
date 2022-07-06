package eaj.web.prova2sapataria.controller;

import eaj.web.prova2sapataria.model.Sapatos;
import eaj.web.prova2sapataria.service.SapatosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MainPage {
    private final SapatosService service;

    public MainPage(SapatosService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(HttpServletResponse response)  {

        return "home";
    }

    @GetMapping("/index")
    public String home(Model model) throws IOException {
        List<Sapatos> sapatos = service.findAll();
        model.addAttribute("sapatos", sapatos);

        return "index";
    }
}
