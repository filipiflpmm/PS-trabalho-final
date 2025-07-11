package ifsc.projetoatividadecomplementar;
import java.util.*;

public class Modalidade {
    private int codigo;
    private String nome;
    private List<Atividade> atividades;
    private List<AtividadePredefinida> atividadesPreDefinidas;

    public Modalidade(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.atividades = new ArrayList<>();
        this.atividadesPreDefinidas = carregarAtividadesPreDefinidas(codigo);
    }

    public void adicionarAtividade(String nome, int horas, int limite) {
        atividades.add(new Atividade(nome, horas, limite));
    }

    public void adicionarAtividadePredefinida(int indice, int horasDeclaradas) {
        if (indice >= 0 && indice < atividadesPreDefinidas.size()) {
            AtividadePredefinida pre = atividadesPreDefinidas.get(indice);
            atividades.add(new Atividade(pre.getNome(), horasDeclaradas, pre.getLimiteHoras()));
        }
    }

    private List<AtividadePredefinida> carregarAtividadesPreDefinidas(int codigo) {
        List<AtividadePredefinida> lista = new ArrayList<>();
        switch (codigo) {
            case 1:
                lista.add(new AtividadePredefinida("Disciplinas cursadas com aproveitamento, não previstas no currículo do curso.", 80));
                lista.add(new AtividadePredefinida("Semana acadêmica dos cursos, quando não obrigatória.", 40));
                lista.add(new AtividadePredefinida("Participação em atividades de monitoria.", 70));
                lista.add(new AtividadePredefinida("Atividades realizadas em laboratórios e/ou oficinas do Instituto.", 40));
                lista.add(new AtividadePredefinida("Visita Técnica relacionada à área.", 40));
                lista.add(new AtividadePredefinida("Participação em cursos de qualificação na área afim do curso com certificado de aproveitamento.", 80));
                lista.add(new AtividadePredefinida("Participação como ouvintes em bancas de projetos integradores de assuntos relacionados à área.", 20));
                lista.add(new AtividadePredefinida("Participação como ouvintes em bancas de TCC, dissertações ou teses de assuntos relacionados à área.", 20));
                lista.add(new AtividadePredefinida("Desenvolvimento de material didático ou instrucional.", 30));
                lista.add(new AtividadePredefinida("Instrutor de cursos abertos à comunidade.", 70));
                break;
            case 2:
                lista.add(new AtividadePredefinida("Participação em programa ou projeto de pesquisa relacionados à área.", 60));
                lista.add(new AtividadePredefinida("Apresentação de projeto de pesquisa relacionado à área.", 20));
                lista.add(new AtividadePredefinida("Autoria e coautoria em artigo publicado em Periódico na área afim.", 30));
                lista.add(new AtividadePredefinida("Livro na área afim.", 100));
                lista.add(new AtividadePredefinida("Capítulo de livro na área afim.", 30));
                lista.add(new AtividadePredefinida("Publicação em Anais de Evento Técnico Científico.", 30));
                lista.add(new AtividadePredefinida("Apresentação de trabalho em Evento Técnico Científico.", 20));
                lista.add(new AtividadePredefinida("Participação de Programa de Iniciação Científica.", 60));
                lista.add(new AtividadePredefinida("Participação como palestrante, conferencista, integrante de mesa-redonda, ministrante de mini-curso em evento científico.", 60));
                lista.add(new AtividadePredefinida("Prêmios concedidos por instituições acadêmicas, científicas e profissionais.", 60));
                lista.add(new AtividadePredefinida("Participação na criação de produto, processo ou propriedade intelectual.", 200));
                lista.add(new AtividadePredefinida("Participação em grupo de pesquisa certificado.", 60));
                break;
            case 3:
                lista.add(new AtividadePredefinida("Participação em programa ou projeto de extensão.", 60));
                lista.add(new AtividadePredefinida("Apresentação de projeto de extensão.", 20));
                lista.add(new AtividadePredefinida("Participação em ações sociais cívicas e comunitárias.", 40));
                lista.add(new AtividadePredefinida("Texto em jornal ou revista da área.", 40));
                lista.add(new AtividadePredefinida("Intercâmbio com instituições de ensino no Brasil ou no exterior.", 100));
                lista.add(new AtividadePredefinida("Estágio não-obrigatório na área do curso, formalizado pelo IFSC.", 100));
                lista.add(new AtividadePredefinida("Exercício profissional com vínculo empregatício, desde que na área do curso.", 100));
                break;
            case 4:
                lista.add(new AtividadePredefinida("Participação em congressos, jornadas, simpósios, fóruns, seminários, encontros, palestras, festivais e similares, com certificado de aproveitamento e/ou frequência.", 20));
                lista.add(new AtividadePredefinida("Comissão organizadora de congressos, jornadas, simpósios, fóruns, seminários, encontros, palestras, festivais e similares.", 20));
                lista.add(new AtividadePredefinida("Premiação em eventos que tenham relação com os objetos de estudo do curso.", 30));
                lista.add(new AtividadePredefinida("Curso de língua estrangeira.", 80));
                lista.add(new AtividadePredefinida("Premiação em atividades esportivas como representante do Instituto.", 60));
                lista.add(new AtividadePredefinida("Representação estudantil em colegiado, grêmio estudantil, centro acadêmico, comissão de formatura, associação esportiva e afins.", 40));
                lista.add(new AtividadePredefinida("Representação de turma (inclui a participação em conselhos de classe horas).", 30));
                lista.add(new AtividadePredefinida("Participação em Empresa Júnior.", 40));
                lista.add(new AtividadePredefinida("Classificação em concursos culturais.", 20));
                lista.add(new AtividadePredefinida("Participação em projetos sociais, trabalho voluntário em entidades vinculadas a compromissos sociopolíticos.", 20));
                lista.add(new AtividadePredefinida("Desenvolvimento de atividades socioculturais, artísticas e esportivas (coral, música, dança, bandas, vídeos, cineclubes, teatro, entre outros eventos sociais horas).", 20));
                break;
        }
        return lista;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public List<AtividadePredefinida> getAtividadesPreDefinidas() {
        return atividadesPreDefinidas;
    }

    public int getTotalDeclarado() {
        return atividades.stream().mapToInt(Atividade::getHorasDeclaradas).sum();
    }

    public int getTotalValidado() {
        return atividades.stream().mapToInt(Atividade::getHorasValidadas).sum();
    }

    @Override
    public String toString() {
        return "Modalidade " + codigo + " - " + nome;
    }
}