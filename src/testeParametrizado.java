import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import org.junit.Test;

@RunWith(Parameterized.class)
public class testeParametrizado{
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
			new Contribuinte("Fulano", new Rendimento[] {new Rendimento(1200,"bolsa"),new Rendimento(200,"salario")},
			new Deducao[] {new Deducao(100,"pensao"),new Deducao(190,"dependente")})
			},
			
			{7.9514999999999985, 
			new Contribuinte("Ciclano", new Rendimento[] {new Rendimento(1200,"bolsa"),new Rendimento(2000,"salario")},
			new Deducao[] {new Deducao(1000,"pensao"),new Deducao(190,"dependente")})
			},
			
			{171.70274999999998, 
			new Contribuinte("Beltrano", new Rendimento[] {new Rendimento(1200,"bolsa"),new Rendimento(3500,"salario")},
			new Deducao[] {new Deducao(1000,"pensao"),new Deducao(190,"dependente")})
			},
			
			{266.12399999999997, 
			new Contribuinte("Beltrano", new Rendimento[] {new Rendimento(1100,"bolsa"),new Rendimento(4200,"salario")},
			new Deducao[] {new Deducao(1100,"pensao"),new Deducao(190,"dependente")})
			},
			
			{776.6633999999999, 
			new Contribuinte("Beltrano", new Rendimento[] {new Rendimento(2200,"bolsa"),new Rendimento(5000,"salario")},
			new Deducao[] {new Deducao(1000,"pensao"),new Deducao(190,"dependente")})
			},
			
		};
		
		return Arrays.asList(parametros);
		}
	
	@Test
	public void testeComParametros() throws BaseInvalidaException {
		CalculosIRPF calculo = new CalculosIRPF();
		double imposto = calculo.calculaImposto(this.c);
		assertEquals(this.valorEsperado,imposto,0);
	}

}