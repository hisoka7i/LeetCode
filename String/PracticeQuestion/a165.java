package PracticeQuestion;

public class a165 {
    public static void main(String[] args) {
        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println(compareVersion(version1, version2));
    }
    public static int compareVersion(String version1, String version2) {
        String[] version1_array = version1.split("\\.");
        String[] version2_array = version2.split("\\.");

        int n = version1_array.length;
        int m = version2_array.length;

        for(int i=0;i<(n>m?n:m);i++){
            int num1 = i<n?Integer.valueOf(version1_array[i]):0;
            int num2 = i<m?Integer.valueOf(version2_array[i]):0;

            if(num1<num2)
                return -1;
            if(num1>num2)
                return 1;
        }

        return 0;
    }
}
