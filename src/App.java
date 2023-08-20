import java.util.function.Predicate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //predicates
        Predicate<RegistroDoTempo> maiorQue = registro -> registro.getTempMaxima() > 35;
        Predicate<RegistroDoTempo> menorQue = registro -> registro.getTempMinima() < 5;

        IRepository<RegistroDoTempo> repository = new RegistrosRepository("poa_temps.txt");
        RegistrosManager registros = new RegistrosManager(repository, maiorQue);

        // output
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(registros.diaQueMaisChoveuNoAno(1980));

        System.out.println("Datas em que choveu mais de 90 milimetros");
        registros.datasEmQueChouveuMaisDe(90)
                .forEach(System.out::println);

        //Dias em que a temperatura máxima foi maior que 35 graus
        List<RegistroData> datas = registros.diasEmQue();
        System.out.println(datas);

        //Dias em que a temperatura mínima foi menor que 5 graus
        registros.alteraConsultaPadrao(menorQue);
        List<RegistroData> datas2 = registros.diasEmQue();
        System.out.println(datas2);

    }
}
