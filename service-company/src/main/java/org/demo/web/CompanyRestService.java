package org.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.demo.dao.CompanyRepository;
import org.demo.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:bootstrap.properties")
@RefreshScope
@RestController
public class CompanyRestService {
	@Value("${xParam}")
private int xParam;
	@Value("${yParam}")
private int yParam;
	@Value("${me}")
private String me;
	
	@GetMapping("/myConfig")
	public Map<String, Object> myConfig(){
		Map<String, Object> params=new HashMap<>();
		params.put("xParam", xParam);
		params.put("yParam", yParam);
		params.put("me", me);
		params.put("threadName", Thread.currentThread().getName());
	    
		return params;
	}
	//ll crud
@Autowired
private CompanyRepository  companyRepository;

@RequestMapping(value="/Companies",method=RequestMethod.GET)
 public List<Company> getCompanies(){
	 return companyRepository.findAll();
 }

@RequestMapping(value="/Companies/{id}",method=RequestMethod.GET)
public Optional<Company> getCompany(@PathVariable Long id){
	 return companyRepository.findById(id) ;
}

@RequestMapping(value="/Companies",method=RequestMethod.POST)
public Company save(@RequestBody Company c){
	 return companyRepository.save(c) ;
}

@RequestMapping(value="/Companies/{id}",method=RequestMethod.DELETE)
public boolean supprimer(@PathVariable Long id){
	companyRepository.deleteById(id);
	 return true; 
}

@RequestMapping(value="/Companies/{id}",method=RequestMethod.PUT)
public Company save(@PathVariable Long id,@RequestBody Company c){
	c.setId(id);
	 return companyRepository.save(c) ;
}

@RequestMapping(value="/chercherCompanies",method=RequestMethod.GET)
public Page<Company> chercher(
		@RequestParam(name="mc",defaultValue="") String mc,
		@RequestParam(name="page",defaultValue="0") int page,
		@RequestParam(name="size",defaultValue="5") int size){
	return companyRepository.findAll(PageRequest.of(page, size));
}
}
