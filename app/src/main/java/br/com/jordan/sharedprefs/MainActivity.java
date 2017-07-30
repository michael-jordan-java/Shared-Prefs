package br.com.jordan.sharedprefs;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNome;
    private Button btSalvar;
    private TextView tvNome;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.etNome);
        btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(this);
        tvNome = (TextView) findViewById(R.id.tvNome);
        sharedPreferences = getSharedPreferences("Nome", MODE_PRIVATE);
    }


    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!etNome.getText().toString().isEmpty()) {
            editor.putString("nome", etNome.getText().toString());
            editor.commit();
            tvNome.setText("Olá " + etNome.getText().toString());
        } else {
            Toast.makeText(this, "Campo vaziio", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!sharedPreferences.getString("nome", "").isEmpty()) {
            tvNome.setText("Olá " + sharedPreferences.getString("nome", ""));
        } else {
            tvNome.setText("");
        }

    }
}
