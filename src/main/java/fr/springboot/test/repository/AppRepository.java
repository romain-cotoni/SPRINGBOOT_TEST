package fr.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.springboot.test.model.AppModel;

@Repository
public interface AppRepository extends JpaRepository<AppModel,Integer> {
	
}
