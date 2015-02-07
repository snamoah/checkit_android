package app.checkitapp.com.checkitapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by samuel on 2/6/15.
 */
public class ServerAccess {
    private static String result;
    private static Context activity;

    public static void request(Context a,String code) {
        ServerAccess.activity = a;
        RequestQueue queue = Volley.newRequestQueue(a);

        String url = "https://check-it-app.herokuapp.com/codes/authenticate?token=jDYp9KBQwUmW9ZG0VoNxnA&code="+ code;

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){

                try{

                   //display.setText(response.getString("message"));

                    if(response.getString("status").equals("501")) {
//                        AlertDialog.Builder ab = new AlertDialog.Builder(activity);
//                        ab
//                                .setTitle(response.getString("title"))
//                                .setMessage(response.getString("message"))
//                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        dialogInterface.cancel();
//                                    }
//                                });
//
//                        AlertDialog ad = ab.create();
//                        ad.show();

                        Dialog d = new Dialog(activity);
                        d.setContentView(R.layout.genuine_drug_layout);
                        d.show();

                    } else if(response.getString("status").equals("502")) {
                        Dialog d = new Dialog(activity);
                        d.setContentView(R.layout.fake_drug_layout);
                        d.show();
                    } else {
                        Toast.makeText(activity, "Code has already been used.", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(activity, response.getString("status"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(activity, "There was a problem parsing the JSON.", Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity, "There was a problem connecting to the server. " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        queue.add(jor);
    }
}
