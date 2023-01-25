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

        homeCategoriesModelList = new ArrayList<>();

        homeCategoriesModelList.add(new HomeCategoriesModel("All"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Best Foods"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Breads"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Burgers"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Chocolates"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Desserts"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Drinks"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Fried Chicken"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Ice Cream"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Pizzas"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Porks"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Sandwiches"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Sausages"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Steaks"));

        homeCategoriesAdapter = new HomeCategoriesAdapter(this,getActivity(),homeCategoriesModelList);
        homeCategoriesRec.setAdapter(homeCategoriesAdapter);
        homeCategoriesRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeCategoriesRec.setHasFixedSize(true);
        homeCategoriesRec.setNestedScrollingEnabled(false);


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