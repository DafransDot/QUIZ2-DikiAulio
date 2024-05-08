package com.example.quiz2_dikiaulio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quiz2_dikiaulio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int Ps3 = 5000;
    int Ps4 = 8000;
    int Ps5 = 10000;
    int Psvr = 20000;
    int Indomie = 7000;
    int Mieayam = 10000;
    int somay = 5000;

    int typePs;
    int PesanMakanan;
    int Waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPesan.setOnClickListener(view ->{
            if ( view.getId() == R.id.btnPesan){
                Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
                if (binding.rbPs3.isChecked()){
                    typePs = Ps3;
                    String namaPS = "PS3";
                    intent.putExtra("typePs",namaPS );
                } else if (binding.rbPs4.isChecked()) {
                    typePs = Ps4;
                    String namaPS = "PS4";
                    intent.putExtra("typePs",namaPS );
                } else if (binding.rbPs5.isChecked()) {
                    typePs = Ps5;
                    String namaPS = "PS5";
                    intent.putExtra("typePs",namaPS );
                } else if (binding.rbPsvr.isChecked()) {
                    typePs = Psvr;
                    String namaPS = "PSVr";
                    intent.putExtra("typePs",namaPS );
                }else {
                    typePs = 0;
                    String namaPS = "tidak ada";
                    intent.putExtra("typePs",namaPS );
                }

                if (binding.rbIndomie.isChecked()){
                    PesanMakanan = Indomie;
                    String namaMakanan = "Indomie";
                    intent.putExtra("Makanan",namaMakanan );
                } else if (binding.rbMieayam.isChecked()) {
                    PesanMakanan = Mieayam;
                    String namaMakanan = "Mie Ayam";
                    intent.putExtra("Makanan",namaMakanan );

                } else if (binding.rbSomay.isChecked()) {
                    PesanMakanan = somay;
                    String namaMakanan = "Somay";
                    intent.putExtra("Makanan",namaMakanan );
                }else {
                    PesanMakanan = 0;
                    String namaMakanan = "tidak ada Pesanan";
                    intent.putExtra("Makanan",namaMakanan );
                }

                String strwaktu = binding.etWaktu.getText().toString();
                if(strwaktu.isEmpty()){
                    Toast.makeText(this, "Isi waktu", Toast.LENGTH_SHORT).show();
                }else {
                    Waktu = Integer.parseInt(binding.etWaktu.getText().toString());
                    String waktu = binding.etWaktu.getText().toString();
                    double total = (typePs * Waktu) + PesanMakanan;
                    intent.putExtra("total", total);
                    intent.putExtra("Waktu", waktu);
                    intent.putExtra("PS", typePs);
                    intent.putExtra("makann", PesanMakanan);
                    startActivity(intent);

                }

            }
        });


    }
}