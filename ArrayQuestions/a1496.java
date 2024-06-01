package ArrayQuestions;
import java.util.HashSet;
import java.util.Set;

public class a1496 {
    public static void main(String[] args) {
        String path="NESSSSSWWWWW";
        System.out.println(crossPath(path.toCharArray()));
    }
    public static boolean crossPath(char[] path){
         Set<String> visitedPoints = new HashSet<>();
        int xPos = 0, yPos = 0;
        visitedPoints.add(xPos+","+yPos);
        for(char dir: path.toCharArray()){
            switch(dir){
                case 'N': {
                    yPos++;
                    break;
                }
                case 'S':{
                    yPos--;
                    break;
                }
                case 'E':{
                    xPos++;
                    break;
                }
                case 'W':{
                    xPos--;
                    break;
                }
            }
            if(visitedPoints.contains(xPos+","+yPos))return true;
            visitedPoints.add(xPos+","+yPos);
        }
        return false;
    }
}
