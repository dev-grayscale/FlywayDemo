package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

/**
 * Repeatable migrations that have no versions are applied every time their checksum changes.
 */
public class R__Add_New_Person_Java extends BaseJavaMigration {

    @Override
    public void migrate(Context context) {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute(String.format("INSERT INTO PERSON (NAME) VALUES ('%s')", "RepeatableJava"));
    }

    /**
     * Hardcoded checksum for example
     */
    @Override
    public Integer getChecksum() {
        return 1;
    }
}
