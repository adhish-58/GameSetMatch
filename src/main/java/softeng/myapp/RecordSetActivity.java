package softeng.myapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecordSetActivity extends AppCompatActivity {
    player player1 = new player();
    player player2 = new player();
    int NUM_GAMES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_set);

        TextView textView;
        Intent intent = getIntent();
        String player1Name = intent.getStringExtra(SelectServerActivity.EXTRA_NAME1);
        String player2Name = intent.getStringExtra(SelectServerActivity.EXTRA_NAME2);
        String server = intent.getStringExtra(SelectServerActivity.EXTRA_NAME3);
        String matchFormat = intent.getStringExtra(SelectServerActivity.EXTRA_GAME);
        NUM_GAMES = Integer.parseInt(matchFormat);

        textView = (TextView) findViewById(R.id.p1);
        textView.setText(player1Name);
        textView = (TextView) findViewById(R.id.p2);
        textView.setText(player2Name);

        textView = (TextView) findViewById(R.id.set1pl1);
        textView.setText("0");

        textView = (TextView) findViewById(R.id.set1pl2);
        textView.setText("0");

        textView = (TextView) findViewById(R.id.ptpl1);
        textView.setText("0");

        textView = (TextView) findViewById(R.id.ptpl2);
        textView.setText("0");

        textView = (TextView) findViewById(R.id.player1buttons);
        textView.setText(player1Name);

        textView = (TextView) findViewById(R.id.player2buttons);
        textView.setText(player2Name);

        player1.setName(player1Name);
        player2.setName(player2Name);
        if (player1.getName().equals(server)) {
            player1.setIsServing(true);
            Button Ace = (Button) findViewById(R.id.acep2);
            Ace.setEnabled(false);
            Button fault = (Button) findViewById(R.id.faultp2);
            fault.setEnabled(false);
            textView = (TextView) findViewById(R.id.p1);
            textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.denote_server));
        } else {
            player2.setIsServing(true);
            Button Ace = (Button) findViewById(R.id.acep1);
            Ace.setEnabled(false);
            Button fault = (Button) findViewById(R.id.faultp1);
            fault.setEnabled(false);
            textView = (TextView) findViewById(R.id.p2);
            textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.denote_server));
        }
    }

    public void onClickAce(View view) {
        switch (view.getId()) {
            case R.id.acep1:
                if(player1.isSecondServe()) {
                    player1.setWinSecondServe();
                    player1.setIsSecondServe();
                }
                else if(!player1.isSecondServe()) {
                    player1.setFirstServe();
                    player1.setWinFirstServe();
                }
                player1.setAce();
                changeGameScore(player1, player2);
                break;
            case R.id.acep2:
                if(player2.isSecondServe()){
                    player2.setWinSecondServe();
                    player2.setIsSecondServe();
                }
                else if(!player2.isSecondServe()) {
                    player2.setFirstServe();
                    player2.setWinFirstServe();
                }
                player2.setAce();
                changeGameScore(player2, player1);
                break;
        }
        updateScreen();
    }

    public void onClickFault (View view) {
        switch (view.getId( )) {
            case R.id.faultp1:
                if (player1.isSecondServe()) {
                    changeGameScore(player2, player1);
                    player1.setDoubleFault();
                    player1.setIsSecondServe();
                } else {
                    player1.setSecondServe();
                }
                break;
            case R.id.faultp2:
                if (player2.isSecondServe()) {
                    changeGameScore(player1, player2);
                    player2.setDoubleFault();
                    player2.setIsSecondServe();
                } else {
                    player2.setSecondServe();
                }
                break;
        }
        updateScreen();
    }

    public void onClickWinner (View view) {
        switch (view.getId()) {
            case R.id.winnerp1:
                changeGameScore(player1, player2);
                player1.setWinner();
                if (player1.isServing() && player1.isSecondServe()) {
                    player1.setWinSecondServe();
                    player1.setIsSecondServe();
                } else if (player1.isServing() && !(player1.isSecondServe())) {
                    player1.setFirstServe();
                    player1.setWinFirstServe();
                    player1.setIsSecondServe();
                } else if (player2.isServing() && player2.isSecondServe()) {
                    player2.setIsSecondServe();
                } else {
                    player1.setFirstServe();
                    player2.setIsSecondServe();
                }
                break;
            case R.id.winnerp2:
                changeGameScore(player2, player1);
                player2.setWinner();
                if (player2.isServing() && player2.isSecondServe()) {
                    player2.setWinSecondServe();
                    player2.setIsSecondServe();
                } else if (player2.isServing() && !(player2.isSecondServe())) {
                    player2.setFirstServe();
                    player2.setWinFirstServe();
                    player2.setIsSecondServe();
                } else if (player1.isServing() && player1.isSecondServe()) {
                    player1.setIsSecondServe();
                } else {
                    player1.setFirstServe();
                    player1.setIsSecondServe();
                }
                break;
        }
        updateScreen();
    }

    public void onClickFCD(View view) {
        switch (view.getId()) {
            case R.id.fcdp2:
                changeGameScore(player1, player2);
                player2.setForcedError();
                if (player1.isServing() && player1.isSecondServe()) {
                    player1.setWinSecondServe();
                    player1.setIsSecondServe();
                } else if (player1.isServing() && !(player1.isSecondServe())) {
                    player1.setFirstServe();
                    player1.setWinFirstServe();
                    player1.setIsSecondServe();
                } else if (player2.isServing() && player2.isSecondServe()) {
                    player2.setIsSecondServe();
                } else {
                    player2.setFirstServe();
                    player2.setIsSecondServe();
                }
                break;
            case R.id.fcdp1:
                changeGameScore(player2, player1);
                player1.setForcedError();
                if (player2.isServing() && player2.isSecondServe()) {
                    player2.setWinSecondServe();
                    player2.setIsSecondServe();
                } else if (player2.isServing() && !(player2.isSecondServe())) {
                    player2.setFirstServe();
                    player2.setWinFirstServe();
                    player2.setIsSecondServe();
                } else if (player1.isServing() && player1.isSecondServe()) {
                    player1.setIsSecondServe();
                } else {
                    player1.setFirstServe();
                    player1.setIsSecondServe();
                }
                break;
        }
        updateScreen();
    }

    public void onClickUNF(View view) {
        switch (view.getId()) {
            case R.id.unfp2:
                changeGameScore(player1, player2);
                player2.setUnforcedError();
                if (player1.isServing() && player1.isSecondServe()) {
                    player1.setWinSecondServe();
                    player1.setIsSecondServe();
                } else if (player1.isServing() && !(player1.isSecondServe())) {
                    player1.setFirstServe();
                    player1.setWinFirstServe();
                    player1.setIsSecondServe();
                } else if (player2.isServing() && player2.isSecondServe()) {
                    player2.setIsSecondServe();
                } else {
                    player2.setFirstServe();
                    player2.setIsSecondServe();
                }
                break;
            case R.id.unfp1:
                changeGameScore(player2, player1);
                player1.setUnforcedError();
                if (player2.isServing() && player2.isSecondServe()) {
                    player2.setWinSecondServe();
                    player2.setIsSecondServe();
                } else if (player2.isServing() && !(player2.isSecondServe())) {
                    player2.setFirstServe();
                    player2.setWinFirstServe();
                    player2.setIsSecondServe();
                } else if (player1.isServing() && player1.isSecondServe()) {
                    player1.setIsSecondServe();
                } else {
                    player1.setFirstServe();
                    player1.setIsSecondServe();
                }
                break;
        }
        updateScreen();
    }

    public void changeGameScore(player playerA, player playerB) {
        String score = playerA.getGame();
        if (score.equals("0"))
            playerA.setGame("15");
        else if (score.equals("15"))
            playerA.setGame("30");
        else if (score.equals("30"))
            playerA.setGame("40");
        else if (score.equals("40")) {
            if (playerB.getGame().equals("40")) {
                playerA.setGame("Ad");
            } else if (playerB.getGame().equals("Ad")) {
                playerB.setGame("40");
            } else {
                playerA.setGame("0");
                playerB.setGame("0");
                switchServer();
                changeSetScore(playerA, playerB);
            }
        } else {
            playerA.setGame("0");
            playerB.setGame("0");
            switchServer( );
            changeSetScore(playerA, playerB);
        }
    }

    public void switchServer( ) {
        TextView textView;
        if (player1.isServing()) {
            player2.setIsServing(true);
            player1.setIsServing(false);
            Button Ace = (Button) findViewById(R.id.acep1);
            Ace.setEnabled(false);
            Ace = (Button) findViewById(R.id.acep2);
            Ace.setEnabled(true);
            Button fault = (Button) findViewById(R.id.faultp1);
            fault.setEnabled(false);
            fault = (Button) findViewById(R.id.faultp2);
            fault.setEnabled(true);
            textView = (TextView) findViewById(R.id.p1);
            textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider));
            textView = (TextView) findViewById(R.id.p2);
            textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.denote_server));
        } else {
            player1.setIsServing(true);
            player2.setIsServing(false);
            Button Ace = (Button) findViewById(R.id.acep2);
            Ace.setEnabled(false);
            Ace = (Button) findViewById(R.id.acep1);
            Ace.setEnabled(true);
            Button fault = (Button) findViewById(R.id.faultp2);
            fault.setEnabled(false);
            fault = (Button) findViewById(R.id.faultp1);
            fault.setEnabled(true);
            textView = (TextView) findViewById(R.id.p2);
            textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider));
            textView = (TextView) findViewById(R.id.p1);
            textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.denote_server));
        }
    }

    public void updateScreen( ) {
        TextView textViewp1 = (TextView) findViewById(R.id.ptpl1);
        TextView textViewp2 = (TextView) findViewById(R.id.ptpl2);
        TextView setViewp1 = (TextView) findViewById(R.id.set1pl1);
        TextView setViewp2 = (TextView) findViewById(R.id.set1pl2);
        textViewp1.setText(player1.getGame());
        textViewp2.setText(player2.getGame());
        setViewp1.setText(String.valueOf(player1.getSet()));
        setViewp2.setText(String.valueOf(player2.getSet()));
    }

    public void changeSetScore(player playerA, player playerB) {
        int scoreA = playerA.getSet();
        int scoreB = playerB.getSet();
        playerA.setSet();
        if (((scoreA-scoreB) >=1 && scoreA >= NUM_GAMES-1)) {
            finishMatch(playerA);
        }
    }

    public void finishMatch(player winner) {
        TextView winnerView;
        Button button;
        if (player1.getName().equals(winner.getName())) {
            winnerView = (TextView) findViewById(R.id.p1);
        } else {
            winnerView = (TextView) findViewById(R.id.p2);
        }
        winnerView.setTypeface(Typeface.DEFAULT_BOLD);

        button = (Button) findViewById(R.id.acep1);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.acep2);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.faultp1);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.faultp2);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.winnerp1);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.winnerp2);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.fcdp1);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.fcdp2);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.unfp1);
        button.setEnabled(false);
        button = (Button) findViewById(R.id.unfp2);
        button.setEnabled(false);
    }

    public void onClickStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player1", player1);
        bundle.putSerializable("player2", player2);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}


