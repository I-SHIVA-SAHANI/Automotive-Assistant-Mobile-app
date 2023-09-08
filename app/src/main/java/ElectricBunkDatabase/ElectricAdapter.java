package ElectricBunkDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.automotiveassistantfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ElectricAdapter extends FirebaseRecyclerAdapter<ElectricModel, ElectricAdapter.ELectricViewHolder> {


    public ElectricAdapter(@NonNull FirebaseRecyclerOptions<ElectricModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ELectricViewHolder holder, int position, @NonNull ElectricModel model) {
        holder.ebname.setText(model.getElbname());
        holder.eavailability.setText(model.getElavailability());
        holder.eaddress.setText(model.getEladdress());
        holder.estate.setText(model.getElstate());
        holder.ecity.setText(model.getElcity());
        holder.epin.setText(model.getElpin());
    }

    @NonNull
    @Override
    public ELectricViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.electric_card, parent, false);
        return new ELectricViewHolder(v);

    }

    class ELectricViewHolder extends RecyclerView.ViewHolder {

        TextView ebname, eavailability, eaddress, estate, ecity, epin;

        public ELectricViewHolder(@NonNull View itemView) {
            super(itemView);

            ebname = itemView.findViewById(R.id.elbunkname1);
            eavailability = itemView.findViewById(R.id.elbunkavail1);
            eaddress = itemView.findViewById(R.id.elbunkadd1);
            estate = itemView.findViewById(R.id.elbunkstate1);
            ecity = itemView.findViewById(R.id.elbunkcity1);
            epin = itemView.findViewById(R.id.elbunkcode1);

        }
    }
}
