import java.time.LocalDate;

public class Calendar {
    private LocalDate day;
    private Object [][] reservations;

    public Calendar() {
        this.reservations = new Object[14][30];
    }

    static void setDatesInCalendar (Object [][] reservation){
        for (int i = 0; i < reservation.length; i ++){
            reservation [0] [i]  = LocalDate.now().plusDays(i);
        }
    }

    public Object[][] getReservations() {
        return reservations;
    }

    public void setReservations(Object[][] reservations) {
        this.reservations = reservations;
    }
}

