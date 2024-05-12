import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Customers customer = new Customers();

        Tickets student = new Tickets(30);
        Tickets invalid = new Tickets(60);
        Tickets pensioner = new Tickets(50);
        Tickets child = new Tickets(100);
        Tickets[] status = {student,invalid,pensioner,child};

        //Calendar reservations = new Calendar(new Integer[30][10]);

        Calendar calendar = new Calendar();

        Object [][] reservations = calendar.getReservations();
        setCalendar(reservations);
        calendar.setReservations(reservations);
        int menu = 1;
        while (menu == 1) {
            System.out.println("Welcome to Greek Mythology Museum");
            System.out.println("Please reserve your -- Ticket --");

            System.out.print("Please reserve to 30 days " + LocalDate.now().plusDays(30) + " use format --> 2000-01-20 <-- : ");
            String inputDate = scanner.nextLine();
            LocalDate reservationDate = LocalDate.parse(inputDate, format);
//            for (int i = 0; i < 30;i++){
//
//            }
            int tickets = 0;
            System.out.print("How many Tickets do you want to reserve? : ");
            tickets = scanner.nextInt();
            System.out.print("Name: ");
            customer.setUsername(scanner.nextLine());
            scanner.nextLine();
            System.out.print("Surname: ");
            customer.setSurename(scanner.nextLine());
            System.out.print("Age: ");
            customer.setAge(scanner.nextLine());
            System.out.print("Status (Student, Invalid, Pensioner, Child): ");
            String statusValue = scanner.nextLine();
            if (statusValue.isEmpty()) {
                customer.setStatus("Normal");
            } else if (statusValue.equalsIgnoreCase("student")) {
                customer.setStatus("Student");
            } else {
                customer.setStatus(statusValue);
            }

            for (int i = 0; i < 30; i++) {
                if (reservations[0][i].toString().equals(inputDate)) {
                    reservations[1][i] = customer.getUsername() + ", " + customer.getSurname() + ", " + tickets;
                    reservations[2][i] = tickets + (int) reservations[2][i];
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
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static void setCalendar (Object [][] reservations){

        for (int i = 0; i<30; i++ ){
            LocalDate localDate = LocalDate.parse(LocalDate.now().plusDays(i).toString());
            reservations[0][i] = localDate.format(format);
            reservations[2][i] = 0;
        }
    }
}
