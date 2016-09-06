package app.generic.com.app.ui.presenter;

import app.generic.com.app.data.api.ApiModule;
import app.generic.com.app.data.api.ApiService;
import app.generic.com.app.data.api.Response.SampleResponse;
import app.generic.com.app.ui.activity.MainActivity;
import rx.Observer;

/**
 * Created by nitheesh on 5/9/16.
 */

public class MainActivityPresenter {

  private MainActivity mainActivity;

  public MainActivityPresenter(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  public void requesData() {
    // Sample Api Request and Response handling using Observer Rx java
    ApiService apiService = ApiModule.getInstance().getApiService(mainActivity);
    apiService.products().subscribe(new Observer<SampleResponse>() {
      @Override public void onCompleted() {
        // calls if every thing done

        mainActivity.done();
      }

      @Override public void onError(Throwable e) {
        // calls if error occurs
      }

      @Override public void onNext(SampleResponse sampleResponse) {
        SampleResponse.RData data = sampleResponse.data;
        // calls when you receive your response

      }
    });
  }
}
