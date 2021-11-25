package com.akmadheshiya.qui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class adapterVip extends RecyclerView.Adapter<adapterVip.ViewHolder> {
    Context context;
    List<ticket>mlist;

    public adapterVip(Context context, List<ticket> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @NotNull
    @Override
    public adapterVip.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
  View view = LayoutInflater.from(context).inflate(R.layout.showtickets,parent,false);
        return new adapterVip.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull adapterVip.ViewHolder holder, int position) {
        ticket tick=mlist.get(position);
        holder.mname.setText("Name - "+tick.getName());
        holder.mtcknum.setText("Ticket No -"+tick.getTcno());
        holder.mseat.setText("Seat No - "+tick.getStno());
        holder.mclass.setText("Class - "+tick.getClas());
        holder.mdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,uid.class);
                intent.putExtra("uid",tick.getUid());
                intent.putExtra("clas",tick.getClas());
                intent.putExtra("tickno",tick.getTcno());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
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



        }
    }
}
