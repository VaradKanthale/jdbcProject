package jdbc;

public class Students {
	
	int  id;
	String name;
	int salary;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Students(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
