package pl.wsb.poznan.listazadan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditActivity extends AppCompatActivity {

    private FloatingActionButton btnAdd;
    private Button btnMenu;


    private void initControls(){
        this.btnAdd = findViewById(R.id.addTaskButton);
        this.btnMenu = findViewById(R.id.menu);
    }

    private void initListeners(){
        if (this.btnAdd  != null){
            this.btnAdd.setOnClickListener(view -> {
                Intent intent = new Intent(this, EditActivity.class);
                startActivity(intent);
                finish();
                return;
            });
        }
        if (this.btnMenu  != null){
            this.btnMenu.setOnClickListener(view -> {
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
        setContentView(R.layout.activity_edit);
        initControls();
        initListeners();
    }
}