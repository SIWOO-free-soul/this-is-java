package test;
import java.io.*;
import java.util.Arrays;

public class container {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //System.out.println("Hello Goorm! Your input is " + input);

        // 컨테이너 숫자
        int containerCount = Integer.parseInt(input);

        // 컨테이너 사이즈 배열
        int[] containerSize = new int[containerCount];

        for( int i = 0 ; i < containerCount ; i++ ){
            containerSize[i] = Integer.parseInt(br.readLine());
        }
        // 입력된 컨테이너 사이즈 소트 : 맨 양쪽에 있는 사이즈중 절대값 큰거가 맨 아래층
        Arrays.sort(containerSize);

        // 첫번째 컨테이너 결정
        int firstFloor = selectFirstFloor( containerSize );

        int maxFloorStep = getContainerFloor( containerSize, firstFloor );
        System.out.println( maxFloorStep );

    }

    public static int selectFirstFloor( int[] containerSize ){
        int firstFloor = Math.abs( containerSize[0] ) > containerSize[containerSize.length-1] ? containerSize[0] : containerSize[containerSize.length-1];
        return firstFloor;
    }

    public static int getContainerFloor( int[] containerSize, int currentFloor ){

        // 1층부터 올라간
        for( int i = 1 ; i < containerSize.length ; i++  ){
            currentFloor = selectContainer( containerSize, currentFloor );
            if( currentFloor == 0 ){
                return i;
            }
        }
        return 0;
    }

    // 현재 최상위 컨테이너보다 한단계 작은 색상 다른 컨테이너 고르기
    public static int selectContainer( int[] containerSize, int currentTopFloor ){

        // 색상변경을 위하여 음수양수 변경
        currentTopFloor = currentTopFloor * -1;


        if( currentTopFloor < 0 ){
        // 음수중 찾아야 한다면
            for( int i = 0 ; i < containerSize.length ; i++){
                if( containerSize[i] > 0 ){
                    // 양수까지는 갈 필요없음
                    return 0;
                } else if( containerSize[i] > currentTopFloor ){
                    return containerSize[i];
                }
            }
        } else {
        // 양수중 찾아야 한다면
            for( int i = containerSize.length-1 ; i > 0 ; i--){
                if( containerSize[i] < 0 ){
                    // 음수까지는 갈 필요없음
                    return 0;
                } else if( containerSize[i] < currentTopFloor ){
                    return containerSize[i];
                }
            }
        }
        // 예외
        return 0;
    }
}
