package DesenvolvimentoSistemasWeb.Atividade.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DesenvolvimentoSistemasWeb.Atividade.Model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
}
