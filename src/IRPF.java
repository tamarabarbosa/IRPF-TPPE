import java.util.Scanner;

public class IRPF {

	public static void main(String[] args) throws BaseInvalidaException {
		Scanner input = new Scanner(System.in);
		CalculosIRPF calculos = new CalculosIRPF();
		Contribuinte contribuinte = new Contribuinte(null, null, null);
		System.out.println("Insira o nome do Contribuinte");
		contribuinte.nome = input.next();
		
		int flag = 1;
		int i = 0;
		
		System.out.println("Quantos rendimentos tributáveis possui?");
		flag = input.nextInt();
		contribuinte.rendimentos = new Rendimento[flag];
		
		while (flag > i) {
			System.out.println("Insira o rendimento tributável");
			contribuinte.rendimentos[i] = new Rendimento(0,"");
			System.out.println("Valor");
			contribuinte.rendimentos[i].valor = input.nextDouble();
			System.out.println("Descrição");
			contribuinte.rendimentos[i].descricao = input.next();
			i++;
			
		}
		double totalRendimentos = calculos.totalRendimentos(contribuinte);
		System.out.println("O total de rendimentos é de " + totalRendimentos + " reais");
		
		int flag2 = 1;
		int i2 = 0;
		
		System.out.println("Quantas deduções possui?");
		flag2 = input.nextInt();
		
		if (flag2 != 0) {
			contribuinte.deducoes = new Deducao[flag2];
			
			while (flag2 > i2) {
				System.out.println("Insira o rendimento tributável");
				contribuinte.deducoes[i2] = new Deducao(0,"");
				System.out.println("Valor");
				contribuinte.deducoes[i2].valor = input.nextDouble();
				System.out.println("Descrição");
				contribuinte.deducoes[i2].descricao = input.next();
				i2++;
				
			}
			
		}
		else {
			contribuinte.deducoes = new Deducao[] {new Deducao(0,"")};
		}
		
		double totalDeducoes = calculos.totalDeducoes(contribuinte);
		System.out.println("O total de deduções é de " + totalDeducoes + " reais");
		
		double base = calculos.baseCalculo(contribuinte);
		System.out.println("A base de cálculo é de " + base + " reais");
		
		double imposto = calculos.calculaImposto(contribuinte);
		System.out.printf("O valor do imposto é de %.2f reais",imposto);
	}
	

}
