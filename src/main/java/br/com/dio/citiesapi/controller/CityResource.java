package br.com.dio.citiesapi.controller;

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
import br.com.dio.citiesapi.repository.ICityRepository;

@RestController
@RequestMapping("/cities")
public class CityResource {

	@Autowired
	private ICityRepository iCityRepository;

	@GetMapping
	public Page<City> cities(Pageable pg) {
		return iCityRepository.findAll(pg);
	}

	@GetMapping("{id}")
	public ResponseEntity cities(@PathVariable Long id) {
		Optional<City> retorno = iCityRepository.findById(id);

		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}