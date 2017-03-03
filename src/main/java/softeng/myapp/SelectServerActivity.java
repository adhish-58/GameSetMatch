package softeng.myapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SelectServerActivity extends AppCompatActivity {
    public final static String EXTRA_NAME1 = "softeng.myapp.NAME1";
    public final static String EXTRA_NAME2 = "softeng.myapp.NAME2";
    public final static String EXTRA_NAME3 = "softeng.myapp.NAME3";
    public final static String EXTRA_GAME = "softeng.myapp.GAME";

    String matchFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_server);

        TextView textView;
        Intent intent = getIntent();
        String player1Name = intent.getStringExtra(MainActivity.EXTRA_NAME1);
        String player2Name = intent.getStringExtra(MainActivity.EXTRA_NAME2);
        matchFormat = intent.getStringExtra(MainActivity.EXTRA_GAME);
        textView = (TextView) findViewById(R.id.TextPlayer1);
        textView.setText(player1Name);
        textView = (TextView) findViewById(R.id.TextPlayer2);
        textView.setText(player2Name);

        textView = (TextView) findViewById(R.id.player1);
        textView.setText(player1Name);
        textView = (TextView) findViewById(R.id.player2);
        textView.setText(player2Name);
    }

    public void onClickStart(View view) {
        TextView player1Text = (TextView) findViewById(R.id.TextPlayer1);
        TextView player2Text = (TextView) findViewById(R.id.TextPlayer2);
        String player1Name = player1Text.getText().toString();
        String player2Name = player2Text.getText().toString();

        RadioGroup serveGroup = (RadioGroup) findViewById(R.id.choose_serve);
        if (serveGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select a player to serve first", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, RecordSetActivity.class);
        intent.putExtra(EXTRA_NAME1, player1Name);
        intent.putExtra(EXTRA_NAME2, player2Name);
        intent.putExtra(EXTRA_GAME, matchFormat);
        RadioButton serverButton = (RadioButton) findViewById(R.id.player1);
        if (serverButton.isChecked())
            intent.putExtra(EXTRA_NAME3, player1Name);
        else
            intent.putExtra(EXTRA_NAME3, player2Name);
        startActivity(intent);
    }
}
