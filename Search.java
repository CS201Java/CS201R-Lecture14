import java.util.ArrayList;

public class Search {
    
    //using linear search
    //there are issues here that need to be corrected!!
    public static int linearSearch(ArrayList<Integer> numbers, Integer value){
        int count = 0;
        for (int i = 0; i < numbers.size(); i++){
            if ( numbers.get(i) == value){
                //return the position of value in the list
                return count;
            }
            count++;
        }
        System.out.println(value + " is not found.");
        return count;
    }

    //using binary search
    //there are issues here that need to be corrected!!
    public static int binarySearch(ArrayList<Integer> numbers, Integer value){
        int count = 0, low = 0, high = numbers.size() - 1, mid = 0 ;
        while (high > low){
            mid = (high + low)/2;
            if (numbers.get(mid) < value)
                low = mid + 1;
            else if (numbers.get(mid) > value)
                high = mid - 1;
            else{
                //return the position of value in the list
                return count;
            }
            count++;
        }
        System.out.println(value + " is not found.");
        return count;
    }
 
}