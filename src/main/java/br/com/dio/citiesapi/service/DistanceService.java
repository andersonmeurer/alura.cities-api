package br.com.dio.citiesapi.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import br.com.dio.citiesapi.entities.City;
import br.com.dio.citiesapi.repository.ICityRepository;

@Service
public class DistanceService {

	private final ICityRepository cityRepository;
	Logger log = LoggerFactory.getLogger(DistanceService.class);

	public DistanceService(final ICityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	/**
	 * @param city1
	 * @param city2
	 * @return
	 */
	public Double distanceByPointsInMiles(final Long city1, final Long city2) {
		log.info("nativePostgresInMiles({}, {})", city1, city2);
		return cityRepository.distanceByPoints(city1, city2);
	}

	/**
	 * @param city1
	 * @param city2
	 * @return
	 */
	public Double distanceByCubeInMeters(Long city1, Long city2) {
		log.info("distanceByCubeInMeters({}, {})", city1, city2);
		final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		Point p1 = cities.get(0).getLocation();
		Point p2 = cities.get(1).getLocation();

		return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
}