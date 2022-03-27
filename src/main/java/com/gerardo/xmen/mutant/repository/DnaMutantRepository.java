package com.gerardo.xmen.mutant.repository;

import com.gerardo.xmen.mutant.entity.DnaMutant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DnaMutantRepository  {

    List<DnaMutant> getStatMutant();
    DnaMutant save(DnaMutant dnaMutant);
    Integer countDnaMutant(boolean isMutant);

}
