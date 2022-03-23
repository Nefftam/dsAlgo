package code.topic.matrix;

import java.util.Arrays;

public class Rotateby90 {

    public void transpose(int matrix[][])
    {
        for(int i = 0; i < matrix.length ; i++)
        {
            for (int j = i+1 ; j < matrix[i].length; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseRows(int matrix[][])
    {
        int temp = 0;
        for(int row[] : matrix)
        {
            for(int i = 0, j = row.length-1 ; i <=j ; i++, j--)
            {
                temp = row[i];
                row[i] = row[j];
                row[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Rotateby90 rotate = new Rotateby90();
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        rotate.transpose(arr);
        System.out.println("\n After transpose");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        rotate.reverseRows(arr);
        System.out.println("\n After reverse");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
