package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private TextView opResult = null;
    private Button correctButton = null;
    private Button incorrectButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.correct:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.incorrect:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        opResult = (TextView)findViewById(R.id.op);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("opResult")) {
            String op = intent.getStringExtra("opResult");
            opResult.setText(String.format("%s", op));
        }

        correctButton = (Button)findViewById(R.id.correct);
        correctButton.setOnClickListener(buttonClickListener);
        incorrectButton = (Button)findViewById(R.id.incorrect);
        incorrectButton.setOnClickListener(buttonClickListener);
    }
}
