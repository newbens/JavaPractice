package shujujiegou;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class SparseArray {     //稀疏素组
    public static void main(String[] args) throws Exception {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        for (int[] row : arr) {
            for (int data : row) {

            }
        }

        int sum = 0;
        HashMap<Integer,Integer> a = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    sum += 1;
                }
            }
        }

        int[][] arr2 = new int[sum + 1][3];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    count ++;
                    arr2[count][0] = i;
                    arr2[count][1] = j;
                    arr2[count][2] = arr[i][j];
                }
            }
        }
        arr2[0][0] = arr.length;
        arr2[0][1] = arr.length;
        arr2[0][2] = sum;
    //数据存入硬盘
        OutputStreamWriter br = new OutputStreamWriter(new FileOutputStream("E:\\IDEA\\稀疏数组.txt"),"gbk");
        BufferedWriter writer = new BufferedWriter(br);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                writer.write(arr2[i][j]);                              //int型转string，write方法写入int会乱码
            }
        }
        writer.close();

    //从硬盘读取数据
        InputStreamReader bi = new InputStreamReader(new FileInputStream("E:\\IDEA\\稀疏数组.txt"),"gbk");
        BufferedReader reader = new BufferedReader(bi);
        int r = reader.read();
 /*       int r2 = new BufferedReader(bi).read();
        int getNum = 0;
        while (r2 != -1) {
            getNum ++ ;
            r2 = reader.read();   }                  //先得到数据长度，除以三就可以得到二维数组长度 */

        int[][] getData = new int[3][3];    //将读取的数据存入数组
        int count2 = 0;
        while (r != -1) {
            getData[count2/3][count2%3] = r;
            count2 ++;
            r = reader.read();
        }
        bi.close();
    //重现数组
        int[][] newArr = new int[getData[0][0]][getData[0][1]];
        for (int i = 1; i <getData.length ; i++) {
            newArr[getData[i][0]][getData[i][1]] = getData[i][2];
        }
        System.out.println(Arrays.deepToString(newArr));
    }


}

