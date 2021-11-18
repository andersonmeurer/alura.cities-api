package br.com.dio.citiesapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.entities.City;
import br.com.dio.citiesapi.entities.State;
import br.com.dio.citiesapi.repository.IStateRepository;

@RestController
@RequestMapping("/states")
public class StateResource {

	@Autowired
	private IStateRepository iStateRepository;

//	@GetMapping
//	public List<State> states() {
//		return iStateRepository.findAll();
//	}
	
	@GetMapping
	public Page<State> cities(Pageable pg) {
		return iStateRepository.findAll(pg);
	}

	@GetMapping("{id}")
	public ResponseEntity states(@PathVariable Long id) {
		Optional<State> retorno = iStateRepository.findById(id);

		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}