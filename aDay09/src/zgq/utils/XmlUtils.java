package zgq.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	private static String filePath;
	static {
		// ���ھ�̬������У�ִֻ��һ��
		filePath = XmlUtils.class.getClassLoader().getResource("users.xml")
				.getPath(); // ��ȡҪ�����ļ���·��
		try {
			filePath = java.net.URLDecoder.decode(filePath,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	// �����෽������static
	public static Document getDocment() throws Exception { // ������ ���쳣�׸�������
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		return document;
	}

	public static void write2Xml(Document document) throws IOException,
			FileNotFoundException {
		// Pretty print the document to System.out
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8"); // ���������ʽ
		XMLWriter writer = new XMLWriter(new FileOutputStream(filePath), format);
		writer.write(document);

		// Compact format to System.out
		format = OutputFormat.createCompactFormat();
		writer = new XMLWriter(System.out, format);
		writer.write(document);

		writer.close();
	}
}
