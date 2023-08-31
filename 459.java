class a459 {
    public boolean repeatedSubstringPattern(String s) {
        char first = s.charAt(0);
        int nextIndex = 0;
        int i;
        for(i=1;i<s.length();i++){
            if(first.equals(s.charAt(i))){
                nextIndex=i;
                break;
            }
            if(i==(s.length()-1)){
                return false;
            }
        }
        int[] count = new int[i+1];
        for(i=0;i<i+1;i++){
          int countchar = 0;
          for(int j=0;j<s.length();j++){
            if(s.charAt(i)==s.charAt(j)){
              count++;
            }
          count[i]=countchar;
          }
        }

    }
}
