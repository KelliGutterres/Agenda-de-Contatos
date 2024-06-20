package modelDominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Contato;

/*
 * @author kelli
 */

public class ContatoDAO {
    
    private String arquivo = "contatos.txt";

    public void salvarContatos(ArrayList<Contato> contatos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Contato contato : contatos) {
                writer.println(contato.getNome() + ";" + contato.getEmail() + ";" + contato.getTelefone());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contato> lerContatos() {
        
        ArrayList<Contato> contatos = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    contatos.add(new Contato(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contatos;
    }
}
