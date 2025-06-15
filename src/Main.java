import javax.swing.*;
// executa o programa
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface app = new Interface();
            app.setVisible(true);
        });
    }
}
