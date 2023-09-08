package BunkRecyclerDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.automotiveassistantfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class BunkAdapter extends FirebaseRecyclerAdapter<BunkModel, BunkAdapter.bunkviewholder> {



    public BunkAdapter(@NonNull FirebaseRecyclerOptions<BunkModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull bunkviewholder holder, int position, @NonNull final BunkModel model) {

        holder.bunkname.setText(model.getBunkname());
        holder.bunkavailability.setText(model.getBunkavailability());
        holder.bunkstate.setText(model.getBunkstate());
        holder.bunkcity.setText(model.getBunkcity());
        holder.bunkaddress.setText(model.getBunkaddress());
        holder.bunkpinCode.setText(model.getBunkpinCode());
        holder.bunkphone.setText(model.getBunkphone());
        holder.bunklandmark.setText(model.getBunklandmark());





    }

    @NonNull
    @Override
    public bunkviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bunk_card, parent, false);
        return new bunkviewholder(v);
    }

    public class bunkviewholder extends RecyclerView.ViewHolder {
        TextView bunkname, bunkavailability, bunkstate, bunkcity, bunkaddress, bunkpinCode, bunkphone, bunklandmark;
        public bunkviewholder(@NonNull View itemView) {
            super(itemView);

            bunkname = itemView.findViewById(R.id.bunkname1);
            bunkavailability = itemView.findViewById(R.id.bunkavail1);
            bunkstate = itemView.findViewById(R.id.bunkstate1);
            bunkcity = itemView.findViewById(R.id.bunkcity1);
            bunkaddress = itemView.findViewById(R.id.bunkadd1);
            bunkpinCode = itemView.findViewById(R.id.bunkcode1);
            bunkphone = itemView.findViewById(R.id.bunkphone1);
            bunklandmark = itemView.findViewById(R.id.bunklandmark1);



        }
    }
}
