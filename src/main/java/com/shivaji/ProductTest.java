package com.shivaji;

import org.apache.juneau.html.HtmlParser;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlParser;
import org.apache.juneau.xml.XmlSerializer;

import com.shivaji.entity.Product;

public class ProductTest {
	public static void main(String[] args) throws SerializeException, ParseException {
		//Serialization
		//Pojo to Json
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		
		String[] sellerNames = {"Neon Enterprise","XYZ Softwares","ABC IT Solutions"};
		Product product = new Product("MacBookPro", 10000,"White", sellerNames);
		
		String json = jsonSerializer.serialize(product);
		System.out.println(json);
		
		//Pojo To XML
		
		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String xml = xmlSerializer.serialize(product);
		System.out.println(xml);
		
		//Pojo to Html
		
		HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
		String html = htmlSerializer.serialize(product);
		System.out.println(html);
		
		//DeSerialization
		//Json to Pojo
		JsonParser jsonParser = JsonParser.DEFAULT;
		String jsonVal = "{\r\n"
				+ "	\"color\": \"White\",\r\n"
				+ "	\"name\": \"MacBookPro\",\r\n"
				+ "	\"price\": 10000,\r\n"
				+ "	\"sellerNames\": [\r\n"
				+ "		\"Neon Enterprise\",\r\n"
				+ "		\"XYZ Softwares\",\r\n"
				+ "		\"ABC IT Solutions\"\r\n"
				+ "	]\r\n"
				+ "}";
		Product pro = jsonParser.parse(jsonVal, Product.class);
		System.out.println(pro);
		
		//XML to Pojo
		
		XmlParser xmlParser = XmlParser.DEFAULT;
		String xmlVal = "<object>\r\n"
				+ "	<color>White</color>\r\n"
				+ "	<name>MacBookPro</name>\r\n"
				+ "	<price>10000</price>\r\n"
				+ "	<sellerNames>\r\n"
				+ "		<string>Neon Enterprise</string>\r\n"
				+ "		<string>XYZ Softwares</string>\r\n"
				+ "		<string>ABC IT Solutions</string>\r\n"
				+ "	</sellerNames>\r\n"
				+ "</object>";
		Product product1 = xmlParser.parse(xmlVal, Product.class);
		System.out.println(product1);
		
		//Html to Pojo
		HtmlParser htmlParser = HtmlParser.DEFAULT;
		String htmlVal = "<table>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>color</td>\r\n"
				+ "		<td>White</td>\r\n"
				+ "	</tr>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>name</td>\r\n"
				+ "		<td>MacBookPro</td>\r\n"
				+ "	</tr>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>price</td>\r\n"
				+ "		<td>10000</td>\r\n"
				+ "	</tr>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>sellerNames</td>\r\n"
				+ "		<td>\r\n"
				+ "			<ul>\r\n"
				+ "				<li>Neon Enterprise</li>\r\n"
				+ "				<li>XYZ Softwares</li>\r\n"
				+ "				<li>ABC IT Solutions</li>\r\n"
				+ "			</ul>\r\n"
				+ "		</td>\r\n"
				+ "	</tr>\r\n"
				+ "</table>";
		Product product2 = htmlParser.parse(htmlVal, Product.class);
		System.out.println(product2);
	}
}
