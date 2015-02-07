package app.checkitapp.com.checkitapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class IntroActivityFragmentOne extends Fragment {

    Animation anim;
    RelativeLayout r;
    TextView main_label;
    IntroActivityFragmentOne fo = this;
    EditText code_box;
    private String result;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final View rootView = inflater.inflate(R.layout.activity_intro_fragment_one, container, false);
        anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.logo_animate);
        anim.reset();
        ImageView iv = (ImageView) rootView.findViewById(R.id.imageView1);
        iv.clearAnimation();
        iv.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.call_to_action_animator);
        anim.reset();
        r = (RelativeLayout) rootView.findViewById(R.id.call_to_action);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.call_to_action_animator);
        r.clearAnimation();
        // Now Set your animation
        r.startAnimation(fadeInAnimation);

        main_label = (TextView) rootView.findViewById(R.id.main_label);
        code_box = (EditText) rootView.findViewById(R.id.codeBox);

        Button button =(Button) rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v){
//               String r = (code_box.getText().toString());
//
//
//               Intent intent = new Intent(getActivity(),Response_1.class);
//                intent.putExtra("code", r);
//               startActivity(intent);
                ServerAccess.request(fo.getActivity(), code_box.getText().toString());
            }
        });

        TextView signup = (TextView) rootView.findViewById(R.id.signup_link);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fo.getActivity().getSupportFragmentManager().beginTransaction().add(R.id.pager, new IntroActivityFragmentFour()).commit();
            }
        });
        return rootView;
    }



    private void StartAnimations() {

        anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.logo_animate);
        anim.reset();
        ImageView iv = (ImageView) getActivity().findViewById(R.id.imageView1);
        iv.clearAnimation();
        iv.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.call_to_action_animator);
        anim.reset();
        r = (RelativeLayout) getView().findViewById(R.id.call_to_action);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.call_to_action_animator);
        r.clearAnimation();
        // Now Set your animation
        r.startAnimation(fadeInAnimation);
    }

}
