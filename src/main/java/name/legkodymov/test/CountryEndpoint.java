package name.legkodymov.test;

import name.legkodymov.ws.country_service.GetCountryRequest;
import name.legkodymov.ws.country_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by sergei on 04/05/2017.
 *
 * @author Sergei Legkodymov - rutven@gmail.com
 */
@Endpoint
public class CountryEndpoint {
    public static final String NAMESPACE_URI = "http://legkodymov.name/ws/country-web-service";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository repository) {
        this.countryRepository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
