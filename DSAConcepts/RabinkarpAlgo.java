public class RabinkarpAlgo {
    // It convert the string into numbers(hashes) and compare those
    // Optimized for cases where mutliple patterns or repeated matching is required
    // Used for plagiagrism detection, substring search and more

    //instead of comparing both the pattern and part it converts them into numbers and then compares those

    //we uuse rolling hash which allows us to compute the hash of the next substring
    //in constant time by updating the previous hash

    //first we compute hash of the pattern and then compare it with every substring, 
    public final static int d = 256;
    public final static int q = 101; //this is prime number for the modulus so that we can avoid collision

    public static void search(String pat, String txt){
        int m = pat.length();
        int n = txt.length();
        int i,j;
        int p = 0; //hash for the pattern
        int t = 0; //hash fot the text
        int h = 1; //the value of the hash "pow(d, m-1)%q"
        for( i = 0 ; i<m-1; i++){
            h = ( h * d) % q;
        }

        for(i = 0; i < m; i++){
            p = (d*p + pat.charAt(i))%q; //checking hash for pattern
            t = (d*t + txt.charAt(i))%q; //checking initial hash for the text
        }

        for(i = 0; i <= n - m ; i++){
            if(p == t){
                //this means that the initial values are same and now we need to check character by character
                for(j = 0; j<m; j++){
                    if(txt.charAt(i+j) != pat.charAt(j)){
                        break;
                    }
                }
                if(j == m) System.out.println("Found!");
            }

            if(i < n -m ){
                //find the hash of the next character
                //we are rolling out the previous character and then rolling in the next character and then finding the hash for it.
                t = ( d * (t - txt.charAt(i)*h) + txt.charAt(i+m))%q;
                if ( t < 0) t = t + q;
            }
        }
    }
}
