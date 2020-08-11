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
                {1, 2, 3, 4, 5, 6, 7, 8},
                {2, 3, 4, 5, 6, 7, 9},
                {1, 1, 1, 1,1},
                {4},

        });
    }

    int[] arr;

    public ParamTest(int... arr) {
        this.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
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
