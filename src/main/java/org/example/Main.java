package org.example;

import org.example.entity.Employee;
import org.example.WordCounter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();///////

        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Irem", "Dincer"));
        employees.add(new Employee(3, "Alper", "Kurtoglu"));
        employees.add(new Employee(2, "Irem", "Dincer")); //
        employees.add(new Employee(4, "Bob", "Ross"));
        employees.add(new Employee(3, "Alper", "Kurtoglu")); //
        employees.add(new Employee(1, "John", "Doe")); //
        employees.add(new Employee(7, "Gamze", "Ozcan"));
        employees.add(new Employee(9, "Jane", "Toe"));
        employees.add(new Employee(6, "Silver", "Star"));

        System.out.println("All Employees");

        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("**********");

        System.out.println("Duplicated Length");
        System.out.println(findDuplicates(employees).size());

        System.out.println("**********");

        System.out.println("Unique Length");
        System.out.println(findUniques(employees).size());

        System.out.println("***************");
        System.out.println(" Only Unique Length");
        System.out.println(removeDuplicates(employees).size());

        System.out.println(WordCounter.calculateWord());


    }


    public static List<Employee> findDuplicates(List<Employee> employees) {

        Map<Integer, Employee> employeeMap = new HashMap<>(); //listede hizli search icin
        List<Employee> duplicateEmployee = new LinkedList<>(); //tekrarlayanlari saklamak icin-insertion order korunur

        Iterator<Employee> iterator = employees.iterator(); //listede gezmek icin iterator- ConcurrentModificationException i engeller

        while (iterator.hasNext()) { //  // Liste bitene kadar döngü
            Employee employee = iterator.next();

            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) { //listede id li key var ise
                duplicateEmployee.add(employee); //duplicated' e ekle
            } else {
                employeeMap.put(employee.getId(), employee); //yok ise listeye ekle
            }
        }
        return duplicateEmployee;
    }


    public static Map<Integer, Employee> findUniques(List<Employee> employees) {

        Map<Integer, Employee> employeeMap = new HashMap<>(); // Unique employee'lar için hızlı search

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();

            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) { // id li key yok ise
                employeeMap.put(employee.getId(), employee); //listeye ekle
            }

        }
        return employeeMap;


    }

    public static List<Employee> removeDuplicates(LinkedList<Employee> employees) {
        Map<Integer, Integer> idCount = new HashMap<>();

        // once her ID'nin kac kez geciyor,sayiyorum
        for (Employee employee : employees) {
            if (employee != null) {
                idCount.put(employee.getId(), idCount.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        // sadece 1 kez gecen employee'leri aliyorum.
        List<Employee> onlyUnique = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee != null && idCount.get(employee.getId()) == 1) {
                onlyUnique.add(employee);
            }
        }

        return onlyUnique;
    }
}