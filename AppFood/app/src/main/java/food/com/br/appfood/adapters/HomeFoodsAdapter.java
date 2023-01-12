package food.com.br.appfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import food.com.br.appfood.R;

import food.com.br.appfood.models.HomeFoodsModel;

public class HomeFoodsAdapter extends RecyclerView.Adapter<HomeFoodsAdapter.ViewHolder> {

    Context context;
    List<HomeFoodsModel> list;

    public HomeFoodsAdapter(Context context, List<HomeFoodsModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeFoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeFoodsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_foods_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFoodsAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.price.setText((int) list.get(position).getPrice());
        holder.rate.setText(list.get(position).getRate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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
