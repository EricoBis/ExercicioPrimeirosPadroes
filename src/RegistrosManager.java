//[Antiga classe Consultas.java]

import java.util.*;
import java.util.function.Predicate;

import javax.xml.crypto.Data;

//TODO - criar predicate padrão

public class RegistrosManager{
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


    //TODO
    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta){
        //altera predicate padrão
    }

    //TODO
    public List<Data> diasEmQue(){
       //Este método deve retornar a lista de datas em que uma determinada condição se aplica. 
       //Esta condição deve ser implementada usando o padrão "strategy"
       
       //percorre a lista de registros, verificando qual se encaixa com a condição do predicate atual.
       //cria objetos do tipo Data quando dada condição é satisfeita, adicionando-os a uma lista.
       //retorna a lista de Data.
        return null;
    }
}
