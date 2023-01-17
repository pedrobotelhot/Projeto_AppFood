package food.com.br.appfood.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import food.com.br.appfood.R;
import food.com.br.appfood.models.HomeCategoriesModel;
import food.com.br.appfood.models.HomeFoodsModel;

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

        if (check) {
            ArrayList<HomeFoodsModel> homeFoodsModels = new ArrayList<>();
            homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));
            homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));
            homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));
            homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));

            updateFoodsRec.callBack(position, homeFoodsModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();

                if (position == 0) {
                    ArrayList<HomeFoodsModel> homeFoodsModels = new ArrayList<>();

                    homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Hamburguer Doido", R.drawable.logo_appfood, 290.53, 3));

                    updateFoodsRec.callBack(position, homeFoodsModels);
                } else if (position == 1) {
                    ArrayList<HomeFoodsModel> homeFoodsModels = new ArrayList<>();

                    homeFoodsModels.add(new HomeFoodsModel("Pizza Maluca", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Pizza Maluca", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Pizza Maluca", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Pizza Maluca", R.drawable.logo_appfood, 290.53, 3));

                    updateFoodsRec.callBack(position, homeFoodsModels);

                } else if (position == 2) {
                    ArrayList<HomeFoodsModel> homeFoodsModels = new ArrayList<>();

                    homeFoodsModels.add(new HomeFoodsModel("Cachorro quente", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Cachorro quente", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Cachorro quente", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Cachorro quente", R.drawable.logo_appfood, 290.53, 3));

                    updateFoodsRec.callBack(position, homeFoodsModels);

                } else if (position == 3) {
                    ArrayList<HomeFoodsModel> homeFoodsModels = new ArrayList<>();

                    homeFoodsModels.add(new HomeFoodsModel("Milk-shake", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Milk-shake", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Milk-shake", R.drawable.logo_appfood, 290.53, 3));
                    homeFoodsModels.add(new HomeFoodsModel("Milk-shake", R.drawable.logo_appfood, 290.53, 3));

                    updateFoodsRec.callBack(position, homeFoodsModels);

                }
            }
        });

        if (select) {
            if (position == 0) {
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
