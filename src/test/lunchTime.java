package test;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class lunchTime {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //System.out.println("Hello Goorm! Your input is " + input);

        // 1라인 : 햄버거 개수
        int hamburgerCount = Integer.parseInt(input);
        Integer[] eatTime = parseTime(br.readLine(), "D" );
        Integer[] burnTime = parseTime(br.readLine(), "A" );

        int minLunchTIme = getLunchTime( accureTime(burnTime), eatTime );

        System.out.println(minLunchTIme);
    }

    public static int getLunchTime( Integer[] eatTime, Integer[] burnTime ){

        Integer[] lunchTime = new Integer[eatTime.length];

        for( int i = 0 ; i < eatTime.length ; i++ ){
            lunchTime[i] = eatTime[i] + burnTime[i];
        }
        Arrays.sort(lunchTime);
        return lunchTime[lunchTime.length-1];
    }

    // 시간 데이터는 누적.
    public static Integer[] accureTime( Integer[] burnTime ){

        int heatTime = 0 ;
        for( int i = 0 ; i < burnTime.length ; i++){
            burnTime[i] = burnTime[i] +  heatTime;
            heatTime = burnTime[i];
        }
        return burnTime;
    }


    public static Integer[] parseTime( String source, String sortType ){

        // 소트타입 : Desc, Asc
        String[] _time = source.split(" ");
        Integer[] response = new Integer[_time.length];

        for( int i = 0 ; i < _time.length; i++ ){
            response[i] = Integer.parseInt(_time[i]);
        }

        if( sortType.equals("A") ){
            Arrays.sort(response);
        } else {
            Arrays.sort(response, Collections.reverseOrder() );
        }

        return response;
    }

}
