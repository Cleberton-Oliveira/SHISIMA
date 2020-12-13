package DominioDoProblema;

public class Matriz {
	
	protected Posicao[][] posicoes;
	
	public Matriz() {
		this.iniciar();
	}
	
	public void iniciar() {
		System.out.println("[Matriz] iniciar");
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
		System.out.println("[Matriz] definirOcupantes 2");
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

	
	public boolean avaliarTresPosicoesAlinhadas() {
		int i = 1;
		int tipoTeste = 0;
		boolean venceu = false;
		Jogador aux1 = new Jogador();
		Jogador aux2 = new Jogador();
		
		do {
		    System.out.println(tipoTeste);
		    if (tipoTeste == 0) {//avaliandoVertical
	        	aux1 = this.posicoes[i+i][i].ocupante;
	    		aux2 = this.posicoes[i-i][i].ocupante;
	    		venceu = aux1.nome == aux2.nome;
		    }
		    if (tipoTeste == 1) {//avaliandoHorizontal
		    	aux1 = this.posicoes[i][i-i].ocupante;
	    		aux2 = this.posicoes[i][i+i].ocupante;
	    		venceu = aux1.nome == aux2.nome;
		    }
		    if (tipoTeste == 2) {//avaliandoDiagonais
		    	aux1 = this.posicoes[i-i][i-i].ocupante;
	    		aux2 = this.posicoes[i-i][i+i].ocupante;
	    		venceu = aux1.nome == aux2.nome;
	    		
	    		if (!venceu) {
	    			aux1 = this.posicoes[i-i][i+i].ocupante;
	    			aux2 = this.posicoes[i+i][i+i].ocupante;
	    			venceu = aux1.nome == aux2.nome;
	    		}
		    }
    		tipoTeste++;
		} while (tipoTeste < 3 || !venceu);
		
		return venceu;
	}


}
