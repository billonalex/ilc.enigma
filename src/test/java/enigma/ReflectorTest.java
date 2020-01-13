package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	@Test
	public void ConvertForward_True() {
            int alpha[] = new int[26];
            for (int i = 0; i < 26; i++) {
                alpha[i] = i;
            }
            Reflector reflect = new Reflector(alpha);
            int conversion = reflect.convertForward(0);
            assertEquals(conversion, 0);
	}

}
