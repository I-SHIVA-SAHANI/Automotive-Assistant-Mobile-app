package MechanicAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.automotiveassistantfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MechanicRecylcer extends AppCompatActivity {
    RecyclerView rv;
    MechanicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_recylcer);


        rv = (RecyclerView) findViewById(R.id.recview);
        rv.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<MechanicModel> options =
                new FirebaseRecyclerOptions.Builder<MechanicModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("GarageBusiness"), MechanicModel.class)
                        .build();

        adapter = new MechanicAdapter(options);
        rv.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}