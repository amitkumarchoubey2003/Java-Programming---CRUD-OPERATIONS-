package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App {
    public static void main( String[] args ) {
        System.out.println( "My Program started..........." );
        //Spring jdbc=> JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//       INSERT OPERATION
        Student student=new Student();
        student.setId(2002);
        student.setName("Mr. Choubey Ji");
        student.setCity("Ranchi");
       
        int result = studentDao.insert(student);
        
        System.out.println("student added "+result);
//       UPDATE OPERATION         
//      Student student =new Student();
//      student.setId(1004);
//      student.setName("Amit Kumar Dubey");
//      student.setCity("Hazaribagh");
//      int result = studentDao.change(student);
//      System.out.println("data changed "+result);
//        
//       DELETE OPERATION
//      int result = studentDao.delete(2008);
//      System.out.println("deleted "+result);
//         
    }
}
