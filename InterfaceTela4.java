// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceTela4 extends JFrame {
   private JLabel lblNome;
   private JTextField txtNome;
   private JLabel lblSenha;
   private JTextField txtSenha;
   private JLabel lblCPF;
   private JFormattedTextField txtCPF;
   private JButton btnSalvar;
   private JButton btnListar;
   private Container ctn;

   public InterfaceTela4() {
      this.setSize(600, 800);
      this.setTitle("Tela Cadastro");
      this.ctn = this.getContentPane();
      this.ctn.setLayout((LayoutManager)null);
      this.lblNome = new JLabel("Nome");
      this.txtNome = new JTextField();
      this.lblCPF = new JLabel("CPF");
      this.txtCPF = new JFormattedTextField();
      this.lblSenha = new JLabel("Senha");
      this.txtSenha = new JTextField();
      this.btnSalvar = new JButton("Salvar");
      this.btnListar = new JButton("Listar");
      this.lblNome.setBounds(20, 20, 100, 25);
      this.txtNome.setBounds(150, 20, 200, 25);
      this.lblCPF.setBounds(20, 50, 100, 25);
      this.txtCPF.setBounds(150, 50, 200, 25);
      this.lblSenha.setBounds(20, 80, 100, 25);
      this.txtSenha.setBounds(150, 80, 200, 25);
      this.btnSalvar.setBounds(20, 110, 100, 30);
      this.btnListar.setBounds(130, 110, 100, 30);
      this.ctn.add(this.lblNome);
      this.ctn.add(this.txtNome);
      this.ctn.add(this.lblCPF);
      this.ctn.add(this.txtCPF);
      this.ctn.add(this.lblSenha);
      this.ctn.add(this.txtSenha);
      this.ctn.add(this.btnSalvar);
      this.ctn.add(btnListar);
    

      UsuarioDAO dao = new UsuarioDAO();

      this.btnSalvar.addActionListener((var2) -> {
         Usuario user = this.criarUsuarioDoFormulario();

         
         if (!user.validar()) {
            JOptionPane.showMessageDialog(this, "Usuário invalido ");
            return;
         } 

         dao.salvar(user);

         JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!");

      });

      this.btnListar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (Usuario a : dao.listar()) {
               System.out.println(a.getId() + " - " + a.getNome() + " - " + a.getCpf());
            }
         }
      });

      this.setVisible(true);
      this.setDefaultCloseOperation(3);
      
     
   }

  

   private Usuario criarUsuarioDoFormulario() {    
      return new Usuario(this.txtNome.getText(), this.txtCPF.getText(), this.txtSenha.getText());
   }

   public static void main(String[] var0) {
      new InterfaceTela4();
   }
}
