package com.gerardo.xmen.mutant.dominio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseStats {
    @JsonProperty("count_mutant_dna")
    private Integer countMutant;
    @JsonProperty("count_human_dna")
    private Integer countHuman;
    @JsonProperty("ratio")
    private Double ratio;

}
