package euler.problem059;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class Problem059 {
	
	static public byte[] loadCryptedText() throws IOException {
		File file = new File("res/cipher1.txt");
		String text = FileUtils.readFileToString(file, "UTF-8");
		text = StringUtils.trim(text);
		String[] characters = StringUtils.split(text, ',');
		byte[] data = new byte[characters.length];
		for (int i = 0; i < characters.length; i++) {
			String character = characters[i];
			data[i] = Byte.parseByte(character);
		}
		return data;
	}
	
	static public String decrypt(byte[] key, byte[] data) {
		if (key.length != 3){
			throw new RuntimeException("Invalid key: " + new String(key));
		}
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (byte character : data) {
			sb.append(new char[] {(char) (character ^ key[i++])});
			if (i == 3) i = 0;
		}
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	static public void sortByOccurences(byte[] data) {
		// Count
		Map<Byte, Integer> map = new HashMap<Byte, Integer>();
		for (byte b : data) {
			Integer old = map.get(b); 
			if (old == null) {
				map.put(b, 1);
			} else {
				map.put(b, ++old);
			}
		}
		
		// Sort
		Iterator<Byte> iter = map.keySet().iterator();
		List<CountedCharacterImpl> list = new LinkedList<CountedCharacterImpl>();
		while (iter.hasNext()) {
			byte key = iter.next();
			CountedCharacterImpl c = new CountedCharacterImpl(key, map.get(key));
			list.add(c);
		}
		Collections.sort(list);
		
		// Display
		for (CountedCharacterImpl c : list) {
			System.out.println(c.getCharacter() + " = " + c.getCount());
		}
	}
	
	static public String searchMatch(byte[] data, String[] words) {
		// Try all keys (97 -> a and 122 -> z)
		for (byte i = 97; i <= 122; i++) {
			for (byte j = 97; j <= 122; j++) {
				for (byte k = 97; k <= 122; k++) {
					String text = decrypt(new byte[] {i, j, k}, data);
					for (String word: words) {
						if (text.matches("(?i).*" + word + ".*")) {
							return text;
						}
					}
				}
			}
		}
		return null;
	}
	
	static public int getSum(String text) {
		int sum = 0;
		for (byte b : text.getBytes()) {
			sum += b;
		}
		return sum;
	}
	
	static public void main(String[] args) {
		byte[] data = null;
		try {
			data = loadCryptedText();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		long start = System.currentTimeMillis();
		String text = searchMatch(data, new String[] {"Gospel"});
		System.out.println("Answer: " + getSum(text));
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
	}
	
}
