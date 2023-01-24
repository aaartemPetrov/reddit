package com.solvd.reddit.task10.fizz_buzz;

public class FizzBuzz {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            if(arr[i] % 15 == 0) System.out.print("FizzBuzz ");
            else if(arr[i] % 5 == 0) System.out.print("Buzz ");
            else if(arr[i] % 3 == 0) System.out.print("Fizz ");
            else System.out.print(arr[i] + " ");
        }
    }

}
