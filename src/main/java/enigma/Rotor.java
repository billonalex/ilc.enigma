package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[Machine.numAlpha];
    private int[] bcipher = new int[Machine.numAlpha];
    private int notch1 = -1;
    private int notch2 = -1;

    public int getPosition() {
        return position;
    }

    public void setPosition(int posn) {
        position = posn;
    }
    
	public static Rotor rotorFactory(String str, String notches){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[Machine.numAlpha];
		for (int i = 0; i< Machine.numAlpha; i++){
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    public int convertForward(int p) {
        return (cipher[(p+position)%Machine.numAlpha]-position)%Machine.numAlpha;
    }

    public int convertBackward(int e) {
        return (bcipher[(e+position)%Machine.numAlpha]-position)%Machine.numAlpha;
    }
    
    public void advance() {
        position = (position+1) % Machine.numAlpha;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<Machine.numAlpha; i++)
			bcipher[cipher[i]] = i;
	}



}
