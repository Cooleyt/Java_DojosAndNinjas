package com.cooley.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=3, max=30, message ="Name must be at least 3 characters long")
    private String firstName;
    
    @NotNull
    @Size(min=3, max=30, message ="Name must be at least 3 characters long")
    private String lastName;
    private int age;
    private String beltColor;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
  
    
    public Ninja(
			@NotNull @Size(min = 3, max = 30, message = "Name must be at least 3 characters long") String firstName,
			@NotNull @Size(min = 3, max = 30, message = "Name must be at least 3 characters long") String lastName,
			int age, String beltColor, Dojo dojo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.beltColor = beltColor;
		this.dojo = dojo;
	}



	public Ninja() {
        
    }
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBeltColor() {
		return beltColor;
	}

	public void setBeltColor(String beltColor) {
		this.beltColor = beltColor;
	}

	public Dojo getDojo() {
		return dojo;
	}



	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}



	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
	    }
}
