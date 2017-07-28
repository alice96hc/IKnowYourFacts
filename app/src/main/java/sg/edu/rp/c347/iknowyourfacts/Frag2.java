package sg.edu.rp.c347.iknowyourfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static sg.edu.rp.c347.iknowyourfacts.R.id.btnColor1;
import static sg.edu.rp.c347.iknowyourfacts.R.id.view;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {
    TextView tv1, tv2, tv3;
    Button btnColor2;

    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        tv1 = (TextView) view.findViewById(R.id.textView2);
        tv2 = (TextView) view.findViewById(R.id.textView3);
        tv3 = (TextView) view.findViewById(R.id.textView4);
        btnColor2 = (Button) view.findViewById(R.id.btnColor2);

        btnColor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(800000);
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

}
