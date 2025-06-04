
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobStr) {
        this.name = name;

        // Handle both formats: "DD-MM-YYYY" and "YYYY-MM-DD"
        if (dobStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
            this.dob = LocalDate.parse(dobStr); // YYYY-MM-DD
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.dob = LocalDate.parse(dobStr, formatter); // DD-MM-YYYY
        }
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age + " years");
    }

    // Test main
    public static void main(String[] args) {
        Person p = new Person("John Doe", "1990-05-20");
        p.displayName();
        p.displayAge();
    }
}


