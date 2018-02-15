import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;
import java.lang.StringBuilder;

class Permutations {
	Deque<String> permutations(String str) {
		Deque<String> ret = new LinkedList<String>(Arrays.asList(""));
		char[] letters = str.toCharArray();

		// For each letter,
		for (int i = 0; i < letters.length; i++) {
			char letter = letters[i];

			int numPartials = ret.size();
			// And for each word currently in our result list,
			for (int iters = 0; iters < numPartials; iters++) {
				String currPartial = ret.removeFirst();

				// We can insert the next letter in (i + 1) positions.
				for (int pos = 0; pos <= i; pos++) {
					StringBuilder sb = new StringBuilder(currPartial);
					ret.addLast(sb.insert(pos, letter).toString());
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		Deque<String> permutes = p.permutations("ABC");
		System.out.println(permutes.toString());
		System.out.println(permutes.size());
	}
}
