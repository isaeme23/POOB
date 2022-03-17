package domain;
import java.util.*;

/*No olviden adicionar la documentacion*/
public class CellularAutomata{
    static private int LENGTH=30;
    private Item[][] automata;

    public CellularAutomata() {
        automata=new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automata[r][c]=null;
            }
        }
        someItems();
    }

    public int  getLength(){
        return LENGTH;
    }

    public Item getItem(int r,int c){
        return automata[r][c];
    }

    public void setItem(int r, int c, Item e){
        automata[r][c]=e;
    }

    public void someItems(){
        Cell a007 = new Cell(this, 2, 2);
        Cell indiana = new Cell(this, 1, 1);
        Inquieta agamenon = new Inquieta(this, 3, 3);
        Inquieta venus = new Inquieta(this, 10, 10);
        Bulb noreste = new Bulb(this, 0, 29);
        Bulb sureste = new Bulb(this, 29, 29);
    }

    public void ticTac(){
        for(Item[] items: automata) {
            for(Item item: items) {
                if(item != null){
                    item.decide();
                }
            }
        }
        for(Item[] items: automata) {
            for(Item item: items) {
                if(item != null) {
                    item.change();
                }
            }
        }
    }
    
    public ArrayList<Item> vecinas(int row, int column){
        ArrayList<Item> vecinas = new ArrayList<Item>();
        for (int i = 0; i < LENGTH; i++){
            for (int j = 0; j < LENGTH; j++){
                int first = (row - i)*(row - i);
                int second = (column - j)*(column - j);
                double result = Math.sqrt(first + second);
                if (result < 1.5 && automata[i][j] != null){
                    vecinas.add(automata[i][j]);
                }
            }
        }
        return vecinas;
    }
    
    public int vecinaDead(int row, int column){
        ArrayList<Item> vecinas = new ArrayList<Item>();
        vecinas = vecinas(row, column);
        int dead = 0;
        for (Item i: vecinas){
            if (i != null){
                if (i.isAlive() == false){
                dead++;
                }
            }
        }
        return dead;
    }
}
