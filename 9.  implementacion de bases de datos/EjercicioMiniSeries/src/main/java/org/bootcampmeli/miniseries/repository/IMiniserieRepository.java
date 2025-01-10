package org.bootcampmeli.miniseries.repository;

import org.bootcampmeli.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie,Long> {

}
