import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class hw1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random r = new Random();
		Map<Integer, Integer> map = new HashMap<>();
		int x;
		for (int i = 0; i < 20; i++) {
			x = r.nextInt(6) + 1;
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}
		for (int i = 1; i < 7; i++) {
			if (map.get(i) == null) {
				System.out.println(i + ":" + 0 + "¦¸");
			} else {
				System.out.println(i + ":" + map.get(i) + "¦¸");
			}
		}
	}
}
