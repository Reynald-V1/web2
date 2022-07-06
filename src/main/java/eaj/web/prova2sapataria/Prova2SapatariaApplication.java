package eaj.web.prova2sapataria;

import eaj.web.prova2sapataria.model.Sapatos;
import eaj.web.prova2sapataria.repository.SapatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Prova2SapatariaApplication implements WebMvcConfigurer {

    @Autowired
    private SapatosRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(Prova2SapatariaApplication.class, args);
    }



    @PostConstruct
    public void initSapatos() {
        List<Sapatos> sapato = Stream.of(
                new Sapatos(1, "austin", 12.99f, 14, "nike", false, "sas"),
                new Sapatos(2, "bustin", 12.99f, 14, "nike", false, "sas"),
                new Sapatos(3, "custin", 12.99f, 24, "nike", false, "sas"),
                new Sapatos(4, "dustin", 12.99f, 35, "nike", false, "sas")
        ).collect(Collectors.toList());
        repository.saveAll(sapato);

    }
}
