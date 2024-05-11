import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Customers customer = new Customers(null,null,null,null);

        Tickets student = new Tickets(30);
        Tickets invalid = new Tickets(60);
        Tickets pensioner = new Tickets(50);
        Tickets child = new Tickets(100);
        Tickets[] status = {student,invalid,pensioner,child};

        Calendar reservations = new Calendar(new Integer[30][10]);

        System.out.println("Welcome to Greek Mythology Museum");
        System.out.println("Please reserve your -- Ticket --");

        System.out.print("Name: ");
        customer.setUsername(scanner.nextLine());
        System.out.print("Surname: ");
        customer.setSurename(scanner.nextLine());
        System.out.print("Age: ");
        customer.setAge(scanner.nextLine());
        System.out.print("Status (Student, Invalid, Pensioner, Child): ");
        customer.setStatus(scanner.nextLine());

        System.out.println(customer.getUsername());
        System.out.println(customer.getSurname());
        System.out.println(customer.getAge());
        System.out.println(customer.getStatus());

    }
}
