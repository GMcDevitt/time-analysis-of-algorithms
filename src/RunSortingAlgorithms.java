import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Runs each sorting algorithm 10 times with arrays of length:
 * 100 | 1,000 | 10,000 | 100,000 | 1,000,000 | 10,000,000
 *
 * Writes data to an excel sheet using Apache POI
 *
 * @author Gerard McDevitt, Jackie Plum
 */
public class RunSortingAlgorithms {

    //Create my arrays
    public static int[] INT_ARRAY_1000 = new int[1000];
    public static int[] INT_ARRAY_10000 = new int[10000];
    public static int[] INT_ARRAY_100000 = new int[100000];
    public static int[] INT_ARRAY_1000000 = new int[1000000];
    public static int[] INT_ARRAY_2000000 = new int[2000000];

    //Put them in an array list for easy access
    public static ArrayList<int[]> list = new ArrayList<int[]>() {{
        add(INT_ARRAY_1000);
        add(INT_ARRAY_10000);
        add(INT_ARRAY_100000);
        add(INT_ARRAY_1000000);
        add(INT_ARRAY_2000000);
    }};

    //Excel workbook used for reporting
    public XSSFWorkbook report;
    //Start time for a sort
    public static long startTime;
    //End time for a sort
    public static long endTime;
    //The calculated elapsed time
    public static long duration;

    /**
     * Creates the excel workbook if one does not exist or gets the workbook.
     * @throws IOException
     */
    public RunSortingAlgorithms() throws IOException {
        //If the report file does not exist it will be created.
        if(! Files.exists(new File("report.xlsx").toPath())) {
            this.report = new XSSFWorkbook();
            report.createSheet("Summary");
            report.createSheet("Bubble Sort");
            report.createSheet("Selection Sort");
            report.createSheet("Insertion Sort");
            report.createSheet("Quick Sort");
            report.createSheet("Merge Sort");
        } else {
            //Otherwise get the file and write data to it.
            this.report = new XSSFWorkbook(new FileInputStream(new File("report.xlsx")));
        }
    }

    public void runBubbleSort() throws FileNotFoundException {
        //What row the info is being placed in.
        int rowNumber = 1;
        //What column the info is being placed in
        int columnNumber;
        Row row;
        writeSheet("Bubble Sort");
        Sheet sheet = report.getSheet("Bubble Sort");

        //Run the sort 10 times for each set of arrays
        for (int i = 0; i < 10; i++) {
            //For each array run the sort
            for (int k = 0; k < 3; k++) {
                //Get the next array
                int[] array = list.get(k);
                //Load it with a new set of the correct number of integers
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int) (Math.random() * 1000000);
                }
                //Get the start time of the sort
                startTime = System.nanoTime();
                //Call the sort
                SortingAlgorithms.bubbleSort(array);
                //Get the end time of the sort
                endTime = System.nanoTime();
                //Get time in milliseconds by subtracting the two times and dividing by 1000000
                duration = (endTime - startTime)/1000000;
                //Start on the pass column to keep track of how many times the data is run.
                columnNumber = 0;
                //Create data rows
                row = sheet.createRow(rowNumber);
                //Pass number
                row.createCell(columnNumber).setCellValue(i + 1);
                //Move to the next column
                columnNumber++;
                //Number of elements
                row.createCell(columnNumber).setCellValue(array.length);
                columnNumber++;
                //Time
                row.createCell(columnNumber).setCellValue(duration);
                columnNumber++;
                //Units
                row.createCell(columnNumber).setCellValue("milliseconds");
                //Move to next row
                rowNumber++;

            }
        }
    }

    public void runSelectionSort() throws FileNotFoundException {
        //What row im on
        int rowNumber = 1;
        //What column im on
        int columnNumber;
        Row row;
        writeSheet("Selection Sort");
        Sheet sheet = report.getSheet("Selection Sort");

        //Run the sort 10 times for each set of arrays
        for (int i = 0; i < 10; i++) {
            //For each array
            for (int k = 0; k < 3; k++) {
                //Get the next array
                int[] array = list.get(k);
                //Load it with a new set of the correct number of integers
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int) (Math.random() * 1000000);
                }
                //Get the start time
                startTime = System.nanoTime();
                //Call the sort
                SortingAlgorithms.selectionSort(array);
                //Get the end time
                endTime = System.nanoTime();
                //Get time in milliseconds by subtracting the two times and dividing by 1000000
                duration = (endTime - startTime)/1000000;

                //Start on the pass column
                columnNumber = 0;
                //Create data row
                row = sheet.createRow(rowNumber);
                //Pass number
                row.createCell(columnNumber).setCellValue(i +1);
                //Move to the next column
                columnNumber++;
                //Number of elements
                row.createCell(columnNumber).setCellValue(array.length);
                columnNumber++;
                //Time
                row.createCell(columnNumber).setCellValue(duration);
                columnNumber++;
                //Units
                row.createCell(columnNumber).setCellValue("milliseconds");
                //Move to next row
                rowNumber++;
            }
        }
    }

    public void runInsertionsSort() throws FileNotFoundException {
        //What row im on
        int rowNumber = 1;
        //What column im on
        int columnNumber;
        Row row;
        writeSheet("Insertion Sort");
        Sheet sheet = report.getSheet("Insertion Sort");

        //Run the sort 10 times for each set of arrays
        for (int i = 0; i < 10; i++) {
            //For each array
            for (int k = 0; k < 3; k++) {
                //Get the next array
                int[] array = list.get(k);
                //Load it with a new set of the correct number of integers
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int) (Math.random() * 1000000);
                }
                //Get the start time
                startTime = System.nanoTime();
                //Call the sort
                SortingAlgorithms.insertionSort(array);
                //Get the end time
                endTime = System.nanoTime();
                //Get time in milliseconds by subtracting the two times and dividing by 1000000
                duration = (endTime - startTime)/1000000;

                //Start on the pass column
                columnNumber = 0;
                //Create data row
                row = sheet.createRow(rowNumber);
                //Pass number
                row.createCell(columnNumber).setCellValue(i +1);
                //Move to the next column
                columnNumber++;
                //Number of elements
                row.createCell(columnNumber).setCellValue(array.length);
                columnNumber++;
                //Time
                row.createCell(columnNumber).setCellValue(duration);
                columnNumber++;
                //Units
                row.createCell(columnNumber).setCellValue("milliseconds");
                //Move to next row
                rowNumber++;
            }
        }
    }

    public void runQuickSort() throws FileNotFoundException {
        //What row im on
        int rowNumber = 1;
        //What column im on
        int columnNumber;
        Row row;
        writeSheet("Quick Sort");
        Sheet sheet = report.getSheet("Quick Sort");

        //Run the sort 10 times for each set of arrays
        for (int i = 0; i < 10; i++) {
            //For each array
            for (int k = 0; k < 5; k++) {
                //Get the next array
                int[] array = list.get(k);
                //Load it with a new set of the correct number of integers
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int) (Math.random() * 1000000);
                }
                //Get the start time
                startTime = System.nanoTime();
                //Call the sort
                SortingAlgorithms.quickSort(array, 0, array.length - 1);
                //Get the end time
                endTime = System.nanoTime();
                //Get time in milliseconds by subtracting the two times and dividing by 1000000
                duration = (endTime - startTime)/1000000;

                //Start on the pass column
                columnNumber = 0;
                //Create data row
                row = sheet.createRow(rowNumber);
                //Pass number
                row.createCell(columnNumber).setCellValue(i +1);
                //Move to the next column
                columnNumber++;
                //Number of elements
                row.createCell(columnNumber).setCellValue(array.length);
                columnNumber++;
                //Time
                row.createCell(columnNumber).setCellValue(duration);
                columnNumber++;
                //Units
                row.createCell(columnNumber).setCellValue("milliseconds");
                //Move to next row
                rowNumber++;
            }
        }
    }

    public void runMergeSort() throws FileNotFoundException {
        //What row im on
        int rowNumber = 1;
        //What column im on
        int columnNumber;
        Row row;
        writeSheet("Merge Sort");
        Sheet sheet = report.getSheet("Merge Sort");

        //Run the sort 10 times for each set of arrays
        for (int i = 0; i < 10; i++) {
            //For each array
            for (int k = 0; k < 5; k++) {
                //Get the next array
                int[] array = list.get(k);
                //Load it with a new set of the correct number of integers
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int) (Math.random() * 1000000);
                }
                //Get the start time
                startTime = System.nanoTime();
                //Call the sort
                SortingAlgorithms.mergeSort(array);
                //Get the end time
                endTime = System.nanoTime();
                //Get time in milliseconds by subtracting the two times and dividing by 1000000
                duration = (endTime - startTime)/1000000;

                //Start on the pass column
                columnNumber = 0;
                //Create data row
                row = sheet.createRow(rowNumber);
                //Pass number
                row.createCell(columnNumber).setCellValue(i +1);
                //Move to the next column
                columnNumber++;
                //Number of elements
                row.createCell(columnNumber).setCellValue(array.length);
                columnNumber++;
                //Time
                row.createCell(columnNumber).setCellValue(duration);
                columnNumber++;
                //Units
                row.createCell(columnNumber).setCellValue("milliseconds");
                //Move to next row
                rowNumber++;
            }
        }
    }

    public void close() throws IOException {
        File excelFile = new File("report.xlsx");
        FileOutputStream output = new FileOutputStream(excelFile);
        this.report.write(output);
        output.close();
    }

    /**
     * Writes the column headers for each sheet
     * @param sheetName the sheet to write the headers for
     */
    public void writeSheet(String sheetName) {
        int columnNumber = 0;
        int rowNumber = 0;
        Row row;
        Sheet sheet = report.getSheet(sheetName);

        //Create Headers for the excel data
        row = sheet.createRow(rowNumber);
        row.createCell(columnNumber).setCellValue("Pass");
        columnNumber++;
        row.createCell(columnNumber).setCellValue("Elements");
        columnNumber++;
        row.createCell(columnNumber).setCellValue("Time");
        columnNumber++;
        row.createCell(columnNumber).setCellValue("Units");

    }
}
