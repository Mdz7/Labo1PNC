package utils.Format;

import java.time.format.DateTimeFormatter;

public class DateTimeFormat {

    public DateTimeFormatter setDateFormat(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public DateTimeFormatter setTimeFormat(){
        return DateTimeFormatter.ofPattern("HH:mm");
    }
}
