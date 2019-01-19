package smartcar.com.uofthacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.util.Log;

import com.smartcar.sdk.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.*;

public class MainActivity extends AppCompatActivity {

    private Context appContext;
    private static String CLIENT_ID;
    private static String REDIRECT_URI;
    private static String[] SCOPE;
    private SmartcarAuth smartcarAuth;

    // TODO: Authorization Step 1a. Initialize the Smartcar object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContext = getApplicationContext();

        // TODO: Authorization Step 1b: Initialize the Smartcar object
        CLIENT_ID = getString(R.string.client_id);
        REDIRECT_URI = "sc" + getString(R.string.client_id) + "://exchange";
        SCOPE = new String[]{"read_vehicle_info"};

        smartcarAuth = new SmartcarAuth(
                CLIENT_ID,
                REDIRECT_URI,
                SCOPE,
                true,
                new SmartcarCallback() {
                    // TODO: Authorization Step 3b: Receive an authorization code
                    @Override
                    public void handleResponse(final SmartcarResponse smartcarResponse) {
                        Log.i("MainActivity", smartcarResponse.getCode());

                        final OkHttpClient client = new OkHttpClient();
                        // TODO: Request Step 1: Obtain and access token

                        // Request can not run on the Main Thread
                        // Main Thread is used for UI and therefore can not be blocked
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                // send request to exchange the auth code for the access token
                                Request exchangeRequest = new Request.Builder()
                                        .url(getString(R.string.app_server) + "/exchange?code=" + smartcarResponse.getCode())
                                        .build();

                                try {
                                    client.newCall(exchangeRequest).execute();
                                } catch (IOException e) {}
                            }
                        }).start();

                        // TODO: Request Step 2: Get vehicle information
                        // send request to retrieve the vehicle info
                        Request infoRequest = new Request.Builder()
                                .url(getString(R.string.app_server) + "/vehicle")
                                .build();

                        try {
                            Response response = client.newCall(infoRequest).execute();

                            String jsonBody = response.body().string();
                            JSONObject JObject = new JSONObject(jsonBody);

                            String make = JObject.getString("make");
                            String model = JObject.getString("model");
                            String year = JObject.getString("year");

                            Intent intent = new Intent(appContext, DisplayInfoActivity.class);
                            intent.putExtra("INFO", make + " " + model + " " + year);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Button connectButton = (Button) findViewById(R.id.connect_button);

        // TODO: Authorization Step 2: Launch the authorization flow
        smartcarAuth.addClickHandler(appContext, connectButton);
    }
}
