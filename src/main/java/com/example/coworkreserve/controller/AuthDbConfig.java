@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.auth.repository",
        entityManagerFactoryRef = "authEntityManagerFactory",
        transactionManagerRef = "authTransactionManager"
)
public class AuthDbConfig {

    @Bean(name = "authDataSource")
    @ConfigurationProperties(prefix = "auth.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "authEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("authDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.auth.model")
                .persistenceUnit("auth")
                .build();
    }

    @Bean(name = "authTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("authEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
