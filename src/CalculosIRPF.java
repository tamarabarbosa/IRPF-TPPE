
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
		else if (base <= 1903.98) {
			valorImposto = 0;
		}
		else if (base <= 2826.65) {
			valorImposto = calculaFaixa(base,1903.98,0.075);
		}
		else if (base <= 3751.05) {
			valorImposto = calculaFaixa(2826.65,1903.98,0.075)+calculaFaixa(base,2826.65,0.15);
		}
		else if (base <= 4664.68) {
			valorImposto = calculaFaixa(2826.65,1903.98,0.075)+calculaFaixa(3751.05,2826.65,0.15)+
						   calculaFaixa(base,3751.05,0.225);
		}
		else if (base >  4664.68) {
			valorImposto = calculaFaixa(2826.65,1903.98,0.075)+calculaFaixa(3751.05,2826.65,0.15)+
					       calculaFaixa(4664.68,3751.05,0.225)+calculaFaixa(base,4664.68,0.27);
		}
		else {
			throw new BaseInvalidaException(base);
	
		}
		
		return valorImposto;
	}

}
