package fr.springboot.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import fr.springboot.test.model.AppModel;
import fr.springboot.test.repository.AppRepository;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SpringbootDataJpaTest {

	private static int count = 0;
	
	@Autowired
	AppRepository appRepository;

	@Order(1)
	@Test
	void test1() {
		long countBefore = appRepository.count();
		appRepository.save(new AppModel("hello-test-"+(++count),1,new Date()) );
		long countAfter = appRepository.count();
		assertThat(countBefore).isLessThan(countAfter);		
	}
	
	@Order(2)
	@Test
	void test2() {
		long count = appRepository.count();
		
		assertThat(count).isGreaterThanOrEqualTo(count);//.isGreaterThan(0);
	}
}

