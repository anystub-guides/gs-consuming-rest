package hello;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataProvider {
    private final RestTemplate restTemplate;

    public DataProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    Quote provideData() {
        return restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}
