package softeng.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        player player1 = (player) bundle.getSerializable("player1");
        player player2 = (player) bundle.getSerializable("player2");

        setname(player1, player2);
        setace(player1, player2);
        setfs(player1, player2);
        setdouble(player1, player2);
        setfsw(player1, player2);
        setssw(player1, player2);
        setpw(player1, player2);
        setw(player1, player2);
        setfer(player1, player2);
        setunf(player1, player2);
    }

    public void setname(player player1, player player2) {
        TextView textViewp1 = (TextView) findViewById(R.id.player1);
        textViewp1.setText(player1.getName());
        TextView textViewp2 = (TextView) findViewById(R.id.player2);
        textViewp2.setText((player2.getName()));
    }
    public void setace(player player1, player player2) {
        TextView acep1 = (TextView) findViewById(R.id.ace_player1);
        acep1.setText(String.valueOf(player1.getAce()));
        TextView acep2 = (TextView) findViewById(R.id.ace_player2);
        acep2.setText(String.valueOf(player2.getAce()));

        TextView textViews1p1bar = (TextView) findViewById(R.id.ace_player1_bar);
        LinearLayout.LayoutParams acep1params = (LinearLayout.LayoutParams) textViews1p1bar.getLayoutParams();
        TextView textViews1p2bar = (TextView) findViewById(R.id.ace_player2_bar);
        LinearLayout.LayoutParams acep2params = (LinearLayout.LayoutParams) textViews1p2bar.getLayoutParams();

        if(player1.getAce()!=0){
            if(player2.getAce() == 0){
                acep2params.weight=player2.getAce();
                textViews1p2bar.setLayoutParams(acep2params);
            }
            acep1params.weight = player1.getAce();
            textViews1p1bar.setLayoutParams(acep1params);
        }
        if(player2.getAce()!=0){
            if(player1.getAce() == 0){
                acep1params.weight = player2.getAce();
                textViews1p1bar.setLayoutParams(acep1params);
            }
            acep2params.weight=player2.getAce();
            textViews1p2bar.setLayoutParams(acep2params);
        }
    }
    public void setfs(player player1, player player2) {
        TextView fs_p1 = (TextView) findViewById(R.id.fs_player1);
        fs_p1.setText(String.valueOf((int) (((double) player1.getFirstServe() / ((double) player1.getFirstServe() + (double) player1.getSecondServe())) * 100)));
        TextView fs_p2 = (TextView) findViewById(R.id.fs_player2);
        fs_p2.setText(String.valueOf((int) (((double) player2.getFirstServe() / ((double) player2.getFirstServe() + (double) player2.getSecondServe())) * 100)));

        TextView textViews2p1bar = (TextView) findViewById(R.id.fs_player1_bar);
        LinearLayout.LayoutParams fsp1params = (LinearLayout.LayoutParams) textViews2p1bar.getLayoutParams();
        TextView textViews2p2bar = (TextView) findViewById(R.id.fs_player2_bar);
        LinearLayout.LayoutParams fsp2params = (LinearLayout.LayoutParams) textViews2p2bar.getLayoutParams();

        if((int)(((double)player1.getFirstServe()/((double)player1.getFirstServe() + (double)player1.getSecondServe())) * 100) != 0){
            fsp1params.weight = (float)(((double)player1.getFirstServe()/((double)player1.getFirstServe() + (double)player1.getSecondServe())) * 100);
            textViews2p1bar.setLayoutParams(fsp1params);
        }
        else {
            if((int)(((double)player2.getFirstServe()/((double)player2.getFirstServe() + (double)player2.getSecondServe())) * 100) != 0)
                fsp1params.weight = 0;
            textViews2p1bar.setLayoutParams(fsp1params);
        }
        if((int)(((double)player2.getFirstServe()/((double)player2.getFirstServe() + (double)player2.getSecondServe())) * 100) != 0) {
            fsp2params.weight = (float) (((double) player2.getFirstServe() / ((double) player2.getFirstServe() + (double) player2.getSecondServe())) * 100);
            textViews2p2bar.setLayoutParams(fsp2params);
        } else {
            if((int)(((double)player1.getFirstServe()/((double)player1.getFirstServe() + (double)player1.getSecondServe())) * 100) != 0)
                fsp2params.weight = 0;
            textViews2p2bar.setLayoutParams(fsp2params);
        }
    }
    public void setdouble(player player1, player player2) {
        TextView double_p1 = (TextView) findViewById(R.id.double_player1);
        double_p1.setText(String.valueOf(player1.getDoubleFault()));
        TextView double_p2 = (TextView) findViewById(R.id.double_player2);
        double_p2.setText(String.valueOf(player2.getDoubleFault()));

        TextView textViews3p1bar = (TextView) findViewById(R.id.double_player1_bar);
        LinearLayout.LayoutParams doublep1params = (LinearLayout.LayoutParams) textViews3p1bar.getLayoutParams();
        TextView textViews3p2bar = (TextView) findViewById(R.id.double_player2_bar);
        LinearLayout.LayoutParams doublep2params = (LinearLayout.LayoutParams) textViews3p2bar.getLayoutParams();

        if (player1.getDoubleFault() != 0) {
            if(player2.getDoubleFault() == 0){
                doublep2params.weight = 0;
                textViews3p2bar.setLayoutParams(doublep2params);
            }
            doublep1params.weight = player1.getDoubleFault();
            textViews3p1bar.setLayoutParams(doublep1params);
        }
        if (player2.getDoubleFault() != 0) {
            if (player1.getDoubleFault() == 0) {
                doublep1params.weight = 0;
                textViews3p1bar.setLayoutParams(doublep1params);
            }
            doublep2params.weight = player2.getDoubleFault();
            textViews3p2bar.setLayoutParams(doublep2params);
        }
    }
    public void setfsw(player player1, player player2){
        TextView fsw_p1 = (TextView) findViewById(R.id.fsw_player1);
        fsw_p1.setText(String.valueOf((int) ((((double) player1.getWinFirstServe() / (double) player1.getFirstServe()) * 100))));
        TextView fsw_p2 = (TextView) findViewById(R.id.fsw_player2);
        fsw_p2.setText(String.valueOf((int) ((((double) player2.getWinFirstServe() / (double) player2.getFirstServe()) * 100))));

        TextView textViews4p1bar = (TextView) findViewById(R.id.fsw_player1_bar);
        LinearLayout.LayoutParams fswp1params = (LinearLayout.LayoutParams) textViews4p1bar.getLayoutParams();
        TextView textViews4p2bar = (TextView) findViewById(R.id.fsw_player2_bar);
        LinearLayout.LayoutParams fswp2params = (LinearLayout.LayoutParams) textViews4p2bar.getLayoutParams();

        if ((int)((((double)player1.getWinFirstServe()/(double)player1.getFirstServe())* 100)) != 0){
            if ((int)((((double)player2.getWinFirstServe()/(double)player2.getFirstServe())* 100)) == 0){
                fswp2params.weight = 0;
                textViews4p2bar.setLayoutParams(fswp2params);
            }
            fswp1params.weight = (int)((((double)player1.getWinFirstServe()/(double)player1.getFirstServe())* 100));
            textViews4p1bar.setLayoutParams(fswp1params);
        }
        if ((int)((((double)player2.getWinFirstServe()/(double)player2.getFirstServe())* 100)) != 0){
            if ((int)((((double)player1.getWinFirstServe()/(double)player1.getFirstServe())* 100)) == 0){
                fswp1params.weight = 0;
                textViews4p1bar.setLayoutParams(fswp1params);
            }
            fswp2params.weight = (int)((((double)player2.getWinFirstServe()/(double)player2.getFirstServe())* 100));
            textViews4p2bar.setLayoutParams(fswp2params);
        }
    }
    public void setssw(player player1, player player2){
        TextView ssw_p1 = (TextView) findViewById(R.id.ssw_player1);
        ssw_p1.setText(String.valueOf((int) (((double) player1.getWinSecondServe() / (double) player1.getSecondServe()) * 100)));
        TextView ssw_p2 = (TextView) findViewById(R.id.ssw_player2);
        ssw_p2.setText(String.valueOf((int) ((((double) player2.getWinSecondServe() / (double) player2.getSecondServe()) * 100))));

        TextView textViews5p1bar = (TextView) findViewById(R.id.ssw_player1_bar);
        LinearLayout.LayoutParams sswp1params = (LinearLayout.LayoutParams) textViews5p1bar.getLayoutParams();
        TextView textViews5p2bar = (TextView) findViewById(R.id.ssw_player2_bar);
        LinearLayout.LayoutParams sswp2params = (LinearLayout.LayoutParams) textViews5p2bar.getLayoutParams();

        if ((int)((((double)player1.getWinSecondServe()/(double)player1.getSecondServe())* 100)) != 0){
            if ((int)((((double)player2.getWinSecondServe()/(double)player2.getSecondServe())* 100)) == 0){
                sswp2params.weight = 0;
                textViews5p2bar.setLayoutParams(sswp2params);
            }
            sswp1params.weight = (int)((((double)player1.getWinSecondServe()/(double)player1.getSecondServe())* 100));
            textViews5p1bar.setLayoutParams(sswp1params);
        }
        if ((int)((((double)player2.getWinSecondServe()/(double)player2.getSecondServe())* 100)) != 0){
            if ((int)((((double)player1.getWinSecondServe()/(double)player1.getSecondServe())* 100)) == 0){
                sswp1params.weight = 0;
                textViews5p1bar.setLayoutParams(sswp1params);
            }
            sswp2params.weight = (int)((((double)player2.getWinSecondServe()/(double)player2.getSecondServe())* 100));
            textViews5p2bar.setLayoutParams(sswp2params);
        }
    }
    public void setpw(player player1, player player2) {
        TextView pw_player1 = (TextView) findViewById(R.id.pw_player1);
        pw_player1.setText(String.valueOf(player1.getWinner() + player2.getUnforcedError() + player2.getForcedError()));
        TextView pw_player2 = (TextView) findViewById(R.id.pw_player2);
        pw_player2.setText(String.valueOf(player2.getWinner() + player1.getUnforcedError() + player1.getForcedError()));

        TextView textViews6p1bar = (TextView) findViewById(R.id.pw_player1_bar);
        LinearLayout.LayoutParams pwp1params = (LinearLayout.LayoutParams) textViews6p1bar.getLayoutParams();
        TextView textViews6p2bar = (TextView) findViewById(R.id.pw_player2_bar);
        LinearLayout.LayoutParams pwp2params = (LinearLayout.LayoutParams) textViews6p2bar.getLayoutParams();

        if ((player1.getWinner()+player2.getForcedError()+player2.getUnforcedError()) != 0){
            if((player1.getWinner()+player2.getForcedError()+player2.getUnforcedError()) != 0){
                pwp2params.weight = 0;
                textViews6p2bar.setLayoutParams(pwp2params);
            }
            pwp1params.weight =(player1.getWinner()+player2.getForcedError()+player2.getUnforcedError());
            textViews6p1bar.setLayoutParams(pwp1params);
        }
        if((player2.getWinner()+player1.getForcedError()+player1.getUnforcedError()) != 0){
            if((player1.getWinner()+player2.getForcedError()+player2.getUnforcedError()) == 0){
                pwp1params.weight = 0;
                textViews6p1bar.setLayoutParams(pwp1params);
            }
            pwp2params.weight = (player2.getWinner()+player1.getForcedError()+player1.getUnforcedError());
            textViews6p2bar.setLayoutParams(pwp2params);
        }

    }
    public void setw(player player1, player player2) {
        TextView w_player1 = (TextView) findViewById(R.id.w_player1);
        w_player1.setText(String.valueOf(player1.getWinner()));
        TextView w_player2 = (TextView) findViewById(R.id.w_player2);
        w_player2.setText(String.valueOf(player2.getWinner()));

        TextView textViews7p1bar = (TextView) findViewById(R.id.w_player1_bar);
        LinearLayout.LayoutParams wp1params = (LinearLayout.LayoutParams) textViews7p1bar.getLayoutParams();
        TextView textViews7p2bar = (TextView) findViewById(R.id.w_player2_bar);
        LinearLayout.LayoutParams wp2params = (LinearLayout.LayoutParams) textViews7p2bar.getLayoutParams();

        if (player1.getWinner() != 0) {
            if(player2.getWinner() == 0){
                wp2params.weight = 0;
                textViews7p2bar.setLayoutParams(wp2params);
            }
            wp1params.weight = player1.getWinner();
            textViews7p1bar.setLayoutParams(wp1params);
        }
        if (player2.getWinner() != 0) {
            if (player1.getWinner() == 0) {
                wp1params.weight = 0;
                textViews7p1bar.setLayoutParams(wp1params);
            }
            wp2params.weight = player2.getWinner();
            textViews7p2bar.setLayoutParams(wp2params);
        }
    }
    public void setfer(player player1, player player2) {
        TextView fer_player1 = (TextView) findViewById(R.id.fer_player1);
        fer_player1.setText(String.valueOf(player1.getForcedError()));
        TextView fer_player2 = (TextView) findViewById(R.id.fer_player2);
        fer_player2.setText(String.valueOf(player2.getForcedError()));

        TextView textViews8p1bar = (TextView) findViewById(R.id.fer_player1_bar);
        LinearLayout.LayoutParams ferp1params = (LinearLayout.LayoutParams) textViews8p1bar.getLayoutParams();
        TextView textViews8p2bar = (TextView) findViewById(R.id.fer_player2_bar);
        LinearLayout.LayoutParams ferp2params = (LinearLayout.LayoutParams) textViews8p2bar.getLayoutParams();

        if (player1.getForcedError() != 0) {
            if(player2.getForcedError() == 0){
                ferp2params.weight = 0;
                textViews8p2bar.setLayoutParams(ferp2params);
            }
            ferp1params.weight = player1.getForcedError();
            textViews8p1bar.setLayoutParams(ferp1params);
        }
        if (player2.getForcedError() != 0) {
            if (player1.getForcedError() == 0) {
                ferp1params.weight = 0;
                textViews8p1bar.setLayoutParams(ferp1params);
            }
            ferp2params.weight = player2.getForcedError();
            textViews8p2bar.setLayoutParams(ferp2params);
        }
    }
    public void setunf(player player1, player player2) {
        TextView unf_player1 = (TextView) findViewById(R.id.unf_player1);
        unf_player1.setText(String.valueOf(player1.getUnforcedError()));
        TextView unf_player2 = (TextView) findViewById(R.id.unf_player2);
        unf_player2.setText(String.valueOf(player2.getUnforcedError()));

        TextView textViews9p1bar = (TextView) findViewById(R.id.unf_player1_bar);
        LinearLayout.LayoutParams unfp1params = (LinearLayout.LayoutParams) textViews9p1bar.getLayoutParams();
        TextView textViews9p2bar = (TextView) findViewById(R.id.unf_player2_bar);
        LinearLayout.LayoutParams unfp2params = (LinearLayout.LayoutParams) textViews9p2bar.getLayoutParams();

        if (player1.getUnforcedError() != 0) {
            if(player2.getUnforcedError() == 0){
                unfp2params.weight = 0;
                textViews9p2bar.setLayoutParams(unfp2params);
            }
            unfp1params.weight = player1.getUnforcedError();
            textViews9p1bar.setLayoutParams(unfp1params);
        }
        if (player2.getUnforcedError() != 0) {
            if (player1.getUnforcedError() == 0) {
                unfp1params.weight = 0;
                textViews9p1bar.setLayoutParams(unfp1params);
            }
            unfp2params.weight = player2.getUnforcedError();
            textViews9p2bar.setLayoutParams(unfp2params);
        }
    }

}
