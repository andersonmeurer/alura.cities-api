package br.com.dio.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.citiesapi.entities.State;

public interface IStateRepository extends JpaRepository<State, Long> {

}