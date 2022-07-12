package com.example.parsing_xml_json;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import android.os.Bundle;

public class Activity_view extends AppCompatActivity {
    TextView lblXmlData,lblJsonData;
    int mode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lblXmlData =(TextView) findViewById(R.id.lbl_xml_data);
        lblJsonData = (TextView) findViewById(R.id.lbl_json_data);
        mode = getIntent().getIntExtra("mode",0);
        if(mode==1)
            parseJson();
        else
            parseXml();
    }

    public String parseXml() {
        try
        {
            InputStream is = getAssets().open("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("employee");

            for(int i=0;i<nList.getLength();i++)
            {
                Node node = nList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element element1=(Element) node;
                    lblXmlData.setText("CityName: "+getValue("city_name",element1)+"\n");
                    lblXmlData.append("Latitude: "+getValue("Latitude",element1)+"\n");
                    lblXmlData.append("Longitude: "+getValue("Longitude",element1)+"\n");
                    lblXmlData.append("Temperature: "+getValue("Temperature",element1)+"\n");
                    lblXmlData.append("Humidity: "+getValue("Humidity",element1)+"\n");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static String getValue(String tag,Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public void parseJson() {
        try
        {
            InputStream inputStream = getAssets().open("input.json");
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String readData = new String(data);
            JSONObject jsonObject = new JSONObject(readData);
            JSONObject jsonObject1 = jsonObject.getJSONObject("employee");
            lblJsonData.setText("CityName: "+jsonObject1.getString("city_name")+"\n");
            lblJsonData.append("Latitude: "+jsonObject1.getString("Latitude")+"\n");
            lblJsonData.append("Temperature: "+jsonObject1.getInt("Temperature")+"\n");
            lblJsonData.append("Humidity: "+jsonObject1.getString("Humidity")+"\n");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}