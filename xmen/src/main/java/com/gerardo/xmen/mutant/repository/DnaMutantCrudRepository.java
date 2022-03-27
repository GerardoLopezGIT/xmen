package com.gerardo.xmen.mutant.repository;

import com.gerardo.xmen.mutant.entity.DnaMutant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DnaMutantCrudRepository extends CrudRepository<DnaMutant,Integer> {
    DnaMutant findByhashId(Integer hashId) ;
    Optional<List<DnaMutant>> findByMutant(boolean isMutant);
}
