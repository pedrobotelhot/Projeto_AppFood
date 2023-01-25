package food.com.br.appfood.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import food.com.br.appfood.R;
import food.com.br.appfood.Models.HomeCategoriesModel;
import food.com.br.appfood.Models.HomeFoodsModel;
import food.com.br.appfood.Service.HomeFoodsMenu;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeCategoriesAdapter extends RecyclerView.Adapter<HomeCategoriesAdapter.ViewHolder> {

    UpdateFoodsRec updateFoodsRec;
    Activity activity;
    ArrayList<HomeCategoriesModel> list;

    int row_index = -1;
    Call<List<HomeFoodsModel>> call;
    Retrofit retrofit;

    public HomeCategoriesAdapter(UpdateFoodsRec updateFoodsRec, Activity activity, ArrayList<HomeCategoriesModel> list) {
        this.updateFoodsRec = updateFoodsRec;
        this.activity = activity;
        this.list = list;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://free-food-menus-api.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_categories_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());

        if (position == 0) {
            call = retrofit.create(HomeFoodsMenu.class).ourFoodsForHome();
        } else {
            call = retrofit.create(HomeFoodsMenu.class).burgersForHome();
        }

        call.enqueue(new Callback<List<HomeFoodsModel>>() {
            @Override
            public void onResponse(Call<List<HomeFoodsModel>> call, Response<List<HomeFoodsModel>> response) {
                ArrayList<HomeFoodsModel> homeFoodsModels = (ArrayList<HomeFoodsModel>) response.body();
                updateFoodsRec.callBack(position, homeFoodsModels);
            }

            @Override
            public void onFailure(Call<List<HomeFoodsModel>> call, Throwable t) {
                Toast.makeText(activity, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if (row_index == position) {
            holder.cardView.setCardBackgroundColor(activity.getResources().getColor(R.color.yellow_500));
        } else {
            holder.cardView.setCardBackgroundColor(activity.getResources().getColor(R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.category_text);
            cardView = itemView.findViewById(R.id.cardView_categories_item);
        }
    }
}
