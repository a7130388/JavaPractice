public class hw3_1 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �۰ʲ��ͤ�k Stub
		int runnum = 100000;
		Runtime run = Runtime.getRuntime();
		
		// System.out.println("memory> total:" + run.totalMemory() + " free:" +
		// run.freeMemory() + " used:" + (run.totalMemory()-run.freeMemory()) );
		System.out.println("" + runnum + "���G");
		String a = "a";
		long tim1 = System.currentTimeMillis();
		long startMem = run.totalMemory() - run.freeMemory();
		for (int i = 0; i < runnum; i++)
			a += "0";
		long tim2 = System.currentTimeMillis();
		long endMem = run.totalMemory() - run.freeMemory();
		System.out.println(("String�걵�ϥΡG" + (tim2 - tim1) + "�@��"));
		System.out.println("memory �ϥ�:" + (endMem - startMem));
		
		StringBuilder sb = new StringBuilder("a");
		tim1 = System.currentTimeMillis();
		startMem = run.totalMemory() - run.freeMemory();
		for (int i = 0; i < runnum; i++)
			sb.append("0");
		tim2 = System.currentTimeMillis();
		endMem = run.totalMemory() - run.freeMemory();
		System.out.println(("��Stringbuilder�걵�ϥΡG" + (tim2 - tim1) + "�@��"));
		System.out.println("memory �ϥ�:" + (endMem - startMem));
	}

}
