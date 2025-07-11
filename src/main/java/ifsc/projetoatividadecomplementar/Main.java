package ifsc.projetoatividadecomplementar;

import ifsc.projetoatividadecomplementar.Decorator.*;
import ifsc.projetoatividadecomplementar.Specification.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        Aluno aluno = new Aluno(matricula);
        ListaModalidade listaModalidade = new ListaModalidade();
        
        Specification<ListaModalidade> regraMinimaHoras = new MinimoHorasValidas();
        Specification<ListaModalidade> regraMinimaAtividades = new PossuiAtividades();
        Specification<ListaModalidade> regrasCombinadas = new SpecificationE<>(regraMinimaHoras, regraMinimaAtividades);

        int opcao;

        principal:
        while (true) {
            System.out.println("\n== Menu de Modalidades ==");
            for (Modalidade m : listaModalidade.getTodas()) {
                System.out.printf("%d) %s\n", m.getCodigo(), m.getNome());
            }
            System.out.println("0) Gerar parecer");
            System.out.print("Escolha a modalidade (0-finalizar): ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Tente novamente.");
                scanner.nextLine();
                continue;
            }

            if (opcao == 0) {
                ParecerComponente parecer = new ParecerBasico();
                parecer = new ParecerComAssinatura(parecer);
                parecer = new ParecerEmPdf(parecer);
                parecer.gerar(aluno, listaModalidade);
                break;
            }

            Modalidade modalidade = listaModalidade.getPorCodigo(opcao);
            if (modalidade == null) {
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.printf("\nVocê escolheu: Modalidade %d - %s\n", modalidade.getCodigo(), modalidade.getNome());
            System.out.println("Escolha uma atividade:");

            var listaPre = modalidade.getAtividadesPreDefinidas();
            for (int i = 0; i < listaPre.size(); i++) {
                System.out.printf("%d) %s\n", (i + 1), listaPre.get(i));
            }

            System.out.print("Digite o número da atividade (ou 0 para voltar): ");
            int numeroAtividade;
            try {
                numeroAtividade = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Número inválido!");
                scanner.nextLine();
                continue;
            }

            if (numeroAtividade == 0) {
                System.out.println("Retornando ao menu de modalidades...");
                continue;
            }

            if (numeroAtividade < 1 || numeroAtividade > listaPre.size()) {
                System.out.println("Número de atividade inválido!");
                continue;
            }

            if (numeroAtividade < 1 || numeroAtividade > listaPre.size()) {
                System.out.println("Número de atividade inválido!");
                continue;
            }

            System.out.print("Digite as horas declaradas: ");
            int horas;
            try {
                horas = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Horas inválidas! Atividade não adicionada.");
                scanner.nextLine();
                continue;
            }

            modalidade.adicionarAtividadePredefinida(numeroAtividade - 1, horas);
            System.out.println("Atividade adicionada com sucesso!");
        }
        
        if (regrasCombinadas.isSatisfiedBy(listaModalidade)) {
            System.out.println("\nO aluno cumpriu a carga horária exigida de 80 horas.\n");
        } else {
            System.out.println("\nO aluno não cumpriu a carga horária exigida de 80 horas.\n");
        }

        scanner.close();
    }
}
