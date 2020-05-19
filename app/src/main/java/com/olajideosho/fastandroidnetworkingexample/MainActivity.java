package com.olajideosho.fastandroidnetworkingexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    public void sendRequest(){

        //Dynamic Java Object Request
        AndroidNetworking.get("https://reqres.in/api/users?page=2")
                .build()
                .getAsObject(UserListResponse.class, new ParsedRequestListener<UserListResponse>() {
                    @Override
                    public void onResponse(UserListResponse response) {
                        Log.d(TAG, "page: " + response.getPage());
                        Log.d(TAG, "data: " + response.getData().get(1).getEmail());
                        Log.d(TAG, "ad " + response.getAd().company);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

        //Delete Request
//        AndroidNetworking.delete(url)

        //Update Request
//        AndroidNetworking.put(url)
//        AndroidNetworking.patch(url)

        //Custom Object Request
//        UserObject user = new UserObject();
//        user.setName("Jido");
//        user.setJob("JSE");
//
//        AndroidNetworking.post("https://reqres.in/api/users")
//                .addBodyParameter(user)
//                .setExecutor(Executors.newSingleThreadExecutor())
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d(TAG, "onResponse: " + response.getString("name"));
//                        }catch (JSONException e){
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });

        //Raw GET Request
//        AndroidNetworking.get("https://jsonplaceholder.typicode.com/posts")
////                .addPathParameter("postId", "1")
//                .setPriority(Priority.HIGH)
//                .build()
//                .getAsJSONArray(new JSONArrayRequestListener() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        try {
//                            Log.d(TAG, "onResponse: " + response.getJSONObject(0).getString("userId"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        Log.d(TAG, "onError: " + anError.getLocalizedMessage());
//                    }
//                });
        //Raw POST Request
//        AndroidNetworking.post("https://reqres.in/api/users")
//                .addBodyParameter("name", "jide")
//                .addBodyParameter("job", "Software Engineer")
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, "onResponse: successful response");
//                        try {
//                            Log.d(TAG, "onResponse: " + response.getString("name"));
//                        }catch (JSONException e){
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });
    }
}
