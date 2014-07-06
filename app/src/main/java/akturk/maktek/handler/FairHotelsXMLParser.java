package akturk.maktek.handler;


import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.model.Hotel;

public final class FairHotelsXMLParser {
    private ArrayList<Hotel> mList;
    private Context mContext;

    public FairHotelsXMLParser(Context context) {
        mList = new ArrayList<Hotel>();
        mContext = context;

        parseXML();
    }

    private void parseXML() {
        XmlPullParser tempPullParser = mContext.getResources().getXml(R.xml.fair_hotels);

        try {
            while (tempPullParser.next() != XmlPullParser.END_DOCUMENT) {
                if (tempPullParser.getEventType() == XmlPullParser.START_TAG && tempPullParser.getName().equals("hotel")) {
                    Hotel tempHotel = new Hotel();
                    tempHotel.setName(tempPullParser.getAttributeValue(null, "name"));
                    tempHotel.setImageName(tempPullParser.getAttributeValue(null, "imageName"));
                    tempHotel.setStar(tempPullParser.getAttributeValue(null, "star"));
                    tempHotel.setLocation(tempPullParser.getAttributeValue(null, "location"));
                    tempHotel.setPhone(tempPullParser.getAttributeValue(null, "phone"));
                    tempHotel.setWebsite(tempPullParser.getAttributeValue(null, "website"));
                    mList.add(tempHotel);
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Hotel> getList() {
        return mList;
    }
}
