package candidatura;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Processo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        lerDados(scanner);
        scanner.close();
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativas");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(String candidato) {
        String[] candidatos = {"Biatriz", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        boolean encontrado = false;
        
        for (int indice = 0; indice < candidatos.length; indice++) {
            if (candidatos[indice].equalsIgnoreCase(candidato)) {
                encontrado = true;
                System.out.println("O candidato " + candidato + " está na posição " + (indice + 1));
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Candidato " + candidato + " não foi encontrado em nenhuma posição.");
        }
        
        System.out.println("Imprimindo a lista dos primeiros 5 candidatos selecionados:");
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("o candidato de nº " + (indice + 1) + " é o " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos(String candidato) {
        String[] candidatos = {"Biatriz", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "CASSI", "MIRELA", "DANIELA", "JORGE"};
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
        boolean candidatoEncontrado = false;
        for (int i = 0; i < candidatos.length; i++) {
            if (candidato.equalsIgnoreCase(candidatos[i])) {
                candidatoEncontrado = true;
                System.out.println("O candidato " + candidato + " solicitou este valor de salário " + decimalFormat.format(valorPretendido()));
                if (i < 5) {
                    System.out.println("O candidato " + candidato + " foi selecionado para vaga");
                } else {
                    System.out.println("O candidato " + candidato + " não foi selecionado para vaga");
                }
                break;
            }
        }
    
        if (!candidatoEncontrado) {
            System.out.println("Candidato " + candidato + " não encontrado na lista.");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void lerDados(Scanner scanner) {
        System.out.println("Bem-vindo ao Processo Seletivo!");
        System.out.println("Digite o nome do candidato que deseja verificar: ");
        String nomeCandidato = scanner.nextLine();

        String[] candidatos = {"Biatriz", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "CASSI", "MIRELA", "DANIELA", "JORGE"};
        boolean candidatoEncontrado = false;
        for (String candidato : candidatos) {
            if (candidato.equalsIgnoreCase(nomeCandidato)) {
                entrandoEmContato(candidato);
                candidatoEncontrado = true;
                selecaoCandidatos(candidato);
                imprimirSelecionados(candidato);
                break;
            }
        }
        if (!candidatoEncontrado) {
            System.out.println("Candidato não encontrado na lista.");
        }
        
    }

}
