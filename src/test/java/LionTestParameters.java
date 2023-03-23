import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameters {

    @Mock
    Feline feline;
    String sex;
    boolean hasMane;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public LionTestParameters(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeCheck() throws Exception {
        Lion lion = new Lion(sex, feline);
        String message = "Используйте допустимые значения пола животного - самец или самка";
        Assert.assertEquals(message, hasMane, lion.doesHaveMane());
    }

}
