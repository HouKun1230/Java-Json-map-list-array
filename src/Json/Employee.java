package Json;


import net.sf.json.JSONString;

public class Employee {
	
	private String name;
	
	private Integer age;
	
	private String department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employer [name=" + name + ", age=" + age + ", department="
				+ department + "]";
	}



}
