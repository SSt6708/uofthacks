import static spark.Spark.*;

import com.google.gson.Gson;
import com.smartcar.sdk.*;
import com.smartcar.sdk.data.*;

public class Main {
    // global variable to save our accessToken
    private static String access;
    private static Gson gson = new Gson();

    public static void main(String[] args) {

        port(8000);

        // TODO: Authorization Step 1a: Launch Smartcar authentication dialog
        String clientId = System.getenv("CLIENT_ID");
        String clientSecret = System.getenv("CLIENT_SECRET");
        String redirectUri = System.getenv("REDIRECT_URI");
        String[] scope = {"read_vehicle_info"};
        boolean testMode = true;

        AuthClient client = new AuthClient(
                clientId,
                clientSecret,
                redirectUri,
                scope,
                testMode
        );

        get("/login", (req, res) -> {
            // TODO: Authorization Step 1b: Launch Smartcar authentication dialog
            String link = client.getAuthUrl();
            res.redirect(link);
            return null;
        });


        get("/exchange", (req, res) -> {
            // TODO: Authorization Step 3: Handle Smartcar response
                    String code = req.queryMap("code").value();

                    System.out.println(code);

            // TODO: Request Step 1: Obtain an access token

            return "";
        });

        get("/vehicle", (req, res) -> {
            // TODO: Request Step 2: Get vehicle ids

            // TODO: Request Step 3: Create a vehicle

            // TODO: Request Step 4: Make a request to Smartcar API

            return null;
        });
    }
}
