package com.junianto.uts13319.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.junianto.uts13319.DetailActivity;
import com.junianto.uts13319.R;
import com.junianto.uts13319.model.ModelMotor;

import java.util.ArrayList;

public class AdapterLinear extends RecyclerView.Adapter<AdapterLinear.viewHolder> {
    ArrayList<ModelMotor> modelMotorArrayList;
    Context context;

    public AdapterLinear(ArrayList<ModelMotor> modelMotorArrayList, Context context) {
        this.modelMotorArrayList = modelMotorArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterLinear.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_item_linear, parent, false);
        return new AdapterLinear.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLinear.viewHolder holder, int position) {
        holder.image_motor.setImageResource(modelMotorArrayList.get(position).getGambar());
        holder.kode_motor.setText(modelMotorArrayList.get(position).getKode());
        holder.nama_motor.setText(modelMotorArrayList.get(position).getNama());
        holder.satuan_motor.setText(modelMotorArrayList.get(position).getSatuan());
        holder.harga_motor.setText(String.format("Rp. %s", modelMotorArrayList.get(position).getHarga()));
        holder.jumlah_motor.setText(String.valueOf(modelMotorArrayList.get(position).getJumlah()));
        holder.item_motor.setOnClickListener(v -> {
            Toast.makeText(context, modelMotorArrayList.get(position).getNama(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("imageMotor", modelMotorArrayList.get(position).getGambar());
            intent.putExtra("kodeMotor", modelMotorArrayList.get(position).getKode());
            intent.putExtra("namaMotor", modelMotorArrayList.get(position).getNama());
            intent.putExtra("satuanMotor", modelMotorArrayList.get(position).getSatuan());
            intent.putExtra("hargaMotor", modelMotorArrayList.get(position).getHarga());
            intent.putExtra("jumlahMotor", modelMotorArrayList.get(position).getJumlah());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelMotorArrayList.size();
    }

    protected class viewHolder extends RecyclerView.ViewHolder {
        LinearLayout item_motor;
        ImageView image_motor;
        TextView kode_motor, nama_motor, satuan_motor, harga_motor, jumlah_motor;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            item_motor = itemView.findViewById(R.id.item_motor);
            image_motor = itemView.findViewById(R.id.iv_image_motor);
            kode_motor = itemView.findViewById(R.id.tv_kode_motor);
            nama_motor = itemView.findViewById(R.id.tv_nama_motor);
            satuan_motor = itemView.findViewById(R.id.tv_satuan_motor);
            harga_motor = itemView.findViewById(R.id.tv_harga_motor);
            jumlah_motor = itemView.findViewById(R.id.tv_jumlah_motor);
        }
    }
}
