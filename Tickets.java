public class Tickets {
    private double ticketPrice = 950;
    private int maxTicketsPerDay = 10;
    private int discount;

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Tickets(double ticketPrice, int maxTicketsPerDay) {
        this.ticketPrice = ticketPrice;
        this.maxTicketsPerDay = maxTicketsPerDay;
    }

    public Tickets() {
    }

    public Tickets(int discount) {
        this.discount = discount;
    }
//    public void discount(status) {
//        if (status.equals("Student")) {
//            price = (price - (price * 30) / 100);
//        } else if (status.equals("Invalid")) {
//            price = (price - (price * 70) / 100);
//        }
//        else if (status.equals("Pensioner")) {
//            price = (price - (price * 50) / 100);
//        }
//        else if (status.equals("Child")) {
//            price = (price - (price * 50) / 100);
//        }
//        else if (status.equals("Normal")) {
//            price = (price - (price * 100) / 100);
//        }
//    }
}
