package com.horustek.gda.infra.seguridad.oauth;

import com.horustek.gda.infra.seguridad.jwt.CustomJwtAccessTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Value("${accessToken.time.expire.seconds}")
    private Integer accessTokenTimeExpireSeconds;

    @Value("${refreshToken.time.expire.seconds}")
    private Integer refrehsTokenTimeExpireSeconds;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    @Autowired
    public AuthorizationServerConfig(BCryptPasswordEncoder passwordEncoder,
                                     @Qualifier("authenticationManager") AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;

    }

    /**
     * Método que se encarga de la configuración asociada con los clientes que se conectarán a nuestra
     * aplicación. Esto es para mayor seguridad de la aplicación. En este caso nos autenticaremos no
     * solo con usuario y contranseña sino ademas con las credenciales de la aplicación que se va a
     * conectar a nuestro backend
     */
    // Fixme Review de static credencial
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("gdaAngularApp")
                .secret(passwordEncoder.encode("12345"))
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(accessTokenTimeExpireSeconds)
                .refreshTokenValiditySeconds(refrehsTokenTimeExpireSeconds);
    }


    /**
     * Método que se encarga de la autenticación y la validación del token. Cada vez que se inicia
     * sesion se envía usuario y contrasena, si sale bien realiza la autenticación genera el token y
     * se lo entrega al usuario para que con este token se acceda a los recursos
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));

        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain)
                /*.exceptionTranslator(loggingExceptionTranslator())*/;

    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        return new CustomJwtAccessTokenConverter();
    }

//    @Bean
//    public WebResponseExceptionTranslator loggingExceptionTranslator() {
//        return new WebResponseExceptionTranslator() {
//            @Override
//            public ResponseEntity<?> translate(Exception e) throws Exception {
//                // Carry on handling the exception
//                ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
//                apiError.setMessage(e.getMessage());
//                apiError.setDebugMessage(e.getMessage());
//                apiError.setTokenExpired(e.getMessage().startsWith("Access token expired"));
//                return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
//            }
//        };
//    }


}
