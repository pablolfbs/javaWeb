package com.pablo.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

	private static final String CONTA_INEXISTENTE = "Conta inexistente!";

	private String nomeTitular;

	private ContaBancaria contaBancaria;

	public void depositar(String NUM_CONTA, BigDecimal valor) {
		if (Objects.nonNull(contaBancaria)) {
			if (Objects.nonNull(NUM_CONTA)) {
				contaBancaria.setSaldo(contaBancaria.getSaldo().add(valor));
				System.out.println("Depósito de R$" + valor.setScale(2) + " efetuado com sucesso!");
			} else {
				System.err.print("Ocorreu um erro ao fazer o depósito! ");
			}
		} else {
			System.out.println(CONTA_INEXISTENTE);
		}
	}

	public void sacar(String NUM_CONTA, BigDecimal valor) {
		if (Objects.nonNull(contaBancaria)) {
			if (Objects.nonNull(NUM_CONTA)) {
				if (contaBancaria.getSaldo().intValue() > valor.intValue()) {
					contaBancaria.setSaldo(contaBancaria.getSaldo().subtract(valor).subtract(new BigDecimal(5)));
					System.out.println("Saque de R$" + valor.setScale(2) + " efetuado com sucesso! Uma taxa de R$5.00 foi cobrada pela transação!");
				} else {
					System.err.print("Saldo insuficiente! ");
					imprimeSaldo();
				}
			} else {
				System.err.print("Ocorreu um erro ao fazer o saque! ");
			}
		} else {
			System.out.println(CONTA_INEXISTENTE);
		}
	}

	public Optional<String> abrirConta(String numeroConta, Cliente cliente, BigDecimal depositoInicial) {
		if (Objects.nonNull(numeroConta)) {
			contaBancaria = new ContaBancaria(numeroConta, cliente, depositoInicial);
			contaBancaria.setSaldo(depositoInicial);

			return Optional.ofNullable("Conta aberta com sucesso!");
		}
		return Optional.of("Não foi possível abrir a conta!");
	}

	public Optional<String> abrirConta(String numeroConta, Cliente cliente) {
		if (Objects.nonNull(numeroConta)) {
			contaBancaria = new ContaBancaria(numeroConta, cliente);
			contaBancaria.setSaldo(contaBancaria.getValorDepositoInicial());

			return Optional.ofNullable("Conta aberta com sucesso!");
		}
		return Optional.ofNullable("Não foi possível abrir a conta!");
	}

	public void imprimeSaldo() {
		if (Objects.nonNull(contaBancaria)) {
			this.contaBancaria.getSaldo().add(this.contaBancaria.getValorDepositoInicial());
			System.out.println("O saldo da conta é R$" + this.contaBancaria.getSaldo().setScale(2));
		} else {
			System.out.println(CONTA_INEXISTENTE);
		}
	}
	
	public void imprimeDadosDaConta() {
		if (Objects.nonNull(contaBancaria)) {
			System.out.println("Dados da conta: " + this.contaBancaria);
		} else {
			System.out.println(CONTA_INEXISTENTE);
		}
	}

	@Override
	public String toString() {
		return "Cliente [nomeTitular=" + nomeTitular + ", numeroConta=" + contaBancaria.getNUM_CONTA() + "]";
	}

}
