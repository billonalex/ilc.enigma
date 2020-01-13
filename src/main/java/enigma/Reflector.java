package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {
	
	int[] reflection;
	
	public static Reflector reflectorFactory(String str){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[Machine.numAlpha];
		for (int i = 0; i< Machine.numAlpha; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	Reflector(int[] r){
		super(r,0);
		reflection = r;
	}
        
    public int convertForward(int p) {
        return (reflection[(p)%Machine.numAlpha])%Machine.numAlpha;
    }

    @Override
    public int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
