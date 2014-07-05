package akturk.maktek.handler;


import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.model.Office;

public class TuyapOverseasOfficesXMLParser {
    private ArrayList<Office> mList;
    private Context mContext;

    public TuyapOverseasOfficesXMLParser(Context context) {
        mList = new ArrayList<Office>();
        mContext = context;

        parseXML();
    }

    private void parseXML() {
        XmlPullParser tempPullParser = mContext.getResources().getXml(R.xml.tuyap_local_offices);

        try {
            while (tempPullParser.next() != XmlPullParser.END_DOCUMENT) {
                if (tempPullParser.getEventType() == XmlPullParser.START_TAG && tempPullParser.getName().equals("office")) {
                    Office tempOffice = new Office();
                    tempOffice.setName(tempPullParser.getAttributeValue(null, "name"));
                    tempOffice.setContact(tempPullParser.getAttributeValue(null, "contact"));
                    tempOffice.setAdress(tempPullParser.getAttributeValue(null, "adress"));
                    tempOffice.setPhone(tempPullParser.getAttributeValue(null, "phone"));
                    tempOffice.setFax(tempPullParser.getAttributeValue(null, "fax"));
                    tempOffice.setEmail(tempPullParser.getAttributeValue(null, "email"));
                    mList.add(tempOffice);
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Office> getList() {
        return mList;
    }
}
