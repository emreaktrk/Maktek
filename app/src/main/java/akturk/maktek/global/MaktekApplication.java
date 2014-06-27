
package akturk.maktek.global;

import akturk.maktek.helper.TypefaceLoader;
import akturk.maktek.provider.AgendaDataProvider;
import android.app.Application;

public final class MaktekApplication extends Application {
   public static TypefaceLoader     mTypefaceLoader;
   public static AgendaDataProvider mAgendaDataProvider;

   @Override
   public void onCreate() {
      super.onCreate();
      mAgendaDataProvider = new AgendaDataProvider(getApplicationContext());
   }
}
