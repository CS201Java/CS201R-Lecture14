import java.util.ArrayList;
import java.util.Collections;

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

    public static void RadixSort(ArrayList<Integer> numbers, int numBuckets) {
        
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++ )
            buckets.add(new ArrayList<>());

        // Get the max value to calculate which bucket an integer goes into.
        for (int index = 1; index < numbers.size(); index++) {
            int key = numbers.get(index) % 10;
            buckets.get(key).add(numbers.get(index));
        }

        // Put array values into correct bucket.
        numbers.clear();
        for (int index = 0; index < buckets.size(); index++) {
            if (!buckets.get(index).isEmpty()){
                for (int j = 0; j < buckets.get(index).size(); j++)
                    numbers.add(buckets.get(index).get(j));
            }
        }
        
        buckets.clear();
        for (int i = 0; i < numBuckets; i++ )
            buckets.add(new ArrayList<>());

        // Get the max value to calculate which bucket an integer goes into.
        for (int index = 1; index < numbers.size(); index++) {
            int key = (numbers.get(index) / 10) % 10;
            buckets.get(key).add(numbers.get(index));
        }

        // Put array values into correct bucket.
        numbers.clear();
        for (int index = 0; index < buckets.size(); index++) {
            if (!buckets.get(index).isEmpty()){
                for (int j = 0; j < buckets.get(index).size(); j++)
                    numbers.add(buckets.get(index).get(j));
            }
        }
    }
}
