package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(new JejuConnectionMaker());
    }
    @Bean
    public ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
