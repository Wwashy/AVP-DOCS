package ke.co.mcfish.itimetable.test4;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LViewHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public LViewHolder(TextView itemView) {
        super(itemView);

        this.tv = itemView;
    }
}
