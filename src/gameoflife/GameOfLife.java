package gameoflife;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfLife {

    static final int WIDTH = 50;
    static final int HEIGHT =50;
    ArrayList<Character> gridRow=new ArrayList<Character>();
    ArrayList<ArrayList> grid=new ArrayList<ArrayList>();
    
    static final char deadCell = '.';
    static final char liveCell = '*';

    String state;
    Character tempChar;

    
    public static void main(String[] args) { 
        
     new GameOfLife();
    
    }
            
    
    public GameOfLife() {
 
       setState();
       turn(); 
    }
    
     
//METHODS
    
     private void turn() {
         
         //set new grid
       
        ArrayList<ArrayList> newGrid=new ArrayList<ArrayList>(grid.size());

        for (int x = 0; x < grid.size(); x++) {
             for (int y = 0; y < grid.size(); y++) {
                 
                 int count = 0;
                 
                 if (y > 0 && grid[x][y-1] == liveCell) {
                     count++;
                 }
                 
                  if (x > 0 && grid[x-1][y] == liveCell) {
                     count++;
                 }
                  
                    if (y > 0 && grid[x][y+1] == liveCell) {
                     count++;
                 }
                 
                  if (x > 0 && grid[x+1][y] == liveCell) {
                     count++;
                 }
                  
                  if (y < grid.size - 1 && x < grid.size - 1 && grid[x+1][y+1] == liveCell) {
                     count++;
                 }
                  
                   if (y < grid.size - 1 && x < grid.size - 1 && grid[x-1][y+1] == liveCell {
                     count++;
                 }
                   
                    if (y < grid.size - 1 && x < grid.size - 1 && grid[x+1][y-1] == liveCell) {
                     count++;
                 }
                    
                     if (y < grid.size - 1 && x < grid.size - 1 && grid[-1][y-1] == liveCell) {
                     count++;
                 }
                 
                  
                  if (grid[x][y] == liveCell) {
                      if (count == 2 || count == 3) {
                          newGrid[x][y] = liveCell;
                      } else {
                          newGrid[x][y] = deadCell;
                      }
                  } else {
                  
                  if (grid[x][y] == liveCell) {
                      if (count < 2) {
                          newGrid[x][y] = deadCell;
                      } else {
                          newGrid[x][y] = liveCell;
                      }
                  }
                  
                  else {
                  
                  if (grid[x][y] == liveCell) {
                      if (count > 3) {
                          newGrid[x][y] = deadCell;
                      } else {
                          newGrid[x][y] = liveCell;
                      }
                  }
                  
                  
                  }
                  
                  }  
                  
             }
             
             grid = newGrid;

        }
    }

    
    public void setState(){
       
        //get string input
        
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the intial state of your Game of life grid: ");
        String state = in.nextLine();
       //..*.*..newLine.*....*newLine.*....*
       String[] rows = state.split("newLine");
            for (int i = 0; i < rows.length; i++) {
            
                 char[] temp = rows[i].toCharArray();  

                    for (int k = 0; k < temp.length; k++) {
           
                         Character tempChar = temp[k];
                         gridRow.add(k, tempChar);

       }
      
                    for (int l = 0; l < rows.length; l++) {
                         grid.add(l, gridRow);
       }
       }
       
                   System.out.println(grid);

        }
    
}