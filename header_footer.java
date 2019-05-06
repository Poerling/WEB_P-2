import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class zentralverwaltung {
	static String footer;
	static String header;
	static String footer_en;
	static String header_en;
	static String body = "";
	static String englishSite="";
	static File f = new File("");
	static String path = f.getAbsolutePath();
	static String firstLine;

	public static void main(String[] args) throws Exception {

		File f = new File(path);
		File[] listOfFiles = f.listFiles();

		// initialisiere header und erste Zeile
		getHeader();
		getHeader_en();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].getName().endsWith(".html")) {
				getBody(listOfFiles[i].getAbsolutePath());
				Writer writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(listOfFiles[i].getAbsolutePath()), "UTF8"));

				if(listOfFiles[i].getName().contains("english")) {
					writer.write(header_en);
					writer.flush();
					writer.write(body);
					writer.flush();
					writer.write(addGermanSiteToFooter(listOfFiles[i].getName()));
					writer.flush();
					writer.close();
					
					
				}
				else {
				
				writer.write(header);
				writer.flush();
				writer.write(body);
				writer.flush();
				//writer.write(footer);
				//writer.flush();
				writer.write(addEnglishSiteToFooter(listOfFiles[i].getName()));
				writer.flush();
				writer.close();
				}

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

	public static String addEnglishSiteToFooter (String fileName) throws IOException {
		getFooter();
		if(footer.contains("English Version")) {
			footer=footer.replace("englishSEITENNAME.html", "english"+fileName);
		}
		
		return footer;
	}
	
	public static String addGermanSiteToFooter (String fileName) throws IOException {
		getFooter_en();
		if(footer_en.contains("German Version")) {
			footer_en=footer_en.replace("SEITENNAME.html", fileName.substring(7, fileName.length()));
		}
		
		return footer_en;
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
	
	public static void getFooter_en() {
		try {
			footer_en = readFile2String(path + "\\header_footer\\footer_en.html");
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
			System.out.println(header.substring(1));
		} catch (IOException e) {
			System.out.println("get header exception");
			e.printStackTrace();
		}
	}
	
	
	public static void getHeader_en() {
		try {
			header_en = readFile2String(path + "\\header_footer\\header_en.html");
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
