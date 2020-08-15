import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.hw_6.MainClass;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class ParamArrayTest {

    MainClass main;
    int[] arr_1;
    int[] arr_2;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[] {1, 2, 3}, new int[]{1, 2, 4, 1, 2, 3}},
                {new int[] {9, 5, 2, 7, 1, 2, 3}, new int[]{1, 2, 4, 9, 5, 2, 7, 1, 2, 3}},
                {new int[] {3, 3, 3}, new int[]{1, 2, 4, 3, 3, 3}},
        });
    }

    public ParamArrayTest(int[] arr_1, int[] arr_2) {
        this.arr_1 = arr_1;
        this.arr_2 = arr_2;
    }

    @Before
    public void init(){
        main = new MainClass();
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(arr_1, main.forePlus(arr_2));
    }
}
