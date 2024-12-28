package org.lld.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Dice {
    private Integer size;

    public Integer rollDice(){
        Random random = new Random();
        return random.nextInt(size+1);
    }
}
