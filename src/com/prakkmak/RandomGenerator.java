package com.prakkmak;

import java.util.Random;

public class RandomGenerator {
    private static final String SEED = "Babar";
    private static Random random;
    public static Random getInstance(){
        if(null == random){
            random = new Random(SEED.hashCode());
        }
        return random;
    }
}
