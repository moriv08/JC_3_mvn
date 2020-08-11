import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.hw_6.TestAdd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)

public class ParamTestAdd {

    TestAdd testAdd;
    int a;
    int b;
    int c;

    public ParamTestAdd(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2, 1, 1},
                {4, 2, 2},
        });
    }



    @Before
    public void init(){
        testAdd = new TestAdd();
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(a, b, c);
    }
}
