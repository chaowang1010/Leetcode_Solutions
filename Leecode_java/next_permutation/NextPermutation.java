public class Solution {
    public void nextPermutation(int[] num) {
        int i = 0; int j = 0;   //!!!
        for(i = num.length - 2; i >= 0; i --){
        	if(num[i] >= num[i + 1])
        		continue;
        	for(j = num.length - 1; j >i; j --)
        		if(num[j] > num[i])
        			break;
        	break;
        }

        if(i >= 0){
        	int temp = num[i];
        	num[i] = num[j];
        	num[j] = temp;
        }

        int start = i + 1;
        int end = num.length - 1;
        while(start < end){
        	int temp = num[start];
        	num[start] = num[end];
        	num[end] = temp;
        	start++;
        	end--;
        }
    }
}