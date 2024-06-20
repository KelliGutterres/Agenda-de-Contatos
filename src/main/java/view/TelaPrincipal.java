package view;
import model.AgendaContato;
import com.mycompany.agendadecontatos.Entrada;
import javax.swing.JOptionPane;

/*
 * @author kelli
 */

public class TelaPrincipal {
  
    private AgendaContato agenda;

    public TelaPrincipal() {
        agenda = new AgendaContato();
    }
    
    public String menuInicial(){
        
        String menu = "AGENDA DE CONTATOS\n"
                + "|1| - Consultar Contatos\n"
                + "|2| - Cadastrar Contato\n"
                + "|3| - Editar Contato\n"
                + "|4| - Excluir Contato\n"
                + "|5| - Sair\n"
                + "Informe a opção que deseja realizar: \n";
        
        return menu;
    }

    public void executar() {
        
        while(true) {
            
            int escolha = Entrada.leiaInt(menuInicial());
            TelaCadastro telaCadastro = new TelaCadastro();

            switch (escolha) {
                case 1:
                    
                    telaCadastro.listar();
                    break;
                case 2:
                    
                    telaCadastro.cadastrar();
                    break;
                case 3:
                    
                    telaCadastro.editar();
                    break;
                case 4:
                    
                    telaCadastro.excluir();
                    break;
                case 5:
                    
                    JOptionPane.showMessageDialog(null, "Programa encerrado!");
                    System.exit(0);
                default:
                    
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!");
            }
        }
    }
}
