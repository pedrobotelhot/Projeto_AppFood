package food.com.br.appfood.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeCategoriesAdapter(UpdateFoodsRec updateFoodsRec, Activity activity, ArrayList<HomeCategoriesModel> list) {
        this.updateFoodsRec = updateFoodsRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_categories_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://free-food-menus-api.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        HomeFoodsMenu foods = retrofit.create(HomeFoodsMenu.class);


        if (check) {

            Call<List<HomeFoodsModel>> call = foods.burgersForHome();

            call.enqueue(new Callback<List<HomeFoodsModel>>() {
                @Override
                public void onResponse(Call<List<HomeFoodsModel>> call, Response<List<HomeFoodsModel>> response) {
                    ArrayList<HomeFoodsModel> homeFoodsModels = (ArrayList<HomeFoodsModel>) response.body();
                    updateFoodsRec.callBack(position, homeFoodsModels);
                    check = false;
                }

                @Override
                public void onFailure(Call<List<HomeFoodsModel>> call, Throwable t) {

                }
            });


        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();

                if (position == 0) {
                    Call<List<HomeFoodsModel>> call = foods.ourFoodsForHome();

                    functionCall(call, position);

                } else if (position == 1) {
                    Call<List<HomeFoodsModel>> call = foods.bestFoodsForHome();

                    functionCall(call, position);

                } else if (position == 2) {
                    Call<List<HomeFoodsModel>> call = foods.breadsForHome();

                    functionCall(call, position);

                } else if (position == 3) {
                    Call<List<HomeFoodsModel>> call = foods.burgersForHome();

                    functionCall(call, position);

                }else if (position == 4) {
                    Call<List<HomeFoodsModel>> call = foods.chocolatesForHome();

                    functionCall(call, position);

                }else if (position == 5) {
                    Call<List<HomeFoodsModel>> call = foods.dessertsForHome();

                    functionCall(call, position);

                }else if (position == 6) {
                    Call<List<HomeFoodsModel>> call = foods.drinksForHome();

                    functionCall(call, position);

                }else if (position == 7) {
                    Call<List<HomeFoodsModel>> call = foods.friedChickenForHome();

                    functionCall(call, position);

                }else if (position == 8) {
                    Call<List<HomeFoodsModel>> call = foods.iceCreamForHome();

                    functionCall(call, position);

                }else if (position == 9) {
                    Call<List<HomeFoodsModel>> call = foods.pizzasForHome();

                    functionCall(call, position);

                }else if (position == 10) {
                    Call<List<HomeFoodsModel>> call = foods.porksForHome();

                    functionCall(call, position);

                }else if (position == 11) {
                    Call<List<HomeFoodsModel>> call = foods.sandwichesForHome();

                    functionCall(call, position);

                }else if (position == 12) {
                    Call<List<HomeFoodsModel>> call = foods.sausagesForHome();

                    functionCall(call, position);

                }else if (position == 13) {
                    Call<List<HomeFoodsModel>> call = foods.steaksForHome();

                    functionCall(call, position);
                }
            }
        });

        if (select) {
            if (position == 3) {
                holder.cardView.setBackgroundResource(R.drawable.change_categories_item);
                select = false;
            }
        } else {
            if (row_index == position) {
                holder.cardView.setBackgroundResource(R.drawable.change_categories_item);
            } else {
                holder.cardView.setBackgroundResource(R.drawable.defaut_categories_item);
            }
        }
    }

    private void functionCall(Call<List<HomeFoodsModel>> call, int position) {
        call.enqueue(new Callback<List<HomeFoodsModel>>() {
            @Override
            public void onResponse(Call<List<HomeFoodsModel>> call, Response<List<HomeFoodsModel>> response) {
                ArrayList<HomeFoodsModel> homeFoodsModels = (ArrayList<HomeFoodsModel>) response.body();
                updateFoodsRec.callBack(position, homeFoodsModels);
            }

            @Override
            public void onFailure(Call<List<HomeFoodsModel>> call, Throwable t) {

            }
        });
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