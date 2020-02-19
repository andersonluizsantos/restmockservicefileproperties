package br.com.anderson.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)

public class Staff {
	private String name;
	private int age;
	private String[] position; // array
	private List<String> skills; // list
	private Map<String, BigDecimal> salary; // map

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getPosition() {
		return position;
	}

	public void setPosition(String[] position) {
		this.position = position;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Map<String, BigDecimal> getSalary() {
		return salary;
	}

	public void setSalary(Map<String, BigDecimal> salary) {
		this.salary = salary;
	}
}
