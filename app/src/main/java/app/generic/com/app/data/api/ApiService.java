package app.generic.com.app.data.api;

import app.generic.com.app.data.api.Request.SampleRequest;
import app.generic.com.app.data.api.Response.SampleResponse;
import java.util.List;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by nitheesh on 6/9/16.
 */

public interface ApiService {

  //Sample Get request

  @Headers({
      "Accept: application/vnd.dbl; version=1"
  }) @GET("/products") Observable<SampleResponse> products();

  //Sample Get request
  @Headers({
      "Accept: application/vnd.dbl; version=1"
  }) @POST("/users/loan_list") Observable<SampleResponse> getList(@Body SampleRequest request);
}
