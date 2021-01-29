package org.demo.dao;

import org.demo.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long>{
	//ll pagination 24/10
	@Query("select c from Company c where c.id like :x")
	public Page<Company> chercher(@Param("x")String mc,Pageable pageable);
}
