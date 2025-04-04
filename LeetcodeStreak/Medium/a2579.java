import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class a2579 {
    public static void main(String[] args) {
        Set<List<Integer>> positions = new HashSet<>();
        positions.add(Arrays.asList(0,0));
        positions.add(Arrays.asList(0,0));

        System.out.println(positions.size());
    }

    //this was my intution and I completed this code using chatGPT but there is time limit exceeded issue with this approach
    public long coloredCells(int n) {
        if (n == 0) return 0;

        Set<List<Integer>> total = new HashSet<>();
        Set<List<Integer>> current = new HashSet<>();

        List<Integer> start = Arrays.asList(0, 0);
        total.add(start);
        current.add(start);

        // Directions: up, down, left, right
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (--n > 0) {
            Set<List<Integer>> next = new HashSet<>();

            for (List<Integer> pos : current) {
                int x = pos.get(0);
                int y = pos.get(1);

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    List<Integer> newPos = Arrays.asList(newX, newY);

                    if (!total.contains(newPos)) {
                        total.add(newPos);
                        next.add(newPos);
                    }
                }
            }

            current = next; // next layer of cells to expand from
        }

        return total.size();
    }
    public long coloredCells2(int n) {
        long totalcolored = 1;
        int newcolored = 4;

        while(--n > 0){
            totalcolored += newcolored;
            newcolored += 4;
        }
        return totalcolored;
    }
}
