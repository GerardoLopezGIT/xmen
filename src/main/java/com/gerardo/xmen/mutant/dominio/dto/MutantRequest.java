package com.gerardo.xmen.mutant.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class MutantRequest implements Serializable {

    private String [] dna;
}
