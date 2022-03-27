package com.gerardo.xmen.mutant.services;

import com.gerardo.xmen.mutant.dominio.dto.MutantRequest;
import com.gerardo.xmen.mutant.dominio.dto.MutantResponse;
import com.gerardo.xmen.mutant.dominio.dto.ResponseStats;
import com.gerardo.xmen.mutant.entity.DnaMutant;
import com.gerardo.xmen.mutant.repository.DnaMutantRepository;
import com.gerardo.xmen.mutant.utils.ArrayUtil;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService{

    private String [][] dnaD2;
    private int chainDNAMutant;
    private String partChain;
    private DnaMutantRepository dnaMutantRepository;

    public MutantServiceImpl(DnaMutantRepository dnaMutantRepository){this.dnaMutantRepository = dnaMutantRepository;}

    @Override
    public MutantResponse isMutant(MutantRequest mutantRequest) {
        return new MutantResponse(isMutant(mutantRequest.getDna()));
    }

    @Override
    public boolean isMutant(String[] dna) {
        dnaD2 = ArrayUtil.convertToArray2D(dna);
        String dnaString = ArrayUtil.convertListStrToString(dna);
        chainDNAMutant=0;
        finished:
        for (int i = 0; i < dnaD2.length; i++) {
            for (int j = 0; j < dnaD2[0].length; j++) {
                partChain = findSequenceADN(i, j);
                findNextPositionXY(i, j);
                findNextPositionX(i,j);
                findNextPositionY(i,j);
                if (chainDNAMutant >1) break finished;
            }
        }
        DnaMutant dnaMutant = new DnaMutant();
        if (chainDNAMutant >1) {

            dnaMutant.setDna(dnaString);
            dnaMutant.setMutant(true);
            dnaMutant.setHashId(dnaString.hashCode());
            dnaMutantRepository.save(dnaMutant);
            return true;
        }else {

            dnaMutant.setDna(dnaString);
            dnaMutant.setMutant(false);
            dnaMutant.setHashId(dnaString.hashCode());
            dnaMutantRepository.save(dnaMutant);
            return false;
        }
    }

    /**
     * Metodo que busca un eslabon de cadena de ADN
     * @param positionX
     * @param positionY
     * @return
     */
    public String findSequenceADN(int positionX, int positionY){
        return dnaD2[positionX][positionY];
    }

    /**
     * Metodo para buscar las coincidencias de eslbones de manera vertical
     * @param positionX
     * @param positionY
     */
    public void findNextPositionX(int positionX, int positionY){
        int cntChainParts= 0;
        do{
            cntChainParts++;
            positionX++;
        }while (positionY<dnaD2.length && positionX <dnaD2[1].length-1
                && partChain.equalsIgnoreCase(findSequenceADN(positionX,positionY)));
        if(cntChainParts>=4)
            chainDNAMutant++;
    }

    /**
     * Metodo para buscar las coincidencias de eslbones de manera horizontal
     * @param positionX
     * @param positionY
     */
    public void findNextPositionY(int positionX, int positionY){
        int cntChainParts= 0;
        do{
            cntChainParts++;
            positionY++;
        }while (positionY<dnaD2.length && positionX <dnaD2[1].length-1
                && partChain.equalsIgnoreCase(findSequenceADN(positionX,positionY)));
        if(cntChainParts>=4){
            chainDNAMutant++;
        }
    }

    /**
     * Metodo para buscar las coincidencias de eslbones de manera oblicua o diagonal
     * @param positionX
     * @param positionY
     */
    public void findNextPositionXY(int positionX, int positionY){
        int cntChainParts= 0;
        do{
            cntChainParts++;
            positionY++;
            positionX++;
        }while(positionY<dnaD2.length && positionX <dnaD2[1].length-1
                    && partChain.equalsIgnoreCase(findSequenceADN(positionX,positionY)));
        if(cntChainParts>=4)
            chainDNAMutant++;
    }

    public ResponseStats getDnaStats(){
        int mutants = dnaMutantRepository.countDnaMutant(true);
        int humans = dnaMutantRepository.countDnaMutant(false);
        return ResponseStats.builder().countMutant(mutants)
                .countHuman(humans)
                .ratio((double) (mutants/humans)).build();
    }

}
