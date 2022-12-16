package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */


    public GameOfLife (String file) {

        // WRITE YOUR CODE HERE

        //read the file (ASK PROFESSOR ABOUT STDIN.SETFILE())
        //followed by StdIn.ReadInt
        

        StdIn.setFile(file); // reads input grid txt file

        //set r equal to first line? num of rows
        //set c equal to second line, num of columns

        int r = StdIn.readInt(); //rows
        int c = StdIn.readInt(); //columns 

        grid = new boolean[r][c]; // creates boolean grid to see if alive or dead.

        //make a while loop
        /*
         * While the file is not at the end 
         * read the line
         * convert the line
         * add it to the grid object
         * 
         * 
         * 
         */

        
        // while(!(StdIn.isEmpty())){
            // Boolean v = StdIn.readBoolean();


            

        // }

        

        for (int i=0; i<r; i++){
            // read line
            for (int j=0; j<c; j++){ // these 2 for loops are correct and give a 3x4.
                grid[i][j] = StdIn.readBoolean();
                if( grid[i][j]== ALIVE){
                    totalAliveCells++;
                }
                // if (value.equalsIgnoreCase("true")){
                    //System.out.println(grid[i][j] = StdIn.readBoolean());
                //}
                //else{
                   // System.out.println(grid[i][j] = StdIn.readBoolean());
                //}
                // code that I might use later:

                // if value .equals("false3333")
               // gridRectangle[r][c] = new Rectangle();
                // gridRectangle[r][c].setWidth(r); // sets width
                // gridRectangle[r][c].setHeight(c); // sets height
               // gridRectangle[r][c].setFill(null);
               // file += grid[r][c] + " ";
               // System.out.println(file);

            }
            System.out.println(); // space seperated
        }
    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {

        // WRITE YOUR CODE HERE

        // this method works completely.

        // so basically if specific row and column is ALIVE return true, if not return false.
        // for (int i =0; i<row; i++){
        //     for(int j =0; j<col; j++){
        //         if (grid[row][col]==ALIVE){ // rows and columns are right.
        //             return true;
        //         }
        //         else if (grid[row][col]==DEAD){
        //             return false;
        //         }
        //     }
        // }
        // ^ this mostly works, howevr top left and top right say alive when it should be dead.



        //if(!row == ALIVE && !col == ALIVE){ // delete this when trying to run it.
            //return false;
        //}
        return grid[row][col]; // update this line, provided so that code compiles
        // ^ statement so it can return something
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {

        // WRITE YOUR CODE HERE
        for (int i=0; i<grid.length; i++){
            for (int j =0; j<grid[i].length; j++){
                if (grid[i][j]== ALIVE && totalAliveCells>=1){ // if any alive cells in the grid.
                    return true;
                }
                else if (grid[i][j]== DEAD && totalAliveCells<1){ // if there's no alive cells in the grid.
                    return false;
                }
            }
        }
        // ^ pretty sure I can simplify this, but don't touch this for now.


        return false; // just to return something.
         // update this line, provided so that code compiles
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {
        // WRITE YOUR CODE HERE

        //need help with this

        // make one for edge cases:

        int count = 0;
        int rows1[] = new int[3];
        int columns1[] = new int[3];
        rows1[1] = row; // 1 is the middle so row is the position.
        columns1[1] = col; //1 is the middle so col is the position.

        if (row==0){ // if at first row
            rows1[0] =grid.length-1;
        }
        else{
            rows1[0]= row-1;
        }
        if (col==0){ // if at first col
            columns1[0]=grid[row].length-1;
        }
        else{
            columns1[0] = col-1;
        }
        if (row==grid.length-1){ // if at last row
            rows1[2]=0;
        }
        else{
            rows1[2]=row+1;

        }
        if (col ==grid[row].length-1){ // if at last col
            columns1[2]=0;
        }
        else{
            columns1[2] = col+1;
            
        }

        for(int i =0; i<rows1.length; i++){
            for(int j =0; j<columns1.length; j++){
                if ((i!=1 || j!=1)&& (grid[rows1[i]][columns1[j]]==ALIVE)){
                    count++;
                }
            }
        }


        //make one for normal alive cells:



        // old code:

        // for (int i=row-1; i<row+2; i++){
        //     for (int j=col-1; j<col+2; j++){
        //         // one more if statement needed for edge cases
        //         if (!((i<0 || j<0) || (i>=grid.length || j>= grid[i].length))){
        //             if(grid[i][j]==ALIVE){
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // if (grid[row][col]==DEAD){
        //     count+=1;
        // }
        // if (count==0){
        //     return 0;
        // }
        // if (count>=8){
        //     return 8;
        // }

        return count;// subtract 1 bc we already subtract one from row and col and add 2 to both conditional statements.
        // update this line, provided so that code compiles
    }

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {

        // WRITE YOUR CODE HERE
        
        //Rule 1: Alive cells with no neighbors or one neighbor die of loneliness.
        boolean newGrid1[][] = new boolean [grid.length][grid[0].length];

        for (int i =0; i<grid.length; i++){ // makes newgrid = grid (assigns the values to them).
            for (int j=0; j<grid[i].length; j++){
                newGrid1[i][j] = grid[i][j];
                int neighboringCells = numOfAliveNeighbors(i, j);
                if (newGrid1[i][j]==ALIVE){ //Rule 1: Alive cells with no neighbors or one neighbor die of loneliness.
                    if (neighboringCells<=1 || neighboringCells >3){
                        newGrid1[i][j] = DEAD;
                    }
                    if((neighboringCells==2) || neighboringCells==3){ //Rule 3: Alive cells with two or three neighbors survive.
                        newGrid1[i][j] = ALIVE;
                    }
                }
                else if (newGrid1[i][j]==DEAD){ //Rule 2: Dead cells with exactly three neighbors become alive by reproduction.
                    if (neighboringCells==3){
                        newGrid1[i][j] = ALIVE;
                    }
                }
            }

        }





        // for (int i =0; i<grid.length; i++){ // <<<<<< loops through grid
        //     for (int j =0; j<grid[i].length; j++){
        //         if (grid[i][j]==ALIVE){ // could pass in I and J into numOfAliveNeighbors method to call it.
        //             if (numOfAliveNeighbors(i, j)<=1){
        //                 return grid; // returns empty grid (die of loneliness).
        //             }
        //             //Rule 3: Alive cells with two or three neighbors survive.
        //             if (numOfAliveNeighbors(i, j)==2 || numOfAliveNeighbors(i, j)==3){
        //                 return grid; // they survive so they stay the same.
        //             }
        //             //Rule 4: Alive cells with four or more neighbors die of overpopulation.
        //             if (numOfAliveNeighbors(i, j)>=4){
        //                 return grid; //ALIVE
        //             }
        //         }
        //         //Rule 2: Dead cells with exactly three neighbors become alive by reproduction.
        //         if (grid[i][j]==DEAD){
        //             if (numOfAliveNeighbors(i, j)==3){
        //                 return grid; //ALIVE
        //             }
        //         }

        //     }
        // }

        // //Rule 4: Alive cells with four or more neighbors die of overpopulation.



        
        return newGrid1;// update this line, provided so that code compiles
    }

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {

        // WRITE YOUR CODE HERE

        // updates the grid instance variable by calling computeNewGrid(). Updates the totalAliveCells instance variable.
        grid = computeNewGrid();
        for (int i=0; i<grid.length; i++){
            for (int j =0; j<grid[i].length; j++){
                if (grid[i][j]==ALIVE){
                    totalAliveCells++;
                }
            }
        }
    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        // WRITE YOUR CODE HERE;
        for (int i =0; i<n; i++){
            grid= computeNewGrid();
        }


        // n represents the amount of generations the user wants.


    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {

        // WRITE YOUR CODE HERE


        // Need to create a union QuickUnionFind object to use methods for union & find:
        WeightedQuickUnionUF finder = new WeightedQuickUnionUF(grid.length, grid[0].length);

        int row;
        int col;

        //copied code:
        int rows1[] = new int[3];
        int columns1[] = new int[3];
        // rows1[1] = row; // 1 is the middle so row is the position. // coordinate
        // columns1[1] = col; //1 is the middle so col is the position. // coordinate

        //ArrayList:
        ArrayList<Integer> amountOfCommunities = new ArrayList<Integer>();
        //for loops:
        for (int a =0; a<grid.length; a++){
            for (int b =0; b<grid[a].length; b++){
                if (grid[a][b]==ALIVE){
                    row =a;
                    col = b;

                    rows1[1] = row; // 1 is the middle so row is the position. // coordinate
                    columns1[1] = col;

                    if (row==0){ // if at first row
                        rows1[0] =grid.length-1;
                    }
                    else{
                        rows1[0]= row-1;
                    }
                    if (col==0){ // if at first col
                        columns1[0]=grid[row].length-1;
                    }
                    else{
                        columns1[0] = col-1;
                    }
                    if (row==grid.length-1){ // if at last row
                        rows1[2]=0;
                    }
                    else{
                        rows1[2]=row+1;
            
                    }
                    if (col ==grid[row].length-1){ // if at last col
                        columns1[2]=0;
                    }
                    else{
                        columns1[2] = col+1;
                        
                    }
                   

                    // System.out.println("Base: " + a + "," + b);

                    for (int i =0; i<rows1.length; i++){
                        for (int j = 0; j<columns1.length; j++){

                            // System.out.println("Comparing Row: " + rows1[i]);
                            // System.out.println("Comparing Col: " + columns1[j]);

                            if ((i!=1 || j!=1) && (grid[rows1[i]][columns1[j]]==ALIVE)){
                               
                                // System.out.print(" Found an Alive Cell");
                                finder.union(rows1[i],columns1[j],a,b); // joins together cells
                            }
                        }
                    }
                    
                }
            }
        }

        for (int a =0; a<grid.length; a++){
            for (int b =0; b<grid[a].length; b++){

                int setAmount = finder.find(a,b);

                if (amountOfCommunities.indexOf(setAmount)<0 && getCellState(a, b)){
                    amountOfCommunities.add(setAmount);
                }

            }
        }
        
        return amountOfCommunities.size(); // update this line, provided so that code compiles
    }
}
