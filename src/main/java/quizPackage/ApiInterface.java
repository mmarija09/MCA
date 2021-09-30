package quizPackage;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.ArrayList;

public interface ApiInterface {

    @GET("qr-scanner-codes/alpha-qr-gFpwhsQ8fkY1")
    Call<ArrayList<Product>> getListOfProducts();

}
