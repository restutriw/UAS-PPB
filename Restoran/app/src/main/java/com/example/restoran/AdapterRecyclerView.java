package com.example.restoran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;
        LinearLayoutCompat parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.text_title);
            textSubhead = itemView.findViewById(R.id.text_subtitle);
            imageIcon = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    AdapterRecyclerView(Context context, ArrayList<ItemModel> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(v -> {
            Toast.makeText(context,"Anda memilih " + dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();
            
            if(dataItem.get(position).getName().equals("Chicken Katsu")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR DEFAULT", R.drawable.f_katsu);
                intent.putExtra("TEKS DEFAULT", "Chicken Katsu merupakan hidangan khas Jepang berupa daging ayam yang dibalur tepung dan digoreng.");
                context.startActivity(intent);
            }
            if(dataItem.get(position).getName().equals("Chicken Curry")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR DEFAULT", R.drawable.f_curry);
                intent.putExtra("TEKS DEFAULT", "Chicken Curry terdiri dari nasi putih, ayam goreng tepung, disiram saus kari Jepang");
                context.startActivity(intent);
            }
            if(dataItem.get(position).getName().equals("Chicken Egg Roll")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR DEFAULT", R.drawable.f_eggroll);
                intent.putExtra("TEKS DEFAULT", "Chicken Egg Roll terbuat dari daging ayam giling kemudian dibungkus dengan telur dadar dan dimasak dengan metode deep frying oil. ");
                context.startActivity(intent);
            }
            if(dataItem.get(position).getName().equals("Shrimp Tempura")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR DEFAULT", R.drawable.f_tempura);
                intent.putExtra("TEKS DEFAULT", "Shrimp Tempura terbuat dari udang yang dibalut dengan tepung lalu digoreng.");
                context.startActivity(intent);
            }
            if(dataItem.get(position).getName().equals("Beef Teriyaki")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR DEFAULT", R.drawable.f_teriyaki);
                intent.putExtra("TEKS DEFAULT", "Beef Teriyaki terbuat dari daging sapi yang dipadukan dengan saus teriyaki dengan cita rasa asin dan manis.");
                context.startActivity(intent);
            }
            if(dataItem.get(position).getName().equals("Beef Yakiniku")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR DEFAULT", R.drawable.f_yakiniku);
                intent.putExtra("TEKS DEFAULT", "Beef Yakiniku terbuat dari daging sapi yang dipanggang seperti bistik dan barbeque.");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    void setFilter(ArrayList<ItemModel> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }

}
