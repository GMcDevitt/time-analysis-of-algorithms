import java.io.IOException;


/**
 * Class to call the sorting algorithms and write the excel workbook.
 *
 * @author Gerard McDevitt, Jackie Plum
 */
public class Main {

    public static void main(String[] args) throws IOException {

		RunSortingAlgorithms runSortingAlgorithms = new RunSortingAlgorithms();
        //These commands simply call the methods to run different sorting algorithms.
        runSortingAlgorithms.runBubbleSort();
        runSortingAlgorithms.runSelectionSort();
        runSortingAlgorithms.runInsertionsSort();
        runSortingAlgorithms.runQuickSort();
        runSortingAlgorithms.runMergeSort();
        runSortingAlgorithms.close();
    }
}
