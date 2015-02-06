package app.checkitapp.com.checkitapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class IntroActivityFragmentFour extends Fragment {

    private Fragment f = this;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_intro_fragment_four,container,false);

        Button verify = (Button) rootView.findViewById(R.id.button1);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(f.getActivity(), MainActivity.class);
                startActivity(i);
            }
        });


        return rootView;
    }

}
