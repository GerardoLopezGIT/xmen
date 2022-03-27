package com.gerardo.xmen.mutant.controller;

import com.gerardo.xmen.mutant.dominio.dto.MutantRequest;
import com.gerardo.xmen.mutant.dominio.dto.MutantResponse;
import com.gerardo.xmen.mutant.dominio.dto.ResponseStats;
import com.gerardo.xmen.mutant.services.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;

import javax.print.attribute.standard.Media;


@RestController
@RequestMapping()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MutantRestController {

    MutantService mutantService;

    public MutantRestController(MutantService mutantService){this.mutantService = mutantService;}

    @PostMapping(path ="/mutant/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity isMutant(@RequestBody MutantRequest mutantRequest){
        if (mutantService.isMutant(mutantRequest).getIsMutant())
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @GetMapping(path = "/stats/")
    public ResponseEntity<ResponseStats> getDnaStats(){
        return new ResponseEntity<>(mutantService.getDnaStats(),HttpStatus.OK);
    }
}
