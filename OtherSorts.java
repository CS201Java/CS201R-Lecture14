import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class OtherSorts{

    public static void BucketSort(ArrayList<Integer> numbers, int numBuckets) {

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++ )
            buckets.add(new ArrayList<>());

        int maxValue = numbers.get(0);

        // Get the max value to calculate which bucket an integer goes into.
        for (int index = 1; index < numbers.size(); index++) {
            if (numbers.get(index) > maxValue)
                maxValue = numbers.get(index);
        }

        // Put array values into correct bucket.
        for (int index = 0; index < numbers.size(); index++)
        {
            int bucket = (int)(numBuckets * numbers.get(index) / (maxValue + 1));
            buckets.get(bucket).add(numbers.get(index));
        }
        //  Sort each bucket (#include <algorithm>)
        for (int i = 0; i < numBuckets; i++)
            Collections.sort(buckets.get(i));
        
        //  merge buckets
        numbers.clear();
        for (int buckIndex = 0; buckIndex < buckets.size(); buckIndex++) {
            for (int j = 0; j < buckets.get(buckIndex).size(); j++)
                numbers.add(buckets.get(buckIndex).get(j));
            
        }
    }

    public static void RadixSort(ArrayList<Integer> numbers, int maxValue) {
        
        
        int bucketCount = 10;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++ )
            buckets.add(new ArrayList<>());

        // For each digits place (exp), 
        // use remainder to calculate which bucket an integer goes into.
        //
        for (int exp = 1; maxValue/exp > 0; exp *= 10){
            for (int value : numbers){
                int key = (value/exp) % 10;
                buckets.get(key).add(value);
            }

            int index = 0;
            numbers.clear();
            System.out.println();
            for (int b = 0; b < bucketCount; b++ ){
                for (int val: buckets.get(b)){
                    numbers.add(val);
                }
                System.out.println(b + ": " + buckets.get(b));
                buckets.get(b).clear();
            }
 
        }
    }
}
