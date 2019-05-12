package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Fecha {
	private SimpleDateFormat formatoIso8601 = new SimpleDateFormat("yyyy-MM-dd");  
	private SimpleDateFormat formatoLatinoamericano = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatoNorteamericano = new SimpleDateFormat("MM-dd-yyyy");
	private String regexIso8601 = "\\d{4}-(1[12]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])";
	private String regexLatinoamericano = "(3[01]|[12][0-9]|0?[1-9])/(1[12]|0?[1-9])/\\d{4}";
	private String regexNorteamericano = "(1[12]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])-\\d{4}";
	private int diaEnMilisegundos = 86400000;
	
	public Fecha() {
		formatoIso8601.setLenient(false);
		formatoLatinoamericano.setLenient(false);
		formatoNorteamericano.setLenient(false);
	}
    
    public Date convertirAIso8601(String fechaIso8601)throws ParseException{
    	return formatoIso8601.parse(fechaIso8601);
    }
    
    public Date convertirALatinoamericano(String fechaLatinoamericano)throws ParseException{
    	return formatoLatinoamericano.parse(fechaLatinoamericano);
    }

    public Date convertirANorteamericano(String fechaNorteamericano)throws ParseException{
    	return formatoNorteamericano.parse(fechaNorteamericano);
    }

    public Date convertirAFlexible(String fechaFlexible)throws ParseException{
    	Date fecha = null;
    	if(Pattern.matches(regexIso8601, fechaFlexible)) {
    		fecha = convertirAIso8601(fechaFlexible);
    	}
    	else if(Pattern.matches(regexLatinoamericano, fechaFlexible)) {
    		fecha = convertirALatinoamericano(fechaFlexible);
    	}
    	else if(Pattern.matches(regexNorteamericano, fechaFlexible)) {
    		fecha = convertirANorteamericano(fechaFlexible);
    	}
    	return fecha;
    }
    
    public int diasEntreFechas(Date fechaA, Date fechaB) {
    	return Math.abs((int) ((fechaA.getTime()-fechaB.getTime())/diaEnMilisegundos));
    }
    
    public boolean fechaAAnteriorAFechaB(Date fechaA, Date fechaB) {
    	return fechaA.before(fechaB);
    }
}
