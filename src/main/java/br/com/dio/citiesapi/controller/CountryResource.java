package br.com.dio.citiesapi.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.entities.Country;
import br.com.dio.citiesapi.repository.ICountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryResource {

	private ICountryRepository iCountryRepository;

	public CountryResource(ICountryRepository iCountryRepository) {
		this.iCountryRepository = iCountryRepository;
	}

	@GetMapping
	public Page<Country> countries(Pageable pg) {
		return iCountryRepository.findAll(pg);
	}

	@GetMapping("{id}")
	public ResponseEntity countries(@PathVariable Long id) {
		Optional<Country> retorno = iCountryRepository.findById(id);

		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}