package hr.cobeisfresh.feelingit;

import com.google.gson.Gson;
import hr.cobeisfresh.feelingit.data.*;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        FeelingsDAO database = new FeelingsDAOImpl();
        Gson gson = new Gson();

        port(getHerokuAssignedPort());

        get("/all", (req, res) -> {
            res.type("application/json");
            return gson.toJson(database.getAllFeelings());
        });

        get("/my", (req, res) -> {
            res.type("application/json");
            return gson.toJson(database.getMyFeelings());
        });

        delete("/my-all", (req, res) -> {
            res.type("application/json");
            database.clearMyFeelings();
            ActionSuccess success = new ActionSuccess(true);
            return gson.toJson(success);
        });

        delete("/my", (req, res) -> {
            res.type("application/json");
            Feeling feeling = gson.fromJson(req.body(), Feeling.class);
            boolean success = database.removeMyFeeling(feeling);
            ActionSuccess response = new ActionSuccess(success);
            return gson.toJson(response);
        });

        post("/my", (req, res) -> {
            res.type("application/json");
            Feeling feeling = gson.fromJson(req.body(), Feeling.class);
            boolean success = database.addMyFeeling(feeling);
            return gson.toJson(new ActionSuccess(success));
        });

        exception(FeelingNotSupportedException.class, ((exception, request, response) -> {
            response.type("application/json");
            response.status(404);
            response.body(gson.toJson(new ActionError(404, "Feeling not supported")));
        }));
    }

    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

}
