package com.gerardo.xmen.mutant.repository;

import com.gerardo.xmen.mutant.entity.DnaMutant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DnaMutantRespositoryImpl implements DnaMutantRepository{

    private DnaMutantCrudRepository dnaMutantCrudRepository;

    public  DnaMutantRespositoryImpl (DnaMutantCrudRepository dnaMutantCrudRepository){this.dnaMutantCrudRepository = dnaMutantCrudRepository;}

    @Override
    public List<DnaMutant> getStatMutant() {
        return (List<DnaMutant>) dnaMutantCrudRepository.findAll();
    }

    @Override
    public DnaMutant save(DnaMutant dnaMutant) {
        DnaMutant dnaMutantFound = dnaMutantCrudRepository.findByhashId(dnaMutant.getHashId());
        if(dnaMutantFound==null){
            return dnaMutantCrudRepository.save(dnaMutant);
        }else{
            return dnaMutantFound;
        }
    }

    @Override
    public Integer countDnaMutant(boolean isMutant) {
        Optional<List<DnaMutant>> dnaMutants = dnaMutantCrudRepository.findByMutant(isMutant);
        return dnaMutants.isPresent()?dnaMutants.get().size():0;
    }


}
