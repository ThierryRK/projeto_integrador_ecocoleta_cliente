package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket socket;

    // Inicia a conexão e os streams
    public void iniciar(String host, int porta) throws IOException {
        this.socket = new Socket(host, porta);
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
    }

    // Recebe String do servidor
    public String inputString() {
        try {
            String mensagem = input.readUTF();
            System.out.println(mensagem); 
            return mensagem;
        } catch (IOException e) {
            System.out.println("Erro de comunicação (servidor pode ter sido encerrado): " + e.getMessage());
            return null; 
        }
    }

    // Envia String ao servidor
    public void outputString(String saida) {
        try {
            output.writeUTF(saida);
            output.flush();
        } catch (IOException e) {
            System.out.println("Erro ao enviar String: " + e.getMessage());
        }
    }

    // Envia int ao servidor
    public void outputInt(int saida) {
        try {
            output.writeInt(saida);
            output.flush();
        } catch (IOException e) {
            System.out.println("Erro ao enviar Int: " + e.getMessage());
        }
    }
    
    // Fecha tudo no final
    public void fecharConexao() throws IOException {
        if (output != null) output.close();
        if (input != null) input.close();
        if (socket != null) socket.close();
    }
}