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
import ca.sheridancollege.jungjuyo.beans.Dog;

@Repository
public class DogRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addDog(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO dogs (name, owner, breed, gender, category) "
				+ "VALUES (:name, :owner, :breed, :gender, :category)";
		
		parameters.addValue("name", dog.getName());
		parameters.addValue("owner", dog.getOwner());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("category", dog.getCategory());
		
		jdbc.update(query, parameters);
	}
	
	public ArrayList<Dog> getDogs() {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs";
		
		ArrayList<Dog> dogs = (ArrayList<Dog>)jdbc.query(query, 
				parameters, new BeanPropertyRowMapper<Dog>(Dog.class));
		
		return dogs;
	}
	
	public Dog getDogById(int id) {
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM dogs WHERE id=:id";
		parameters.addValue("id", id);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setCategory((String)row.get("category"));
			
			dogs.add(d);
		}
		
		if (dogs.size() == 1) {
			return dogs.get(0); 
		} else {
			return null;
		}
	}
	
	public void editDog(Dog dog) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE dogs SET name=:name, owner=:owner,"
				+ "breed=:breed, gender=:gender, category=:category "
				+ "WHERE id=:id";
		
		parameters.addValue("name", dog.getName());
		parameters.addValue("owner", dog.getOwner());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("category", dog.getCategory());
		parameters.addValue("id", dog.getId());
		
		jdbc.update(query, parameters);		
		
	}
	
	public void deleteDog(int id) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE from dogs WHERE id=:id";
		
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}
	
	
	public ArrayList<Dog> getMaleClass(String breed) {
		
		ArrayList<Dog> group = new ArrayList<Dog>();
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs WHERE breed=:breed AND gender='male'"
				+ "AND category='class'";
		parameters.addValue("breed", breed);
	
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setCategory((String)row.get("category"));
			
			group.add(d);
		}
		
		return group;
	}
	
	public ArrayList<Dog> getFemaleClass(String breed) {
		
		ArrayList<Dog> group = new ArrayList<Dog>();
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs WHERE breed=:breed AND gender='female'"
				+ "AND category='class'";
		parameters.addValue("breed", breed);
	
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setCategory((String)row.get("category"));
			
			group.add(d);
		}
		
		return group;
	}
	
	public ArrayList<Dog> getMaleSpecialty(String breed) {
		
		ArrayList<Dog> group = new ArrayList<Dog>();
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs WHERE breed=:breed AND gender='male'"
				+ "AND category='specialty'";
		parameters.addValue("breed", breed);
	
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setCategory((String)row.get("category"));
			
			group.add(d);
		}
		
		return group;
	}
	
	public ArrayList<Dog> getFemaleSpecialty(String breed) {
		
		ArrayList<Dog> group = new ArrayList<Dog>();
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM dogs WHERE breed=:breed AND gender='female'"
				+ "AND category='specialty'";
		parameters.addValue("breed", breed);
	
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			Dog d = new Dog();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setOwner((String)row.get("owner"));
			d.setBreed((String)row.get("breed"));
			d.setGender((String)row.get("gender"));
			d.setCategory((String)row.get("category"));
			
			group.add(d);
		}
		
		return group;
	}
	
	
}
