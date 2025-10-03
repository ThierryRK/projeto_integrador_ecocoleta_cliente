package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    // Streams como atributos da classe
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket socket; // Armazena o socket

    // Construtor para iniciar a conexão e os streams
    public void iniciar(String host, int porta) throws IOException {
        this.socket = new Socket(host, porta);
        // Crie os streams UMA ÚNICA VEZ
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
    }

    // Métodos agora usam os atributos da classe, sem receber o socket como parâmetro
    // E, crucialmente, SEM fechar os streams
    public String inputString() {
        try {
            String mensagem = input.readUTF();
            System.out.println(mensagem); // Imprime a mensagem recebida para o usuário ver
            return mensagem;
        } catch (IOException e) {
            System.out.println("Erro de comunicação (servidor pode ter sido encerrado): " + e.getMessage());
            return null; // Indica que a comunicação falhou
        }
    }

    public void outputString(String saida) {
        try {
            output.writeUTF(saida);
            output.flush();
        } catch (IOException e) {
            System.out.println("Erro ao enviar String: " + e.getMessage());
        }
    }

    public void outputInt(int saida) {
        try {
            output.writeInt(saida);
            output.flush();
        } catch (IOException e) {
            System.out.println("Erro ao enviar Int: " + e.getMessage());
        }
    }
    
    // Método para fechar tudo no final
    public void fecharConexao() throws IOException {
        if (output != null) output.close();
        if (input != null) input.close();
        if (socket != null) socket.close();
    }
}