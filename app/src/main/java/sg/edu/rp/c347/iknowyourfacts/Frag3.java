package sg.edu.rp.c347.iknowyourfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static sg.edu.rp.c347.iknowyourfacts.R.id.btnColor1;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag3 extends Fragment {
    TextView tv5;
    Button btnColor3;

    public Frag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        tv5 = (TextView) view.findViewById(R.id.textView5);
        btnColor3 = (Button) view.findViewById(R.id.btnColor3);

        btnColor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(006400);
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

}
