package one.digitalinnovation.gof.model.ListaPresentes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListasPresentesRepository extends CrudRepository<ListasPresentes, Long> {
}
