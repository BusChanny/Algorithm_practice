import org.junit.Assert;
import org.junit.Test;

public class prog_멀쩡한사각형 {
//        public long solution(int w, int h) {
//            int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
//            return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
//        }

    public long solution(int w, int h) {
        long answer = 0;
        // 최대공약수를 활용
        for(int i = 0; i < w; i++)
            answer += (Long.valueOf(h) * i) / Long.valueOf(w);

        return answer * 2;
    }

    @Test
    public void 정답() {
        Assert.assertEquals(80, solution(8, 12));
        Assert.assertEquals(80, solution(12, 8));
        Assert.assertEquals(12, solution(4, 4));
    }

}
