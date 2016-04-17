package test;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.webapp.spring.configuration.HibernateConfigurationDb1;
import com.webapp.spring.configuration.HibernateConfigurationDb2;
import com.webapp.spring.model.EmployeeTest;
import com.webapp.spring.service.EmployeeService;

public class MainTest {

	public static void main(String[] args) {
		MainTest app = new MainTest();
		app.db1();
		app.db2();

	}
	
	public static void db1(){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfigurationDb1.class);

		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		/*
		 * Create Employee1
		 */
		EmployeeTest employee1 = new EmployeeTest();
		employee1.setName("Han Yenn");
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("ssn00000001");

		/*
		 * Create Employee2
		 */
		EmployeeTest employee2 = new EmployeeTest();
		employee2.setName("Dan Thomas");
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00000002");

		/*
		 * Persist both Employees
		 */
		service.saveEmployee(employee1);
		service.saveEmployee(employee2);

		/*
		 * Get all employees list from database
		 */
		List<EmployeeTest> employees = service.findAllEmployees();
		for (EmployeeTest emp : employees) {
			System.out.println(emp);
		}

		/*
		 * Get all employees list from database
		 */
		List<EmployeeTest> employeeList = service.findAllEmployees();
		for (EmployeeTest emp : employeeList) {
			System.out.println(emp);
		}

		context.close();
	}
	
	public static void db2(){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfigurationDb2.class);

		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		/*
		 * Create Employee1
		 */
		EmployeeTest employee1 = new EmployeeTest();
		employee1.setName("Han Yenn");
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("ssn00000001");

		/*
		 * Create Employee2
		 */
		EmployeeTest employee2 = new EmployeeTest();
		employee2.setName("Dan Thomas");
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00000002");

		/*
		 * Persist both Employees
		 */
		service.saveEmployee(employee1);
		service.saveEmployee(employee2);

		/*
		 * Get all employees list from database
		 */
		List<EmployeeTest> employees = service.findAllEmployees();
		for (EmployeeTest emp : employees) {
			System.out.println(emp);
		}

		/*
		 * Get all employees list from database
		 */
		List<EmployeeTest> employeeList = service.findAllEmployees();
		for (EmployeeTest emp : employeeList) {
			System.out.println(emp);
		}

		context.close();
	}

}
