import java.util.Collection;

public interface IRepository<T> {
    Collection<T> getRegistros();
}