import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class hw1_2 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Random r = new Random();
		List arr = new ArrayList();
		DecimalFormat df = new DecimalFormat("#.###");

		while (arr.size() < 15) {
			double num = r.nextDouble() + r.nextInt(10);

			if (!arr.contains(num)) {
				arr.add(df.format(num)); // 往集合裡面新增資料。
			}
		}
		System.out.print("陣列:");
		StringBuffer s = new StringBuffer();
		Iterator it = arr.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (s.length() > 0) {
				s.append(",");
				s.append(o);
			} else {
				s.append(o);
			}
		}
		String ss = s.toString();
		System.out.println(ss);

		double sum = 0;
		for (Object number : arr) {
			sum = sum + Double.valueOf(number.toString());
		}
		System.out.println("總和:" + df.format(sum));
		System.out.println("平均數:" + df.format(sum / 15));

	}

}
