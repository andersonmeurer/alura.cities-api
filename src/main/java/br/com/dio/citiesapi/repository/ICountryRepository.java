package br.com.dio.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.citiesapi.entities.Country;

public interface ICountryRepository extends JpaRepository<Country, Long> {

}