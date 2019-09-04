
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

	public double baseCalculo(Contribuinte contribuinte) {
		double rendimentos = totalRendimentos(contribuinte);
		double deducoes = totalDeducoes(contribuinte);
		double baseImposto = rendimentos - deducoes;
		return baseImposto;
	}

	public double calculaFaixa(double valorSuperior, double valorInferior, double aliquota) {
		double valorFaixa = (valorSuperior - valorInferior) * aliquota;
		return valorFaixa;
	}

	public double calculaImposto(Contribuinte contribuinte) throws BaseInvalidaException {
		double valorImposto = -1;
		double base = baseCalculo(contribuinte);
		
		if (base < 0) {
			throw new BaseInvalidaException(base);
		}
		else if (base <= 1710.78) {
			valorImposto = 0;
		}
		else if (base <= 2563.91) {
			valorImposto = calculaFaixa(base,1710.78,0.075);
		}
		else if (base <= 3418.59) {
			valorImposto = calculaFaixa(2563.91,1710.78,0.075)+calculaFaixa(base,2563.91,0.15);
		}
		else if (base <= 4271.59) {
			valorImposto = calculaFaixa(2563.91,1710.78,0.075)+calculaFaixa(3418.59,2563.91,0.15)+
						   calculaFaixa(base,3418.59,0.225);
		}
		else if (base >  4271.59) {
			valorImposto = calculaFaixa(2563.91,1710.78,0.075)+calculaFaixa(3418.59,2563.91,0.15)+
					       calculaFaixa(4271.59,3418.59,0.225)+calculaFaixa(base,4271.59,0.27);
		}
		else {
			throw new BaseInvalidaException(base);
	
		}
		
		return valorImposto;
	}

}
