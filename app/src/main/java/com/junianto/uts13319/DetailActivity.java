package com.junianto.uts13319;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView ivImageMotor;
    TextView tvKodeMotor, tvNamaMotor, tvSatuanMotor, tvHargaMotor, tvJumlahMotor, tvJumlahHarga;
    Button btnPlus, btnMinus, btnBayar;

    int tampungTotal=0;
    int totalHarga=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImageMotor = findViewById(R.id.iv_image_motor);
        tvKodeMotor = findViewById(R.id.tv_kode_motor);
        tvNamaMotor = findViewById(R.id.tv_nama_motor);
        tvSatuanMotor = findViewById(R.id.tv_satuan_motor);
        tvHargaMotor = findViewById(R.id.tv_harga_motor);
        tvJumlahMotor = findViewById(R.id.tv_jumlah_motor);
        tvJumlahHarga = findViewById(R.id.tv_jumlah_harga);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnBayar = findViewById(R.id.btn_beli);

        btnBayar.setOnClickListener(v -> {
            goToCetak();
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getStringExtra("namaMotor");
        setActionBarTitle(title);

        getExtra();

        btnPlus.setOnClickListener(v -> {
            addTotal();
        });

        btnMinus.setOnClickListener(v -> {
            minusTotal();
        });
    }

    private void goToCetak() {
        Intent intent = new Intent(this, CetakActivity.class);
        intent.putExtra("namaMotor", getIntent().getStringExtra("namaMotor"));
        intent.putExtra("hargaMotor", getIntent().getIntExtra("hargaMotor", 0));
        intent.putExtra("jumlahMotor", getIntent().getIntExtra("jumlahMotor", 0));
        intent.putExtra("totalHarga", totalHarga * tampungTotal);

        startActivity(intent);
    }

    private void getExtra() {
        String kodeMotor = getIntent().getStringExtra("kodeMotor");
        String namaMotor = getIntent().getStringExtra("namaMotor");
        String satuanMotor = getIntent().getStringExtra("satuanMotor");
        int hargaMotor = getIntent().getIntExtra("hargaMotor", 0);
        int jumlahMotor = getIntent().getIntExtra("jumlahMotor", 0);
        int gambarMotor = getIntent().getIntExtra("imageMotor", R.drawable.a01);

        tampungTotal=jumlahMotor;
        totalHarga=hargaMotor;

        setData(kodeMotor, namaMotor, satuanMotor, hargaMotor, jumlahMotor, gambarMotor);
    }

    private void setData(String kodeMotor, String namaMotor, String satuanMotor, int hargaMotor, int jumlahMotor, int gambarMotor) {
        tvKodeMotor.setText(kodeMotor);
        tvNamaMotor.setText(namaMotor);
        tvSatuanMotor.setText(satuanMotor);
        tvHargaMotor.setText(String.format("Rp. %s", hargaMotor));
        tvJumlahMotor.setText(String.valueOf(jumlahMotor));
        ivImageMotor.setImageResource(gambarMotor);

        tvJumlahHarga.setText(String.format("Rp. %s", hargaMotor));
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void addTotal() {
        tampungTotal=tampungTotal+1;

        tvJumlahMotor.setText(String.valueOf(tampungTotal));
        tvJumlahHarga.setText(String.format("Rp. %s", calcTotalPrice()));
    }

    private void minusTotal() {
        if(tampungTotal!=0) {
            tampungTotal=tampungTotal-1;
        }

        tvJumlahMotor.setText(String.valueOf(tampungTotal));
        tvJumlahHarga.setText(String.format("Rp. %s", calcTotalPrice()));
    }

    private int calcTotalPrice() {
        return totalHarga * tampungTotal;
    }
}