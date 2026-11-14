
import livingstack.LivingStack;
import livingstack.LivingStack1L;

public class LivingStack1LTest {

    @Test
    public void testisEmpty() {

        LivingStack<String> yahoos = new LivingStack1L<>();

        boolean isEmpty = yahoos.isEmpty();

        asserEquals(true, isEmpty);

    }

}
