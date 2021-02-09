package socket.client.chatclient_sockets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.jar.Attributes;

import socket.client.chatclient_sockets.data.Diligencia;
import socket.client.chatclient_sockets.listeners.StartListener;
import socket.client.chatclient_sockets.view.NameViewModel;

public class NameActivity extends AppCompatActivity implements StartListener {

    private EditText etName;
    private ProgressBar progressBar;
    private NameViewModel viewModel;
    private Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        init();
    }

    private void init() {
        viewModel = new NameViewModel(getApplicationContext(), this);
        etName = findViewById(R.id.etName);
        progressBar = findViewById(R.id.progressBar);
        btSend = findViewById(R.id.btSendName);
        initEvents();
    }

    private void initEvents() {
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.sendSolicitud(etName.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                etName.setVisibility(View.GONE);
                btSend.setVisibility(View.GONE);
            }
        });
/*
        viewModel.getDiligencia().observe(this, new Observer<Diligencia>() {
            @Override
            public void onChanged(Diligencia diligencia) {
                if (diligencia.isAprovada()){
                    startActivity(new Intent(NameActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),
                            diligencia.getMotivo(), Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    etName.setVisibility(View.VISIBLE);
                    btSend.setVisibility(View.VISIBLE);
                }
            }
        });*/
    }

    @Override
    public void isStart(boolean start) {
        Log.d("DEPURACION", "isStart()");
        if (start){
            progressBar.setVisibility(View.GONE);
            etName.setVisibility(View.VISIBLE);
            btSend.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(getApplicationContext(),
                    "ES FALSE", Toast.LENGTH_LONG).show();
        }
    }
}