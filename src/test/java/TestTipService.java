import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.example.TipService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTipService {
    TipService tipService = new TipService();

    @ParameterizedTest
    @ValueSource(strings = {"500", "800", "999"})
    public void testCalculationTipsForPurchasesUnder1000(BigDecimal purchase){
        BigDecimal exp = purchase.multiply(BigDecimal.valueOf(1.1));
        assertEquals(exp, tipService.roundTips(purchase));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "1001", "1500"})
    public void testCalculationTipsForPurchasesOver1000(BigDecimal purchase){
        BigDecimal exp = purchase.multiply(BigDecimal.valueOf(1.05));
        assertEquals(exp, tipService.roundTips(purchase));
    }
}
