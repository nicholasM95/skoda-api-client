package be.nicholasmeyers.skoda.api.client;

import be.nicholasmeyers.skoda.ApiClient;
import be.nicholasmeyers.skoda.ServerConfiguration;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.HashMap;
import java.util.List;

public class ClientConfiguration {

    private final ApiClient apiClient;

    ClientConfiguration(String email, String password) {
        TokenService tokenService = new TokenService(email, password);

        Interceptor authorizationInterceptor = chain -> {
            Request originalRequest = chain.request();
            Request requestWithAuthorization = originalRequest.newBuilder()
                    .header("Authorization", "Bearer " + tokenService.getToken())
                    .build();
            return chain.proceed(requestWithAuthorization);
        };

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(authorizationInterceptor)
                .build();

        this.apiClient = new ApiClient(httpClient);
    }

    ClientConfiguration(String email, String password, String server) {
        TokenService tokenService = new TokenService(email, password);

        Interceptor authorizationInterceptor = chain -> {
            Request originalRequest = chain.request();
            Request requestWithAuthorization = originalRequest.newBuilder()
                    .header("Authorization", "Bearer " + tokenService.getToken())
                    .build();
            return chain.proceed(requestWithAuthorization);
        };

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(authorizationInterceptor)
                .build();

        ServerConfiguration serverConfiguration = new ServerConfiguration(
                server,
                "No description provided",
                new HashMap<>()
        );
        this.apiClient = new ApiClient(httpClient);
        this.apiClient.setBasePath(server);
        this.apiClient.setServers(List.of(serverConfiguration));
    }

    ApiClient getApiClient() {
        return this.apiClient;
    }
}
