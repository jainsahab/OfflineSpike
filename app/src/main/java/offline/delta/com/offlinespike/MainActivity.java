package offline.delta.com.offlinespike;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;

import static android.support.design.widget.Snackbar.LENGTH_INDEFINITE;

public class MainActivity extends Activity {

  private View inflatedView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    inflatedView = LayoutInflater.from(this).inflate(R.layout.activity_main, null, false);
    setContentView(inflatedView);
  }


  public void showSnackBar(View view) {
    final Snackbar snackbar = Snackbar.make(inflatedView, "Dummy Text", LENGTH_INDEFINITE);
    Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
    snackbarLayout.findViewById(android.support.design.R.id.snackbar_text).setVisibility(View.INVISIBLE);
    View snackBarCustomView = LayoutInflater.from(this).inflate(R.layout.custom_snackbar_layout, null, false);
    snackbarLayout.addView(snackBarCustomView, 0);
    snackBarCustomView.findViewById(R.id.cross).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        snackbar.dismiss();
      }
    });
    snackbar.show();
  }
}
