package com.junianto.uts13319;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CetakActivity extends AppCompatActivity {

    TextView namaMotor, hargaMotor, jumlahMotor, totalHarga, ppn, bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak);

        namaMotor = findViewById(R.id.tv_nama_motor);
        hargaMotor = findViewById(R.id.tv_harga_motor);
        jumlahMotor = findViewById(R.id.tv_jumlah_motor);
        totalHarga = findViewById(R.id.tv_total_harga);
        ppn = findViewById(R.id.tv_ppn);
        bayar = findViewById(R.id.tv_bayar);

        setData();
    }

    private void setData() {
        int tampungTotalHarga = getIntent().getIntExtra("totalHarga", 0);
        int tampungPPN = getIntent().getIntExtra("totalHarga", 0) * 10/100;

        namaMotor.setText(getIntent().getStringExtra("namaMotor"));
        hargaMotor.setText(String.format("Rp. %s", getIntent().getIntExtra("hargaMotor", 0)));
        jumlahMotor.setText(String.format("%s Unit", getIntent().getIntExtra("jumlahMotor", 0)));
        totalHarga.setText(String.format("Rp. %s", tampungTotalHarga));
        ppn.setText(String.format("Rp. %s", tampungPPN));
        bayar.setText(String.format("Rp. %s", tampungTotalHarga + tampungPPN));
    }
}