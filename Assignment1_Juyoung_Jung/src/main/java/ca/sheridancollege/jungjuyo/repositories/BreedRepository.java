package ca.sheridancollege.jungjuyo.repositories;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.jungjuyo.beans.Breed;

@Repository
public class BreedRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addBreed(Breed breed) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO breeds (name) VALUES (:name)";
		
		parameters.addValue("name", breed.getName());
		
		jdbc.update(query, parameters);
	}


	public ArrayList<Breed> getBreeds() {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM breeds";
		
		ArrayList<Breed> breeds = (ArrayList<Breed>)jdbc.query
				(query, parameters, new BeanPropertyRowMapper<Breed>(Breed.class));
		
		return breeds;
		
	}
	
}