package DesenvolvimentoSistemasWeb.Atividade.Controller;



import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import DesenvolvimentoSistemasWeb.Atividade.Model.Carro;
import DesenvolvimentoSistemasWeb.Atividade.Service.CarroService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CarroController {
    private final CarroService carroService;

    @GetMapping({"/", "/listagem-carros"})
    public String listagemCarros(Model model) {
        List<Carro> carros = carroService.listarCarros();
        model.addAttribute("carros", carros); // Correção aqui
        return "listagem-carros";
    }

    @GetMapping("/form-cadastro-carro")
    public String formCadastroCarro(Model model) {
        model.addAttribute("carro", new Carro());
        return "form-cadastro-carro";
    }

    @PostMapping("/incluir-carro")
    public String incluirCarro(@Validated @ModelAttribute Carro carro, BindingResult result) {
        if (result.hasErrors()) {
            return "form-cadastro-carro";
        }
        carroService.salvarCarro(carro);
        return "redirect:/listagem-carros";
    }
}
