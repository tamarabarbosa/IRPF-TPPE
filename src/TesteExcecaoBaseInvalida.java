import static org.junit.Assert.*;

import org.junit.Test;

public class TesteExcecaoBaseInvalida {

	@Test(expected = BaseInvalidaException.class)
	public void test() throws BaseInvalidaException {
		Rendimento[] r = new Rendimento[] {new Rendimento(100,"salario")};
		Deducao[] d = new Deducao[] {new Deducao(190,"dependente")};
		Contribuinte c = Contribuinte.NovoContribuinte("Tâmara",r,d);
		CalculosIRPF calculo = new CalculosIRPF();
		calculo.calculaImposto(c);
		
	}

}
