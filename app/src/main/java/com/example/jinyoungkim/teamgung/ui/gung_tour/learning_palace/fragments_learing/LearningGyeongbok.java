package com.example.jinyoungkim.teamgung.ui.gung_tour.learning_palace.fragments_learing;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinyoungkim.teamgung.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LearningGyeongbok extends Fragment {
    View view;
    Document doc;
    TextView status1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gyeongbok_learning,container,false);
        status1 = (TextView)view.findViewById(R.id.test);

        new GetXMLTask().execute();
        return view;
    }
    private class GetXMLTask extends AsyncTask<String, Void, Document> {
        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL("http://www.heritage.go.kr/heri/gungDetail/gogungListOpenApi.do");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(view.getContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            NodeList nodeList = doc.getElementsByTagName("list");

//            for(int i = 0; i< nodeList.getLength(); i++){
//
//                Node node = nodeList.item(i);
//                Element fstElmnt = (Element) node;
//
//                NodeList idx = fstElmnt.getElementsByTagName("contents_kor");
//                s =idx.item(0).getChildNodes().item(0).getNodeValue() +"\n";
//
//
//            }


            Node node = nodeList.item(0);
            Element fstElmnt = (Element) node;

            NodeList idx = fstElmnt.getElementsByTagName("contents_kor");
            s =idx.item(0).getChildNodes().item(0).getNodeValue() +"\n";


            status1.setText(s);

            super.onPostExecute(doc);
        }
    }

}
