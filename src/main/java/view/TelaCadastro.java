package view;

import model.AgendaContato;
import com.mycompany.agendadecontatos.Entrada;

/*
 * @author kelli
 */

public class TelaCadastro {
    
    private AgendaContato agenda;

    public TelaCadastro() {
        
        agenda = new AgendaContato();
    }
    
    public void listar(){
    
        agenda.listarContatos();
    }
    
    public void cadastrar(){
    
        String nome = Entrada.leiaString("Informe seu Nome: ");

        String email = Entrada.leiaString("Informe seu E-mail: ");

        String telefone = Entrada.leiaString("Informe seu Telefone: ");
        
        agenda.cadastrarContato(nome, email, telefone);
    }
    
    public void editar(){
    
        String emailEditar = Entrada.leiaString("Informe o E-mail a ser editado: ");

        String novoNome = Entrada.leiaString("Informe o Novo Nome: ");

        String novoTelefone = Entrada.leiaString("Informe seu Telefone: ");

        agenda.editarContato(emailEditar, novoNome, novoTelefone);
    }
    
    public void excluir(){
    
        String emailExcluir = Entrada.leiaString("Informe o E-mail a ser excluído: ");

        agenda.excluirContato(emailExcluir);
    }
}
