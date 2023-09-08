package BunkRecyclerDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.automotiveassistantfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BunkRecycler extends AppCompatActivity {

    RecyclerView BunkRev;
    BunkAdapter bunkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunk_recycler);
        BunkRev = (RecyclerView) findViewById(R.id.bunkrecview);
        BunkRev.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<BunkModel> options =
                new FirebaseRecyclerOptions.Builder<BunkModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("BunkBusiness"), BunkModel.class)
                        .build();

        bunkAdapter = new BunkAdapter(options);
        BunkRev.setAdapter(bunkAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        bunkAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bunkAdapter.stopListening();
    }
}