import java.util.*;

public class Prog_오픈채팅방 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                Solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                        "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));

    }

    private static String[] Solution(String[] record) {
        StringTokenizer st = null;
        HashMap<String, String> map = new HashMap<>();
        Queue<String[]> execQ = new LinkedList<>();
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);

            String exec = st.nextToken();
            String id = st.nextToken();
            String nickName = "";
            if (st.hasMoreTokens()) {
                nickName = st.nextToken();
            }

            if (exec.equals("Enter")){
                map.put(id, nickName);
                execQ.offer(new String[] {"Enter", id});
            }else if (exec.equals("Change")){
                map.put(id, nickName);
            }else {
                execQ.offer(new String[] {"Leave", id});
            }

        }

        int size = execQ.size();
        String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            String[] temp = execQ.poll();
            if (temp[0] == "Enter"){
                answer[i] = map.get(temp[1]) + "님이 들어왔습니다.";
            }else {
                answer[i] = map.get(temp[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
