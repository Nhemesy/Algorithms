package problems.problem2;

import java.util.*;


/**
 * This class studies the efficiency of numberOfMarks.
 * 
 * 
 * @author carmocca 
 * @version (Abril 2016)
 */
public class NumberOfMarksCost {

    //Change these values to test different array sizes
    private static int SIZE_INI = 100000;
    private static int SIZE_FIN = 1000000;
    private static int SIZE_INCR = 100000;

    //Mark to be beaten
    private static final int MARK = 50;
    //Maximum mark possible
    private static final int MAX_ARRAY = 100;
  
    public static void main(String args[]) {
        int [] vector;
        double t1, t2, time;
        List<ExamMarks> list = new ExamMarksFactory().create();

        System.out.println("#-----------------------------------------");
        System.out.println("#       Measurement of search times: ");
        System.out.println("#        Marks from 0 to "+MAX_ARRAY+"    ");
        System.out.println("#----------------------------------------- ");
        System.out.println("#  Size    Search time   Nº Marks > "+MARK+"   ");


        for (ExamMarks ex : list){
            String clazz = ex.getClass().getName();
            t1 = t2 = time = 0;
            System.out.println("#-----------------------------------------");
            System.out.println("#  \t\t" + clazz.replaceFirst("problems.problem2.", "") + " implementation.");
            System.out.println("#-----------------------------------------");
            for (int t = SIZE_INI; t <= SIZE_FIN; t += SIZE_INCR) {
                vector = generateIncreasingRandoms(t, MAX_ARRAY);
                t1 = System.nanoTime();
                int n = ex.numberOfMarks(vector, MARK);
                t2 = System.nanoTime();
                time += t2 - t1;
                System.out.printf(Locale.US, " %1$8d %2$8.0f μs      %3$8d\n",
                        t,
                        time / 1e3,
                        n);
            }
        }
    }

    /**
    *	
    * @param amount "size of the array"
    * @param max "maximum possible number"
    * @return int "array of elements from 0 to max, with duplicates."
    */
    public static int[] generateIncreasingRandoms(int amount, int max) {
        int[] randomNumbers = new int[amount];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(max);
        }
        Arrays.sort(randomNumbers);
        return randomNumbers;
     }
}
