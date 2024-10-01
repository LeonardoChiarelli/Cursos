
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class olamundoswing extends javax.swing.JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha Janela Swing"); // Cria um novo JFrame (janela)
        frame.setSize(300, 200); // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define ação de fechar o programa ao fechar a janela
        frame.setLayout(null); // Usando layout nulo para posicionar os componentes manualmente

        JButton button = new JButton("Clique Aqui"); // Cria um botão
        button.setBounds(90, 80, 120, 30); // Definindo a posição e o tamanho do botão
        button.addActionListener((ActionEvent e) -> { // Adicionando um listener para o clique ao botão
            // Exibindo uma mensagem quando o botão é clicado
            JOptionPane.showMessageDialog(frame, "Olá, Mundo");
        });
        frame.add(button); // Adiciona o botão à janela
        frame.setVisible(true); // Torna a tela visível
    }
}
