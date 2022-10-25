package com.junianto.uts13319;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.junianto.uts13319.adapter.AdapterGrid;
import com.junianto.uts13319.adapter.AdapterLinear;
import com.junianto.uts13319.model.ModelMotor;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<ModelMotor> modelMotorArrayList = new ArrayList<>();
    RecyclerView rvMotor;

    String kodeMotor[] = {
            "A01",
            "A02",
            "A03",
            "A04",
            "A05",
            "A06",
            "A07",
            "A08",
            "A09",
            "A10",
    };

    String namaMotor[] = {
            "Honda ADV 160",
            "Honda Beat",
            "Honda PCX",
            "Yamaha Nmax",
            "Yamaha YZF R15",
            "Honda Vario 125",
            "Kawasaki KLX 150",
            "Yamaha XSR 155",
            "KTM Duke 200",
            "KTM RC 200"
    };

    String satuanMotor[] = {
            "Unit",
            "Unit",
            "Unit",
            "Unit",
            "Unit",
            "Unit",
            "Unit",
            "Unit",
            "Unit",
            "Unit"
    };

    int hargaMotor[] = {
            36000000,
            16665000,
            29845000,
            30200000,
            36080000,
            21500000,
            31200000,
            36900000,
            52000000,
            43500000
    };

    int jumlahMotor[] = {
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1
    };

    int gambar[] = {
            R.drawable.a01,
            R.drawable.a02,
            R.drawable.a03,
            R.drawable.a04,
            R.drawable.a05,
            R.drawable.a06,
            R.drawable.a07,
            R.drawable.a08,
            R.drawable.a09,
            R.drawable.a10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvMotor = findViewById(R.id.rv_motor);

        baca_data_motor();

        showRecyclerList();
    }

    private void baca_data_motor() {
        for(int i=0; i<namaMotor.length; i++) {
            modelMotorArrayList.add(new ModelMotor(
                    kodeMotor[i],
                    namaMotor[i],
                    satuanMotor[i],
                    hargaMotor[i],
                    jumlahMotor[i],
                    gambar[i]
            ));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            showRecyclerList();
        } else {
            showRecyclerGrid();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerGrid() {
        baca_data_motor();

        AdapterGrid menuAdapterGrid = new AdapterGrid(modelMotorArrayList, this);
        rvMotor.setAdapter(menuAdapterGrid);
        rvMotor.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void showRecyclerList() {
        baca_data_motor();

        AdapterLinear menuAdapterLinear = new AdapterLinear(modelMotorArrayList, this);
        rvMotor.setAdapter(menuAdapterLinear);
        rvMotor.setLayoutManager(new LinearLayoutManager(this));
    }
}