package com.solvd.reddit.task2.image_matrix;

public class Image {

    public static void getRectanglesInfo(int[][] imageMatrix) {
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[i].length; j++) {
                if (imageMatrix[i][j] == 0) {
                    rectangleInfo(imageMatrix, i, j);
                }
            }
        }
    }

    public static void rectangleInfo(int[][] tempMatrix, int i, int j) {
        int height = 0;
        int width = 0;
        for (int ii = i; ii < tempMatrix.length; ii++) {
            if (tempMatrix[ii][j] != 0) {
                break;
            } else {
                width = 0;
                height++;
                for (int jj = j; jj < tempMatrix[ii].length; jj++) {
                    if (tempMatrix[ii][jj] == 0) {
                        width++;
                        tempMatrix[ii][jj] = 1;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(i + " " + j + " " + width + " " + height);
    }

}
