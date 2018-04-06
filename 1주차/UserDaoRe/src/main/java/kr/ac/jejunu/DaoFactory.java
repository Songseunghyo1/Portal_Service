package kr.ac.jejunu;

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
