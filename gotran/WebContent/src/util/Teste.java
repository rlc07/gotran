package util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.javafx.css.CalculatedValue;

public class Teste {
	
   @SuppressWarnings("static-access")
public static void main(String[] args) throws ParseException {

	 
	  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	  Date dt = new Date();
	  String atual = df.format(dt);
		Date d = new Date();

	  Calendar calendarAtual = Calendar.getInstance();
 	   calendarAtual .setTime(d);

 	   calendarAtual .set(Calendar.DAY_OF_MONTH, calendarAtual.get(Calendar.DAY_OF_MONTH));
 	   calendarAtual .set(Calendar.MONTH, calendarAtual .get(Calendar.MONTH));
 	   calendarAtual .set(Calendar.YEAR, calendarAtual .get(Calendar.YEAR));
       System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(calendarAtual.getTime()));
 	   
       /*data atual + 30 dias*/

 	   Calendar calendarExpira  = Calendar.getInstance();
 	   calendarExpira.setTime(d);

 	   calendarExpira.set(Calendar.DAY_OF_MONTH, calendarExpira.get(Calendar.DAY_OF_MONTH)+30);
 	   calendarExpira.set(Calendar.MONTH, calendarExpira.get(Calendar.MONTH));
 	   calendarExpira.set(Calendar.YEAR, calendarExpira.get(Calendar.YEAR));
}
   
   
}
