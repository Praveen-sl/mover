package com.example.login_design;

import static androidx.core.content.ContextCompat.startActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Getter_Setter> Getter_SetterArraylist;

    public CustomAdapter(ArrayList<Getter_Setter> Getter_SetterArraylist) {this.Getter_SetterArraylist = Getter_SetterArraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        Getter_Setter data = Getter_SetterArraylist.get(position);
        holder.Image.setImageResource(data.getImage());
        holder.Name.setText(data.getName());
        holder.Capacity.setText(data.getCapacity());
        holder.Location.setText(data.getLocation());
        holder.button.setText(data.getButton());
    }

    @Override
    public int getItemCount() {
        return Getter_SetterArraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView Image;
        TextView Name,Capacity,Location,button;
        private final Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Image = (ImageView) itemView.findViewById(R.id.Image);
            Name = (TextView) itemView.findViewById(R.id.Name);
            Capacity = (TextView) itemView.findViewById(R.id.Capacity);
            Location = (TextView) itemView.findViewById(R.id.Location);
            button = (TextView) itemView.findViewById(R.id.button);
            context = itemView.getContext();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final  Intent intent;
                    String number  = button.getText().toString();
                    Toast.makeText(view.getContext(), "Number is"+number, Toast.LENGTH_SHORT).show();

                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" +number));
                    context.startActivity(intent);
                }
            });

        }
    }
}
