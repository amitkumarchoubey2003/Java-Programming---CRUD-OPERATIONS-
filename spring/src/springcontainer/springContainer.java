package springcontainer;

import pojo.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
//import configurationFiles.applicationConfiguration;

 
public class springContainer {
 
public static void main(String[] args) {
// TODO Auto-generated method stub

String config_file = "Configuration/ApplicationConfiguration.xml";
 
ApplicationContext context = new ClassPathXmlApplicationContext(config_file);
Employee emp = (Employee) context.getBean("emp1");
Employee emp1 = (Employee) context.getBean("emp2");

emp.display();
System.out.println();
emp1.display();
}
 
}
