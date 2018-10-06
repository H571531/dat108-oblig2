package no.hvl.dat108.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat108.kontroll.ErrorHandler;
import no.hvl.dat108.kontroll.VareKontroll;
import no.hvl.dat108.objekter.Handleliste;
import no.hvl.dat108.objekter.Vare;

public class UnitTests {
	
	private Handleliste handleliste;
	
	@Before
	public void setup() {
		handleliste = new Handleliste();
	}
	
	@Test
	public void ErrorTest() {
		String error1="Feil passord";
		String error2="Du m&aring; v&aelig;re logget inn for &aring; se denne siden";
		String error3="Ukjent Feil";
		String error4="Du m&aring; logge inn p&aring; nytt for &aring; utf&oslash;re denne handlingen.";
		String errorU="Ukjent Feil";
		assertTrue(error1.equals(ErrorHandler.errorCheck("1")));
		assertTrue(error2.equals(ErrorHandler.errorCheck("2")));
		assertTrue(error3.equals(ErrorHandler.errorCheck("3")));
		assertTrue(error4.equals(ErrorHandler.errorCheck("4")));
		assertTrue(errorU.equals(ErrorHandler.errorCheck("5")));
		assertTrue(errorU.equals(ErrorHandler.errorCheck("<script>Skummel kode!!</script>")));
	}
	
	@Test
	public void TestVareKontroll() {
		Vare vare1=new Vare("Lovlig");
		Vare vare2=new Vare("");
		Vare vare3=new Vare(" ");
		
		assertTrue(VareKontroll.lovligVare(vare1.toString()));
		assertFalse(VareKontroll.lovligVare(vare2.toString()));
		assertFalse(VareKontroll.lovligVare(vare3.toString()));
	}
	
	@Test
	public void leggeTilLovligeVarer() {
		
		handleliste.leggTil("Melk");
		handleliste.leggTil("");
		handleliste.leggTil("Egg");
		handleliste.leggTil(" Bananer");
		
		List<Vare> varer = handleliste.getVarer();
		
		assertTrue(varer.size() == 2);
		
		handleliste.fjernVare("Melk");
		handleliste.fjernVare("Egg");
		
		assertTrue(varer.isEmpty());
		
	}
	
}
