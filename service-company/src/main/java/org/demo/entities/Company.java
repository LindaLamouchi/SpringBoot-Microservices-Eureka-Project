package org.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	private String name;
	private String mail;
	private String responsable;
	private String local;
	private long num;

public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

public Company(Long id, String name, String mail, String responsable, String local, long num) {
	
	this.id = id;
	this.name = name;
	this.mail = mail;
	this.responsable = responsable;
	this.local = local;
	this.num = num;
}


}
