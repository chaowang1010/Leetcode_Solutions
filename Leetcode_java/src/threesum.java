public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3)
        return result;
        
        int length = num.length;
        Arrays.sort(num);
        
        for (int i=0; i<length-2; i++){
            if(i==0 || num[i]>num[i-1]){
            int j=i+1;
            int k=length - 1;
            while(j<k){
                if (num[i] + num[j] + num[k] == 0){
                    ArrayList<Integer> e = new ArrayList<Integer>();
                    e.add(num[i]);
                    e.add(num[j]);
                    e.add(num[k]);
                    result.add(e);
                    
                    j++;
                    k--;
                    
                    while (j<k && num[k]==num[k+1]) k--;
                    while (j<k && num[j]==num[j-1]) j++;
                }
                else if(num[i] + num[j] + num[k] > 0)
                    k--;
                    else
                    j++;
                }
            }
            }
        return result;
        }
    }
