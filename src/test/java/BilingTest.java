import com.phonecompany.billing.TelephoneBill;
import com.phonecompany.billing.TelephoneBillCalculator;
import org.junit.Test;
import util.TestData;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BilingTest {
    TelephoneBill bill=new TelephoneBill();
    @Test
    public void UT01_checkSum(){
        BigDecimal expectedSum = new BigDecimal(7);
        BigDecimal sum= bill.calculate(TestData.Ucet01.log);
        BigDecimal roundedValue = sum.setScale(3, RoundingMode.HALF_UP);
        BigDecimal expectedSumRound = expectedSum.setScale(3, RoundingMode.HALF_UP);
        boolean isPurchaseSumValid = expectedSumRound.equals(roundedValue);
        assertTrue(isPurchaseSumValid, "UT01_checkSum is valid");
    }
    @Test
    public void UT02_checkSum(){
        BigDecimal expectedSum = new BigDecimal(6.3);
        BigDecimal sum= bill.calculate(TestData.Ucet02.log);
        BigDecimal roundedValue = sum.setScale(3, RoundingMode.HALF_UP);
        BigDecimal expectedSumRound = expectedSum.setScale(3, RoundingMode.HALF_UP);
        boolean isPurchaseSumValid = expectedSumRound.equals(roundedValue);
        assertTrue(isPurchaseSumValid, "UT02_checkSum is valid");
    }
}
