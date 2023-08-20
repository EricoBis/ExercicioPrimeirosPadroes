//[Antiga classe Consultas.java]

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class RegistrosManager {
    private Predicate<RegistroDoTempo> predicate;
    private IRepository<RegistroDoTempo> repository;

    // --> Aceitar um objeto que implemente a interface
    public RegistrosManager(IRepository<RegistroDoTempo> repository, Predicate<RegistroDoTempo> predicate) {
        this.repository = repository;
        this.predicate = predicate;

    }

    // --> Todos os métodos utilizam/devem utilizar a interface
    public List<String> datasEmQueChouveuMaisDe(double milimetros) {
        // --> Utiliza a interface para acessar os registros
        return repository.getRegistros()
                .stream()
                .filter(r -> r.getPrecipitacao() > milimetros)
                .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
                .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = repository.getRegistros()
                .stream()
                .filter(reg -> reg.getAno() == ano)
                .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
                .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", "
                + registro.getPrecipitacao();
        return resp;
    }

    
    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        this.predicate = consulta;
    }

    
    public List<RegistroData> diasEmQue() {
        List<RegistroData> datas = new LinkedList<>();
        datas = repository.getRegistros().stream()
                .filter(predicate).map(registro -> new RegistroData(registro.getDia(), registro.getMes(), registro.getAno()))
                .collect(Collectors.toList());
        return datas;
    }
}
