package edu.escuelaing.arep.webapp;

import edu.escuelaing.arep.calculator.Calculator;
import edu.escuelaing.arep.datastructures.LinkedList;
import com.google.gson.Gson;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class SparkWebApp
{
    public static void main(String[] args) {

        port(getPort());
        staticFileLocation("/");
        get("/", (req, res) -> {
            res.redirect("/index.html");
            res.status(200);
            return null;
        });

        post("/calculator/mean",(req,res) ->{
            Double mean = Calculator.mean( req.body() );
            Gson gson = new Gson();
            return mean;
        });

        post("/calculator/standardDeviation",(req,res) ->{
            Double mean = Calculator.standardDeviation( req.body() );
            Gson gson = new Gson();
            return gson.toJson(mean);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
