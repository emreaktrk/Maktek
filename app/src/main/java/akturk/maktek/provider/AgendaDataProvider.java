
package akturk.maktek.provider;

import akturk.maktek.model.Agenda;
import android.content.Context;

public class AgendaDataProvider extends BaseDataProvider<Agenda> {

   public AgendaDataProvider(Context context) {
      super(context);
   }

   @Override
   protected String getName() {
      return Agenda.class.getName();
   }
}
