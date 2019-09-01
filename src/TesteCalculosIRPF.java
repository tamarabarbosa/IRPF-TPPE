import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCalculosIRPF {
	Rendimento[] r = new Rendimento[] {new Rendimento(1200,"salario"),new Rendimento(400,"bolsa")};
	Deducao[] d = new Deducao[] {new Deducao(190,"dependente"),new Deducao(200,"pensao")};
	Contribuinte c = Contribuinte.NovoContribuinte("Tâmara",r,d);
	CalculosIRPF calcula = new CalculosIRPF();
	
	@Test
	void testSomaRendimentos() {
		double somaRendimentos = calcula.totalRendimentos(c);
		assertEquals(somaRendimentos,1600,0);
	}
	
	@Test
	void testSomaDeducoes() {
		double somaDeducoes = calcula.totalDeducoes(c);
		assertEquals(somaDeducoes,390,0);
	}
	
	@Test
	void testBaseCalculo() {
		double baseImposto = calcula.baseCalculo(c);
		assertEquals(baseImposto,1210,0);
	}

	@Test
	void testCalculaFaixa() {
		double valorFaixa = calcula.calculaFaixa(2563.91,1710.79,0.075);
		assertEquals(valorFaixa,63.98399999999999,0);
	}
	
	@Test
	void testTotalImposto() throws BaseInvalidaException {
		double valorImposto = calcula.calculaImposto(c);
		assertEquals(valorImposto,0,0);
	}
	
}
