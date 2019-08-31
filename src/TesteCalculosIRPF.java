import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCalculosIRPF {
	Rendimento[] r = new Rendimento[] {new Rendimento(1200,"salario"),new Rendimento(400,"bolsa")};
	Deducao[] d = new Deducao[] {new Deducao(190,"dependente"),new Deducao(200,"pensao"),};
	Contribuinte c = Contribuinte.NovoContribuinte("Tâmara",r,d);
	CalculosIRPF calcula = new CalculosIRPF();
	
	@Test
	void testSomaRendimentos() {
		double somaRendimentos = calcula.totalRendimentos(c);
		System.out.println(somaRendimentos);
		assertEquals(somaRendimentos,1600,0);
	}
	
	@Test
	void testSomaDeducoes() {
		double somaDeducoes = calcula.totalDeducoes(c);
		System.out.println(somaDeducoes);
		assertEquals(somaDeducoes,390,0);
	}

}
