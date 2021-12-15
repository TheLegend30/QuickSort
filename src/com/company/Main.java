package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10000];
        for (int n = 0; n < numbers.length; n++) {
            numbers[n] = rand.nextInt(10000);
        }
        System.out.println("Before: ");
        printArray(numbers);
        quickSort(numbers);
        System.out.println("After: ");
        printArray(numbers);

    }
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }
    private static void quickSort(int[] array,int lowIndex,int highIndex){
        if(lowIndex>=highIndex){
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex-lowIndex)+lowIndex;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,highIndex);
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer<rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer <rightPointer) {
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
