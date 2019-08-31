
public class CalculosIRPF {
		
	public double totalRendimentos(Contribuinte contribuinte) {
		double somaRendimentos = 0;
		for (int i=0;i < contribuinte.rendimentos.length;i++ ){
			somaRendimentos = somaRendimentos + contribuinte.rendimentos[i].valor;
		}
		return somaRendimentos;
	}
	
	public double totalDeducoes(Contribuinte contribuinte) {
		double somaDeducoes = 0;
		for (int i=0;i < contribuinte.deducoes.length;i++ ){
			somaDeducoes = somaDeducoes + contribuinte.deducoes[i].valor;
		}
		return somaDeducoes;
	}

}
