package main;

import java.io.IOException;
import java.util.Scanner;
import cliente.Cliente;

public class Main {

    public static void main(String[] args) { 

        Cliente cliente = new Cliente();
        Scanner teclado = new Scanner(System.in);

        try {
        	// Inicia a conexão e streams
            System.out.println("Estabelecendo conexão...");
            cliente.iniciar("localhost", 55555); 
            System.out.println("Conexão estabelecida!");

            int cursor;

            // Loop principal de comunicação
            do {
                // O cliente recebe as 4 mensagens do menu
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
					// Cliente recebe uma lista de locais em String (resíduo plástico)
					cliente.inputString();
					cliente.inputString();
					// Entrada para voltar ao menu ("Digite 0 para voltar.")
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 2:
				do {
					// Cliente recebe uma lista de locais em String (resíduo metal)
					cliente.inputString();
					cliente.inputString();
					// Entrada para voltar ao menu ("Digite 0 para voltar.")
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 3:
				do {
					// Cliente recebe uma lista de locais em String (resíduo papel)
					cliente.inputString();
					cliente.inputString();
					// Entrada para voltar ao menu ("Digite 0 para voltar.")
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 4:
				do {
					// Cliente recebe uma lista de locais em String (resíduo vidro)
					cliente.inputString();
					cliente.inputString();
					// Entrada para voltar ao menu ("Digite 0 para voltar.")
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
				}while (cursor != 0);
				break;
			case 5:
				cliente.inputString();
				break;
			case 123456:
				String nome;
				String endereco;
				String residuo;
				do {
					// Cliente recebe o menu do ADM
					cliente.inputString();
					cliente.inputString();
					cliente.inputString();
					// Entrada para escolha das ações
					cursor = teclado.nextInt();
					teclado.nextLine();
					cliente.outputInt(cursor);
					switch (cursor) {
					case 1:
						//Inserindo no banco de dados
						cliente.inputString();
						nome = teclado.nextLine();
						cliente.outputString(nome);
						cliente.inputString();
						endereco = teclado.nextLine();
						cliente.outputString(endereco);
						cliente.inputString();
						residuo = teclado.nextLine().toLowerCase();						
						cliente.outputString(residuo);
						cliente.inputString();
						break;
						
					case 2:
						//Apagando no banco de dados
						cliente.inputString();
						nome = teclado.nextLine();
						cliente.outputString(nome);
						cliente.inputString();
						break;
						
					case 3:
						String nomeAtual;
						//Editando no banco de dados
						cliente.inputString();
						nomeAtual = teclado.nextLine();
						cliente.outputString(nomeAtual);
						cliente.inputString();
						nome = teclado.nextLine();
						cliente.outputString(nome);
						cliente.inputString();
						endereco = teclado.nextLine();
						cliente.outputString(endereco);
						cliente.inputString();
						residuo = teclado.nextLine().toLowerCase();
						cliente.outputString(residuo);
						cliente.inputString();
						break;
						
					case 4:
						//Saindo do menu do ADM
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