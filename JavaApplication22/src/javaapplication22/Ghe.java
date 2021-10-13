/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

/**
 *
 * @author Quan Dau
 */
public class Ghe {
   
    private int sold;
    private int block;


    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Ghe() {
    }

    public Ghe(int sold, int block) {
        
        this.sold = sold;
        this.block = block;
    }
    
    
}
