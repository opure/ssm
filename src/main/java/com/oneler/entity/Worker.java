package com.oneler.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oneler.annotation.orm.Column;


@Entity
@Table(name="worker",catalog="hibernate5")
public class Worker {
    
	private Integer id;
	private String name;
	
	private Pay pay;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="monthlyPay"),Column = @Column(name="monthlyPay")})
	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}
	
	
	
}
