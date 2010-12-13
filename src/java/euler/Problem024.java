package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem024 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9");
		System.out.println(problem024(list, 1000000));
	}

	/**
	 * Solve using recursivity
	 * @param digits
	 * @param index
	 * @return answer
	 */
	public static String problem024(List<String> digits, int index) {
		StringBuffer answer = new StringBuffer();
		recur(index - 1, digits, answer, "", 0);
		return answer.toString();
	}

	/**
	 * Recur on all sequences. Stop at the target index.
	 * 
	 * @param index
	 *            target index. Zero-based
	 * @param digits
	 *            digits available
	 * @param answer
	 *            sequence at the target index
	 * @param current
	 *            current sequence. May be incomplete
	 * @param current_index
	 *            current sequence index. Zero-based
	 * @return new current_index
	 */
	private static int recur(int index, List<String> digits,
			StringBuffer answer, String current, int current_index) {

		for (int i = 0; i < digits.size(); i++) {

			if (answer.length() != 0) {
				break;
			}

			String sequence = current + digits.get(i);

			ArrayList<String> copy = new ArrayList<String>(digits);
			copy.remove(i);

			if (copy.size() == 1) {
				if (current_index == index) {
					answer.append(sequence + copy.get(0));
				}
				current_index++;
			} else {
				current_index = recur(index, copy, answer, sequence,
						current_index);
			}
		}

		return current_index;
	}
}
