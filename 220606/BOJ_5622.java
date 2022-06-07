import java.io.IOException;

public class BOJ_5622 {
    public static void main(String[] args) throws IOException {
        int sum = 0;		// 합계

        while(true)
        {
            // 문자열을 하나씩 입력
            int read = System.in.read();

            // Enter가 입력되면 break;
            if(read < 'A')
                break;
                // 각 문자마다 값을 계산
            else if(read < 'D')
                sum += 3;
            else if(read < 'G')
                sum += 4;
            else if(read < 'J')
                sum += 5;
            else if(read < 'M')
                sum += 6;
            else if(read < 'P')
                sum += 7;
            else if(read < 'T')
                sum += 8;
            else if(read < 'W')
                sum += 9;
            else if(read < '[')
                sum += 10;
        }

        // 결과 출력
        System.out.print(sum);
    }
}
