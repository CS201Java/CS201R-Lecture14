import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Sort {

    public static void SelectionSort(ArrayList<Integer> numbers) {
        int i;
        int j;
        int indexSmallest;
        int temp;      // Temporary variable for swap

        System.out.println("The original list is: " + numbers);
        
        for (i = 0; i < numbers.size(); ++i) {

            // Find index of smallest remaining element
            indexSmallest = i;
            for (j = i + 1; j < numbers.size(); ++j) {

                if (numbers.get(j) < numbers.get(indexSmallest)) {
                    indexSmallest = j;
                }
            }

            // Swap numbers[i] and numbers[indexSmallest]
            temp = numbers.get(i);
            numbers.set(i, numbers.get(indexSmallest));
            numbers.set(indexSmallest, temp);
            //could also use:
            //Collections.swap(numbers, i, indexSmallest);
        }
        System.out.println("The list sorted is: " + numbers);
    }

     public static void InsertionSort(ArrayList<Integer> numbers) {
        int i;
        int j;
        int temp;      // Temporary variable for swap

        System.out.println("The original list is: " + numbers);
        
        for (i = 1; i < numbers.size(); ++i) {
            j = i;
            while (j > 0 && numbers.get(j) < numbers.get(j-1)){
                //or use: Collections.swap(numbers, j, j-1);
                temp = numbers.get(j-1);
                numbers.set(j-1, numbers.get(j));
                numbers.set(j, temp);
                j--;
            }
        }
        System.out.println("The list sorted is: " + numbers);
    }

    public static void BubbleSort(ArrayList<Integer> numbers) {
        int i;
        int j;

        System.out.println("The original list is: " + numbers);
        
        for (i = numbers.size() - 1; i > 1; --i) {
            for (j = 0; j < i; j++){
                if (numbers.get(j) > numbers.get(j+1)){
                    Collections.swap(numbers, j, j+1);
                }
            }
        }
        System.out.println("The list sorted is: " + numbers);
    }

    public static ArrayList<Integer> MergeSort(ArrayList<Integer> numbers) {

        if (numbers.size() <= 1)
            return numbers;

        int mid = numbers.size()/2;

        ArrayList<Integer> left = new ArrayList<>(numbers.subList(0,mid));
        ArrayList<Integer> right = new ArrayList<>(numbers.subList(mid, numbers.size()));
        left = MergeSort(left);
        right = MergeSort(right);

        return merge(left, right);
    }

     public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Compare and merge elements
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements from left
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // Add remaining elements from right
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}

