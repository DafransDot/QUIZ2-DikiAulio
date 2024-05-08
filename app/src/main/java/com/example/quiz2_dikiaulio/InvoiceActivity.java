package com.example.quiz2_dikiaulio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quiz2_dikiaulio.databinding.ActivityInvoiceBinding;

import java.text.DecimalFormat;

public class InvoiceActivity extends AppCompatActivity {
    private ActivityInvoiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityInvoiceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        String typePs = getIntent().getStringExtra("typePs");
        int hargaTypePs = getIntent().getIntExtra("PS",0);
        String makanan = getIntent().getStringExtra("Makanan");
        int hargaMakanan = getIntent().getIntExtra("makann",0);
        String waktu =  getIntent().getStringExtra("Waktu");
        double Total = getIntent().getDoubleExtra("total",0);

        binding.tvTypePs.setText(typePs);
        binding.tvPesananMakanan.setText(makanan);
        binding.hargaTypePs.setText(String.valueOf(hargaTypePs));
        binding.tvhargaPesanan.setText(String.valueOf(hargaMakanan));
        binding.tvWaktu.setText(waktu);
        binding.tvTotal.setText(String.valueOf(Total));


    }
}