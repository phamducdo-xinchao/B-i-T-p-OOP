
public class Bai1 {
    static abstract class Employee {
        protected String name;
        protected int age;
        protected double salary;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public abstract double calculateSalary();

        public void display() {
            System.out.println("Tên: " + name);
            System.out.println("Tuổi: " + age);
            System.out.println("Lương: " + salary);
            System.out.println("----------------------");
        }
    }

    static class OfficeEmployee extends Employee {
        public static final double DAILY_RATE = 100;

        private int workDays;

        public OfficeEmployee(String name, int age, int workDays) {
            super(name, age);
            this.workDays = workDays;
        }

        @Override
        public double calculateSalary() {
            salary = workDays * DAILY_RATE;
            return salary;
        }
    }

    static class TechnicalEmployee extends Employee {
        private int workHours;
        private double hourlyRate;

        public TechnicalEmployee(String name, int age, int workHours, double hourlyRate) {
            super(name, age);
            this.workHours = workHours;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            salary = workHours * hourlyRate;
            return salary;
        }
    }

    public static void main(String[] args) {
        Employee[] list = new Employee[4];
        list[0] = new OfficeEmployee("Nguyen Van An", 25, 22);
        list[1] = new TechnicalEmployee("Tran Thi Binh", 28, 160, 50);
        list[2] = new TechnicalEmployee("Le Van Chi", 30, 120, 70);
        list[3] = new OfficeEmployee("Pham Thi Dung", 35, 20);

        for (Employee e : list) {
            e.calculateSalary();
            e.display();
        }
    }
}