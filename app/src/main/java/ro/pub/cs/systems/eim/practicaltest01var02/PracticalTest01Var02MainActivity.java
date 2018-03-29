package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private EditText cifra_1 = null;
    private EditText cifra_2 = null;
    private Button plus = null;
    private Button minus = null;
    private TextView opResult = null;

    private Button navigateToSecondaryActivityButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int fNumber = Integer.parseInt(cifra_1.getText().toString());
            int sNumber = Integer.parseInt(cifra_2.getText().toString());
            int op = 0;
            String content = null;

            switch(view.getId()) {
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    String opR = opResult.getText().toString();
                    intent.putExtra("opResult", opR);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                case R.id.plus:
                    op = fNumber + sNumber;
                    opResult.setText(String.format("%s + %s = %s", String.valueOf(fNumber), String.valueOf(sNumber), String.valueOf(op)));
                    break;
                case R.id.minus:
                    op = fNumber - sNumber;
                    opResult.setText(String.format("%s - %s = %s", String.valueOf(fNumber), String.valueOf(sNumber), String.valueOf(op)));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        cifra_1 = (EditText)findViewById(R.id.cifra_1);
        cifra_2 = (EditText)findViewById(R.id.cifra_2);
        cifra_1.setText(String.valueOf(0));
        cifra_2.setText(String.valueOf(0));

        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);

        plus.setOnClickListener(buttonClickListener);
        minus.setOnClickListener(buttonClickListener);

        opResult = (TextView) findViewById(R.id.operatie);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("first")) {
                cifra_1.setText(savedInstanceState.getString("first"));
            } else {
                cifra_1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("first")) {
                cifra_2.setText(savedInstanceState.getString("first"));
            } else {
                cifra_2.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("result")) {
                opResult.setText(savedInstanceState.getString("result"));
            } else {
                opResult.setText(String.valueOf(0));
            }
        } else {
            cifra_1.setText(String.valueOf(0));
            cifra_2.setText(String.valueOf(0));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("first", cifra_1.getText().toString());
        savedInstanceState.putString("second", cifra_2.getText().toString());
        savedInstanceState.putString("result", opResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("first")) {
            cifra_1.setText(savedInstanceState.getString("first"));
        } else {
            cifra_1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("second")) {
            cifra_2.setText(savedInstanceState.getString("second"));
        } else {
            cifra_2.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("result")) {
            opResult.setText(savedInstanceState.getString("result"));
        } else {
            opResult.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
