public class Tickets {
    private double price;
    private int maxTicketsPerDay;
    private int discount;

    private int student;
    private int invalid;
    private int pensioner;
    private int child;
    private int normal;

    public Tickets(double price, int maxTicketsPerDay) {
        this.price = price;
        this.maxTicketsPerDay = maxTicketsPerDay;
    }

    public Tickets(int discount) {
        this.discount = discount;
    }
    void discount(){

    }
}
