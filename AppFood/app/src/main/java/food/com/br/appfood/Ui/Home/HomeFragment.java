package food.com.br.appfood.Ui.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import food.com.br.appfood.R;
import food.com.br.appfood.Adapters.HomeCategoriesAdapter;
import food.com.br.appfood.Adapters.HomeFoodsAdapter;
import food.com.br.appfood.Adapters.UpdateFoodsRec;
import food.com.br.appfood.Models.HomeCategoriesModel;
import food.com.br.appfood.Models.HomeFoodsModel;
import food.com.br.appfood.Service.HomeCategoriesMenu;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment implements UpdateFoodsRec {

    RecyclerView homeCategoriesRec;
    ArrayList<HomeCategoriesModel> homeCategoriesModelList;
    HomeCategoriesAdapter homeCategoriesAdapter;

    RecyclerView homeFoodsRec;
    ArrayList<HomeFoodsModel> homeFoodsModelList;
    HomeFoodsAdapter homeFoodsAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeCategoriesRec = root.findViewById(R.id.home_categories_rec);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://free-food-menus-api.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        HomeCategoriesMenu categories = retrofit.create(HomeCategoriesMenu.class);
        Call<List<HomeCategoriesModel>> call = categories.categoriesForMenu();

        call.enqueue(new Callback<List<HomeCategoriesModel>>() {
            @Override
            public void onResponse(Call<List<HomeCategoriesModel>> call, Response<List<HomeCategoriesModel>> response) {
                List<HomeCategoriesModel> model = response.body();
                homeCategoriesAdapter = new HomeCategoriesAdapter(getActivity(),model);
                homeCategoriesRec.setAdapter(homeCategoriesAdapter);
                homeCategoriesRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
                homeCategoriesRec.setHasFixedSize(true);
                homeCategoriesRec.setNestedScrollingEnabled(false);
            }

            @Override
            public void onFailure(Call<List<HomeCategoriesModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "error :(", Toast.LENGTH_SHORT).show();
            }
        });


        homeFoodsRec = root.findViewById(R.id.home_foods_rec);


        homeFoodsModelList = new ArrayList<>();

        homeFoodsAdapter = new HomeFoodsAdapter(getActivity(), homeFoodsModelList);
        homeFoodsRec.setAdapter(homeFoodsAdapter);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        homeFoodsRec.setLayoutManager(mGridLayoutManager);





        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeFoodsModel> list) {

        homeFoodsAdapter = new HomeFoodsAdapter(getContext(),list);
        homeFoodsAdapter.notifyDataSetChanged();
        homeFoodsRec.setAdapter(homeFoodsAdapter);

    }
}