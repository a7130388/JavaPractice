import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class hw2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random r = new Random();

		Map<Integer, String> map = new TreeMap<>();
		for (int i = 0; i < 100; i++) {
			int total = (r.nextInt(6) + 1) + (r.nextInt(6) + 1)
					+ (r.nextInt(6) + 1);
			if (map.containsKey(total)) {
				map.put(total, map.get(total) + "*");
			} else {
				map.put(total, "*");
			}
		}
		Iterator<Integer> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + map.get(key));
		}

	}

}
