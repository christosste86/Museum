import java.time.LocalDate;

public class Calendar {
    private LocalDate day;
    private Integer [][] rezervation;

    public Calendar(Integer[][] rezervation) {
        this.rezervation = rezervation;
    }
}

