package org.demo;

import org.demo.dao.FournisseurRepository;
import org.demo.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
@EnableDiscoveryClient
@SpringBootApplication 
public class ServiceFournisseurApplication implements  CommandLineRunner {
	@Autowired
	FournisseurRepository fournisseurRepository;
	public static void main(String[] args) {
	
		SpringApplication.run(ServiceFournisseurApplication.class, args);
	}
	/*
	 * @Bean CommandLineRunner start(FournisseurRepository fournisseurRepository) { return
	 * args->{ Stream.of("A","B","C").forEach(cn->{ fournisseurRepository.save(new
	 * Fournisseur(null,cn,100 + Math.random()*900)); });
	 * 
	 * fournisseurRepository.findAll().forEach(System.out::println); }; }
	 */

	@Override
	public void run(String... args) throws Exception {//8085
		fournisseurRepository.save(new Fournisseur(null,"Sopra","Sopra@hr.team","Hichem","lac",21670447));
		fournisseurRepository.save(new Fournisseur(null,"Vermeg","Vermeg.walide@hr.team","Amiin","lac",21670477));
		fournisseurRepository.save(new Fournisseur(null,"Etap","EtapTunisie@.team","Youssef","Mohamed5",216708847));
		fournisseurRepository.findAll().forEach(c->{
			   System.out.println(c.getId()+" =>ID ; "+ c.getName() + " =>Name ;"+c.getLocal()+" =>locale");
		   });
	}

}
