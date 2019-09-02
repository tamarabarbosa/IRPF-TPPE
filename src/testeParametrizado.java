import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@RunWith(Parameterized.class)
class testeParametrizado{
	double valorEsperado;
	Contribuinte c;
	
	public testeParametrizado(double valorEsperado,Contribuinte c) {
		this.c = c;
		this.valorEsperado = valorEsperado;
	}
	
	
	@Parameters
	public static Iterable getParameters() {
		Object [][] parametros = new Object[][] {
			{0, 
			new Contribuinte("Fulano", new Rendimento[] {new Rendimento(1200,"bolsa"),new Rendimento(2000,"salario")},
			new Deducao[] {new Deducao(1000,"pensao"),new Deducao(190,"dependente")})
			},
			
			{0, 
			new Contribuinte("Ciclano", new Rendimento[] {new Rendimento(1200,"bolsa"),new Rendimento(2000,"salario")},
			new Deducao[] {new Deducao(1000,"pensao"),new Deducao(190,"dependente")})
			}};
		
		return Arrays.asList(parametros);
		}
	
	@Test
	void testeComParametros() throws BaseInvalidaException {
		CalculosIRPF calculo = new CalculosIRPF();
		double imposto = calculo.calculaImposto(this.c);
		assertEquals(this.valorEsperado,imposto,0);
	}

}