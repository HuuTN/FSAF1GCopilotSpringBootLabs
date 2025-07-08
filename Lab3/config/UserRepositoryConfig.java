package config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.InMemoryUserRepository;
import repository.UserRepository;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class UserRepositoryConfig {
    @Bean
    @ConditionalOnProperty(name = "user.repository.type", havingValue = "inmemory", matchIfMissing = true)
    public UserRepository inMemoryUserRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("User API")
                .version("1.0")
                .description("API documentation for User management"));
    }
}

@ConfigurationProperties(prefix = "custom.datasource")
class DataSourceProperties {
    private String url;
    private String username;
    private String password;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
