package org.demo.dao;

import org.demo.entities.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	//ll pagination 24/10
	@Query("select c from Fournisseur c where c.id like :x")
	public Page<Fournisseur> chercher(@Param("x")String mc,Pageable pageable);
}
