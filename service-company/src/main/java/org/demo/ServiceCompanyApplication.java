package org.demo;

import org.demo.dao.CompanyRepository;
import org.demo.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
@EnableDiscoveryClient
@SpringBootApplication 
public class ServiceCompanyApplication implements  CommandLineRunner {
	@Autowired
	CompanyRepository companyRepository;
	public static void main(String[] args) {
	
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}
	/*
	 * @Bean CommandLineRunner start(CompanyRepository companyRepository) { return
	 * args->{ Stream.of("A","B","C").forEach(cn->{ companyRepository.save(new
	 * Company(null,cn,100 + Math.random()*900)); });
	 * 
	 * companyRepository.findAll().forEach(System.out::println); }; }
	 */

	@Override
	public void run(String... args) throws Exception {//8085
		companyRepository.save(new Company(null,"Sopra","Sopra@hr.team","fatma","lac",21670447));
		companyRepository.save(new Company(null,"Vermeg","Vermeg.walide@hr.team","walide","lac",21670477));
		companyRepository.save(new Company(null,"Etap","EtapTunisie@.team","Grami","Mohamed5",216708847));
		companyRepository.findAll().forEach(c->{
			   System.out.println(c.getId()+" =>ID ; "+ c.getName() + " =>Name ;"+c.getLocal()+" =>locale");
		   });
	}

}
