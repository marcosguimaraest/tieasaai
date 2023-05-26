package com.marcola.tieasaaiapp.repos;

import com.marcola.tieasaaiapp.model.Fase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRepository extends CrudRepository<Fase, String> {
    
}
