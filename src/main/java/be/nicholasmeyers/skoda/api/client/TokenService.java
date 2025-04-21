package be.nicholasmeyers.skoda.api.client;

import be.nicholasmeyers.skodaconnector.resource.Client;
import be.nicholasmeyers.skodaconnector.resource.Tokens;
import be.nicholasmeyers.skodaconnector.service.ConnectorService;

public class TokenService {

    private final ConnectorService connectorService;
    private final String email;
    private final String password;

    TokenService(String email, String password) {
        this.connectorService = new ConnectorService();
        this.email = email;
        this.password = password;
    }

    String getToken() {
        Tokens tokens = connectorService.getTokens(Client.VWG, email, password);
        return tokens.getAccessToken();
    }
}
