import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Customers customer = new Customers();

        Tickets ticketPrice = new Tickets();

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
            System.out.println("--------------Welcome to Greek Mythology Museum---------------");
            System.out.println("              Please reserve your -- Ticket --");
            System.out.println("Price of ticket is "+ticketPrice.getTicketPrice()+" Kč");
            System.out.println("--------------------------------------------------------------");
            System.out.println("                         Discounts");
            System.out.println("Student: -30% | Invalid: - 70% | Pensioner: -50% | Child: -60%");
            System.out.println("--------------------------------------------------------------");

            //insert reservation date with specific format

            boolean checkDateFormat = false;
            String inputDate = null;
            LocalDate reservationDate = LocalDate.now();
            while (checkDateFormat == false) {
                System.out.print("Please reserve to " + LocalDate.now().plusDays(30).format(format) + " use format --> 20.01.2000 <-- : ");
                inputDate = scanner.nextLine();
                try {
                    reservationDate = LocalDate.parse(inputDate, format);
                    checkDateFormat = true;
                } catch (Exception in){
                    System.out.print("Plsease insert correct date: ");
                    checkDateFormat = false;
                }
            }

            //insert how many tickets you want to reserve
            int tickets = 0;
            System.out.print("How many Tickets do you want to reserve? : ");
            tickets = scanner.nextInt();

            //check if tickets are more than max museum seats per day
            boolean result = false;
            while (result == false) {
                if (((int) reservations[11][arrayDate(reservationDate)]) + tickets > 10) {
                    System.out.println("You can reserve Max " + (10 - ((int) reservations[11][arrayDate(reservationDate)])));
                    result = false;
                    tickets = scanner.nextInt();
                } else {
                    result = true;
                }

            }
            int customersReservations = tickets;
            while (customersReservations > 0) {
                customersReservations = customersReservations - 1;
                //Type customer contacts
                scanner.nextLine();
                System.out.print("Name: ");
                customer.setUsername(scanner.nextLine());
                System.out.print("Surname: ");
                customer.setSurename(scanner.nextLine());
                System.out.print("Age: ");
                customer.setAge(scanner.nextLine());
                System.out.print("Status (Student, Invalid, Pensioner, Child): ");

                //check the status if is correct
                boolean statusResult = false;
                while (statusResult == false) {
                    String statusValue = scanner.nextLine();
                    if (statusValue.isEmpty()) {
                        customer.setStatus("Normal");
                        customer.setPayment(ticketPrice.getTicketPrice());
                        statusResult = true;
                    } else if (statusValue.equalsIgnoreCase("student")) {
                        customer.setStatus("Student");
                        customer.setPayment(ticketPrice.getTicketPrice()-(ticketPrice.getTicketPrice()*30/100));
                        statusResult = true;
                    } else if (statusValue.equalsIgnoreCase("Invalid")) {
                        customer.setStatus("Invalid");
                        customer.setPayment(ticketPrice.getTicketPrice()-(ticketPrice.getTicketPrice()*70/100));
                        statusResult = true;
                    } else if (statusValue.equalsIgnoreCase("Pensioner")) {
                        customer.setStatus("Pensioner");
                        customer.setPayment(ticketPrice.getTicketPrice()-(ticketPrice.getTicketPrice()*50/100));
                        statusResult = true;
                    } else if (statusValue.equalsIgnoreCase("Child")) {
                        customer.setStatus("Child");
                        customer.setPayment(ticketPrice.getTicketPrice()-(ticketPrice.getTicketPrice()*60/100));
                        statusResult = true;
                    } else {
                        System.out.print("Please type your status corect: ");
                        statusResult = false;
                    }
                }

                //set to calendar reservation data
                for (int i = 0; i < 30; i++) {
                    if (reservations[0][i].toString().equals(inputDate)) {
                        reservations[emptyArray(reservations, i)][i] = customer.getUsername() + ", " + customer.getSurname() + ", " +customer.getPayment();
                        reservations[11][i] = (int) reservations[11][i] + tickets;
                        reservations[12][i] = (double) reservations[12][i] + customer.getPayment();
                    }
                    tickets = 0;
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
        scanner.nextLine(); //repair a problem with next scanner
        System.out.print("Insert date from: ");
        String dateF = scanner.nextLine();
        LocalDate datefr = LocalDate.parse(dateF, format);
        int intdateFrom = arrayDate(datefr);

        //System.out.println();

        System.out.print("Insert date to: ");
        String dateT = scanner.nextLine();
        LocalDate dateTo = LocalDate.parse(dateT, format);
        int intdateTo = arrayDate(dateTo);

        System.out.println("Reservations from "+reservations[0][intdateFrom]+" - "+reservations[0][intdateTo]);
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[0][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[0][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[1][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[1][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[2][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[2][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[3][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[3][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[4][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[4][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[5][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[5][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[6][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[6][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[7][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[7][i]);
            }
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[8][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[8][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[9][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[9][i]);
            }
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++){
            if (reservations[10][i] == null){
                System.out.printf("|%-30S|","");
            }else {
                System.out.printf("|%-30S|", reservations[10][i]);
            }
        }
        System.out.println();
        System.out.println("");
        for(int i = intdateFrom; i <= intdateTo; i++){
            System.out.printf("|%-2s %-27S|",reservations[11][i],"Tickets");
        }
        System.out.println();
        for(int i = intdateFrom; i <= intdateTo; i++) {
            System.out.printf("|%-8s%-22S|", reservations[12][i],"Kč");
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Summary of tickets: ");
        System.out.println("Earnings: ");

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
            reservations[11][i] = 0;
            reservations[12][i] = (double) 0;
        }
    }

    //empty array check
    static int emptyArray(Object [][] reservations, int x){
        int i = 0;
        for (i = 0; i < reservations.length;i++){
            if ((reservations[i][x] == null)){
                return i;
            }
        }
        return i;
    }
}
