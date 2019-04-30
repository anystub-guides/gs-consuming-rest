package hello;

import org.springframework.stereotype.Component;

@Component
public class DataProcessor {

    private final DataProvider dataProvider;

    public DataProcessor(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    int processData() {
        return dataProvider.provideData().getValue().getQuote().length();
    }
}
