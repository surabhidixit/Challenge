import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by surabhi on 8/4/17.
 */

/*
Unit tests for all the methods 
*/
public class SmallestBasePalindromeTest extends TestCase {
    SmallestBasePalindrome tester=new SmallestBasePalindrome();
    public void testGetBase() throws Exception {
        Assert.assertNotNull(tester.getBase()!=null);

    }

    public void testConverttoBase() throws Exception {
        Assert.assertEquals(tester.converttoBase(11),10);
    }

    public void testIsPalindrome() throws Exception {
        Assert.assertTrue(tester.isPalindrome("121"));

    }

    public void testCheckValue() throws Exception {
        Assert.assertEquals(tester.checkValue(15,17),"F");
    }

}
