import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;


public class COCOMO_javaTests {

	@Test
	public void testFround() {
		assertEquals(COCOMO_java.fround(1.01f),1);
		assertEquals(COCOMO_java.fround(1.51f),2);
		assertEquals(COCOMO_java.fround(2.999999f),3);
	}
	
	@Test 
	public void testCalculate() {
		
        // Given input
        float[][] table = {
                {2.4f, 1.05f, 2.5f, 0.38f},
                {3.0f, 1.12f, 2.5f, 0.35f},
                {3.6f, 1.20f, 2.5f, 0.32f}};
        char[][] mode = new char[4][15];
        mode[0] = "Organic".toCharArray();
        mode[1] = "Semi-Detached".toCharArray();
        mode[2] = "Embedded".toCharArray();

        int size = 4;

        // Capture system output to test as calculate doesn't return anything
        ByteArrayOutputStream captureStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(captureStream);
        PrintStream oldStream = System.out;
        
        System.setOut(out);

        try {
			COCOMO_java.calculate(table, 3, mode, size);
		}         
        catch (Exception e) {
			e.printStackTrace();
		}

        System.out.flush();
        System.setOut(oldStream);
        
        System.out.println(captureStream.toString());
        
        // Using regex, determine that the correct values are in the correct places
        
        // Mode
        assertTrue(captureStream.toString().matches("The mode is(\\s*)Organic(.|\n)*"));
        
        // Effort
        assertTrue(captureStream.toString().matches("(.|\n)*Effort =(\\s*)10.289025(.|\n)*"));
        
        // Development Time
        assertTrue(captureStream.toString().matches("(.|\n)*Development Time =(\\s*)6.062367(.|\n)*"));
        
        // Average Staff Required
        assertTrue(captureStream.toString().matches("(.|\n)*Average Staff Required =(\\s*)2(.|\n)*"));
	}
}
