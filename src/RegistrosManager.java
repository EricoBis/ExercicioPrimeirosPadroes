//[Antiga classe Consultas.java]

import java.util.*;

// --> Implementa "IRepository<RegistroDoTempo>" pois trabalha com objetos RegistroDoTempo
public class RegistrosManager implements IRepository<RegistroDoTempo>{
    private IRepository<RegistroDoTempo> repository;

    // --> Aceitar um objeto que implemente a interface
    public RegistrosManager(IRepository<RegistroDoTempo> repository){
        this.repository = repository;
    }

    // --> Todos os métodos utilizam/devem utilizar a interface
    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        // --> Utiliza a interface para acessar os registros
        return repository.getRegistros()
                .stream()
                .filter(r->r.getPrecipitacao() > milimetros)
                .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
                .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = repository.getRegistros()
                .stream()
                .filter(reg -> reg.getAno() == ano)
                .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
                .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", " + registro.getPrecipitacao();
        return resp;
    }
    @Override
    public Collection<RegistroDoTempo> getRegistros() {
        return repository.getRegistros();
    }
}
