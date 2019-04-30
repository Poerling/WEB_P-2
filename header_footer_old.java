package irgendeins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class zentralverwaltung {
	static String footer;
	static String header;
	static String body = "";
	static File f = new File("");
	static String path = f.getAbsolutePath();
	static String firstLine;

	public static void main(String[] args) throws Exception {

		File f = new File(path);
		File[] listOfFiles = f.listFiles();

		// System.out.println(path);

		// initialisiere footer und header und erste Zeile
		getFooter();
		getHeader();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].getName().endsWith(".html")) {
				// wenn in der dateie schon ein header und footer existieren

				getBody(listOfFiles[i].getAbsolutePath());
				FileWriter writer = new FileWriter(new File(listOfFiles[i].getAbsolutePath()));

				writer.write(header);
				writer.flush();
				writer.write(body);
				writer.flush();
				writer.write(footer);
				writer.flush();
				writer.close();

			}
		}
	}

	static String getFirstLine(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
		String firstLine = "";
		firstLine = br.readLine();
		br.close();
		return firstLine;
	}

	// schreibt gesamte Datei in einen String inklusive Zeilenumbruch
	public static String readFile2String(String fileName) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
		String fileString = "";
		String line = "";
		while ((line = br.readLine()) != null) {
			fileString = fileString + line + "\n";
		}
		br.close();
		return fileString;
	}

	// nutzt die Methode readFile2String um footer.html in String zu laden
	public static void getFooter() {
		try {
			footer = readFile2String(path + "\\header_footer\\footer.html");
		} catch (IOException e) {
			System.out.println("get footer exception");
			e.printStackTrace();
		}
	}

	// nutzt die Methode readFile2String um header.html in String zu laden
	public static void getHeader() {
		try {
			header = readFile2String(path + "\\header_footer\\header.html");
			header = header.substring(1);
		} catch (IOException e) {
			System.out.println("get header exception");
			e.printStackTrace();
		}
	}

	// holt den body in einen String wenn ueber- und unterhalb head bzw. footer
	// stehen
	public static void getBody(String filename) throws Exception {
		body = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
		firstLine = br.readLine();
		String iterateBody = "";
		boolean collectBodyTags = false;

		while ((iterateBody = br.readLine()) != null) {
			if (iterateBody.equals("<body onload=\"onload()\">")) {
				collectBodyTags = true;
			}
			if (collectBodyTags) {
				body = body + iterateBody + "\n";
			}
			if (iterateBody.equals("</body>")) {
				collectBodyTags = false;
			}

		}

		br.close();
	}

}
