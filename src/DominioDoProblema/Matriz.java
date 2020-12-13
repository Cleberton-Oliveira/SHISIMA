package DominioDoProblema;

public class Matriz {
	
	protected Posicao[][] posicoes;
	
	public Matriz() {
		this.iniciar();
	}
	
	public void iniciar() {
		this.posicoes = new Posicao[3][3];
		for(int i = 0; i < 3; i++){
		    for(int j = 0; j < 3; j++){
		    	posicoes[i][j] = new Posicao();
		    }
		}
	}
	
	public void definirOcupantes(Jogador primeiro, Jogador segundo) {
		posicoes[0][0].ocupante = primeiro;
		posicoes[0][1].ocupante = primeiro;
		posicoes[0][2].ocupante = primeiro;
		
		posicoes[2][0].ocupante = segundo;
		posicoes[2][1].ocupante = segundo;
		posicoes[2][2].ocupante = segundo;
	}
	
	public void testePrintMatriz() {
		System.out.println("[Matriz] testePrintMatriz");
		for(int i = 0; i < 3; i++){
		    for(int j = 0; j < 3; j++){
		    	System.out.print(i);
		    	System.out.print(",");
		    	System.out.print(j);
		    	System.out.print(": ");
		    	if (posicoes[i][j].ocupante != null) {
		    		if (posicoes[i][j].ocupante.informarCor() == 0) {
			    		System.out.println("vermelho");
		    		} else {
			    		System.out.println("azul");
		    		}
		    	} else {
		    		System.out.println(posicoes[i][j].ocupante);
		    	}
		    }
		}
	}
	
	private Jogador obterAlinhamentoCentral() {
		int i = 1;
		return this.posicoes[i][i].ocupante;
	}
	
	private boolean obterAlinhamentoHorizontal() {
		int i = 1;
		boolean venceuNaHorizontal = false;
		Jogador aux1 = new Jogador();
		Jogador aux2 = new Jogador();
		
		aux1 = posicoes[i][i-i].ocupante;
		aux2 = posicoes[i][i+i].ocupante;
		
		if (aux1 != null && aux2 != null) {
			venceuNaHorizontal = aux1.informarCor() == aux2.informarCor();
		}
		
		return venceuNaHorizontal;
	}
	
	private boolean obterAlinhamentoVertical() {
		int i = 1;
		boolean venceuNaVertical = false;
		Jogador aux1 = new Jogador();
		Jogador aux2 = new Jogador();
		
		aux1 = posicoes[i-i][i].ocupante;
		aux2 = posicoes[i+i][i].ocupante;
		if (aux1 != null && aux2 != null) {
			venceuNaVertical = aux1.informarCor() == aux2.informarCor();
		}

		
		
		return venceuNaVertical;
	}
	
	private boolean obterAlinhamentoDiagonal() {
		int i = 1;
		boolean venceuNaDiagonal = false;
		Jogador aux1 = new Jogador();
		Jogador aux2 = new Jogador();
		
		aux1 = posicoes[i-i][i-i].ocupante;
		aux2 = posicoes[i+i][i+i].ocupante;
		
		if (aux1 != null && aux2 != null) {
			venceuNaDiagonal = aux1.informarCor() == aux2.informarCor();
		}
		
		if (!venceuNaDiagonal) {
			aux1 = posicoes[i-i][i+i].ocupante;
			aux2 = posicoes[i+i][i-i].ocupante;
			if (aux1 != null && aux2 != null) {
				venceuNaDiagonal = aux1.informarCor() == aux2.informarCor();
			}
		}
		
		return venceuNaDiagonal;
	}
	
	public boolean avaliarTresPosicoesAlinhadas(Jogador daVez) {
		boolean venceu = false;
		Jogador aux = obterAlinhamentoCentral();
		if (aux != null) {
			if(aux.informarCor() == daVez.informarCor()) { // verifica se o daVez esta no centro
				venceu = obterAlinhamentoHorizontal();
				if (!venceu) {
					venceu = obterAlinhamentoVertical();
					if (!venceu) {
						venceu = obterAlinhamentoDiagonal();
					}
				}
			}
		}
		return venceu;
	}

}
