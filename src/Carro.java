import java.time.Duration;
import java.time.LocalDateTime;
import javax.swing.JTextArea;
import java.time.format.DateTimeFormatter;
public class Carro {
    private String placa;
    private String modelo;
    private Proprietario proprietario;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Carro(String placa, String modelo, Proprietario proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.entrada = LocalDateTime.now();
        this.saida = null;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean saiu() {
        return saida != null;
    }

    public void registrarSaida() {
        if (saida == null) {
            saida = LocalDateTime.now();
        }
    }

    public double getTempoPermanenciaMinutos() {
        if (saida != null) {
            return Duration.between(entrada, saida).toMinutes();
        }
        return 0;
    }

    public void exibirINTER(JTextArea areaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        areaTexto.append("Placa: " + placa + "\n");
        areaTexto.append("Modelo: " + modelo + "\n");
        areaTexto.append("Proprietário: " + proprietario.getNome() + "\n");

        areaTexto.append("Entrada: " + entrada.format(formatter) + "\n");

        if (saida != null) {
            areaTexto.append("Saída: " + saida.format(formatter) + "\n");
            areaTexto.append("Tempo (min): " + getTempoPermanenciaMinutos() + "\n");
        } else {
            areaTexto.append("Saída: -\n");
        }

        areaTexto.append("------\n");
    }
// valor a ser pago
    public double calcularValorEstacionamento() {
        if (saida != null) {
            double minutos = getTempoPermanenciaMinutos();
            double horas = (minutos + 59) / 60; // Arredonda
            return horas * 12.0;
        } else {
            return -1;
        }
    }
}