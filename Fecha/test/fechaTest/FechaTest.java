package fechaTest;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import modelo.Fecha;
//private SimpleDateFormat formatoIso8601 = new SimpleDateFormat("yyyy-MM-dd");  
//private SimpleDateFormat formatoLatinoamericano = new SimpleDateFormat("dd/MM/yyyy");
//private SimpleDateFormat formatoNorteamericano = new SimpleDateFormat("MM-dd-yyyy");

public class FechaTest {
	@Test
	public void convertirAISO8601_ConvierteStringAISO8601()throws ParseException {
		Fecha conversor = new Fecha();
		Date fecha = conversor.convertirAIso8601("2017-07-25");
		Calendar fechaEsperada = Calendar.getInstance();
		fechaEsperada.clear();
		fechaEsperada.set(2017, 6, 25);
		Assert.assertEquals("La fecha en formato ISO8601 se convirtio incorrectamente", fechaEsperada.getTime(),fecha);
	}
	@Test(expected = ParseException.class)
	public void convertirAISO8601_ConvierteStringErroneoAISO8601()throws ParseException {
		Fecha conversor = new Fecha();
		conversor.convertirAIso8601("2017-13-25");
	}
	@Test
	public void convertirALatinoamericano_ConvierteStringALatinoamericano()throws ParseException {
		Fecha conversor = new Fecha();
		Date fecha = conversor.convertirALatinoamericano("25/07/2017");
		Calendar fechaEsperada = Calendar.getInstance();
		fechaEsperada.clear();
		fechaEsperada.set(2017, 6, 25);
		Assert.assertEquals("La fecha en formato Latinoamericano se convirtio incorrectamente", fechaEsperada.getTime(),fecha);
	}
	@Test(expected = ParseException.class)
	public void convertirALatinoamericano_ConvierteStringErroneoALatinoamericano()throws ParseException {
		Fecha conversor = new Fecha();
		conversor.convertirALatinoamericano("32/11/2017");
	}
	@Test
	public void convertirANorteamericano_ConvierteStringANorteamericano()throws ParseException {
		Fecha conversor = new Fecha();
		Date fecha = conversor.convertirANorteamericano("07-25-2017");
		Calendar fechaEsperada = Calendar.getInstance();
		fechaEsperada.clear();
		fechaEsperada.set(2017, 6, 25);
		Assert.assertEquals("La fecha en formato Norteamericano se convirtio incorrectamente", fechaEsperada.getTime(),fecha);
	}
	@Test(expected = ParseException.class)
	public void convertirANorteamericano_ConvierteStringErroneoANorteamericano()throws ParseException {
		Fecha conversor = new Fecha();
		conversor.convertirANorteamericano("13-25-2017");
	}
	@Test
	public void convertirAFlexible_ConvierteStringAISO8601()throws ParseException {
		Fecha conversor = new Fecha();
		Date fecha = conversor.convertirAFlexible("2017-07-25");
		Calendar fechaEsperada = Calendar.getInstance();
		fechaEsperada.clear();
		fechaEsperada.set(2017, 6, 25);
		Assert.assertEquals("La fecha en formato ISO8601 se convirtio incorrectamente", fechaEsperada.getTime(),fecha);
	}
	@Test
	public void convertirAFlexible_ConvierteStringALatinoamericano()throws ParseException {
		Fecha conversor = new Fecha();
		Date fecha = conversor.convertirAFlexible("25/07/2017");
		Calendar fechaEsperada = Calendar.getInstance();
		fechaEsperada.clear();
		fechaEsperada.set(2017, 6, 25);
		Assert.assertEquals("La fecha en formato Latinoamericano se convirtio incorrectamente", fechaEsperada.getTime(),fecha);
	}
	@Test
	public void convertirAFlexible_ConvierteStringANorteamericano()throws ParseException {
		Fecha conversor = new Fecha();
		Date fecha = conversor.convertirAFlexible("07-25-2017");
		Calendar fechaEsperada = Calendar.getInstance();
		fechaEsperada.clear();
		fechaEsperada.set(2017, 6, 25);
		Assert.assertEquals("La fecha en formato Norteamericano se convirtio incorrectamente", fechaEsperada.getTime(),fecha);
	}
	@Test(expected = ParseException.class)
	public void convertirAFlexible_ConvierteStringErroneoAISO8601()throws ParseException {
		Fecha conversor = new Fecha();
		conversor.convertirAIso8601("2017-13-25");
	}
	@Test(expected = ParseException.class)
	public void convertirAFlexible_ConvierteStringErroneoALatinoamericano()throws ParseException {
		Fecha conversor = new Fecha();
		conversor.convertirALatinoamericano("32/11/2017");
	}
	@Test(expected = ParseException.class)
	public void convertirAFlexible_ConvierteStringErroneoANorteamericano()throws ParseException {
		Fecha conversor = new Fecha();
		conversor.convertirANorteamericano("13-25-2017");
	}
	@Test
	public void diasEntreFechas_Entre20DeFebrero2019Y26DeFebrero2019Pasaron6Dias()throws ParseException {
		Fecha conversor = new Fecha();
		Date fechaA = conversor.convertirALatinoamericano("20/02/2019");
		Date fechaB = conversor.convertirALatinoamericano("26/02/2019");
		Assert.assertEquals(6, conversor.diasEntreFechas(fechaA, fechaB));
	}
	@Test
	public void fechaAAnteriorAFechaB_26DeFebrero2019EsAnteriorA15DeMarzoDe2019()throws ParseException{
		Fecha conversor = new Fecha();
		Date fechaA = conversor.convertirALatinoamericano("26/02/2019");
		Date fechaB = conversor.convertirALatinoamericano("15/03/2019");
		Assert.assertTrue(conversor.fechaAAnteriorAFechaB(fechaA, fechaB));
	}
	@Test
	public void fechaAAnteriorAFechaB_15DeMarzoDe2019NoEsAnteriorA26DeFebrero2019()throws ParseException{
		Fecha conversor = new Fecha();
		Date fechaA = conversor.convertirALatinoamericano("15/03/2019");
		Date fechaB = conversor.convertirALatinoamericano("26/02/2019");
		Assert.assertFalse(conversor.fechaAAnteriorAFechaB(fechaA, fechaB));
	}
}
