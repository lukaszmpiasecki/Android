package pl.wsb.poznan.listazadan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;


import io.reactivex.schedulers.Schedulers;
import pl.wsb.poznan.listazadan.adapter.TasksAdapter;
import pl.wsb.poznan.listazadan.api.ApiUtils;
import pl.wsb.poznan.listazadan.model.Task;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    private FloatingActionButton btnAdd;
    private Button btnMenu;


    private void initControls() {
        this.btnAdd = findViewById(R.id.addTaskButton);
        this.btnMenu = findViewById(R.id.menu);
    }

    private void initListeners() {
        if (this.btnAdd != null) {
            this.btnAdd.setOnClickListener(view -> {
                Intent intent = new Intent(this, EditActivity.class);
                startActivity(intent);
                finish();
                return;
            });
        }
        if (this.btnMenu != null) {
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
        getTasksApiCall();
    }

    private void initRecyclerView(List<Task> tasks) {

        RecyclerView recyclerView = findViewById(R.id.rvLoggedInUsersList);
        if (recyclerView == null) {
            return;
        }
        if (tasks == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TasksAdapter tasksAdapter = new TasksAdapter(this, tasks);
        recyclerView.setAdapter(tasksAdapter);
    }

    private void getTasksApiCall() {
        ApiUtils.getAPIService().getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Response<List<Task>>>() {
                    @Override
                    public void onNext(Response<List<Task>> response) {
                        if (ApiUtils.getResponseStatusCode(response) == 200) { initRecyclerView(response.body());
                        }   //if
                    }
                    @Override
                    public void onError(Throwable ex) {
                        Log.e("API_CALL", ex.getMessage(), ex);
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
}