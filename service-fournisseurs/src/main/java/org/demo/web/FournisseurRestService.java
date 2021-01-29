package org.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.demo.dao.FournisseurRepository;
import org.demo.entities.Fournisseur;
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
public class FournisseurRestService {
	@Value("${xParam}")
private int xParam;
	@Value("${zParam}")
private int zParam;
	@Value("${me}")
private String me;
	
	@GetMapping("/myConfig")
	public Map<String, Object> myConfig(){
		Map<String, Object> params=new HashMap<>();
		params.put("xParam", xParam);
		params.put("zParam", zParam);
		params.put("me", me);
		params.put("threadName", Thread.currentThread().getName());
	    
		return params;
	}
	//ll crud
@Autowired
private FournisseurRepository  fournisseurRepository;

@RequestMapping(value="/Fournisseurs",method=RequestMethod.GET)
 public List<Fournisseur> getCompanies(){
	 return fournisseurRepository.findAll();
 }

@RequestMapping(value="/Fournisseurs/{id}",method=RequestMethod.GET)
public Optional<Fournisseur> getCompany(@PathVariable Long id){
	 return fournisseurRepository.findById(id) ;
}

@RequestMapping(value="/Fournisseurs",method=RequestMethod.POST)
public Fournisseur save(@RequestBody Fournisseur c){
	 return fournisseurRepository.save(c) ;
}

@RequestMapping(value="/Fournisseurs/{id}",method=RequestMethod.DELETE)
public boolean supprimer(@PathVariable Long id){
	fournisseurRepository.deleteById(id);
	 return true; 
}

@RequestMapping(value="/Fournisseurs/{id}",method=RequestMethod.PUT)
public Fournisseur save(@PathVariable Long id,@RequestBody Fournisseur c){
	c.setId(id);
	 return fournisseurRepository.save(c) ;
}

@RequestMapping(value="/chercherFournisseurs",method=RequestMethod.GET)
public Page<Fournisseur> chercher(
		@RequestParam(name="mc",defaultValue="") String mc,
		@RequestParam(name="page",defaultValue="0") int page,
		@RequestParam(name="size",defaultValue="5") int size){
	return fournisseurRepository.findAll(PageRequest.of(page, size));
}
}
