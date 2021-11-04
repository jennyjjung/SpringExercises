CREATE TABLE breeds (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
					name VARCHAR(20) );
			
CREATE TABLE dogs (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
					name VARCHAR(20),
					owner VARCHAR(30),
					breed VARCHAR(30),
					gender VARCHAR(10),
					category VARCHAR(20),
					CONSTRAINT BreedFK
					FOREIGN KEY (breed) REFERENCES breeds (name));