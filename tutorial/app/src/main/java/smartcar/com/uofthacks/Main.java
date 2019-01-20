import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.smartcar.sdk.*;
import com.smartcar.sdk.data.*;


public class Main {
  // global variable to save our accessToken
  private static String access;
  private static Gson gson = new Gson();

  public static void main(String[] args) {

    port(8000);

    String clientId = System.getenv("CLIENT_ID");
    String clientSecret = System.getenv("CLIENT_SECRET");
    String redirectUri = System.getenv("REDIRECT_URI");
    String[] scope = {"read_vehicle_info", "read_location", "read_odometer", "control_security"};
    //boolean testMode = false;

    AuthClient client = new AuthClient(
            clientId,
            clientSecret,
            redirectUri,
            scope,
            false
    );

    get("/login", (req, res) -> {
      String link = client.getAuthUrl();
      res.redirect(link);
      return null;
    });

    get("/exchange", (req, res) -> {
      String code = req.queryMap("code").value();

      System.out.println(code);

      Auth auth = client.exchangeCode(code);

      // in a production app you'll want to store this in some kind of persistent storage
      access = auth.getAccessToken();

      return "";
    });

    get("/vehicle", (req, res) -> {
      SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
      // the list of vehicle ids
      String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

      // instantiate the first vehicle in the vehicle id list
      Vehicle vehicle = new Vehicle(vehicleIds[0], access);

      VehicleInfo info = vehicle.info();
      System.out.println(gson.toJson(info));

      res.type("application/json");

      JsonParser parser = new JsonParser();
      System.out.println(parser.parse(gson.toJson(info)).getAsJsonObject().get("model"));

      return gson.toJson(info);
    });

    get("/location", (req, res) -> {
      SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
      // the list of vehicle ids
      String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

      // instantiate the first vehicle in the vehicle id list
      Vehicle vehicle = new Vehicle(vehicleIds[0], access);

      VehicleLocation location = (VehicleLocation) vehicle.location().getData();
      System.out.println(location.getLatitude());
      System.out.println(location.getLongitude());

      res.type("application/json");

      return gson.toJson(location);
    });

    get("/odometer", (req, res) -> {
      SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
      // the list of vehicle ids
      String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

      // instantiate the first vehicle in the vehicle id list
      Vehicle vehicle = new Vehicle(vehicleIds[0], access);

      VehicleOdometer info = (VehicleOdometer) vehicle.odometer().getData();
      System.out.println(info.getDistance());

      res.type("application/json");

      return gson.toJson(info);
    });

    get("/unlock", (req, res) -> {
      SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
      // the list of vehicle ids
      String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

      // instantiate the first vehicle in the vehicle id list
      Vehicle vehicle = new Vehicle(vehicleIds[0], access);

      vehicle.unlock();
      System.out.println("unlock");

      res.type("application/json");

      return null;
    });

    get("/lock", (req, res) -> {
      SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
      // the list of vehicle ids
      String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

      // instantiate the first vehicle in the vehicle id list
      Vehicle vehicle = new Vehicle(vehicleIds[0], access);

      vehicle.lock();
      System.out.println("lock");

      res.type("application/json");

      return null;
    });
  }
}
