import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        System.out.println("SEARCHING ALGORITHMS\n");
        Scanner input = new Scanner(System.in);

        //arraylists to use for searching & sorting
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 60; i+=2)
           numbers.add(i);
 
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);
            randomNumbers.add(randomNumber);
        }
        System.out.println(numbers);
        System.out.println(randomNumbers);

        System.out.println("\nEXAMPLE 1: LINEAR SEARCH");
        System.out.print("Enter a value to find:  ");
        int n = input.nextInt();
        System.out.println("Linear search position for the value " + n + " is: " + Search.linearSearch(numbers, n));
        System.out.println("Linear search position for the value " + n + " in randomNumbers is: " + Search.linearSearch(randomNumbers, n));

        System.out.println("\nEXAMPLE 2: BINARY SEARCH");
        System.out.println("Binary search position for the value " + n + " is: " + Search.binarySearch(numbers, n));
        System.out.println("Binary search position for the value " + n + " in randomNumbers is: " + Search.binarySearch(randomNumbers, n));
        input.close();

        System.out.println("\nEXAMPLE 3: SELECTION SORT");
        Sort.SelectionSort(randomNumbers);

        System.out.println("\nEXAMPLE 4: INSERTION SORT");
        //reset randomNumbers
        randomNumbers.clear();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);
            randomNumbers.add(randomNumber);
        }
        Sort.InsertionSort(randomNumbers);

        System.out.println("\nEXAMPLE 5: BUBBLE SORT");
        //reset randomNumbers
        randomNumbers.clear();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);
            randomNumbers.add(randomNumber);
        }
        Sort.BubbleSort(randomNumbers);


        System.out.println("\nEXAMPLE 6: MERGE SORT");
        randomNumbers.clear();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);
            randomNumbers.add(randomNumber);
        }
        System.out.println("The original list is: " + randomNumbers);
        randomNumbers = Sort.MergeSort(randomNumbers);
        System.out.println("The sorted list is:   " + randomNumbers);
 
        
        System.out.println("\nEXAMPLE 7: QUICK SORT");
        randomNumbers.clear();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);
            randomNumbers.add(randomNumber);
        }
        System.out.println("The original list is: " + randomNumbers);
        Sort.QuickSort(randomNumbers, 0, randomNumbers.size()-1);
        System.out.println("The sorted list is:   " + randomNumbers);    
        
        /*
        //These are additional sorts you can review if you would like

        System.out.println("\nEXAMPLE 8: BUCKET SORT");
        randomNumbers.clear();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);
            randomNumbers.add(randomNumber);
        }
        System.out.println("The original list is: " + randomNumbers);
        OtherSorts.BucketSort(randomNumbers, 5);
        System.out.println("The sorted list is:   " + randomNumbers);
 

        System.out.println("\nEXAMPLE 9: RADIX SORT");
        randomNumbers.clear();
        for (int i = 0; i < 15; i++){
            int randomNumber = random.nextInt(100);   //0-99
            randomNumbers.add(randomNumber);
        }
        System.out.println("The original list is: " + randomNumbers);
        OtherSorts.RadixSort(randomNumbers, 99);
        System.out.println("The sorted list is:   " + randomNumbers);
        */

    }


}
