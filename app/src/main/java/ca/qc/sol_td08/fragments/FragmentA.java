package ca.qc.sol_td08.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ca.qc.sol_td08.R;


public class FragmentA extends Fragment {

    public interface CommunicationChannel {
        void SendMessage(String message);
    }

    CommunicationChannel channel;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        channel = (CommunicationChannel) context;
    }

    TextView lblTitre;
    Button btnClick;
    EditText txtMessage;

    public FragmentA() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a, container, false);
        //instancier les composants UI
        lblTitre = view.findViewById(R.id.frag_a_lbl_titre);
        btnClick = view.findViewById(R.id.frag_a_btn_click);
        txtMessage = view.findViewById(R.id.frag_a_txt_message);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lblTitre.setText("Hello World");
                String message  = txtMessage.getText().toString();
                channel.SendMessage(message);
            }
        });

        return  view;
    }
}