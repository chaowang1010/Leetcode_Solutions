public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 4) return result;
        
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 3; i++){
            if(i > 0 && num[i] == num[i-1]) continue;
            for(int j = i + 1; j < num.length - 2; j++){
                if(j > i + 1 && num[j] == num[j-1]) continue;
                int k = j + 1;
                int m = num.length - 1;
                while(k < m){
                    int sum = num[i]+num[j]+num[k]+num[m]; 
                    if(sum == target){
                        ArrayList<Integer> temp = new ArrayList<Integer>(4);  
                        temp.add(num[i]);  
                        temp.add(num[j]);  
                        temp.add(num[k]);  
                        temp.add(num[m]);  
                        result.add(temp);
                        do { k++; }while (k<m && num[k]==num[k-1]);  
                        do { m--; }while (k<m && num[m]==num[m+1]); 
                        // k++;
                        // m--; 
                    }else if(sum < target){
                        k++;
                    }else {
                        m--;
                    }
                }
            }
        }
        return result;
    }
}