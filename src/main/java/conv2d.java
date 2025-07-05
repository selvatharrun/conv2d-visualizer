import java.io.*;
import java.util.*;

public class conv2d {
    public static void main(String[] args) {
      int[][] image = new int[][]; //ill get sparse matrix from a diff module.

      int fsm = 3; //filter_size_m , no. of rows 
      int fsn =3;//filter_size_n , no. of columns
      int stride = 1;

      int[][] filter = new int[fsm][fsn];
      int outheight = 1+ ((image.length - fsn)/stride);
      int outbreadth = 1+ ((image[0].length - fsm)/stride);
      int[][] output = new int[outheight][outbreadth];

      int outcol =0;
      int outrow=0;

      for(int i=0;i<image.length-fsm;i+=stride){
        for(int j=0;j<image[0].length-fsn;j+=stride){
          int sum =0;
          for(int m=0;m<fsm;m++){
            for(int n=0;n<fsn;n++){
              sum+=image[i+m][j+n]*filter[m][n];
            }
          }
          output[outrow][outcol++] = sum;
        }
        outrow++;
      }
    }
}
