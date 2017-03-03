package softeng.myapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_NAME1 = "softeng.myapp.NAME1";
    public final static String EXTRA_NAME2 = "softeng.myapp.NAME2";
    public final static String EXTRA_GAME = "softeng.myapp.GAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNext(View view) {
        EditText player1Text = (EditText) findViewById(R.id.Name1);
        EditText player2Text = (EditText) findViewById(R.id.Name2);
        String player1Name = player1Text.getText().toString();
        String player2Name = player2Text.getText().toString();

        if (player1Name.matches("") || player2Name.matches("")) {
            Toast.makeText(this, "Please Enter Player/Team Names", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.matchFormat);
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select a match format", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton fourGame = (RadioButton) findViewById(R.id.set3);
        RadioButton sixGame = (RadioButton) findViewById(R.id.set2);

        Intent intent = new Intent(this, SelectServerActivity.class);
        intent.putExtra(EXTRA_NAME1, player1Name);
        intent.putExtra(EXTRA_NAME2, player2Name);
        if (fourGame.isChecked()) {
            intent.putExtra(EXTRA_GAME, "4");
            startActivity(intent);
        } else if (sixGame.isChecked()) {
            intent.putExtra(EXTRA_GAME, "6");
            startActivity(intent);
        } else {
            intent.putExtra(EXTRA_GAME, "8");
            startActivity(intent);
        }
    }


}
