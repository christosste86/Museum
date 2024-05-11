public class Tickets {
    private boolean price;
    private int maxTicketsPerDay;
    private int discount;

    private int student;
    private int invalid;
    private int pensioner;
    private int child;
    private int normal;

    public Tickets(boolean price, int maxTicketsPerDay) {
        this.price = price;
        this.maxTicketsPerDay = maxTicketsPerDay;
    }

    public Tickets(int discount) {
        this.discount = discount;
    }


}
