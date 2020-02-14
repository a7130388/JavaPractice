import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw5 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws UnsupportedEncodingException,
			IOException {
		// TODO 自動產生方法 Stub

		// ======================================aaaaaaa===========================================================
		File file = new File("src/cars.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String len = null;
		ArrayList<String> data = new ArrayList();
		while ((len = br.readLine()) != null) {
			// System.out.println(len);
			String item[] = len.split(",");
			data.add(item[0].trim());
			data.add(item[1].trim());
			data.add(item[2].trim());
			data.add(item[3].trim());
		}
		br.close();
		List<Map<String, String>> convertdata = new ArrayList<Map<String, String>>();
		for (int i = 4; i < data.size();) {
			Map<String, String> map = new HashMap<>();
			map.put(data.get(0), data.get(i));
			map.put(data.get(1), data.get(i + 1));
			map.put(data.get(2), data.get(i + 2));
			map.put(data.get(3), data.get(i + 3));
			convertdata.add(map);
			i = i + 4;
		}

		Collections.sort(convertdata, new Comparator<Map<String, String>>() {
			public int compare(final Map<String, String> o1,
					final Map<String, String> o2) {
				return o1.get("Price").compareTo(o2.get("Price"));
			}
		});
		// System.out.print(convertdata);

		FileWriter writer;
		writer = new FileWriter("src/cars2.csv", false);
		// Write CSV
		writer.write("Manufacturer");
		writer.write(",");
		writer.write("Type");
		writer.write(",");
		writer.write("Price");
		writer.write(",");
		writer.write("Min.Price");
		writer.write("\r\n");
		for (int i = 0; i < convertdata.size(); i++) {
			writer.write(convertdata.get(i).get("Manufacturer").toString());
			writer.write(",");
			writer.write(convertdata.get(i).get("Type").toString());
			writer.write(",");
			writer.write(convertdata.get(i).get("Price").toString());
			writer.write(",");
			writer.write(convertdata.get(i).get("Min.Price").toString());
			writer.write("\r\n");
		}
		System.out.println("Write success!");

		writer.close();
		// ======================================bbbbbb===========================================================
		Collections.sort(convertdata, new Comparator<Map<String, String>>() {
			public int compare(final Map<String, String> o1,
					final Map<String, String> o2) {
				return o1.get("Manufacturer").compareTo(o2.get("Manufacturer"));
			}
		});
		BigDecimal minlittle = new BigDecimal(0);
		BigDecimal biglittle = new BigDecimal(0);
		BigDecimal mintotal = new BigDecimal(0);
		BigDecimal bigtotal = new BigDecimal(0);
		String text = "Manufacturer  Type  Min.Price    Price\n";
		for (int i = 0; i < convertdata.size(); i++) {
			Map dataValue = convertdata.get(i);
			minlittle = minlittle.add(new BigDecimal(dataValue.get("Min.Price")
					.toString()));
			biglittle = biglittle.add(new BigDecimal(dataValue.get("Price")
					.toString()));
			mintotal = mintotal.add(new BigDecimal(dataValue.get("Min.Price")
					.toString()));
			bigtotal = bigtotal.add(new BigDecimal(dataValue.get("Price")
					.toString()));
			if (i < convertdata.size() - 1) {
				if (!convertdata.get(i).get("Manufacturer")
						.equals(convertdata.get(i + 1).get("Manufacturer"))) {
					text += dataValue.get("Manufacturer") + "  "
							+ dataValue.get("Type") + "  "
							+ dataValue.get("Min.Price") + "  "
							+ dataValue.get("Price") + "\n" + "小計:      "
							+ minlittle + "    " + biglittle + "\n";
					minlittle = BigDecimal.ZERO;
					biglittle = BigDecimal.ZERO;
				} else {
					text += dataValue.get("Manufacturer") + "  "
							+ dataValue.get("Type") + "  "
							+ dataValue.get("Min.Price") + "  "
							+ dataValue.get("Price") + "\n";
				}
			}
		}
		text += "小計:      " + minlittle + "    " + biglittle + "\n"
				+ "合計:      " + mintotal + "    " + bigtotal;
		System.out.print(text);
	}
}
