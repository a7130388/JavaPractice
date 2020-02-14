import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;

public class hw4 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自動產生方法 Stub
		File file = new File("src/encode_text.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String len = null;
		String keyWord = new String();
		while ((len = br.readLine()) != null) {
			System.out.println(len);
			keyWord = keyWord + URLDecoder.decode(len, "UTF-8");
		}
		br.close();
		System.out.println(keyWord);
		File filewrite = new File("src/decode_file.txt");
		file.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(filewrite);
		// Writes the content to the file
		writer.write(keyWord);
		writer.flush();
		writer.close();

	}

}
