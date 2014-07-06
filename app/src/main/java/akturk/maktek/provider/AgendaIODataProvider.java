
package akturk.maktek.provider;

import akturk.maktek.model.Agenda;
import android.content.Context;

public final class AgendaIODataProvider extends BaseIODataProvider<Agenda> {

   public AgendaIODataProvider(Context context) {
      super(context);
   }

   @Override
   protected String getName() {
      return Agenda.class.getName();
   }
}
