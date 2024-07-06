package com.streams;

import java.util.*;
import java.util.stream.Stream;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String dept;
    private int age;
    private Date dateOfBirth;
    private double salary;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(int id, String name, String address, String dept, int age, Date dateOfBirth, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dept = dept;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    // Getters and setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                '}';
    }


    public static void main(String[] args) {

        // Create 10 Employee objects with different values
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "123 Elm Street", "HR", 30, new Date(1993 - 1900, 1 - 1, 15), 55000.0));
        employees.add(new Employee(2, "Jane Smith", "456 Oak Avenue", "Finance", 25, new Date(1998 - 1900, 3 - 1, 22), 60000.0));
        employees.add(new Employee(3, "Emily Johnson", "789 Pine Road", "IT", 28, new Date(1995 - 1900, 6 - 1, 30), 75000.0));
        employees.add(new Employee(4, "Michael Brown", "321 Maple Lane", "Marketing", 35, new Date(1988 - 1900, 9 - 1, 5), 70000.0));
        employees.add(new Employee(5, "Chris Davis", "654 Cedar Street", "Sales", 40, new Date(1983 - 1900, 12 - 1, 10), 65000.0));
        employees.add(new Employee(6, "Amanda Wilson", "987 Birch Boulevard", "R&D", 32, new Date(1991 - 1900, 4 - 1, 8), 72000.0));
        employees.add(new Employee(7, "Matthew Martinez", "135 Spruce Court", "Operations", 27, new Date(1996 - 1900, 7 - 1, 20), 68000.0));
        employees.add(new Employee(8, "Sarah Garcia", "246 Willow Drive", "Support", 29, new Date(1994 - 1900, 2 - 1, 25), 64000.0));
        employees.add(new Employee(9, "Daniel Lee", "357 Poplar Avenue", "HR", 31, new Date(1992 - 1900, 10 - 1, 18), 59000.0));
        employees.add(new Employee(10, "Jessica Taylor", "468 Ash Lane", "IT", 26, new Date(1997 - 1900, 5 - 1, 12), 73000.0));


        /// get all employee using map();
        Stream<Employee> stream = employees.stream();
        List<Integer> ages = stream.map(emp -> emp.getAge()).toList();
        System.out.print(ages + " ");


        // filter();
        List<String> names = employees.stream().
                filter(emp -> emp.getAge() > 30).
                map(emp -> emp.getName()).toList();
        System.out.print(names + " ");


        //print all city names of employees
        employees.stream().
                map(Employee::getDept).distinct().
                forEach(System.out::println);
///count();
////get count of employees sal>20;
        Long count = employees.stream().
                filter(emp -> emp.getSalary() > 35000).
                count();
        System.out.println(count);

//limit();
// get first 3 employees
        List<Employee> first3Employees = employees.stream().limit(3).toList();
        System.out.println(first3Employees);

//skip();
///skip first 3 employees/
        List<Employee> skipFirst3 = employees.stream().skip(3).toList();

//anyMatch();
//verify under age<20
        Boolean b = employees.stream().anyMatch(emp -> emp.getAge() < 20);

//allMatch();
        Boolean match = employees.stream().allMatch(emp -> emp.getAge() > 20);
//NoneMatch
        Boolean noneMatch = employees.stream().noneMatch(emp -> emp.getAge() > 100);
//findAny();-> returns optional of employee object
//find any random employee
        Employee emp = employees.stream().findAny().get();
//findFirst();
        Employee emp2 = employees.stream().findFirst().get();
//sorted()
// get empid in sorted order
        List<Integer> ids = employees.stream().map(Employee::getId).sorted().toList();

//sorted() using comparator arg
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge));

//min()
       Optional<Employee> employee= employees.stream().min(Comparator.comparing(Employee::getAge));
//max()
        Optional<Employee> employee2= Optional.of(employees.stream().max(Comparator.comparing(Employee::getAge)).get());
//average()  //1.43min
        Double d= employees.stream().mapToDouble(e->e.getSalary()).average().getAsDouble();




    }

}
