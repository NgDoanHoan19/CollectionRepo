package com.example.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class JavaCollectionApplication {

    public static void main(String[] args) {
        Employee john = new Employee("John P.",1500, "M","1903@gmail",25,"pass1");
        Employee sarah = new Employee("Sarah M.", 2000, "F","1990@gmail",24,"pass12");
        Employee charles = new Employee("Charles B.", 1700, "M","2990@gmail",34,"pass12");
        Employee mary = new Employee("Mary T.", 5000, "F","1934@gmail",24,"pass133");
        Employee sophia = new Employee("Sophia B.", 7000, "F","1940@gmail",14,"pass1223");

        List<Employee> employees = Arrays.asList(john, sarah, charles, mary, sophia);

        List<Employee> e = employees.stream().filter(employee -> employee.getSalary() > 2000 && "F".equals(employee.getGender())).collect(Collectors.toList());

        for (Employee employee : e) {
            System.out.println(employee);
        }

//        List<EmployeeDTO> employeeDTOS = employees.stream().map(employee -> new EmployeeDTO(employee))
//        List<Employee> employees = Arrays.asList(john, sarah, charles, mary, sophia);
////        List<Employee> result=new ArrayList<>();
////        for (Employee e: employees){
////            if (e.getSalary()>1700){
////                result.add(e);
////            }
////        }
////        result.forEach( employee -> System.out.println(employee.toString()));
//
//
//        Predicate<Employee> predicate= employee -> employee.getSalary()<3000;
//        Function<Employee,EmployeeDTO> function=new Function<Employee, EmployeeDTO>() {
//            @Override
//            public EmployeeDTO apply(Employee employee) {
//                return new EmployeeDTO(employee.getName().toUpperCase(), employee.getSalary());
//            }
//        };
//        Comparator<Employee> comparator= (o1, o2) -> -Float.compare(o1.getSalary(), o2.getSalary());
//        List<Employee> result=employees.stream().sorted( (o1, o2) -> Float.compare(o1.getSalary(), o2.getSalary())).collect(Collectors.toList());
//        result.forEach(employee -> System.out.println(employee.toString()));
    }
}

class EmployeeDTO {

    private String name;
    private float salary;

    private String gender;
    private String email;
    private Integer age;

    public EmployeeDTO(String name, float salary, String gender, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

class Employee {

    private String name;
    private float salary;
    private String gender; // "M", "F"

    private String email;

    private Integer age;

    private String pass;

    public Employee(String name, float salary, String gender, String email, Integer age, String pass) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.pass = pass;
        this.email = email;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}