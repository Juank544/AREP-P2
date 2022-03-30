package co.edu.escuelaing;

import co.edu.escuelaing.services.MathService;
import com.google.gson.JsonObject;

import static spark.Spark.*;

/**
 * Hello world!
 * Otros comandos para correr:
 * java -cp "target/classes;target/dependency/*" co.edu.escuelaing.App
 * mvn exec:java -Dexec.mainClass="co.edu.escuelaing.App" (CMD)
 */
public class App 
{
    static MathService mathService = new MathService();

    public static void main( String[] args )
    {
        port(getport());
        path("/api/v1", () -> {
            get("/ln" , (request,response) -> {
                response.type("application/json");
                JsonObject json = new JsonObject();
                Double value = Double.valueOf(request.queryParams("value"));

                json.addProperty("operation", "ln");
                json.addProperty("input", value);
                json.addProperty("output", mathService.ln(value));

                return json;
            });
            get("/acos", (request,response) -> {
                response.type("application/json");
                JsonObject json = new JsonObject();
                Double value = Double.valueOf(request.queryParams("value"));

                json.addProperty("operation", "acos");
                json.addProperty("input", value);
                json.addProperty("output", mathService.acos(value));

                return json;
            });
        });
        get("/hello", (request,response) -> "Hello!");
    }

    private static int getport(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
