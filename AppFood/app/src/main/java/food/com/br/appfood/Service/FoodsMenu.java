package food.com.br.appfood.Service;

import java.util.List;

import food.com.br.appfood.Models.FoodsMenuRepo;
import food.com.br.appfood.Models.HomeFoodsModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodsMenu {

    @GET("/our-foods")
    Call<List<HomeFoodsModel>>menusForFood(String food);
}
