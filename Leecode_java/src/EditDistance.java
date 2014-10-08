public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null||word2 == null) 
            return 0;
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0)
            return length2;
        if (length2 == 0)
            return length1;    
        
        char w1[] = word1.toCharArray();
        char w2[] = word2.toCharArray();
        int E[][] = new int[length1+1][length2+1];
        for(int i=0; i<=length1; i++)
            E[i][0] = i;
        for(int j=0; j<=length2; j++)
            E[0][j] = j;
        for(int i=1; i<=length1; i++){
            for(int j=1; j<=length2; j++)
            {
                if (w1[i-1] == w2[j-1])
                    E[i][j] = Math.min(Math.min(E[i-1][j]+1 , E[i][j-1]+1), E[i-1][j-1]); 
                else
                    E[i][j] = Math.min(Math.min(E[i-1][j]+1 , E[i][j-1]+1), E[i-1][j-1]+1);
            }
        }    
        return E[length1][length2];    
    }
}