package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.client.RestClientException;

/**
 * Custom configuration for the required Spring Social Twitter beans.
 */
@Configuration
public class ZwitscherConfiguration {
    @Bean
    public Twitter twitter(final @Value("${spring.social.twitter.appId}") String appId,
                           final @Value("${spring.social.twitter.appSecret}") String appSecret) {
        try {
            return new TwitterTemplate(appId, appSecret);
        } catch (org.springframework.web.client.RestClientException e) {
            return new MockTwitter();
        }
    }
}
