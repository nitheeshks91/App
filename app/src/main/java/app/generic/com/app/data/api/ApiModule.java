package app.generic.com.app.data.api;

import android.content.Context;
import android.support.compat.BuildConfig;
import app.generic.com.app.R;
import com.squareup.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by nitheesh on 5/9/16.
 */

public class ApiModule {

  private static ApiModule apiModule;
  private ApiService apiService;

  public static ApiModule getInstance() {
    if (apiModule == null) {
      return apiModule = new ApiModule();
    }
    return apiModule;
  }

  private OkHttpClient getOkHttpClient() {
    OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
    okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
    return okHttpClient;
  }

  private RestAdapter getRestAdapter(Context context) {
    RestAdapter.Builder builder = new RestAdapter.Builder();
    builder.setClient(new OkClient(getOkHttpClient()))
        .setEndpoint(context.getString(R.string.baseurl));

    if (BuildConfig.DEBUG) {
      builder.setLogLevel(RestAdapter.LogLevel.FULL);
    }

    return builder.build();
  }

  public ApiService getApiService(Context context) {
    if (apiService == null) {
      return apiService = getRestAdapter(context).create(ApiService.class);
    }
    return apiService;
  }
}
