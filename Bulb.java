package domain;
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class Bulb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bulb extends Agent implements Item{
    protected char nextState;
    protected Color color;
    private CellularAutomata automata;
    private int row,column;

    /**
     * Constructor for objects of class Bulb
     */
    public Bulb(CellularAutomata ac,int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        nextState=Agent.ALIVE;
        automata.setItem(row,column,(Item)this);	
        color=Color.yellow;
    }
    
    public final Color getColor(){
        return color;
    }
    public int shape(){
        int shape = 0;
        if (getAge() % 2 == 0){
            shape = ROUND;
        } else{
            shape = SQUARE;
        }
        return shape;
    }
    
    public void decide(){
        if (getAge() > 100){
            color=Color.gray;
            turn();
            turn();
        }
    }
    
    public final void change(){
        turn();
        shape();
        state=nextState;
    }
}
