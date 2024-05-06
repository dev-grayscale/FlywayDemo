package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * Example of a Java-based migration using Spring JDBC.
 */
public class V3__Insert_Person_With_Name_Dummy extends BaseJavaMigration {

    private final String content = "INSERT INTO PERSON (NAME) VALUES ('Dummy')";

    @Override
    public void migrate(Context context) {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute(content);
    }

    /**
     * Just a simple example to demonstrate the CRC32 which is used for SQL checksums by Flyway
     * and how you might supply a content. (Not suited for good checksum implementation as it fails in many aspects)
     */
    @Override
    public Integer getChecksum() {
        Checksum crc32 = new CRC32();
        crc32.update(content.getBytes(StandardCharsets.UTF_8), 0, content.length());
        return (int) crc32.getValue();
    }
}