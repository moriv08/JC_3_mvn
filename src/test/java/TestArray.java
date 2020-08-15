
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.hw_6.MainClass;

public class TestArray {

    private MainClass arrTest;

    @Before
    public void before(){
        arrTest = new MainClass();
    }

    @Test(expected = RuntimeException.class)
    public void test_1(){
        int[] array = { 1, 2, 3, 2, 3, 3, 1, 7};
        int[] array2 = {};
        Assert.assertArrayEquals(array2, arrTest.forePlus(array));
    }

    @Test
    public void test_2(){
        int[] array = { 1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] array2 = {1, 7};
        Assert.assertArrayEquals(array2, arrTest.forePlus(array));
    }

    @Test
    public void test_3(){
        int[] array = { 1, 2, 4, 4, 2, 3, 4, 1, 7, 2, 3, 3, 2, 3};
        int[] array2 = {1, 7, 2, 3, 3, 2, 3};
        Assert.assertArrayEquals(array2, arrTest.forePlus(array));
    }

    @Test
    public void test_4(){
        int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9};
        int[] array2 = { 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(array2, arrTest.forePlus(array));
    }

    @Test
    @Ignore("If test_6 ok, then test_5 ok too")
    public void test_5(){
        int[] array = {2,2,2,2,2,2};
        Assert.assertFalse(arrTest.foreOne(array));
    }

    @Test
    public void test_6(){
        int[] arr = {1, 1, 4, 4, 4};
        Assert.assertTrue(arrTest.foreOne(arr));
    }
}
