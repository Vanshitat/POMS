package com.purchaseOrder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@ToString
@Entity
@Table(name="po_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;

	public enum MyEnum {
        Female,Male,other
    }
    private MyEnum gender;
    private Integer age;
    private String city;
	
	public Customer() {
	}
	
	public Customer(String name,String email,MyEnum gender,Integer age,String city) {
		this.name = name;
		this.email = email;
		this.gender= gender;
		this.age= age;
		this.city=city;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public MyEnum getGender() {
		return gender;
	}

	public void setGender(MyEnum gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
