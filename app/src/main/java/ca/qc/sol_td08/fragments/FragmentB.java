package ca.qc.sol_td08.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.qc.sol_td08.R;


public class FragmentB extends Fragment {

    TextView lblMessage;

    public FragmentB() {
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
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        //instancier les composants UI
        lblMessage = view.findViewById(R.id.frag_b_lbl_message);
        Bundle bundle = getArguments();
        if (bundle != null)
            lblMessage.setText(bundle.getString("titre"));
        return  view;
    }
}