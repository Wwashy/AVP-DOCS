package ke.co.mcfish.itimetable.test2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mRecycleView = (RecyclerView) findViewById(R.id.mRecycleView);
        this.mRecycleView.setHasFixedSize(true);

        this.mLayout = new LinearLayoutManager(this);
        this.mRecycleView.setLayoutManager(this.mLayout);

        this.mAdapter = new RecyclerView.Adapter() {

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        };

        this.mRecycleView.setAdapter(this.mAdapter);
    }
}
