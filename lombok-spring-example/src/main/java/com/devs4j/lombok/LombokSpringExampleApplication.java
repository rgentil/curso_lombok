package com.devs4j.lombok;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devs4j.lombok.file.FileManager;
import com.devs4j.lombok.model.Employee;
import com.devs4j.lombok.model.EmployeeType;
import com.devs4j.lombok.model.Permission;
import com.devs4j.lombok.model.Person;
import com.devs4j.lombok.model.PersonVIP;
import com.devs4j.lombok.model.Point;
import com.devs4j.lombok.model.Role;
import com.devs4j.lombok.model.TwitterAcount;
import com.devs4j.lombok.service.ConfigService;
import com.devs4j.lombok.service.Devs4jFileManager;

import lombok.Cleanup;
import lombok.val;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LombokSpringExampleApplication {

	//private static final Logger log = LoggerFactory.getLogger(LombokSpringExampleApplication.class);

	public static void valAndVar() {

		val username = "rgentil2112";
		// username = "dev4j";
		log.info("Username {} of type {} ", username, username.getClass().getName());

		var profileDescription = "Geek, developer and cool";
		log.info("Profile {} of type {} ", profileDescription, profileDescription.getClass().getName());
		profileDescription = "Geek, beer";
		log.info("Profile {} of type {} ", profileDescription, profileDescription.getClass().getName());
	}

	public static void notNullExample() {
		TwitterAcount ta = new TwitterAcount(null);
		log.info("User : {}", ta.getUsername());
	}

	public static void cleanupExample() {
		/*
		 * try (Devs4jFileManager writer = new Devs4jFileManager()) {
		 * writer.write("Geek beer","text.txt"); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		try {
			@Cleanup("releasingResources")
			Devs4jFileManager writer = new Devs4jFileManager();
			writer.write("Geek beer", "text.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getterAndSetter() {
		Person p = new Person();
		p.setName("Ricardo");
		log.info("Person {}", p.toString());
	}
	
	public static void toStringExample() {
		Person p = new Person();
		p.setName("Ricardo");
		p.setPassword("lala");
		log.info("Person {}", p.toString());
	}

	public static void equalsAndHashCode() {
		Person p1 = new Person();
		p1.setName("Ricardo");
		p1.setPassword("lala44");
		log.info("Person 1{}", p1.toString());
		
		Person p2 = new Person();
		p2.setName("Ricardo");
		p2.setPassword("lala");
		log.info("Person 2 {}", p2.toString());
		
		log.info("Equals ? {}", p1.equals(p2));
	}
	
	public static void equalsAndHashCodeExtends() {
		PersonVIP p1 = new PersonVIP();
		p1.setName("Ricardo");
		p1.setPassword("lala44");
		p1.setIdVIP(3);
		log.info("Person 1{}", p1.toString());
		
		PersonVIP p2 = new PersonVIP();
		p2.setName("Ricardo");
		p2.setPassword("lala");
		p2.setIdVIP(3);
		log.info("Person 2 {}", p2.toString());
		
		log.info("Equals ? {}", p1.equals(p2));
	}
	
	public static void constructorExample() {
		Person p1 = new Person();
		p1.setName("Ricardo");
		p1.setPassword("lala44");
		log.info("Person 1 {}", p1.toString());
		
		Person p2 = new Person();
		p2.setName("Ricardo");
		p2.setPassword("lala");
		log.info("Person 2 {}", p2.toString());
		
		log.info("Equals ? {}", p1.equals(p2));
		
		Person p3 = new Person(new Date());
		log.info("Person 3 {}", p3.toString());
		
	}
	
	public static void dataExample() {	
		Role r = new Role("ADMIN");
		r.setId(1020);
		r.setCreateTs(LocalDateTime.now());
		log.info("Role name {}", r.getName());
		log.info("Role hashCode {}", r.hashCode());
		log.info("Role full info {}", r.toString());
	}
	
	public static void valueInmutableClass() {	
		//@Value hace que la clase sea final por lo tanto tampoco se puede heredad para modificar.
		Permission p = new Permission(1, "Permi", LocalDateTime.now());
		//p.set
		log.info("Permission name {}", p.getName());
		log.info("Permission hashCode {}", p.hashCode());
		log.info("Permission full info {}", p.toString());
	}
	
	public static void basicBuilderExample() {
		//Employee emp = new Employee(10, "Alex", "Garcia", null, "Lazaroth", 34, 100.0f, EmployeeType.EMPLOYEE,
		//		Arrays.asList("Polando 22"), null, LocalDateTime.now());
		
		Employee emp = Employee.builder()
				.id(10)
				.firstName("Alex")
				.lastName("Garcia")
				.nickName("Lazaroth")
				.age(33)
				.salary(100)
				.type(EmployeeType.EMPLOYEE)
				.addresses(Arrays.asList("Chaco 333", "Poderoso 666"))
				.sport("Bike")
				.sport("Football")
				.sport("Tennis")
				.createTs(LocalDateTime.now())
				.build();
							
		
		log.info("Full employee info: {}", emp);
	}
	
	/*public static void sneakyThrowsExample() throws IOException {
		FileManager.createFiles("src/main/resources/test1.properties" ,"src/main/resources/test2.properties");
	}*/
	public static void sneakyThrowsExample(){
		FileManager.createFiles("src/main/resources/test1.properties" ,"src/main/resources/test2.properties");
	}
	
	public static void withExample() {
		// with sirve para que si cambia algun valor se clone el obejeto, crea uno nuevo
		Point point1 = new Point("point1", 1, 3);
		
		log.info("{}", point1);
		
		Point point2 = point1.withX(99);
		log.info("{}", point2);
		
		Point point3 = point1.withX(99).withName("point3").withX(111).withY(3333);
		log.info("{}",point3);
		
	}
	
	public static void getLazyExample() {
		ConfigService cs = new ConfigService();
		String configuration = cs.getConfiguration();
		log.info("{}", configuration);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LombokSpringExampleApplication.class, args);
		// valAndVar();
		// notNullExample();
		// cleanupExample();
		// getterAndSetter();
		// toStringExample();
		// equalsAndHashCode();
		// equalsAndHashCodeExtends();
		// constructorExample();
		// dataExample();
		// valueInmutableClass();
		// basicBuilderExample();
		// sneakyThrowsExample();
		// withExample();
		getLazyExample();
		
	}

}
