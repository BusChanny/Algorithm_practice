import java.util.*;
import java.io.*;
public class boj_2480{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int ans = 0;
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[7];
        for(int i = 0; i < 3; i++){
            arr[Integer.parseInt(st.nextToken())]++;
        }
        //int num1 = Integer.parseInt(st.nextToken());
        //int num2 = Integer.parseInt(st.nextToken());
        //int num3 = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 6; i++){
            if(max < arr[i]){
                max = arr[i];
                idx = i;
            }
        }
        //1. 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
        //2. 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
        //3. 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다. 
        if(max == 3){
            ans = 10000 + idx * 1000;
        }else if(max == 2){
            ans = 1000 + idx * 100;
        }else {
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 1) idx = i;
            }
            ans = idx * 100;
        }
        System.out.println(ans);


    }
}