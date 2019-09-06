import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class TesteContribuinte {
	
	Rendimento[] r = new Rendimento[] {new Rendimento(1200,"salario")};
	Deducao[] d = new Deducao[] {new Deducao(190,"dependente")};
	Contribuinte c = Contribuinte.NovoContribuinte("Tâmara",r,d);

	
	@Test
	public void testeNovoContribuinteInstancia() {
		assertNotNull(c);
		assertTrue(c instanceof Contribuinte);
	}
	
	@Test
	public void testeNovoContribuinte() {
		assertEquals(c.nome,"Tâmara");
		assertArrayEquals(c.deducoes,d);
		assertArrayEquals(c.rendimentos,r);
	}
}
