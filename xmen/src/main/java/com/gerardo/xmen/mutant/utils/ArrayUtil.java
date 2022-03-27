package com.gerardo.xmen.mutant.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtil {
    /**
     * Metodo que convierte un arreglo de String en una matriz
     * @param array1D
     * @return adnArray2D
     */
    public static String [][]convertToArray2D (String [] array1D){
        String[][] adnArray2D =new String [array1D.length][array1D[1].length()];
        for (int i = 0; i < array1D.length; i++) adnArray2D[i] = array1D[i].split("");
        return adnArray2D;
    }
    public static String convertListStrToString(String [] array1D){
        return Arrays.asList(array1D).stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
