package com.example.jinyoungkim.teamgung.ui.gung_tour.learning_palace.fragments_learing;

import android.os.AsyncTask;
import android.os.Bundle;
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

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LearningDuksu extends Fragment {
    View view;
    Document doc;
    TextView explain_duksu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_duksu_learning,container,false);
        explain_duksu = (TextView)view.findViewById(R.id.explain_duksu);

        new GetXMLTask().execute();

        return view;
    }

    //    공공 API 정보 가져오는 부분
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


            Node node = nodeList.item(72);
            Element fstElmnt = (Element) node;

            NodeList idx = fstElmnt.getElementsByTagName("explanation_kor");
            s =idx.item(0).getChildNodes().item(0).getNodeValue() +"\n";
            s=s.replace("<br />","");

            explain_duksu.setText(s);

            super.onPostExecute(doc);
        }
    }
}
