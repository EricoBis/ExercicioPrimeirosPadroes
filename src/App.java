import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.List;

public class App {
    public static void main(String[] args) {
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

        List<RegistroData> datas = registros.diasEmQue();
        System.out.println(datas);
        registros.alteraConsultaPadrao(menorQue);
        List<RegistroData> datas2 = registros.diasEmQue();
        System.out.println(datas2);

    }
}
