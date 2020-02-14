import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class hw2_2 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO 自動產生方法 Stub
		Random r = new Random();
		List<BigDecimal> arr = new ArrayList();
		
		while(arr.size() < 15) {			
			double num = r.nextDouble()+r.nextInt(10);
			BigDecimal bb = new BigDecimal(num).setScale(3,RoundingMode.HALF_UP);
			if(!arr.contains(bb)) {
				arr.add(bb); //往集合裡面新增資料。
			}
		}
		Collections.sort(arr);
		System.out.print("陣列:");
		StringBuffer s = new StringBuffer();
		Iterator it = arr.iterator();
		while(it.hasNext()){
			Object o = it.next();
			if(s.length() > 0){
				s.append(",");
				s.append(o);
			} else{
				s.append(o);
			}	
		}
		String ss = s.toString();		
		System.out.println(ss);
		BigDecimal total = new BigDecimal(0);
		BigDecimal count = new BigDecimal(15);
		for (BigDecimal number:arr) {
			total = total.add(number);
		}
		System.out.println("平均數:"+total.divide(count,3,RoundingMode.HALF_UP));

	}

}
