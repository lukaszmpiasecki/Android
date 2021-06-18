package pl.wsb.poznan.listazadan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button btnTsk;
    private Button btsSett;
    private FloatingActionButton btnAdd;

    private void initControls(){
        this.btnTsk = findViewById(R.id.list);
        this.btsSett = findViewById(R.id.settings);
        this.btnAdd = findViewById(R.id.addTaskButton);
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
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initListeners();
    }
}