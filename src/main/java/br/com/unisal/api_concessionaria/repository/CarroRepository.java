package br.com.unisal.api_concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unisal.api_concessionaria.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
