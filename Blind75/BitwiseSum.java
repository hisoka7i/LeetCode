import java.util.HashSet;
import java.util.Set;

class BitwiseSum{
	//I was on the right track almost there 
    public int sum(int a, int b) {
        while ( b!= 0){
 int carry = a & b;
 a = a ^ b;

b = carry<<1;
}
return a;
    }
	
}