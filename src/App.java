public class App {
    public static void main(String[] args) {
        IRepository<RegistroDoTempo> repository = new RegistrosRepository("poa_temps.txt");
        RegistrosManager registros = new RegistrosManager(repository);

        //output
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(registros.diaQueMaisChoveuNoAno(1980));

        System.out.println("Datas em que choveu mais de 90 milimetros");
        registros.datasEmQueChouveuMaisDe(90)
             .forEach(System.out::println);
    }
}
