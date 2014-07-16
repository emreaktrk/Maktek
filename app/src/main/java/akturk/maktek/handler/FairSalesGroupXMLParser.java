package akturk.maktek.handler;


import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.model.Office;

public final class FairSalesGroupXMLParser {
    private ArrayList<Office> mList;
    private Context mContext;

    public FairSalesGroupXMLParser(Context context) {
        mList = new ArrayList<Office>();
        mContext = context;

        parseXML();
    }

    private void parseXML() {
        XmlPullParser tempPullParser = mContext.getResources().getXml(R.xml.fair_sales_group);

        try {
            while (tempPullParser.next() != XmlPullParser.END_DOCUMENT) {
                if (tempPullParser.getEventType() == XmlPullParser.START_TAG && tempPullParser.getName().equals("office")) {
                    Office tempOffice = new Office();
                    tempOffice.setName(tempPullParser.getAttributeValue(null, "name"));
                    tempOffice.setContact(tempPullParser.getAttributeValue(null, "contact"));
                    tempOffice.setPhone(tempPullParser.getAttributeValue(null, "phone"));
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
