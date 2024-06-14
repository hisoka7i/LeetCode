package PracticeQuestion;

public class a551 {
    public static void main(String[] args) {
        
    }
    //The student is eligible for an attendance award if they meet both of the following criteria:

    public static boolean checkRecord(String s) {
        //Attendance 
        char[] attendance_array = s.toCharArray();

        int L = 0;
        int A = 0;

        for(int i=0;i<attendance_array.length;i++){
            if(attendance_array[i]=='L'){
                L++;
                if(L==3)
                    return false;
            }
            if(attendance_array[i]=='A'){
                A++;
                L=0;
            }
            if(attendance_array[i]=='P'){
                L=0;
            }
        }

        if(A>1){
            return false;
        }
        if(L>=3){
            return false;
        }
        return true;
    }
}
