package pl.wsb.poznan.listazadan.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pl.wsb.poznan.listazadan.R;
import pl.wsb.poznan.listazadan.model.Task;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private List<Task> data;
    private LayoutInflater inflater;

    public TasksAdapter(
            Context context,
            List<Task> data
    ) {
        this.inflater = LayoutInflater.from(context); this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { View view = this.inflater.inflate(R.layout.item_tasks_list, parent, false); return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { Task item = data.get(position);

        if (item == null) {
            return;
        }   //if
        holder.txtTasksListTaskId.setText(item.getId()); holder.txtTasksListTaskName.setText(item.getTaskname()); holder.txtTasksListTaskDesc.setText(item.getTaskdesc()); holder.txtTasksListTaskDate.setText(item.getTaskdate());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTasksListTaskId;
        TextView txtTasksListTaskName;
        TextView txtTasksListTaskDesc;
        TextView txtTasksListTaskDate;

        ViewHolder(View itemView) {
            super(itemView);
            this.txtTasksListTaskId = itemView.findViewById(R.id.txtTasksListTaskId);
            this.txtTasksListTaskName =
                    itemView.findViewById(R.id.txtTasksListTaskName);
            this.txtTasksListTaskDesc =
                    itemView.findViewById(R.id.txtTasksListTaskDesc);
            this.txtTasksListTaskDate =
                    itemView.findViewById(R.id.txtTasksListTaskDate);
        }
    }


    public Task getItem(int position) {
        return data.get(position);
    }
}
