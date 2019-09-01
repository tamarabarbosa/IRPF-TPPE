import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@RunWith(Parameterized.class)
class TesteParametrizadoCalculosIRPF {
	double valorEsperado;
	Rendimento [] rendimentos;
	Deducao [] deducoes;
	
	public TesteParametrizadoCalculosIRPF(double valorEsperado, Rendimento[] rendimentos, Deducao[] deducoes) {
		this.deducoes = deducoes;
		this.rendimentos = rendimentos;
		this.valorEsperado = valorEsperado;
	}
	
	
	@Parameters
	public static Iterable getParameters() {
		Object [][] parametros = new Object[][] {
			{0, 
			new Rendimento[] {new Rendimento(1200,"bolsa"),new Rendimento(2000,"salario")},
			new Deducao[] {new Deducao(1000,"pensao"),new Deducao(190,"dependente")}
		}};
		
		return Arrays.asList(parametros);
		}
	
	@Test
	void test() throws BaseInvalidaException {
		Contribuinte c = new Contribuinte("Tâmara",this.rendimentos,this.deducoes);
		CalculosIRPF calculo = new CalculosIRPF();
		double imposto = calculo.calculaImposto(c);
		assertEquals(this.valorEsperado,imposto,0);
	}

}
