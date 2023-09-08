package ElectricBunkDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.automotiveassistantfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ElectricBunkRecycler extends AppCompatActivity {
    RecyclerView RecV;
    ElectricAdapter EA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_bunk_recycler);
        RecV = findViewById(R.id.Recv);
        RecV.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<ElectricModel> options =
                new FirebaseRecyclerOptions.Builder<ElectricModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("ElectricBusiness"), ElectricModel.class)
                        .build();
        EA = new ElectricAdapter(options);
        RecV.setAdapter(EA);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EA.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EA.stopListening();
    }
}