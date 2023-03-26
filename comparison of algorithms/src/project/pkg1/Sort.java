/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

/**
 *
 * @author yunus
 */
class Insertion {

    static void insertionSort(int arr[], int n) {
        if (n <= 1) //passes are done
        {
            return;
        }

        insertionSort(arr, n - 1);        //one element sorted, sort the remaining array

        int last = arr[n - 1];                        //last element of the array
        int j = n - 2;                                //correct index of last element of the array

        while (j >= 0 && arr[j] > last) //find the correct index of the last element
        {
            arr[j + 1] = arr[j];                          //shift section of sorted elements upwards by one element if correct index isn't found
            j--;
        }
        arr[j + 1] = last;                            //set the last element at its correct index
    }

    void display(int arr[]) //display the array
    {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {22, 21, 11, 15, 16};
        Insertion ob = new Insertion();
        ob.insertionSort(arr, arr.length);
        
        ob.display(arr);
    }
}
