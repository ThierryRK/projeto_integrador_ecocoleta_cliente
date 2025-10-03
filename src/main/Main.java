package main;

import java.io.IOException;
import java.util.Scanner;
import cliente.Cliente;

public class Main {

    public static void main(String[] args) { // Remova 'throws IOException' daqui

        Cliente cliente = new Cliente();
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.println("Estabelecendo conexão...");
            cliente.iniciar("localhost", 55555); // Inicia conexão e streams
            System.out.println("Conexão estabelecida!");

            int cursor;
            String entradaString;

            // Loop principal de comunicação
            do {
                // O servidor envia 4 mensagens de menu
                cliente.inputString(); 
                cliente.inputString(); 
                cliente.inputString(); 
                cliente.inputString(); 

                // Cliente envia sua escolha
                cursor = teclado.nextInt();
                teclado.nextLine(); // Limpa o buffer do scanner
                cliente.outputInt(cursor);
                
                // Se a escolha for sair, o loop principal vai parar
                if (cursor == 5) {
                    cliente.inputString(); // Recebe a mensagem de "Fechando..." do servidor
                    break;
                }
			switch (cursor) {
			case 1:
				do {
					cliente.inputString();
					//saida
					cliente.inputString();
					//entrada
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 2:
				do {
					cliente.inputString();
					//saida
					cliente.inputString();
					//entrada
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 3:
				do {
					cliente.inputString();
					//saida
					cliente.inputString();
					//entrada
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 4:
				do {
					cliente.inputString();
					//saida
					cliente.inputString();
					//entrada
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 5:
				//saida
				cliente.inputString();
				break;
			case 123456:
				String nome;
				String endereco;
				String residuo;
				do {
					//saida
					cliente.inputString();
					cliente.inputString();
					cliente.inputString();
					//entrada
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
					switch (cursor) {
					case 1:
						//saida
						cliente.inputString();
						//entrada
						nome = teclado.nextLine();
						cliente.outputString(nome);
						//saida
						cliente.inputString();
						//entrada
						endereco = teclado.nextLine();
						cliente.outputString(endereco);
						//saida
						cliente.inputString();
						//entrada
						residuo = teclado.nextLine();
						cliente.outputString(residuo);
						//saida
						cliente.inputString();
						break;
						
					case 2:
						//saida
						cliente.inputString();
						//entrada
						nome = teclado.nextLine();
						cliente.outputString(nome);
						//saida
						cliente.inputString();
						break;
						
					case 3:
						String nomeAtual;
						//saida
						cliente.inputString();
						//entrada
						nomeAtual = teclado.nextLine();
						cliente.outputString(nomeAtual);
						//saida
						cliente.inputString();
						//entrada
						nome = teclado.nextLine();
						cliente.outputString(nome);
						//saida
						cliente.inputString();
						//entrada
						endereco = teclado.nextLine();
						cliente.outputString(endereco);
						//saida
						cliente.inputString();
						//entrada
						residuo = teclado.nextLine();
						cliente.outputString(residuo);
						//saida
						cliente.inputString();
						break;
						
					case 4:
						//saida
						cliente.inputString();
						break;
					}
				}while (cursor != 4);
				break;
			} 
            } while (true); // O loop é controlado pela opção '5'

        } catch (IOException ex) {
            System.out.println("Não foi possível conectar ao servidor: " + ex.getMessage());
        } finally {
            // Garante que a conexão seja fechada
            try {
                System.out.println("Fechando conexão.");
                cliente.fecharConexao();
                teclado.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}

