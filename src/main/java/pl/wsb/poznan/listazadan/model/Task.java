package pl.wsb.poznan.listazadan.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Task {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("taskname")
    @Expose
    private String taskname;
    @SerializedName("taskdesc")
    @Expose
    private String taskdesc;
    @SerializedName("taskdate")
    @Expose
    private String taskdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

    public String getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(String taskdate) {
        this.taskdate = taskdate;
    }

}
