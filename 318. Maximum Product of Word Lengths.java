class Solution {
    public int maxProduct(String[] words) {
        
        //here bit mask will be the lowest tc solution
        int n=words.length;
        int ans=0;
        
        //each word we store as bit to array then comparing is easy
        //there will be 1-26 element in each position
        int []bits=new int[n];
        int k=0;
        for(String word:words){ //take each word
            
            //loop through word and make bit
            int len=word.length();
            int bit=0;
            for(int i=0;i<len;i++){
                int ch=word.charAt(i)-'a';
                bit |=(1<<ch);
            }
            
            bits[k]=bit;
            k++;
        }
        
        //now if the two words have same char then it will not give zero while'&'
        //so if it give zero then multiply the length
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((bits[i]&bits[j])==0){
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
       return ans;
    }
}