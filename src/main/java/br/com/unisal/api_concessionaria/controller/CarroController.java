package br.com.unisal.api_concessionaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisal.api_concessionaria.model.Carro;
import br.com.unisal.api_concessionaria.repository.CarroRepository;

@RestController 
@RequestMapping("/carros")
public class CarroController {

    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PostMapping 
    public ResponseEntity<Carro> criar(@RequestBody Carro carro) {
        carro.setId(null);
        Carro salvo = carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return carroRepository.findById(id)
                .map(carro -> ResponseEntity.ok(carro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id, @RequestBody Carro dadosAtualizados) {
        return carroRepository.findById(id)
            .map(carroExistente -> {
                carroExistente.setMarca(dadosAtualizados.getMarca());
                carroExistente.setModelo(dadosAtualizados.getModelo());
                carroExistente.setAnoFabricacao(dadosAtualizados.getAnoFabricacao());
                carroExistente.setAnoModelo(dadosAtualizados.getAnoModelo());
                carroExistente.setMotorizacao(dadosAtualizados.getMotorizacao());
                Carro atualizado = carroRepository.save(carroRepository.save(carroExistente));
                return ResponseEntity.ok(atualizado);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!carroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
