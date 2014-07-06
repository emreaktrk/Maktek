package akturk.maktek.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import akturk.maktek.model.Exhibitor;

public final class ServiceDataProvider {
    private final static String NAMESPACE = "http://tempuri.org";
    private final static String URL = "http://www.maktekfuari.com/service/WebService.asmx?WSDL";

    public static ArrayList<Exhibitor> getListOfExhibitors() {
        final String METHOD_NAME = "selectMaktekFuarAlani";
        final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

        SoapObject tempSoapRequest = new SoapObject(NAMESPACE, METHOD_NAME);

        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.setOutputSoapObject(tempSoapRequest);
        soapEnvelope.dotNet = true;

        try {
            HttpTransportSE httpTransport = new HttpTransportSE(URL);
            httpTransport.call(SOAP_ACTION, soapEnvelope);

            SoapPrimitive tempSoapResult = (SoapPrimitive) soapEnvelope.getResponse();
            Gson tempGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

            Type listOfItems = new TypeToken<ArrayList<Exhibitor>>() {
            }.getType();

            ArrayList<Exhibitor> tempExhibitorsList = tempGson.fromJson(tempSoapResult.toString(), listOfItems);

            return tempExhibitorsList;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
