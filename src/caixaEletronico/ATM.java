package caixaEletronico;

import java.util.Scanner;

public class ATM {
	Integer nota100;
	Integer nota50;
	Integer nota20;
	Integer nota10;
	Integer saldo;
	Integer valorDoSaque;
	private static Scanner valorDigitado;

	
	public ATM(Integer saqueSolicitado) {
		nota100=0;
		nota50=0;
		nota20=0;
		nota10=0;
		saldo=saqueSolicitado;
		valorDoSaque=saqueSolicitado;
	}
	
	//metodo que busca o valor do saldo
	public Integer getSaldo() {
		return saldo;
	}
	
	//metodo que busca o valor do saque
	public Integer getValorSaque() {
		return valorDoSaque;
	}
	
	//metodo que busca a quatidade de notas de 100
	public Integer getNota100() {
		return nota100;
	}
	
	//metodo que busca a quatidade de notas de 50
	public Integer getNota50() {
		return nota50;
	}
	
	//metodo que busca a quatidade de notas de 20
	public Integer getNota20() {
		return nota20;
	}
	
	//metodo que busca a quatidade de notas de 10
	public Integer getNota10() {
		return nota10;
	}
	
	/*metodo para realizar o saque, ele verifica se o valor do saque é negativo, se é igual a zero.
	 * depois verificar se o valor é maior que 100 e entrega primeiro as notas de 100
	 * depois verificar se o valor é maior que 50 e entrega primeiro as notas de 50
	 * depois verificar se o valor é maior que 20 e entrega primeiro as notas de 20
	 * depois verificar se o valor é maior que 10 e entrega primeiro as notas de 10 */
	
	public void saque() {
		boolean continuaSaque=true;

		if (valorDoSaque == 0) {
			System.out.println("Foi entregue todo o valor solicitado");

		} else if (valorDoSaque < 10) {
			System.out.println("Valor invalido");

		} else
			while (continuaSaque && saldo>0) {
				
				if (saldo%100==0 || saldo%100!=0 && saldo>=100) {
					saldo -= 100;
					nota100++;
				} else if (saldo%50==0 || saldo%50!=0 && saldo>=50) {
					saldo -= 50;
					nota50++;
				}else if (saldo%20==0 || saldo%20!=0 && saldo>=20) {
					saldo -=20;
					nota20++;
				}
				else if (saldo%10==0 || saldo%10!=0 && saldo>=10) {
					saldo -=10;
					nota10++;
				} else {
					continuaSaque=false;
				}
			}
	}
	
	// metrodo principal que faz rodar a aplicação.
	
	public static void main(String[] args) {		
		 valorDigitado = new Scanner(System.in);
		
		//comeca chamando o construtor, onde passa o valor que deseja sacar.
		
		System.out.println("Digite o valor que deseja sacar?");
		
		ATM atm1 = new ATM(valorDigitado.nextInt());
		
		//Printa o valor do saque solicitado.
		System.out.println("Você solicitou o valor de: " + atm1.getValorSaque());
		
		//chama o metodo que saca
		atm1.saque();
		
		//printa os valores de quantidade de notas.
		System.out.println("Quantidade de notas de 100 foi: " + atm1.getNota100());
		System.out.println("Quantidade de notas de 50 foi: " + atm1.getNota50());
		System.out.println("Quantidade de notas de 20 foi: " + atm1.getNota20());
		System.out.println("Quantidade de notas de 10 foi: " + atm1.getNota10());
		System.out.println("Saldo restante devido a valor solicitado não ter notas para retirada: " + atm1.getSaldo());
	}

}
