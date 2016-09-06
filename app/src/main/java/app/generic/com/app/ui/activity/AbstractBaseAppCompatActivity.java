package app.generic.com.app.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by nitheesh on 5/9/16.
 */

public abstract class AbstractBaseAppCompatActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpPresenter();
  }

  protected abstract void setUpPresenter();

  public void displaySnackBar(String message) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
  }

  public void displaySnackBar(@StringRes int message) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
  }

  public void logMessage(String message) {
    Log.d("DEBUG", message);
  }

  public void logError(String error) {
    Log.e("ERROR", error);
  }

  public void displayDialog(String title, String message, boolean isCancellable,
      @StringRes int positiveText, DialogInterface.OnClickListener positiveTextClickListener,
      @StringRes int cancelText, DialogInterface.OnClickListener cancelTextClickListener) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage(message).setTitle(title).setCancelable(isCancellable);

    if (positiveText != 0 || positiveTextClickListener != null) {
      builder.setPositiveButton(positiveText, positiveTextClickListener);
    }

    if (cancelText != 0 || cancelTextClickListener != null) {
      builder.setNegativeButton(cancelText, cancelTextClickListener);
    }

    builder.create().show();
  }
}
