// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

// Note:
// The solution is guaranteed to be unique.

public class Solution {
    // brute force
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for(int i = 0; i < gas.length; i++){
            int j = i;
            int gasRemain = 0;
            do{
                gasRemain += gas[j];
                gasRemain -= cost[j];
                if(gasRemain < 0) break; 
                j++;
                if(j == gas.length){  
                    j = 0;  
                }
            }while(j != i);
            if(gasRemain >= 0) return i;
        }
        
        return -1;
    }

    // O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total =0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            total += sum;
            if(sum < 0){
                sum = 0;
                start = i + 1;
            }
        }
        if(total < 0) return -1;
        return start;
    }
}