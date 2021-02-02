package edu.escuelaing.arep.webapp;

import edu.escuelaing.arep.calculator.Calculator;
import edu.escuelaing.arep.datastructures.LinkedList;
import com.google.gson.Gson;
import static spark.Spark.*;

/**
 * Main class that define endpoints to use the statistics calculator.
 *
 * @author Angi Paola Jimenez Pira
 * @version 1.0
 */
public class SparkWebApp
{
    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple web app. It maps the lambda function to the
     * / relative URL.
     */
    public static void main(String[] args) {

        port(getPort());
        staticFileLocation("/");
        get("/", (req, res) -> {
            res.redirect("/index.html");
            res.status(200);
            return null;
        });

        post("/calculator/mean",(req,res) ->{
            String mean = "{\"mean\":"+Calculator.mean( req.body() )+"}";
            Gson gson = new Gson();
            return gson.toJson(mean);
        });

        post("/calculator/standardDeviation",(req,res) ->{
            String std = "{\"std\":" +Calculator.standardDeviation( req.body() )+"}";
            Gson gson = new Gson();
            return gson.toJson(std);
        });
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
