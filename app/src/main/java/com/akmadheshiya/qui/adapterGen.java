package com.akmadheshiya.qui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class adapterGen extends RecyclerView.Adapter<adapterGen.ViewHolder> {
    Context context;
    List<ticket>mlist1;
    public adapterGen(Context context, List<ticket> mlist1) {
        this.context = context;
        this.mlist1 = mlist1;
    }


    @NonNull
    @NotNull
    @Override
    public adapterGen.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.showtickets,parent,false);

        return new adapterGen.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull adapterGen.ViewHolder holder, int position) {
        ticket tick=mlist1.get(position);
        holder.mname.setText("Name - "+tick.getName());
        holder.mtcknum.setText("Ticket No -"+tick.getTcno());
        holder.mseat.setText("Seat No - "+tick.getStno());
        holder.mclass.setText("Class - "+" General");
    }

    @Override
    public int getItemCount() {
        return mlist1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mname,mtcknum,mseat,mclass;
        ImageView mdelete;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mname=itemView.findViewById(R.id.namebook);
            mclass=itemView.findViewById(R.id.clas);
            mseat=itemView.findViewById(R.id.seatnum);
            mtcknum=itemView.findViewById(R.id.ticknum);
            mdelete=itemView.findViewById(R.id.delete);
            mdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
