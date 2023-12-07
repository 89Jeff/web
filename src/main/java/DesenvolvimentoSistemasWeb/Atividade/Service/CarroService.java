package DesenvolvimentoSistemasWeb.Atividade.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import DesenvolvimentoSistemasWeb.Atividade.Model.Carro;
import DesenvolvimentoSistemasWeb.Atividade.Repository.CarroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public void salvarCarro(Carro carro) {
        carroRepository.save(carro);
    }
}
