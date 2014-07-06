
package akturk.maktek.global;

import akturk.maktek.helper.TypefaceLoader;
import akturk.maktek.provider.AgendaIODataProvider;

import android.app.Application;

public final class MaktekApplication extends Application {
   public static TypefaceLoader     mTypefaceLoader;
   public static AgendaIODataProvider mAgendaIODataProvider;

   @Override
   public void onCreate() {
      super.onCreate();

      mAgendaIODataProvider = new AgendaIODataProvider(getApplicationContext());
   }
}
