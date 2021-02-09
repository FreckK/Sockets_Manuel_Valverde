package socket.client.chatclient_sockets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import socket.client.chatclient_sockets.data.Message;
import socket.client.chatclient_sockets.listeners.ListeningListener;
import socket.client.chatclient_sockets.view.MainViewModel;

public class MainActivity extends AppCompatActivity implements ListeningListener {

    private EditText etMessage;
    private Button btSend, btClose;
    private TextView tvResponse;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        this.viewModel = new MainViewModel(this.getApplicationContext(), this);

        this.etMessage = findViewById(R.id.etMessage);
        this.btSend = findViewById(R.id.btSend);
        this.tvResponse = findViewById(R.id.tvResponse);
        this.btClose = findViewById(R.id.btClose);

        initEvents();
    }

    private void initEvents() {
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message(1, 2, etMessage.getText().toString(), "19:00");
                viewModel.sendMessage(message);
                etMessage.setText("");
            }
        });

        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.closeConnection();
            }
        });

        /*
        if (viewModel.getLiveMessage() != null){
            viewModel.getLiveMessage().observe(this, new Observer<Message>() {
                @Override
                public void onChanged(Message message) {
                    tvResponse.setText(message.getMessage());
                }
            });
        }*/

    }

    @Override
    public void listening(Message response) {
        String oldText = tvResponse.getText().toString();
        tvResponse.setText(response.getMessage());
        Log.d("pollometro", response.getMessage());
    }


}