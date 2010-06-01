package euler.problem059;

public class CountedCharacterImpl implements CountedCharacter {

	private byte c;
	private int count;
	
	public CountedCharacterImpl(byte c, int count) {
		this.c = c;
		this.count = count;
	}
	
	public byte getCharacter() {
		return c;
	}

	public int getCount() {
		return count;
	}

	public int compareTo(Object o) {
		CountedCharacterImpl ob = (CountedCharacterImpl) o;
		return count - ob.count;
	}

}
