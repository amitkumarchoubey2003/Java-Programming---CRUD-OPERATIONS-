package pojo;

public class Employee {


private String name;

private int salary;

private int empId;

/**

* @return the name

*/

public String getName() {

return name;

}

/**

* @param name the name to set

*/

public void setName(String name) {

this.name = name;

}

/**

* @return the salary

*/

public int getSalary() {

return salary;

}

/**

* @param salary the salary to set

*/

public void setSalary(int salary) {

this.salary = salary;

}

/**

* @return the empId

*/

public int getEmpId() {

return empId;

}

/**

* @param empId the empId to set

*/

public void setEmpId(int empId) {

this.empId = empId;

}

public void display() {

System.out.println("Employee Name - "+name);

System.out.println("Employee Salary - "+salary);

System.out.println("Employee Id - "+empId);

}

}


