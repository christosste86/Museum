public class Customers {
    private String username;
    private String surname;
    private String age;
    private String status;
    private double payment;
    Tickets ticketPrice = new Tickets();

    public Customers(String username, String surname, String age, String status, double Payment) {
        this.username = username;
        this.surname = surname;
        this.age = age;
        this.status = status;
        this.payment = Payment;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSurename(String surename) {
        this.surname = surename;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public Customers() {
    }
}
