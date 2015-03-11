/**
 * Developed using IntelliJ Idea 14
 * Class of Sorting Algorithms that can be used to sort arrays of integers.
 * @author Gerard McDevitt, Jackie Plum
 */
public class SortingAlgorithms {

    /**
     * Implementation of the Bubble Sort
     * @param numArray
     */
	 public static void bubbleSort(int[] numArray) {
        int n = numArray.length;
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
     * Implementation of the Selection Sort
     * @param numArray
     */
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
     * Implementation of the Insertion Sort
     * @param numArray
     */
    public static void insertionSort(int[] numArray) {
        int key;
        int i;

        for (int j = 1; j < numArray.length; j++) {
            key = numArray[j];
            // Smaller values are moving up
            for(i = j - 1; (i >= 0) && (numArray[i] < key); i--) {
                numArray[i + 1] = numArray[ i ];
            }
            // Put the key in its proper location
            numArray[i + 1] = key;
        }
    }

    /**
     * Implementation of the Quick Sort
     * @param numArray the array to be sorted
     * @param low
     * @param high
     */
    public static void quickSort(int[] numArray, int low, int high) {
        if (numArray == null || numArray.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

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

    /**
     * Places the elements of the given array into sorted order
     * using the merge sort algorithm.
     * post: array is in sorted (nondecreasing) order
     * @param array
     */
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

    /**
     * Returns the first half of the given array.
     * @param array
     * @return
     */
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    /**
     * Returns the second half of the given array.
     * @param array
     * @return
     */
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    /**
     * Merges the given left and right arrays into the given
     * result array.  Second, working version.
     * pre : result is empty; left/right are sorted
     * post: result contains result of merging sorted lists;
     * @param result
     * @param left
     * @param right
     */
    public static void merge(int[] result, int[] left, int[] right) {
        // index into left array
        int iL = 0;
        // index into right array
        int iR = 0;

        for (int i = 0; i < result.length; i++) {
            if (iR >= right.length || (iL < left.length &&
                    left[iL] <= right[iR])) {
                // take from left
                result[i] = left[iL];
                iL++;
            } else {
                // take from right
                result[i] = right[iR];
                iR++;
            }
        }
    }
}
