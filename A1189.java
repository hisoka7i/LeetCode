class A1189{
  public static void main(String[] args){
    String str = "loonbalxballpoon";
    /*
find the number of 'b', 'a', 'l', 'o', 'n'
number of b should be equal to number of a and n;
then number of l and o should be double of b;
     */
     int len = str.length();
     int number_of_b = 0;
     int number_of_a = 0;
     int number_of_l = 0;
     int number_of_o = 0;
     int number_of_n = 0;
     for(int i=0;i<len;i++){
       if(str.charAt(i)=='b')number_of_b++;
       if(str.charAt(i)=='a')number_of_a++;
       if(str.charAt(i)=='l')number_of_l++;
       if(str.charAt(i)=='o')number_of_o++;
       if(str.charAt(i)=='n')number_of_n++;
     }
     if(number_of_b!=number_of_a && number_of_a!=number_of_n){
       System.out.println("Error a");
     }
     if(2*number_of_a != number_of_l){
       System.out.println("Error");
     }
     if(2*number_of_a != number_of_o){
       System.out.println("Error");
     }
     System.out.println("Number of baloons "+number_of_a);
  }
}
