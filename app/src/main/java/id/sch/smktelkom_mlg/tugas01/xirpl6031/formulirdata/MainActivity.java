package id.sch.smktelkom_mlg.tugas01.xirpl6031.formulirdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etAsal;
    Button bSend;
    TextView TvHasil;
    TextView TvAsal;
    RadioButton rpl, tkj;
    TextView jurus;
    TextView juru;
    CheckBox cbB, cbF, cbV;
    TextView eks;
    TextView akir;
    Spinner angk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        bSend = (Button) findViewById(R.id.buttonSend);
        TvHasil = (TextView) findViewById(R.id.textViewTv);
        TvAsal = (TextView) findViewById(R.id.textViewAsal);
        rpl = (RadioButton) findViewById(R.id.radioButtonrpl);
        tkj = (RadioButton) findViewById(R.id.radioButtontkj);
        juru = (TextView) findViewById(R.id.jurusan);
        jurus = (TextView) findViewById(R.id.textViewjuru);
        cbB = (CheckBox) findViewById(R.id.checkBoxBasket);
        cbF = (CheckBox) findViewById(R.id.checkBoxFutsal);
        cbV = (CheckBox) findViewById(R.id.checkBoxVoli);
        eks = (TextView) findViewById(R.id.textViewEkskul);
        akir = (TextView) findViewById(R.id.last);
        angk = (Spinner) findViewById(R.id.spinner);

        etNama.setText("Nama Lengkap");
        etAsal.setText("Asal Kota");
        bSend.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         doProcess();
                                         doClick();
                                         doPush();
                                         dolast();
                                         String name = etNama.getText().toString();
                                         String from = etAsal.getText().toString();
                                         TvHasil.setText("Nama : " + name);
                                         TvAsal.setText("Berumur : " + from);
                                     }
                                 }
        );


    }

    private void dolast() {

        akir.setText("Angkatan : " + angk.getSelectedItem().toString());

    }

    private void doPush() {
        String hasil = "Ekskul Anda :\n";
        int starten = hasil.length();
        if (cbB.isChecked()) hasil += cbB.getText() + "\n";
        if (cbF.isChecked()) hasil += cbF.getText() + "\n";
        if (cbV.isChecked()) hasil += cbV.getText() + "\n";

        if (hasil.length() == starten) hasil += "Tidak Mengikuti Ekskul";

        eks.setText(hasil);


    }

    private void doClick() {
        String jurusi = null;
        if (rpl.isChecked()) {
            jurusi = rpl.getText().toString();
        } else if (tkj.isChecked()) {
            jurusi = tkj.getText().toString();
        }
        if (jurusi == null) {
            jurus.setError("Apa Jurusan kamu?");
        } else {
            juru.setText("Mengambil Jurusan : " + jurusi);
        }
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etAsal.getText().toString());
            int usia = 2016 - tahun;
            TvHasil.setText("Nama : " + nama);
            TvAsal.setText("Berusia " + usia + " tahun ");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String asal = etAsal.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Siapa Nama Anda");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Terlalu Pendek !!!");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (asal.isEmpty()) {
            etAsal.setError("Dari Mana Asal Mu ?");
            valid = false;
        } else {
            etAsal.setError(null);
        }
        return valid;
    }

}