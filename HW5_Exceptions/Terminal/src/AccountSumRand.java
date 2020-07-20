import java.math.BigDecimal;

public class AccountSumRand {

    public static BigDecimal randomAccountSum(){
        BigDecimal min = new BigDecimal("0");
        BigDecimal max = new BigDecimal("1000000000000000000");
        BigDecimal result = min.add(max.multiply(BigDecimal.valueOf(Math.random())));
        return result.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
