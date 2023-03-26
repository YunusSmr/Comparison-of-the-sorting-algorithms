package project.pkg1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author yunus
 */
public class Main {

    public static void main(String[] args) {
        int[] size = {1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288};

        //Selection ob = new Selection();
        // Insertion ob = new Insertion();
        // Merge ob = new Merge();
        // QuickwithLomuto ob = new QuickwithLomuto();
        //QuickwithLomuto ob = new QuickwithLomuto();
        QuickwithHoare ob = new QuickwithHoare();
        //Heap ob = new Heap();

        for (int i = 0; i < size.length; i++) {
            int arr[] = GenerateRand(size[i]);
            orderDes(arr);
            long startTime = System.nanoTime();
            ob.quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            long totalTime = (endTime - startTime);
            double milliseconds = (double) totalTime / 1000000;
            System.out.println("milliseconds is " + milliseconds);
            writeFile("file.txt", milliseconds);
        }
        //   Arrays.sort(arr,Collections.reverseOrder());
        // System.out.println(Arrays.toString(arr));
        // ob.display(arr);
    }

    public static int[] readFile(String file) {
        int arr[];
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            arr = new int[ctr];
            Scanner s1 = new Scanner(f);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s1.nextInt();
            }
            s1.close();
        } catch (Exception ex) {
            return null;
        }
        return arr;

    }

    public static int[] GenerateRand(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        //System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void orderAsc(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
    }

    public static void orderDes(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
    }

    public static void writeFile(String file, double time) {
        // Try block to check for exceptions
        // Try block to check for exceptions
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));

            // Writing on output stream
            out.write(String.valueOf(time + "\n"));
            // Closing the connection
            out.close();
        } // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }
    }

}
