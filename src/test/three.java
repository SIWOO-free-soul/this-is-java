package test;

import java.io.*;
public class three {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        String[] resource = input.split(" ");
        int start = Integer.parseInt(resource[0]);
        int end = Integer.parseInt(resource[1]);

        // 최대 사이클
        int maxCycle = 0;
        // 촤대 사이클을 만든 숫자
        //int maxNum = 0;

        for( int i = start ; i <= end ; i++){
            int count = process((long)i);
            if( maxCycle < count ){
                maxCycle = count;
//                maxNum = i;
            }
        }

//        System.out.println(maxNum);
        System.out.println(maxCycle);
    }

    public static int process( long m ){
        // 사이클
        int count = 1 ;

        while ( m != 1 ){
            m = (m % 2 == 0) ? m/2 : m*3+1;
            count++;
        }
        return count;
    }
}
