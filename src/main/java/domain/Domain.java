package domain;


import entity.Address;
import entity.Employee;
import entity.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Domain {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepository = context.getBean((ProjectRepository.class));

        Address address = new Address();
        address.setId(1L);
        address.setCountry("Russia");
        address.setCity("Vologda");
        address.setStreet("Teplyak");
        address.setPostCode("160000");

        Employee employee = new Employee();
        employee.setFirstName("Dimon");
        employee.setLastName("Hacker");

        Project project = new Project();
        project.setId(1L);
        project.setTitle("new Project");



        Calendar calendar = Calendar.getInstance();
        calendar.set(1999,8,21);
        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee);
        project.setEmployees(employeeSet);

        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project);
        employee.setProjects(projectSet);

        addressRepository.save(address);
        employeeRepository.save(employee);
        projectRepository.save(project);




        //List<Address> addressList = addressRepository.findAll();
        //System.out.println(addressList);
    }



}
