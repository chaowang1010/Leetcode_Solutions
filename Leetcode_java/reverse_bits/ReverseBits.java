// Reverse bits of a given 32 bits unsigned integer.

// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

// Follow up:
// If this function is called many times, how would you optimize it?

// Related problem: Reverse Integer

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i = 0; i < 16; i++){
            n = swapdig(n, i, 31-i);
        }
        return n;
    }
    
    public int swapdig(int n, int i, int j){
        if( ((n>>i)&1) != ((n>>j)&1) ){
            n ^= (1<<i) | (1<<j);
        }
        return n;
    }
}