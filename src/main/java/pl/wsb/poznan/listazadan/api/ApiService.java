package pl.wsb.poznan.listazadan.api;

import java.util.List;


import io.reactivex.Observable;
import pl.wsb.poznan.listazadan.model.Task;
import retrofit2.Response;
import retrofit2.http.GET;


public interface ApiService {

    @GET("/lukaszmpiasecki/fakeapi/tasks")
    Observable<Response<List<Task>>> getTasks();
}
