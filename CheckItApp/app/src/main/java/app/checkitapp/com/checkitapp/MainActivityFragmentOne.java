package app.checkitapp.com.checkitapp;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MainActivityFragmentOne extends Fragment {

    private MainActivityFragmentOne mf = this;
    private EditText code;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_main_fragment_one, container, false);

        code = (EditText) rootView.findViewById(R.id.codeBox);
        RelativeLayout rl = (RelativeLayout) rootView.findViewById(R.id.tag_line_text);
        rl.setVisibility(View.GONE);
        TextView tv = (TextView) rootView.findViewById(R.id.main_label);
        tv.setVisibility(View.INVISIBLE);
        Button b = (Button) rootView.findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServerAccess.request(mf.getActivity(), code.getText().toString());
            }
        });

        return rootView;
    }
}
