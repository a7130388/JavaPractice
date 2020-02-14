import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class hw3_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動產生方法 Stub
		int month = 0;

		while (month <= 0 || month > 12) {
			System.out.print("請輸入月份：");
			month = new Scanner(System.in).nextInt();
		}

		System.out.println("     2020年    " + month + " 月");
		System.out.println("日     一   二   三   四   五   六 ");
		System.out.println("========================");

		int remois = month - 1;
		Calendar cal = new GregorianCalendar(2020, remois, 1);
		int day = cal.getActualMaximum(Calendar.DATE);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);

		for (int k = 1; k < day_of_week; k++) {
			System.out.print("   ");
		}

		for (day_of_month = 1; day_of_month <= day; day_of_month++) {
			if (day_of_month < 10) {
				System.out.print(" " + day_of_month + " ");
			} else {
				System.out.print(day_of_month + " ");
			}
			if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
				System.out.println("");
			}
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

}
