package no.hvl.dat108.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.objekter.Vare;

@Stateless
public class vareEAO {
	@PersistenceContext(name="VarePU")
	private EntityManager em;
	public List<Vare> hentAlle(){
		return em.createQuery("SELECT v FROM handleliste v", Vare.class).getResultList();
	}
	
	
	public void leggTil(Vare vare) {
		em.persist(vare);
	}
	
	public void slett(String vare) {
		Vare vareS=em.find(Vare.class, vare);
		
		em.remove(vareS);
	}
	
	
}
