package ramasatriafb.dicoding.myhealthdessert;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDessertAdapter extends RecyclerView.Adapter<ListDessertAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Dessert> listDessert;

    private ArrayList<Dessert> getListDessert() {
        return listDessert;
    }

    void setListDessert(ArrayList<Dessert> listDessert) {
        this.listDessert = listDessert;
    }

    ListDessertAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_dessert, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListDessert().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListDessert().get(position).getRemarks());

        Glide.with(context)
                .load(getListDessert().get(position).getPhoto())
                .apply(new RequestOptions().override(75,75))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListDessert().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById((R.id.img_item_photo));
        }
    }
}
