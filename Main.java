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

        //set dates to Museum Schedule
        setCalendar(reservations);
        calendar.setReservations(reservations);

        //Create a loop to start new reservation
        boolean menuResult = false;
        while (menuResult == false) {

            //welcome page
            System.out.println("Welcome to Greek Mythology Museum");
            System.out.println("Please reserve your -- Ticket --");

            //insert reservation date with specific format
            System.out.print("Please reserve to 30 days " + LocalDate.now().plusDays(30) + " use format --> 20.01.2000 <-- : ");
            String inputDate = scanner.nextLine();
            LocalDate reservationDate = LocalDate.parse(inputDate, format);

            //insert how many tickets you want to reserve
            int tickets = 0;
            System.out.print("How many Tickets do you want to reserve? : ");
            tickets = scanner.nextInt();

            //check if tickets are more than max museum seats per day
            boolean result = false;
            while (result == false) {
                if (((int) reservations[2][arrayDate(reservationDate)]) + tickets > 10) {
                    System.out.println("You can reserve Max " + (10 - ((int) reservations[2][arrayDate(reservationDate)])));
                    result = false;
                    tickets = scanner.nextInt();
                } else {
                    result = true;
                }

            }

            //Type customer contacts
            System.out.print("Name: ");
            customer.setUsername(scanner.nextLine());
            scanner.nextLine();
            System.out.print("Surname: ");
            customer.setSurename(scanner.nextLine());
            System.out.print("Age: ");
            customer.setAge(scanner.nextLine());
            System.out.print("Status (Student, Invalid, Pensioner, Child): ");
            String statusValue = scanner.nextLine();

            //check the status if is correct
            boolean statusResult = false;
            while (statusResult == false){
                if (statusValue.isEmpty()) {
                    customer.setStatus("Normal");
                    statusResult = true;
                } else if (statusValue.equalsIgnoreCase("student")) {
                    customer.setStatus("Student");
                    statusResult = true;
                } else if (statusValue.equalsIgnoreCase("Invalid")) {
                    customer.setStatus("Invalid");
                    statusResult = true;
                } else if (statusValue.equalsIgnoreCase("Pensioner")) {
                    customer.setStatus("Pensioner");
                    statusResult = true;
                } else if (statusValue.equalsIgnoreCase("Pensioner")) {
                    customer.setStatus("Pensioner");
                    statusResult = true;
                }else {
                    System.out.print("Please type your status corect: ");
                    statusResult = false;
                }
            }

            //set to calendar reservation data
            for (int i = 0; i < 30; i++) {
                if (reservations[0][i].toString().equals(inputDate)) {
                    reservations[1][i] = customer.getUsername() + ", " + customer.getSurname() + ", ";
                    reservations[12][i] = tickets + (int) reservations[2][i];
                }
            }

            //select if you want to continue with the reservation or see the schedule
            boolean check = false;
            System.out.print("Do you want to continue? Press 1. to continue or 2. to reservations: ");
            while (check == false) {
                int menu = scanner.nextInt();
                if (menu == 1) {
                    menuResult = false;
                    check = true;
                } else if (menu == 2) {
                    menuResult = true;
                    check = true;
                } else {
                    check = false;
                }
            }
        }

        //insert date from to date you see the reservations

        //generate the date to number
        System.out.print("Insert date from: ");
        String dateF = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(dateF, format);
        int dateFrom = arrayDate(localDate);

        System.out.println();

        System.out.print("Insert date to: ");
        String dateT = scanner.nextLine();
        localDate = LocalDate.parse(dateT, format);
        int dateTo = arrayDate(localDate);

        System.out.println("Reservations from "+reservations[0][dateFrom]+" - "+reservations[0][dateTo]);
        for(int i = dateTo; i < dateTo; i++){
            System.out.printf("|%-25S|",reservations[0][i]);
        }
        System.out.println();
        for(int i = dateTo; i < dateTo; i++){
            System.out.printf("|%-25S|",reservations[1][i]);
        }
        System.out.println();
        for(int i = dateTo; i < dateTo; i++) {
            System.out.printf("|%-25s|", reservations[2][i]);
        }

    }
    // Methods

    //use static Date Format
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    //generate Date to number today = 0 to .....
    static int arrayDate(LocalDate reservationDate) {
        int possition = 0;
        for (int i = 0; i < 30; i++) {
            if (LocalDate.parse(LocalDate.now().plusDays(i).toString()).equals(reservationDate)) {
                possition = i;
            }
        }
        return possition;
    }

    // Create a calendar with Dates in header
    static void setCalendar (Object [][] reservations){

        for (int i = 0; i<30; i++ ){
            LocalDate localDate = LocalDate.parse(LocalDate.now().plusDays(i).toString());
            reservations[0][i] = localDate.format(format);
            reservations[2][i] = 0;
        }
    }
}
