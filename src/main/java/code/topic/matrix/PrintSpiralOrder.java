package code.topic.matrix;

import java.util.ArrayList;
import java.util.List;

/*
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33
40 41 42 43
 */
public class PrintSpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length -1 ;
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int n = row * col;

        while(res.size() < n) {

            //Traverse right
            for(int i = left; i <= right && res.size() < n ; i++){
                System.out.println("right adding " + top + ", " + i);
                res.add(matrix[top][i]);
            }

            top++;
            System.out.println("top = " + top);
            //Traverse bottom
            for(int i = top; i <= bottom && res.size() < n ; i++) {
                System.out.println("bottom adding " + i + ", " + right);
                res.add(matrix[i][right]);
            }

            right--;
            System.out.println("right = " + right);
            //Traverse left
            for(int i = right; i >= left && res.size() < n ; i--) {
                System.out.println("left adding " + bottom + ", " + i);
                res.add(matrix[bottom][i]);
            }

            bottom--;
            System.out.println("bottom = " + bottom);
            //Traverse up
            for(int i = bottom; i >= top && res.size() < n ; i--) {
                System.out.println("up adding " + i + ", " + left);
                res.add(matrix[i][left]);
            }

            left++;
            System.out.println("left = " + left);
        }

        return res;
    }

    public static void main(String[] args) {

        PrintSpiralOrder printSpiralOrder = new PrintSpiralOrder();
        printSpiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}


