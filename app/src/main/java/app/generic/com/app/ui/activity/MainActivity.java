package app.generic.com.app.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import app.generic.com.app.R;
import app.generic.com.app.data.api.ApiModule;
import app.generic.com.app.data.api.ApiService;
import app.generic.com.app.data.api.Response.SampleResponse;
import app.generic.com.app.ui.presenter.MainActivityPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;

public class MainActivity extends AbstractBaseAppCompatActivity {

  private MainActivityPresenter activityPresenter;

  //Example of using butter knife . This is enough instead of wring findview by id
  @BindView(R.id.sample_txtview) TextView textView;
  @BindView(R.id.buton) Button button;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Example of using butterknife
    ButterKnife.bind(this);

    this.textView.setText("Chakkudu");

    this.button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        displayDialog("Message", "Chakkudu", true, R.string.mdtp_ok, null, R.string.mdtp_cancel,
            null);
      }
    });

    activityPresenter.requesData();
  }

  @Override protected void setUpPresenter() {
    activityPresenter = new MainActivityPresenter(this);
  }

  public void done() {

  }
}
