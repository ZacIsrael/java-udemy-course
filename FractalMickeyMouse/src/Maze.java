public class Maze {

    public static void main(String[] args) {
      int[][] maze = createMaze(5,5);
        printMaze(maze);
        Turtle t = new Turtle();
        t.delay(2);
        

//      for (int i = 0; i < 15 ; i++) {
//            System.out.println(randOdd(   1,29));
//       }

    }
    public static int[][] createMaze(int numRows, int numCols){
        // scale the maze to larger grid
        numRows = 2 * numRows + 1;
        numCols = 2 * numCols + 1;
        int[][] maze = new int[numRows][numCols];

        // create borders

        for(int i = 0; i < numCols; i++){
            maze[0][i] = 1;// top row
            maze[numRows-1][i] = 1; // bottom row
        }
        for(int i = 0; i < numRows; i++){
            maze[i][0] = 1;//left column
            maze[i][numCols-1] = 1; // right column
        }

        //open two doors
        maze[1][0] = 0; // top left door
        maze[numRows-2][numCols-1] = 0; // bottom right door

        divideMaze(maze, 1, numRows-2, 1, numCols-2);

        return maze;

    }
    public static void divideMaze(int[][] maze, int startRow, int startCol,int endRow,int endCol){

        if(endRow - startRow < 2 || endCol - startCol < 2){
            return; // base case: room too small
        }
        else{
            // pick a random point at even coordinates in the chamber
            int row = randEven(startRow, endRow);
            int col = randEven(startCol,endCol);
            // build two walls centered at that point
            for (int i = startCol; i <= endCol; i++) {
                maze[row][i] = 1;
            }
//          vertical wall
            for (int i = startRow; i <= endRow; i++) {
                maze[i][col] = 1;
            }
            // open three random doors
            int noDoor = (int)((Math.random() * 4));
            if(noDoor != 0){
                maze[row][randOdd(startCol, col -1)] = 0;
            }
            if(noDoor != 1){
                maze[row][randOdd(col+1, endCol)] = 0;
            }
            if(noDoor != 2){
                maze[randOdd(startRow, row -1)][col]= 0;
            }
            if(noDoor != 3){
                maze[randOdd(row+1, endRow)][col] = 0;
            }
            divideMaze(maze, startRow, row-1, startCol, col -1);
            divideMaze(maze, startRow, row-1, col + 1, endCol);
            divideMaze(maze, row+1, endRow, startCol, col -1);
            divideMaze(maze, row + 1, endRow, col+1, endCol);
        }
    }

    public static int randInt(int a, int b){
        return (int)( Math.random() * (b-a + 1)) + a;
    }

    public static int randEven(int a, int b){
        return 2 * randInt(a/2 + a%2, b/2);
    }
    public static int randOdd(int a, int b){
        return 1 + 2 * randInt(a/2 + a%2, b/2);
    }

    public static void printMaze(int[][] maze){
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                if(maze[row][col]== 1){
                    System.out.print("#"); // wall
                }
                else{
                    System.out.print(" "); // open space
                }
            }
            System.out.println();
        }
    }
}
