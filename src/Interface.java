import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface extends JFrame {
    private ArrayList<Carro> carros = new ArrayList<>();
    private JTextArea areaTexto;
    private JTextField campoPlaca;
    private JTextField campoModelo;
    private JTextField campoProprietario;

    public Interface() {
        setTitle("Estacionamento");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        JPanel painelEntrada = new JPanel(new GridLayout(4, 2));
        painelEntrada.add(new JLabel("Placa:"));
        campoPlaca = new JTextField();
        painelEntrada.add(campoPlaca);

        painelEntrada.add(new JLabel("Modelo:"));
        campoModelo = new JTextField();
        painelEntrada.add(campoModelo);

        painelEntrada.add(new JLabel("Proprietário:"));
        campoProprietario = new JTextField();
        painelEntrada.add(campoProprietario);

        JButton btnRegistrarEntrada = new JButton("Registrar Entrada");
        btnRegistrarEntrada.addActionListener(e -> registrarEntrada());
        painelEntrada.add(btnRegistrarEntrada);

        JButton btnRegistrarSaida = new JButton("Registrar Saída");
        btnRegistrarSaida.addActionListener(e -> registrarSaida());
        painelEntrada.add(btnRegistrarSaida);

        add(painelEntrada, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();
        JButton btnListar = new JButton("Listar Carros");
        btnListar.addActionListener(e -> listarCarros());
        painelBotoes.add(btnListar);

        JButton btnMedia = new JButton("Calcular Média de Tempo");
        btnMedia.addActionListener(e -> calcularMedia());
        painelBotoes.add(btnMedia);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void registrarEntrada() {
        String placa = campoPlaca.getText().trim();
        String modelo = campoModelo.getText().trim();
        String nomeProprietario = campoProprietario.getText().trim();

        if (placa.isEmpty() || modelo.isEmpty() || nomeProprietario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Placa, modelo e proprietário são obrigatórios.");
            return;
        }

        Proprietario proprietario = new Proprietario(nomeProprietario);
        carros.add(new Carro(placa, modelo, proprietario));

        campoPlaca.setText("");
        campoModelo.setText("");
        campoProprietario.setText("");

        areaTexto.append("Entrada registrada: " + placa + " - " + modelo + " - " + nomeProprietario + "\n");
    }

    private void registrarSaida() {
        String placa = campoPlaca.getText().trim();

        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a placa do carro para saída.");
            return;
        }

        boolean encontrado = false;
        for (Carro c : carros) {
            if (c.getPlaca().equalsIgnoreCase(placa) && !c.saiu()) {
                c.registrarSaida();
                areaTexto.append("Saída registrada: " + placa + "\n");
                double valor = c.calcularValorEstacionamento();
                areaTexto.append("Valor a pagar: R$ " + String.format("%.2f", valor) + "\n");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "Carro não encontrado ou já saiu.");
        }
    }

    private void listarCarros() {
        areaTexto.setText("");
        for (Carro c : carros) {
            c.exibirINTER(areaTexto);
        }
    }

    private void calcularMedia() {
        double total = 0;
        int count = 0;
        for (Carro c : carros) {
            if (c.saiu()) {
                total += c.getTempoPermanenciaMinutos();
                count++;
            }
        }

        if (count > 0) {
            double media = total / count;
            areaTexto.append("Média de tempo no estacionamento: " + media + " minutos\n");
        } else {
            areaTexto.append("Nenhum carro saiu ainda.\n");
        }
    }
    }
