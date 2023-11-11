package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenteRepository extends CrudRepository<ProdutoPedido, Long> {
}
