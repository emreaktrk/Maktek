package akturk.maktek.parser;


import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.model.Shuttle;

public final class ShuttleXMLParser {
    private ArrayList<Shuttle> mList;
    private Context mContext;

    public ShuttleXMLParser(Context context) {
        mList = new ArrayList<Shuttle>();
        mContext = context;

        parseXML();
    }

    private void parseXML() {
        XmlPullParser tempPullParser = mContext.getResources().getXml(R.xml.free_shuttle_services);

        try {
            while (tempPullParser.next() != XmlPullParser.END_DOCUMENT) {
                if (tempPullParser.getEventType() == XmlPullParser.START_TAG && tempPullParser.getName().equals("shuttle")) {
                    Shuttle tempShuttle = new Shuttle();
                    tempShuttle.setName(tempPullParser.getAttributeValue(null, "name"));
                    tempShuttle.setDeparture(tempPullParser.getAttributeValue(null, "departure"));
                    tempShuttle.setReturn(tempPullParser.getAttributeValue(null, "return"));
                    mList.add(tempShuttle);
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Shuttle> getList() {
        return mList;
    }
}
