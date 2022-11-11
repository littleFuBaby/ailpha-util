package com.ailpha.common.util;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileUtil {

	public static final int BYTE = 0;

	public static final int KILOBYTE = 3;

	public static final int MEGEBYTE = 5;

	public static final int GIGABYTE = 7;
	
	/**
	 * file length
	 * 
	 * @param filePath
	 * @param scale
	 * @param module
	 * @return
	 */
	public static BigDecimal length(String filePath, int scale, int module) {
		File file = new File(filePath);
		BigDecimal bg = null;
		if (file.exists() && file.isFile()) {
			bg = new BigDecimal(file.length());
			BigDecimal divisor = new BigDecimal(1024);
			switch (module) {
			case GIGABYTE:
				bg = bg.divide(divisor).divide(divisor).divide(divisor);
				break;
			case MEGEBYTE:
				bg = bg.divide(divisor).divide(divisor);
				break;
			case KILOBYTE:
				bg = bg.divide(divisor);
				break;
			case BYTE:
				break;
			default:
				break;
			}
			bg = bg.divide(new BigDecimal(1), scale, BigDecimal.ROUND_HALF_UP);
		}
		return bg;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(FileUtil.length("C:\\Users\\ys\\Desktop\\Linux����ָ��.txt", 2, FileUtil.KILOBYTE));
		System.out.println("************************************************************");
		File file = new File("C:\\Users\\ys\\Desktop\\Linux����ָ��.txt");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(file.lastModified()));
		System.out.println("************************************************************");

		// inputstream
		if (file.exists()) {
			InputStream is = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int root = 0;
			int temp = 0;
			while ((temp = is.read()) != -1 && root < 1024) {
				bytes[root++] = (byte) temp;
			}
			is.close();
			System.out.println(new String(bytes));
		}

		System.out.println("************************************************************");

		if (file.exists()) {
			Reader r = new FileReader(file);
			char[] chars = new char[100];
			int root = 0;
			int temp = 0;
			while ((temp = r.read()) != -1 && root < 100) {
				chars[root++] = (char) temp;
			}
			r.close();
			System.out.println(new String(chars));
		}

		System.out.println("************************************************************");

		// System properties
		System.getProperties().list(System.out);

		System.out.println("************************************************************");

		// scanner
		if (file.exists()) {
			Scanner scan = new Scanner(new FileInputStream(file));
			scan.skip(".....Li");
			scan.useDelimiter("[^\u4e00-\u9fa5]+");
			while (scan.hasNext()) {
				System.out.println(scan.next());
			}
			scan.close();
		}

		System.out.println("************************************************************");
		// bufferedreader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag2 = false;
		while (flag2 == false) {
			System.out.print("���������֣�");
			String str = br.readLine();
			if (str.matches("[0-9]+")) {
				System.out.println("�����������ݣ�" + str);
				flag2 = true;
			} else {
				System.out.println("���ݴ�����������������");
			}
		}
		br.close();
		
		System.out.println("************************************************************");
		String s = "Hello World! 3 + 3.0 = 6.0 true";
		// create a new scanner with the specified String Object
		Scanner scanner = new Scanner(s);
		// skip the word that matches the pattern ..llo
		scanner.skip(Pattern.compile(".......or"));
		// print a line of the scanner
		System.out.println("" + scanner.nextLine());
		// close the scanner
		scanner.close();
	}

}
