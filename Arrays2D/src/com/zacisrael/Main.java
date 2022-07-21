package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	//2D array
        //int [][] x = new int[2][3]; // This array will have 2 rows and 3 columns
       // x[0][0] = 100; // assigns 100 to the element in row 0, column 0 ( top left corner )

        double [][] y = new double[2][3];
        y[0][0] = 10;
        y[0][1] = 20;
        y[0][2] = 30;
        y[1][0] = 40;
        y[1][1] = 50;
        y[1][2] = 60;

        /* System.out.println(matrixToString(y,2,3)); */

        double [][] yt = transpose(y, 2,3);
        System.out.println(matrixToString(yt, 3, 2));

        /* double [][]w = new double [][]{{15, 23, 35}, {45,55,65}};
        System.out.println(matrixToString(w, 2, 3));

        System.out.println(isTriangular(new double[][]{{1,0,0,0,0} , {2,3,0,0,0},{4,5,6,0,0},{7,8,9,10,0},{11,12,13,14,15}}, 5)); */




    }
    public static String matrixToString(double[][] x, int n, int m){ // m is the number of columns, n is the number of rows
        String result = ""; // "\n" represents moving to a new line
        for (int row = 0; row < n ; row++){
            result += "["; // the result = the previous value of result plus a open bracket for the next loop
            for (int column = 0; column < m-1; column++){
                result += x[row][column] + ", "; // result = the element for that number column and that number row and a ", " afterwards
            }
            result+= x[row][m-1] + "]\n"; // adding the last element with the closed bracket afterwards
        }
        return result;
    }
    public static double[][] transpose(double[][] x, int n, int m) {
        double [][] result = new double[m][n];
        for (int row = 0; row < n; row++){

            for(int col = 0; col < m; col++){
                result[col][row] = x[row][col];
            }
        }
        return result;
    }
    // a triangular matrix is where the all the items above or below the main diagonal are 0
    public static boolean isTriangular(double[][] x, int n){
        // check if lower triangular
        boolean isLowerTriangular = true;
        for (int row = 0; row < n -1; row++){
            for (int col = row + 1; col < n; col++){
                if(x[row][col] != 0){
                    isLowerTriangular = false;
                }
            }
        }
        boolean isUpperTriangle = true;
        for(int row = 1; row < n; row++){
            for(int col = 0; col < row; col++){
                if(x[row][col] != 0){
                    isUpperTriangle = false;
                }
            }
        }
        return isLowerTriangular || isUpperTriangle;
    }

}
