package com.wagner.loch.vidadeestudante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Switch switchDormir;
    private Switch switchVidaSocial;
    private Switch switchBoasNotas;
    private TextView textViewMensagem;
    private float alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchDormir = (Switch) findViewById(R.id.switchDormir);
        switchVidaSocial = (Switch) findViewById(R.id.switchVidaSocial);
        switchBoasNotas = (Switch) findViewById(R.id.switchBoasNotas);
        textViewMensagem = (TextView) findViewById(R.id.textViewMensagem);
        alpha = (float) -0.3;

        switchDormir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adicionarDormir ();
                alpha+=0.1;
                textViewMensagem.setAlpha(alpha);
            }
        });

        switchVidaSocial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adicionarVidaSocial();
                alpha+=0.1;
                textViewMensagem.setAlpha(alpha);
            }
        });

        switchBoasNotas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adicionarBoasNotas ();
                alpha+=0.1;
                textViewMensagem.setAlpha(alpha);
            }
        });

    }

    private void adicionarBoasNotas () {
        if (switchBoasNotas.isChecked() && switchVidaSocial.isChecked()) {
            switchDormir.setChecked(false);
        }
        if (switchDormir.isChecked() && switchBoasNotas.isChecked()) {
            switchVidaSocial.setChecked(false);
        }
    }

    private void adicionarDormir () {
        if (switchBoasNotas.isChecked() && switchDormir.isChecked()) {
            switchVidaSocial.setChecked(false);
        }
        if (switchDormir.isChecked() && switchVidaSocial.isChecked()) {
            switchBoasNotas.setChecked(false);
        }
    }

    private void adicionarVidaSocial () {
        if (switchDormir.isChecked() && switchVidaSocial.isChecked()) {
            switchBoasNotas.setChecked(false);
        }
        if (switchBoasNotas.isChecked() && switchVidaSocial.isChecked()) {
            switchDormir.setChecked(false);
        }
    }
}
