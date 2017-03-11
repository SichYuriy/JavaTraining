package com.gmail.at.sichyuriyy.javatraining.homework4.task21;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class ElfTest {

    @Test
    public void moveGround() {
        Elf elf = new Elf();
        assertTrue(elf.move(true));
    }

    @Test
    public void moveAir() {
        Elf elf = new Elf();
        assertTrue(elf.move(false));
    }

}