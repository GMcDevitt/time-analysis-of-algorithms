/**
 * Developed using IntelliJ Idea 14
 * Class of Sorting Algorithms that can be used to sort arrays of integers.
 * @author Gerard McDevitt, Jackie Plum
 */
public class SortingAlgorithms {

    /**
     *

     * @param numArray the array to be sorted
     */
//Create the bubble sort to sort the data
	 public static void bubbleSort(int[] numArray) {
//set the length of the array as an integer
        int n = numArray.length;
        //create a temp variable
		int temp;
//compare the int and evaluate, and sort
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < (n - i); j++) {

                if (numArray[j - 1] > numArray[j]) {

                    temp = numArray[j - 1];

                    numArray[j - 1] = numArray[j];

                    numArray[j] = temp;
                }

            }
        }
    }


    /**
     *
     * @param numArray the array to be sorted
     */
    
	//Create the Selection sort method
	public static void selectionSort(int[] numArray) {
//Evaluate the current int and sort 
        for(int i=0; i < numArray.length - 1; i++){

            int min = i;

            for (int k = i + 1; k < numArray.length; k++){

                if(numArray[k] < numArray[min]) {

                    min = k;
                }
            }
            if (i != min) {

                int temp = numArray[i];

                numArray[i] = numArray[min];

                numArray[min] = temp;
            }
        }
    }


    /**
     *
     * @param numArray the array to be sorted
     */
    public static void insertionSort(int[] numArray)
    {
        int j;                     // the number of items sorted so far
        int key;                   // the item to be inserted
        int i;

        for (j = 1; j < numArray.length; j++) {    // Start with 1 (not 0)

            key = numArray[j];

            for(i = j - 1; (i >= 0) && (numArray[ i ] < key); i--) {   // Smaller values are moving up

                numArray[i + 1] = numArray[ i ];
            }

            numArray[i + 1] = key;    // Put the key in its proper location
        }
    }


    /**
     *
     * @param numArray the array to be sorted
     * @param low
     * @param high
     */
    public static void quickSort(int[] numArray, int low, int high) {

        if (numArray == null || numArray.length == 0)
            return;

        if (low >= high)
            return;

        //pick the pivot point
        int middle = low + (high - low) / 2;
        int pivot = numArray[middle];

        //make left < pivot and right > pivot
        int i = low, j = high;
        //sort the data in each pivot point
		while (i <= j) {
            while (numArray[i] < pivot) {
                i++;
            }

            while (numArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;
                i++;
                j--;
            }
        }

        //recursively sort two sub parts
        if (low < j)
            quickSort(numArray, low, j);

        if (high > i)
            quickSort(numArray, i, high);
    }


    // Places the elements of the given array into sorted order
    // using the merge sort algorithm.
    // post: array is in sorted (nondecreasing) order
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // merge the sorted halves into a sorted whole
            merge(array, left, right);
        }
    }

    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    // Merges the given left and right arrays into the given
    // result array.  Second, working version.
    // pre : result is empty; left/right are sorted
    // post: result contains result of merging sorted lists;
    public static void merge(int[] result,
                             int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }
}
