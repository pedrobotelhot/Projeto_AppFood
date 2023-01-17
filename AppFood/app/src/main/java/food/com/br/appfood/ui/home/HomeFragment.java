package food.com.br.appfood.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import food.com.br.appfood.R;
import food.com.br.appfood.adapters.HomeCategoriesAdapter;
import food.com.br.appfood.adapters.HomeFoodsAdapter;
import food.com.br.appfood.adapters.UpdateFoodsRec;
import food.com.br.appfood.models.HomeCategoriesModel;
import food.com.br.appfood.models.HomeFoodsModel;


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
        homeCategoriesModelList.add(new HomeCategoriesModel("Pizza"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Hamburguer"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Sorvete"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Bebida"));
        homeCategoriesModelList.add(new HomeCategoriesModel("Acompanhamento"));

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