package com.example.sistemaplacas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class PlacaController {

    @Autowired
    private PlacaRepository placaRepository;

    @GetMapping("/{id}")
    public RedirectView redirecionar(@PathVariable Integer id) {
        Optional<Placa> placa = placaRepository.findById(id);

        if (placa.isPresent()) {
            return new RedirectView(placa.get().getLinkDestino());
        } else {
            return new RedirectView("https://google.com");
        }
    }
}