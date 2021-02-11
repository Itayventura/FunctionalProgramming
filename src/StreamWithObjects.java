import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithObjects {
    static class Person {
        public final String name;
        public final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        public final String make;
        public final String color;
        public final Float price;

        public Car(String make, String color, Float price) {
            this.make = make;
            this.color = color;
            this.price = price;
        }
    }

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Person[] peopleArr = {
                new Person("Brandon", 23),
                new Person("Hank", 43),
                new Person("Jenna", 33),
                new Person("Veronica", 56),
                new Person("Jack", 27),
        };
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArr));

        List<String> names = people.stream().map(person -> person.name).collect(Collectors.toList());
        System.out.println("names:\n" + names);

        // Answer 1 goes here

        Car[] carsArr = {
                new Car("Chevy", "red", 45000f),
                new Car("Ford", "blue", 23000f),
                new Car("Toyota", "grey", 14000f),
                new Car("Lamborghini", "blue", 150000f),
                new Car("Renault", "blue", 150000f),
        };
        List<Car> cars = new ArrayList<>(Arrays.asList(carsArr));

        List<Car> blueCars = cars.stream().filter(car -> car.color.equals("blue")).collect(Collectors.toList());

        System.out.println("blue cars\n" + blueCars.stream().map(car -> car.color).collect(Collectors.toList()));

        // Answer 2 goes here

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        Float s = employees.stream().map(employee -> employee.salary).collect(Collectors.toList()).stream().reduce(0f, Float::sum);
        System.out.println("sum: " + s);

        Float SumOfSalariesOfDevelopers = employees
                .stream()
                .filter(employee -> employee.jobTitle.equals("developer"))
                .map(developer -> developer.salary)
                .reduce(0f, Float::sum);
        Long cntDevelopers = employees
                .stream()
                .filter(employee -> employee.jobTitle.equals("developer"))
                .collect(Collectors.counting());
        System.out.println("developers average salary is: " + SumOfSalariesOfDevelopers/cntDevelopers);
    }
}

