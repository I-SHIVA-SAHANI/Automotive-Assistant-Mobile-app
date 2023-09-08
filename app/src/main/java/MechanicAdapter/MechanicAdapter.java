package MechanicAdapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.automotiveassistantfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MechanicAdapter extends FirebaseRecyclerAdapter<MechanicModel, MechanicAdapter.myviewholder> {


    public MechanicAdapter(@NonNull FirebaseRecyclerOptions<MechanicModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull MechanicModel model) {
        holder.address.setText(model.getAddress());
        holder.bavailability.setText(model.getAvailability());
        holder.bname.setText(model.getBusinessname());
        holder.bservices.setText(model.getServices());
        holder.city.setText(model.getCity());
        holder.mname.setText(model.getMechanicname());
        holder.phone.setText(model.getPhone());
        holder.pinCode.setText(model.getPinCode());
        holder.state.setText(model.getState());

        holder.call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String makePhone = model.getPhone();
                String phoneNumber = "tel:" +makePhone.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));

            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mechanic_card, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {
        public ImageButton call_button;
        TextView address, bavailability, bname, bservices, city, mname, phone, pinCode, state;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            address = itemView.findViewById(R.id.add1);
            bavailability = itemView.findViewById(R.id.avail1);
            bname = itemView.findViewById(R.id.bname1);
            bservices = itemView.findViewById(R.id.services1);
            city = itemView.findViewById(R.id.city1);
            mname = itemView.findViewById(R.id.mechanicName1);
            phone = itemView.findViewById(R.id.phone1);
            pinCode = itemView.findViewById(R.id.code1);
            state = itemView.findViewById(R.id.state1);
            call_button = itemView.findViewById(R.id.call_btn);
        }
    }
}
