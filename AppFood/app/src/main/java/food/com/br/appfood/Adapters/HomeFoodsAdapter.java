package food.com.br.appfood.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import food.com.br.appfood.R;

import food.com.br.appfood.Models.HomeFoodsModel;

public class HomeFoodsAdapter extends RecyclerView.Adapter<HomeFoodsAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeFoodsModel> list;

    public HomeFoodsAdapter(Context context, ArrayList<HomeFoodsModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeFoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_foods_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFoodsAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(String.valueOf(list.get(position).getPrice()));
        holder.rate.setText(String.valueOf(list.get(position).getRate()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView price;
        TextView rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.food_img_cardFood);
            name = itemView.findViewById(R.id.text_name_cardFood);
            price = itemView.findViewById(R.id.text_price_cardFood);
            rate = itemView.findViewById(R.id.text_rate_cardFood);
        }
    }
}
