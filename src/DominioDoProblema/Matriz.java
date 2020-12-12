package DominioDoProblema;

public class Matriz {
	
	protected Posicao[][] posicoes;
	
	public Matriz() {}
	
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
