package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    //Chuyển định dạng time kiểu Date và Intance sang kiểu String
    //viết kiểu định dạng time cho 2 kiểu Date và Intance
    private static final String FORMAT_TIME = "hh:mm:ss EEEE dd-MM-yyyy";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_TIME);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_TIME);
    public String formatDate(Date date){
        return simpleDateFormat.format(date);
    }
    public String formatIntance(Instant instantDate){
        return dateTimeFormatter.format(instantDate);
    }
    public Date formatStringToDate(String stringDate){
        Date simpleDateFormat1 = null;
        try{
            simpleDateFormat1 = simpleDateFormat.parse(stringDate);
        }catch (ParseException parseException){
            parseException.printStackTrace();
        }
        return simpleDateFormat1;
    }
//    public Instant formatStringToInstant(String stringIntance){
//        return Instant.parse(stringIntance);
//    }
}
