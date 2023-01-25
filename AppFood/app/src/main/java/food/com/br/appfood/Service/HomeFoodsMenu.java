package food.com.br.appfood.Service;

import java.util.List;

import food.com.br.appfood.Models.HomeFoodsModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeFoodsMenu {

    @GET("/our-foods")
    Call<List<HomeFoodsModel>>ourFoodsForHome();

    @GET("/bbqs")
    Call<List<HomeFoodsModel>>bbqsForHome();

    @GET("/best-foods")
    Call<List<HomeFoodsModel>>bestFoodsForHome();

    @GET("/breads")
    Call<List<HomeFoodsModel>>breadsForHome();

    @GET("/burgers")
    Call<List<HomeFoodsModel>>burgersForHome();

    @GET("/chocolates")
    Call<List<HomeFoodsModel>>chocolatesForHome();

    @GET("/desserts")
    Call<List<HomeFoodsModel>>dessertsForHome();

    @GET("/drinks")
    Call<List<HomeFoodsModel>>drinksForHome();

    @GET("/fried-chicken")
    Call<List<HomeFoodsModel>>friedChickenForHome();

    @GET("/ice-cream")
    Call<List<HomeFoodsModel>>iceCreamForHome();

    @GET("/pizzas")
    Call<List<HomeFoodsModel>>pizzasForHome();

    @GET("/porks")
    Call<List<HomeFoodsModel>>porksForHome();

    @GET("/sandwiches")
    Call<List<HomeFoodsModel>>sandwichesForHome();

    @GET("/sausages")
    Call<List<HomeFoodsModel>>sausagesForHome();

    @GET("/steaks")
    Call<List<HomeFoodsModel>>steaksForHome();
}
