package br.fiap.main;

import java.util.Random;

import br.fiap.cliente.Cliente;

public class Main {
	public static void main(String[] args) {

		Random gerador = new Random();
		Cliente[] vetorClientes = new Cliente[10];

		for (int i = 0; i < vetorClientes.length; i++) {
			Cliente cliente = new Cliente("CPF" + (i + 1), gerador.nextInt(2000), gerador.nextDouble(20000));
			vetorClientes[i] = cliente;
		}

		for (Cliente cliente : vetorClientes) {
			System.out.println(cliente);
		}

		double porcentagem = vetorClientes.length * 0.30;

		for (int i = 0; i < porcentagem; i++) {
			System.out.println(vetorClientes[gerador.nextInt(vetorClientes.length)]);
		}

	}
}
