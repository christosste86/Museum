import java.time.LocalDate;

public class Calendar {
    private LocalDate day;
    Object [][] rezervation;

    public Calendar(Object[][] rezervation) {
        this.rezervation = rezervation;
    }

    static void setDatesInCalendar (Object [][] reservation){
        for (int i = 0; i < reservation.length; i ++){
            reservation [0] [i]  = LocalDate.now().plusDays(i);
        }
    }
}

