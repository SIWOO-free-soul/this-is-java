package test;
import java.io.*;

public class lunch {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //System.out.println("Hello Goorm! Your input is " + input);

        String[] resource = input.split(" ");

        // 첫번쨰 입력데이터 :: 피자 n판을 교환할 수 있는 쿠폰
        int pizzaCount = Integer.parseInt(resource[0]);

        // 피자로 교환가능한 쿠폰 단위
        int pizzaCouponSize = Integer.parseInt(resource[1]);

        int pizzaMax = pizzaCount + morePizza(pizzaCount, pizzaCouponSize);
        System.out.println( pizzaMax );
    }

    public static int morePizza( int pizzaCount, int pizzaCouponSize){

        if( pizzaCount < pizzaCouponSize ){
            return 0;
        }
        int pizza = pizzaCount / pizzaCouponSize;
        return pizza + morePizza( pizza + ( pizzaCount % pizzaCouponSize ), pizzaCouponSize );
    }
}
