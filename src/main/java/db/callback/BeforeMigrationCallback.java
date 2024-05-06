package db.callback;

import org.flywaydb.core.api.callback.BaseCallback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;

public class BeforeMigrationCallback extends BaseCallback {

    @Override
    public boolean supports(Event event, Context context) {
        return event == Event.BEFORE_MIGRATE;
    }

    @Override
    public void handle(Event event, Context context) {
        System.out.println("Do some action..");
    }
}
