//This is the basic idea behind hashing.

public class CharHashing{
  public static void main(String[] args){
    char[] sample = {'a','b','a','c','c','a','d'};

    int[] count = new int[97];

    for(int i=0;i<sample.length;i++){
      int location = sample[i] - 'a';
      System.out.println(location);
      count[location] +=1;
    }

    for(int i=0;i<sample.length;i++){
      int occ = sample[i]-'a';
      System.out.println("Count of:"+sample[i]+" is "+count[occ]);
    }
  }
}
