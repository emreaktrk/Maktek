package akturk.maktek.parser;


import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.model.Paragraph;

public final class TiadAndMibXMLParser {
    private ArrayList<Paragraph> mList;
    private Context mContext;

    public TiadAndMibXMLParser(Context context) {
        mList = new ArrayList<Paragraph>();
        mContext = context;

        parseXML();
    }

    private void parseXML() {
        XmlPullParser tempPullParser = mContext.getResources().getXml(R.xml.tiad_and_mib);

        try {
            while (tempPullParser.next() != XmlPullParser.END_DOCUMENT) {
                if (tempPullParser.getEventType() == XmlPullParser.START_TAG && tempPullParser.getName().equals("paragraph")) {
                    Paragraph tempParagraph = new Paragraph();
                    tempParagraph.setContent(tempPullParser.getAttributeValue(null, "content"));
                    tempParagraph.setTitle(tempPullParser.getAttributeValue(null, "title"));
                    mList.add(tempParagraph);
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Paragraph> getList() {
        return mList;
    }
}
