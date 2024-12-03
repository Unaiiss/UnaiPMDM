package com.example.repasoconinazuma;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {

    private ArrayList<Personaje> personajes;

    // Constructor: recibe la lista de personajes
    public PersonajeAdapter(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    // ViewHolder para representar un elemento de la lista
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtNombre, txtApellido, txtPosicion;

        public ViewHolder(View itemView) {
            super(itemView);
            // Vinculamos los TextView del layout
            txtId = itemView.findViewById(R.id.tvId);
            txtNombre = itemView.findViewById(R.id.tvNombre);
            txtApellido = itemView.findViewById(R.id.tvApellido);
            txtPosicion = itemView.findViewById(R.id.tvPosicion);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout del item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personaje_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Obtenemos el personaje actual
        Personaje personaje = personajes.get(position);

        // Configuramos los datos en los TextView
        holder.txtId.setText(String.valueOf(personaje.getId()));
        holder.txtNombre.setText(personaje.getNombre());
        holder.txtApellido.setText(personaje.getApellido());
        holder.txtPosicion.setText(personaje.getPosicion());
    }

    @Override
    public int getItemCount() {
        // Número total de elementos
        return personajes.size();
    }
}
