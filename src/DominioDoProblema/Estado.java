package DominioDoProblema;

public class Estado {

	protected Lance lance;
	protected String mensagem;
	
	public Estado() {
		definirLance(new Lance());
	}
	
	public void definirLance(Lance lance) {
		this.lance = lance;
	}
	
	public Lance obterLance() {
		return this.lance;
	}
}
