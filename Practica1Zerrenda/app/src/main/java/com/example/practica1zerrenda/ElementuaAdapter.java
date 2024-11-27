package com.example.practica1zerrenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ElementuaAdapter extends RecyclerView.Adapter<ElementuaAdapter.ElementuaViewHolder> {

    private final ArrayList<Elementua> elementuakList; // Erakutsi beharreko elementuen zerrenda

    // Adaptadorearen eraikitzailea edo constructorea
    public ElementuaAdapter(ArrayList<Elementua> elementuakList) {
        this.elementuakList = elementuakList;
    }

    public static class ElementuaViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtIzena, txtDeskribapena;

        public ElementuaViewHolder(View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.etId); // Layout-arekin lotu
            txtIzena = itemView.findViewById(R.id.etIzena);
            txtDeskribapena = itemView.findViewById(R.id.etDeskribapena);
        }
    }

    // RecyclerView-ren metodoa: Zerrendako elementu bakoitzeko ViewHolder bat sortzen du (gorde edo birziklatu)
    // datu barik!
    @Override
    public ElementuaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Elementu bakoitzaren diseinua inflatu
        // LayoutInflater klasea: XML fitxategia (elementua_item.xml) View objetu batean bilakatu edo inflatu.
        // View objetu bakoitza, RecyclerView-ko errenkada bakoitzean bistaratzen da.
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elementua_item, parent, false);
        return new ElementuaViewHolder(itemView);
    }

    // RecyclerView-ren metodoa: Datuak ViewHolder-retan (kontenedore edo edukitzaile) kargatu.
    @Override
    public void onBindViewHolder(ElementuaViewHolder holder, int position) {
        // Uneko elementua eskuratu
        Elementua currentElementua = elementuakList.get(position);

        // Balioak ezarri
        holder.txtId.setText(String.valueOf(currentElementua.getId())); // ID erakutsi
        holder.txtIzena.setText(currentElementua.getIzena()); // Izena erakutsi
        holder.txtDeskribapena.setText(currentElementua.getDeskribapena()); // Deskribapena erakutsi
    }

    @Override
    public int getItemCount() {
        // Zerrendaren tamaina
        return elementuakList.size();
    }
}