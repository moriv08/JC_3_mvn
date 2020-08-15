import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.hw_6.MainClass;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class ParamTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new int[]{2, 3, 4, 5, 6, 7, 9}},
                {new int[]{1, 1, 1, 1,1}},
                {new int[]{4, 1}},

        });
    }

    int[] arr;

    public ParamTest(int[] arr) {
            this.arr = arr;
    }

    MainClass mainClass;

    @Before
    public void init(){
        mainClass = new MainClass();
    }

    @Test
    public void paramTestAdd(){
        Assert.assertTrue(mainClass.foreOne(arr));
    }

}
