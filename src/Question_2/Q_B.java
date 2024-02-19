package Question_2;

import java.util.*;

public class Q_B {

    public static List<Integer> determineSecretReceivers(int n, List<int[]> intervals, int firstPerson) {
        Set<Integer> secretReceivers = new HashSet<>();
        secretReceivers.add(firstPerson); // Person 0 initially has the secret
        
        // Iterate through each interval
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            // Add all individuals in the interval to the set of secret receivers
            for (int i = start; i <= end; i++) {
                secretReceivers.add(i % n); // % n to handle cyclic sharing
            }
        }
        
        // Convert the set to a list and return
        return new ArrayList<>(secretReceivers);
    }

    public static void main(String[] args) {
        int n = 5;
        List<int[]> intervals = List.of(new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 4});
        int firstPerson = 0;
        
        List<Integer> result = determineSecretReceivers(n, intervals, firstPerson);
        System.out.println("The individuals who will eventually know the secret are: " + result);
    }
}


