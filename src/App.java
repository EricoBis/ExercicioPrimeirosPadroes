
public class App {
    public static void main(String[] args) {
        ConsultasRepository consultas = new ConsultasRepository();
        consultas.carregaDados();
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        // System.out.println(consultas.diaQueMaisChoveuNoAno(1980));
        // System.out.println("Datas em que choveu mais de 90 milimetros");
        // consultas.datasEmQueChouveuMaisDe(90)
        //     .forEach(System.out::println);
    }

    /*
     
    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return registros
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }
     */
}
