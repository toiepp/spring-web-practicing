package me.mikholskiy.domains;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {
	private String firstName;
	private String lastName;
	private String age;
	private String country;
	private String progLang;
	private List<String> operatingSystems;

	private Map<String, String> countryOptions = new LinkedHashMap<>();

	{
		countryOptions.put(/*value*/"BR", /*label*/"Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("RU", "Russia");
	}

	public Student() {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProgLang() {
		return progLang;
	}

	public void setProgLang(String progLang) {
		this.progLang = progLang;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Student{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age='" + age + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
