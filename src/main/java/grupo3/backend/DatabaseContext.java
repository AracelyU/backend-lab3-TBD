package grupo3.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    @Value("${database.url}")
    private String dbURL;

    @Value("${database.user}")
    private String dbUSER;

    @Value("${database.password}")
    private String dbPASS;

    @Bean
    public Sql2o sql2o() { return new Sql2o(dbURL, dbUSER, dbPASS); }
}

