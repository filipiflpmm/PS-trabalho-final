package ifsc.projetoatividadecomplementar;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parecer {
    
    public static void gerarParecer(Aluno aluno, ListaModalidade lista) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataAtual = LocalDate.now().format(formatador);

        int[] limitesValidacao = {32, 32, 32, 16};
        int totalDeclarado = 0;
        int totalValidado = 0;

        System.out.println("\n=== PARECER DE VALIDAÇÃO ===");
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Data emissão: " + dataAtual);

        for (Modalidade m : lista.getTodas()) {
            System.out.printf("\nModalidade %d-%s:\n", m.getCodigo(), m.getNome());

            if (m.getAtividades().isEmpty()) {
                System.out.println("Nenhuma atividade declarada para esta modalidade.\n");
            } else {
                for (Atividade a : m.getAtividades()) {
                    System.out.println("Atividade: " + a.getNome());
                    System.out.println("Horas declaradas: " + a.getHorasDeclaradas() + "h");
                    System.out.println("Limite Máximo: " + a.getLimiteHoras() + "h");
                    System.out.println("Horas validadas: " + a.getHorasValidadas() + "h");
                    System.out.println("Observação: " + a.gerarObservacao());
                    System.out.println();
                }
            }

            int index = m.getCodigo() - 1;
            int validadoAjustado = Math.min(m.getTotalValidado(), limitesValidacao[index]);
            totalValidado += validadoAjustado;
            totalDeclarado += m.getTotalDeclarado();
        }

        System.out.println("\nResumo geral:");
        System.out.println("Total de horas declaradas: " + totalDeclarado + "h");
        System.out.println("Total de horas validadas (ajustadas conforme limite por modalidade): " + totalValidado + "h");
        
    }
}