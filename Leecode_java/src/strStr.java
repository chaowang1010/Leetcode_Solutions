public class Solution {
    public String strStr(String haystack, String needle) {
        char hs[] = haystack.toCharArray();
        char nd[] = needle.toCharArray();
        if (hs.length < nd.length)   // haystack = null, needle = null , return ""
        return null;
        int count = nd.length;
        int i = 0;
        int j = 0;
        while (i<=hs.length-nd.length){
            j = 0;
            count = nd.length;
            while (j<nd.length){
                if (hs[i+j]==nd[j]){
                    count--;
                }
                j++;
            }
            i++;
            if (count == 0)
            return haystack.substring(i-1);
        }
        return null;
    }
}