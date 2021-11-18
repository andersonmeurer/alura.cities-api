package br.com.dio.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.citiesapi.entities.City;

public interface ICityRepository extends JpaRepository<City, Long> {

}