import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensCountCheck() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodCheck() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);
        Assert.assertEquals(expectedList, lion.getFood());
    }

    @Test
    //Проверка исключения для пола животного
    public void lionCheckForSexOfAnimal() {
        String exceptionExpectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception trowException = Assert.assertThrows(Exception.class,() -> new Lion("Не определен", feline));
        Assert.assertEquals(trowException.getMessage(), exceptionExpectedMessage);
    }

}