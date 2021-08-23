import java.util.*;

public class BOJ_S5_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        String [] arr = new String[T];
        for (int t = 0; t < T; t++) {
            arr[t] = sc.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() - o2.length() == 0) {    //길이가 같으면
                    return o1.compareTo(o2);    // 사전순 정렬
                }
                return o1.length() - o2.length(); // 길이순 정렬
            }
        });

        for (int i = 0; i < T; i++) {
            if (i + 1 != T) {
                if (arr[i].equals(arr[i + 1])) {
                    continue;
                }
            }
            System.out.println(arr[i]);
        }
    }
}
