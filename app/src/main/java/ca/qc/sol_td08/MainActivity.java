package ca.qc.sol_td08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;

import ca.qc.sol_td08.fragments.FragmentA;
import ca.qc.sol_td08.fragments.FragmentB;

public class MainActivity extends AppCompatActivity implements FragmentA.CommunicationChannel {

    Button btnToggle;
    TextView lblResult;
    String[] titres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToggle = findViewById(R.id.main_btn_toggle);
        lblResult = findViewById(R.id.main_lbl_result);
        titres = new String[3];
        titres[0] = "Hello Friends";
        titres[1] = "Hello Guys";
        titres[2] = "Hello People";

    }

    public void Charger(View view) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment frag = manager.findFragmentById(R.id.frag_container);
        FragmentTransaction ft = manager.beginTransaction();
        if(frag != null && frag instanceof FragmentB){
            ft.remove(frag);
            btnToggle.setText("Charger");

        }else {
            FragmentB fragmentB = new FragmentB();
            Bundle bundle = new Bundle();
            bundle.putString("titre", titres[new Random().nextInt(3)]);
            fragmentB.setArguments(bundle);
            ft.add(R.id.frag_container, fragmentB);
            btnToggle.setText("Supprimer");
        }
        ft.commit();
    }

    @Override
    public void SendMessage(String message) {
        lblResult.setText(message);
    }
}