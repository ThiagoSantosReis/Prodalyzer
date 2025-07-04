package com.orders.ordermnagement;

import com.orders.ordermnagement.principal.Principal;
import com.orders.ordermnagement.repository.CategoryRepository;
import com.orders.ordermnagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdalyzerApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository ctgRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProdalyzerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repository, ctgRepository);
		principal.showMenu();
	}
}
