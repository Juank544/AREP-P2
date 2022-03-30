package co.edu.escuelaing;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Hello world!
 * Otros comandos para correr:
 * java -cp "target/classes;target/dependency/*" co.edu.escuelaing.App
 * mvn exec:java -Dexec.mainClass="co.edu.escuelaing.App" (CMD)
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        port(getport());
        get("/hello", (request,response) -> "Hello!");
    }

    private static int getport(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
