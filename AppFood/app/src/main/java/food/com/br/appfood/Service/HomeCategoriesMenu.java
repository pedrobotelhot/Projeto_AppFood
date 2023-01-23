package food.com.br.appfood.Service;

import java.util.List;

import food.com.br.appfood.Models.HomeCategoriesModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeCategoriesMenu {

    @GET("/pagination")
    Call<List<HomeCategoriesModel>> categoriesForMenu();
}
