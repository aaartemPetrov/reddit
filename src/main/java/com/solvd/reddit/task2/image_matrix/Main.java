package com.solvd.reddit.task2.image_matrix;

public class Main {

    public static void main(String[] args) {
        int[][] imageMatrix = {
                {1, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        rectangleInfo(imageMatrix);
    }

    public static void rectangleInfo(int[][] imageMatrix) {
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[i].length; j++) {
                if (imageMatrix[i][j] == 0) printInfo(imageMatrix, i, j);
            }
        }
    }

    public static void printInfo(int[][] imageMatrix, int i, int j) {
        int width = 0;
        int height = 0;
        for (int ii = i; ii < imageMatrix.length; ii++) {
            if(imageMatrix[ii][j] == 0) {
                height++;
                for (int jj = j; jj < imageMatrix[jj].length; jj++) {
                    if(imageMatrix[ii][jj] == 0) {
                        width++;
                        imageMatrix[ii][jj] = 1;
                    } else break;
                }
            } else break;
        }

        if(width % height == 0) System.out.println(String.format("i: %d, j: %d, width: %d, height: %d", i, j, width / height, height));
        else System.out.println(String.format("Not a rectangle starts at: i: %d, j: %d", i, j));
    }

}