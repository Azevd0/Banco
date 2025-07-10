package guanabaraaulas;

import java.util.Scanner;

public class ContaBanco {
	public int numConta;
	protected int tipo;
	private String dono;
	private int saldo;
	private boolean status;

	Scanner scan = new Scanner(System.in);
	

	public ContaBanco(int nc, String d, int sd, boolean s) {
		
		this.numConta = nc;
		this.dono = d;
		this.saldo = sd;
		this.status = s;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean s) {
		this.status = s;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void setSaldo(int sd) {
		this.saldo = sd;
	}

	public String getDono() {
		return this.dono;
	}

	public void setDono(String d) {
		this.dono = d;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int t) {
		this.tipo = t;
	}

	public void abrirConta() {
		if (getStatus() == true) {
			System.out.println("Conta: " + numConta);
			System.out.println("Bem vindo, " + getDono() + ", escolha a conta: \n1 - corrente \n2 - poupança");
			tipo = scan.nextInt();
			switch (tipo) {
			case 1:
				System.out.println("Conta corrente. Você recebeu R$ 50,00.");
				System.out.print("Saldo atual: ");
				System.out.println(getSaldo() + 50);
				break;
			case 2:
				System.out.println("Conta poupança. Você recebeu R$ 150,00.");
				System.out.print("Saldo atual: ");
				System.out.println(getSaldo() + 150);
				break;
			default:
				System.out.println("Tipo não reconhecido.");
			}
		} else {
			System.out.println("A conta está fechada.");
		}

	}

	public void acoes() {
		if (tipo == 1 || tipo == 2) {
			boolean verificar;
			verificar = true;
			if (getStatus() == true) {
				System.out.println("\nO que você deseja?\n1 - Depositar\n2 - Sacar\n3 - Pagar mensalidade\n4 - Fechar Conta");
				int acao = scan.nextInt();
				switch (acao) {
				case 1:
					depositar();
					break;
				case 2:
					sacar();
					break;
				case 3:
					pagarMes();
					break;
				case 4: fechar();
					break;
				default:
					System.out.println("Irreconhecido.");
				}
			} else if (getStatus() == false) {
				System.out.println("Operação interrompida.");
			}
		} else {
			System.out.println("Operação interrompida.");
		}

	}

	public void depositar() {
		System.out.println("Quanto você quer depositar?");
		int deposito = scan.nextInt();
		if (deposito > getSaldo()) {
			System.out.println("Erro, depósito além do limite de saldo.");
		} else {
			int posDeposito = getSaldo() - deposito;
			System.out.println("Você depositou " + deposito + " Seu saldo atual é " + posDeposito);
		}
	}

	public void sacar() {
		System.out.println("Quanto você quer sacar?");
		int saque = scan.nextInt();
		if (saque > getSaldo()) {
			System.out.println("Erro, depósito além do limite de saldo.");
		} else {
			int posSaque = getSaldo() - saque;
			System.out.println("Você depositou " + saque + " Seu saldo atual é " + posSaque);
		}
	}

	public void pagarMes() {
		if (tipo == 1) {
			System.out.print("Você pagou R$ 12,00 da mensalidade com a conta correte.\nSeu saldo atual é: ");
			System.out.println(getSaldo() + 50 - 12);

		} else if (tipo == 2) {
			System.out.print("Você pagou R$ 20,00 da mensalidade com a conta poupança.\nSeu saldo atual é: ");
			System.out.println(getSaldo() + 150 - 20);
		}
	}
	public void fechar() {
		System.out.println("Você fechou a conta."); 
		
	}

}
