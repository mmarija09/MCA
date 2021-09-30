package quizPackage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;


public class Client {

    String REST_URL = "https://interview-task-api.mca.dev/";

    public void getProducts() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(REST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<ArrayList<Product>> call = apiInterface.getListOfProducts();
        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        ArrayList<Product> onlyDomestic = ProductService.getByDomestic(response.body(), true);
                        ArrayList<Product> onlyImported = ProductService.getByDomestic(response.body(), false);

                        //sort alphabetically
                        ProductService.sortProductsByNameAlphabetically(onlyDomestic);
                        ProductService.sortProductsByNameAlphabetically(onlyImported);

                        //print
                        System.out.println(". Domestic");
                        onlyDomestic.forEach(System.out::println);
                        System.out.println(". Imported");
                        onlyImported.forEach(System.out::println);

                        //cost
                        System.out.print("Domestic cost: $");
                        ProductService.printCost(onlyDomestic);
                        System.out.print("Imported cost: $");
                        ProductService.printCost(onlyImported);

                        //counts
                        System.out.println("Domestic count: " + onlyDomestic.size());
                        System.out.println("Imported count: " + onlyImported.size());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                System.out.println("" + t.getMessage());
            }
        });
    }

}
