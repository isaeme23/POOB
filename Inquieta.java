package domain;
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class Inquieta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inquieta extends Agent implements Item{
    // instance variables - replace the example below with your own
    protected char nextState;
    protected Color color;
    private CellularAutomata automata;
    private int row,column;

    /**
     * Constructor for objects of class Inquieta
     */
    public Inquieta(CellularAutomata ac,int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        nextState=Agent.ALIVE;
        automata.setItem(row,column,(Item)this);
        color=Color.orange;
    }
    
    /**Returns the row
    @return 
     */
    public final int getRow(){
        return row;
    }

    /**Returns tha column
    @return 
     */
    public final int getColumn(){
        return column;
    }
    
    /**Returns the color
    @return 
     */
    public final Color getColor(){
        return color;
    }

    /**
     * Decides 
     */
    public void decide(){
        int dead = automata.vecinaDead(this.getRow(), this.getColumn());
        ArrayList<Item> number = automata.vecinas(this.getRow(), this.getColumn());
        int tamano = number.size();
        if (dead > 0 && getAge() > 1){
            nextState=Agent.DEAD;
        }
        if (tamano == 1 && getAge() > 0){
            nextState=Agent.ALIVE;
            if (this.getRow() != 0){
                new Inquieta(automata, this.getRow() + 1, this.getColumn());
            }
            if (this.getRow() != automata.getLength()){
                new Cell(automata, this.getRow() - 1, this.getColumn());
            }
        }
    }
    
    public int prueba(){
        ArrayList<Item> number = automata.vecinas(this.getRow(), this.getColumn());
        int tamano = number.size();
        return tamano;
    }
    
    public final void change(){
        turn();
        state=nextState;
    }
}
