package pl.wsb.poznan.listazadan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Button btnTsk;
    private Button btsSett;

    private void initControls(){
        this.btnTsk = findViewById(R.id.list);
        this.btsSett = findViewById(R.id.help);
    }

    private void initListeners(){
        if (this.btnTsk  != null){
            this.btnTsk.setOnClickListener(view -> {
                Intent intent = new Intent(this, EditActivity.class);
                startActivity(intent);
                finish();
                return;
            });
        }
        if (this.btsSett != null){
            this.btsSett.setOnClickListener(view ->{
                Intent intent = new Intent(this, HelpActivity.class);
                startActivity(intent);
                finish();
                return;
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initListeners();
    }
}