package com.scalar.sample;

import com.scalar.sample.projections.ProductWithTitleAndDescription;
import com.scalar.sample.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testTC(){
		/*ProductWithTitleAndDescription ptd = productRepository.someRandomQuery(1L);
		System.out.println("Description ---> " + ptd.getDescription() + ", " + ptd.getTitle() );*/
	}

}
