package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {
    
        Rotor r1 = Rotor.rotorFactory("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "W");
        Rotor r2 = Rotor.rotorFactory("B A C D E F G H I J K L M N O P Q R S T U V W X Y Z", "W");

	@Test
	public void Advance_True() {
            int position = 1;
            int expected = position + 1;
            r1.setPosition(position);
            r1.advance();            
            assertEquals(expected, r1.getPosition());
	}

        public void ConvertBackward_A_B() {
            r2.setPosition(0);
            int expected = 1;
            assertEquals(expected, r2.convertBackward(0));
        }
}
