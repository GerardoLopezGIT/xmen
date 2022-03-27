package com.gerardo.xmen.mutant.services;

import com.gerardo.xmen.mutant.dominio.dto.MutantRequest;
import com.gerardo.xmen.mutant.dominio.dto.MutantResponse;
import com.gerardo.xmen.mutant.dominio.dto.ResponseStats;

public interface MutantService {

    boolean isMutant(String[] dna);
    MutantResponse isMutant(MutantRequest mutantRequest);
    ResponseStats getDnaStats();
}
