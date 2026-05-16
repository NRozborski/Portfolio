package com.nz.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

	public int i;

	void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
		gross();
	}

	public void gross(){
		int asdf;
		asdf= 1;
	
		System.out.print(asdf);
	}

}
