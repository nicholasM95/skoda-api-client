package be.nicholasmeyers.skoda.api.client;

import be.nicholasmeyers.skoda.ApiClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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

    ApiClient getApiClient() {
        return this.apiClient;
    }
}
