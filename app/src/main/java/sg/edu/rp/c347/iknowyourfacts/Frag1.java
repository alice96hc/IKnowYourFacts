package sg.edu.rp.c347.iknowyourfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static sg.edu.rp.c347.iknowyourfacts.R.id.view;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {
    TextView tv;
    Button btnColor1;

    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        tv = (TextView) view.findViewById(R.id.textView);
        btnColor1 = (Button) view.findViewById(R.id.btnColor1);

        btnColor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(808080);
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
}
