package pl.wsb.poznan.listazadan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {

    private Button returnButton;

    private void initControls(){
        this.returnButton = findViewById(R.id.returnButton);
    }

    private void initListeners(){
        if (this.returnButton  != null){
            this.returnButton.setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        initControls();
        initListeners();
    }
}