package br.fiap.cliente;

public class Cliente {
	private String cpf;
	private int numeroConta;
	private double saldo;

	public Cliente(String cpf, int numeroConta, double saldo) {
		super();
		this.cpf = cpf;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public String getCPF() {
		return cpf;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		String aux = "\n";
		aux += "CPF: " + cpf + "\n";
		aux += "Número da conta: " + numeroConta + "\n";
		aux += "Saldo: " + saldo + "\n";
		return aux;
	}
}
