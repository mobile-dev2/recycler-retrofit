package com.example.retrofitbedu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RcvAdapter extends RecyclerView.Adapter<RcvAdapter.UserVH> {

    List list;

    public RcvAdapter(List list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        holder.setDataItem((User) list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserVH extends RecyclerView.ViewHolder {

        TextView txtv_user;
        public UserVH(@NonNull View itemView) {
            super(itemView);

            txtv_user = itemView.findViewById(R.id.txtv_user);
        }

        public void setDataItem(User user){
            txtv_user.setText(
                    "id: " + user.id +"\n"
                    + "name: " + user.name + "\n"
                    + "email: " + user.email + "\n"
                    + "address: {" + "\n"
                    + "   street: " + user.address.street + "\n"
                    + "   suite: " + user.address.suite + "\n"
                    + "   city: " + user.address.city + "\n"
                    + "   zipcode: " + user.address.zipcode + "\n"
                    + "   geo: {" + "\n"
                    + "      lat: " + user.address.geo.lat + "\n"
                    + "      lng: " + user.address.geo.lng + "\n"
                    + "   }" + "\n"
                    + "}" + "\n\n"
            );
        }
    }
}
