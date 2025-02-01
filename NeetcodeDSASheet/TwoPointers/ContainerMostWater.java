package NeetcodeDSASheet.TwoPointers;

public class ContainerMostWater {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int maximum_area = 0;
        while(p1 < p2){
            int current_area = Math.min(height[p1], height[p2]) * (p2 - p1); //here we will get the current area
            maximum_area = Math.max(maximum_area, current_area);
            //now we will move the pointer which is less in height
            if(height[p1] > height[p2]){
                p2--;
            }else{
                p1++;
            }
        }
        return maximum_area;
    }
}
