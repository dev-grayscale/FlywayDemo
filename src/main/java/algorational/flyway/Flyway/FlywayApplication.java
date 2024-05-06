package algorational.flyway.Flyway;

import db.callback.AfterMigrationCallback;
import db.callback.BeforeMigrationCallback;
import org.flywaydb.core.api.callback.Callback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlywayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywayApplication.class, args);
	}

	@Bean
	public Callback beforeMigrationCallback() {
		return new BeforeMigrationCallback();
	}

	@Bean
	public Callback afterMigrationCallback() {
		return new AfterMigrationCallback();
	}

}
