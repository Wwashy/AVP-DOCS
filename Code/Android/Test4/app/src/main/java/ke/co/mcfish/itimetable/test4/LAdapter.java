package ke.co.mcfish.itimetable.test4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class LAdapter extends RecyclerView.Adapter<LViewHolder> {

    private String[] data;

    public LAdapter(String[] data){
        this.data = data;
    }

    @NonNull
    @Override
    public LViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        return new LViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LViewHolder holder, int position) {
        holder.tv.setText(this.data[position]);
    }

    @Override
    public int getItemCount() {
        return this.data == null ?
                0 :
                    this.data.length;
    }

}