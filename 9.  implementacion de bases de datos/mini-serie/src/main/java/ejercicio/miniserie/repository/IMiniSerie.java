package ejercicio.miniserie.repository;

import ejercicio.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerie extends JpaRepository<MiniSerie, Long> {
}
