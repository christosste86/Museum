import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("DD.MM.yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("");


        Scanner scanner = new Scanner(System.in);

        Customers customer = new Customers(null,null,null,null);

        Tickets student = new Tickets(30);
        Tickets invalid = new Tickets(60);
        Tickets pensioner = new Tickets(50);
        Tickets child = new Tickets(100);
        Tickets[] status = {student,invalid,pensioner,child};

        //Calendar reservations = new Calendar(new Integer[30][10]);

        Object [][] reservations = new Object[3][30];
        setCalendar(reservations);
        int menu = 1;
        while (menu == 1) {
            System.out.println("Welcome to Greek Mythology Museum");
            System.out.println("Please reserve your -- Ticket --");

            System.out.print("Name: ");
            customer.setUsername(scanner.nextLine());
            System.out.print("Surname: ");
            customer.setSurename(scanner.nextLine());
            System.out.print("Age: ");
            customer.setAge(scanner.nextLine());
            System.out.print("Status (Student, Invalid, Pensioner, Child): ");
            String statusValue = scanner.nextLine();
            if (statusValue.equals("")) {
                customer.setStatus("Normal");
            } else {
                customer.setStatus(statusValue);
            }
            System.out.print("Please reserve to " + LocalDate.now().plusDays(30) + " use format --> 2000-01-20 <-- : ");
            String inputDate = scanner.nextLine();
            System.out.print("How many Tickets do you want to reserve? : ");
            int tickets = scanner.nextInt();
            for (int i = 0; i < 30; i++) {
                if (reservations[0][i].toString().equals(inputDate)) {
                    reservations[1][i] = customer.getUsername() + ", " + customer.getSurname() + ", " + tickets;
                    reservations[2][i] = tickets;
                }
            }
            System.out.print("Do you want to continue? Press 1. to continue or 2. to reservations: ");
            menu = scanner.nextInt();
        }
        System.out.println("Insert date from: ");
        int dateFrom = scanner.nextInt();

        System.out.println("Insert date to: ");
        int dateTo = scanner.nextInt();

        System.out.println("Reservations from "+reservations[0][dateFrom]+" - "+reservations[0][dateTo]);
        for(int i = dateFrom; i < dateTo; i++){
            System.out.printf("|%-25S|",reservations[0][i]);
        }
        System.out.println();
        for(int i = dateFrom; i < dateTo; i++){
            System.out.printf("|%-25S|",reservations[1][i]);
        }
        System.out.println();
        for(int i = dateFrom; i < dateTo; i++) {
            System.out.printf("|%-25s|", reservations[2][i]);
        }

    }
    static void setCalendar (Object [][] rezervations){
        for (int i = 0; i<30; i++ ){
            rezervations[0][i] = LocalDate.now().plusDays(i);
            rezervations[2][i] = 0;
        }
    }
}
