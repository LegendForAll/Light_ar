package com.example.hothaingoc.chemicallight;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class adapter_Element extends RecyclerView.Adapter<adapter_Element.ViewHolder>{

    ArrayList<data_Element> dataEle;
    Activity context;

    public adapter_Element(ArrayList<data_Element> dataEle, Activity context) {
        this.dataEle = dataEle;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_element,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.id_ele.setText(String.valueOf(dataEle.get(position).getId()));
        holder.img_ele.setImageResource(dataEle.get(position).getImg());
        holder.name_ele.setText(dataEle.get(position).getName());
        holder.symbol_ele.setText(dataEle.get(position).getSymbol());
        holder.atomic_mass_ele.setText(dataEle.get(position).getAtomic_mass());
        holder.group_ele.setText(dataEle.get(position).getGroup());
        holder.cycle_ele.setText(dataEle.get(position).getCycle());
        holder.oxi_ele.setText(dataEle.get(position).getOxi());

    }

    @Override
    public int getItemCount() {
        return dataEle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id_ele;
        ImageView img_ele;
        TextView name_ele;
        TextView symbol_ele;
        TextView atomic_mass_ele;
        TextView group_ele;
        TextView cycle_ele;
        TextView oxi_ele;

        public ViewHolder(View itemView) {
            super(itemView);

            id_ele = (TextView) itemView.findViewById(R.id.id);
            img_ele = (ImageView) itemView.findViewById(R.id.img_image);
            name_ele = (TextView) itemView.findViewById(R.id.txt_name);
            symbol_ele = (TextView) itemView.findViewById(R.id.txt_symbol);
            atomic_mass_ele = (TextView) itemView.findViewById(R.id.txt_atomicMass);
            group_ele = (TextView) itemView.findViewById(R.id.txt_Group);
            cycle_ele = (TextView) itemView.findViewById(R.id.txt_cycle);
            oxi_ele = (TextView) itemView.findViewById(R.id.txt_oxi);
        }
    }
}