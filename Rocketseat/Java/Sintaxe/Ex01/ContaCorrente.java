import java.util.Date;

public class ContaCorrente {
	private int numeroConta;
	private int numeroAgencia;
	private String nomeCliente;
	private Date dataNascimento;
	private double saldo;

	public ContaCorrente() {}

	public ContaCorrent(int numeroConta, int numeroAgencia, String nomeCliente, Date dataNascimento) {
	
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.nomeCliente = nomeCliente;
		this.dataNascimento = dataNascimento;
		this.saldo = 0;
	}

	public int getNumeroConta() {
	
		return this.numeroConta;
	}

	public int getNumeroAgencia() {
		
		return this.numeroAgencia;
	}

	public String getNomeCliente() {
	
		return this.nomeCliente;
	}

	public Date getDataNascimento() {
	
		return this.dataNascimento;
	}

	public double getSaldo() {
		
		return this.saldo;
	}


	public void sacarValor(double valor) {
	
		if (this.saldo < valor) {
			
			throw new Exception("Saldo insuficiente para o saque!");
		}

		this.saldo -= valor;
	}

	public void depositarValor(double valor) {
	
		this.saldo += valor;
	}

	public void transferirValor(double valor, int numeroConta, int numeroAgencia) {
		
		if (this.saldo < valor) {
			
			throw new Exception("Saldo insuficiente para a transferência!");
		}

		// Método para buscar no DB a outra conta com um findByNumeroConta()...
		// Carregar essa conta de destino, e criar uma variável chamada contaDestino
		
		contaDestino.depositarValor(valor);
	}


	public void cancelarConta(int numeroConta, int numeroAgencia, String motivo) {
	
		if (motivo.equals(null) {
			
			throw new Exception("Motivo de cancelamento obrigatório");
		}

		// Método no DB ou para desativar a conta (nesse caso devemos colocar um atributo na classe)
		// Ou método para excluir do DB usando um deleteByNumeroConta()....
	}
}
