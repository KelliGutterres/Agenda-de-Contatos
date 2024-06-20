package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.ContatoDAO;

/*
 * @author kelli
 */

public class AgendaContato {

    private ArrayList<Contato> contatos;
    private ContatoDAO contatoDAO;

    public AgendaContato() {
        contatos = new ArrayList<>();
        contatoDAO = new ContatoDAO();
        contatos.addAll(contatoDAO.lerContatos());
    }

    public void cadastrarContato(String nome, String email, String telefone) {
        Contato novoContato = new Contato(nome, email, telefone);
        
        if (!contatos.contains(novoContato)) {
            
            contatos.add(novoContato);
            contatoDAO.salvarContatos(contatos);
            
            JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!"); 
        } else {
            
            JOptionPane.showMessageDialog(null, "Contato com E-mail já existente!");
        }
    }

    public void editarContato(String email, String novoNome, String novoTelefone) {
        
        for (Contato contato : contatos) {
            
            if (contato.getEmail().equals(email)) {
                contatoDAO.salvarContatos(contatos);
                
                JOptionPane.showMessageDialog(null, "Contato editado com sucesso!");
            }
        }
        JOptionPane.showMessageDialog(null, "Contato com E-mail ( "+email+" ) não ENCONTRADO!");
    }

    public void excluirContato(String email) {
        
        contatos.removeIf(contato -> contato.getEmail().equals(email));
        contatoDAO.salvarContatos(contatos);
        
        JOptionPane.showMessageDialog(null, "Contato excluído com sucesso!");
    }

    public void listarContatos() {
        
        if (contatos.isEmpty()) {
            
             JOptionPane.showMessageDialog(null, "Nenhum contato encontrado na agenda!");
        } else {
            
           String listNomes = "";
            
            for (Contato contato : contatos) {
                listNomes += contato+ "\n";
            }
            
            JOptionPane.showMessageDialog(null,listNomes,"Contatos na agenda: ",JOptionPane.OK_OPTION);
        }
    }
}
