package com.example.nettournament_1dawproyectofinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nettournament_1dawproyectofinal.model.Torneo;
import java.util.List;

public class TorneoAdapter extends RecyclerView.Adapter<TorneoAdapter.TorneoViewHolder> {

    private List<Torneo> listaTorneos;
    private Context context;

    public TorneoAdapter(List<Torneo> listaTorneos, Context context) {
        this.listaTorneos = listaTorneos;
        this.context = context;
    }

    @NonNull
    @Override
    public TorneoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_torneo, parent, false);
        return new TorneoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TorneoViewHolder holder, int position) {
        Torneo torneo = listaTorneos.get(position);

        String fechaFormateada = limpiarFormatoFechaHora(torneo.getFecha_inicio());

        SharedPreferences prefs = context.getSharedPreferences("InscripcionesPrefs", Context.MODE_PRIVATE);
        boolean yaInscrito = prefs.getBoolean("inscrito_" + torneo.getNombre(), false);

        if (yaInscrito) {
            holder.tvNombre.setText(torneo.getNombre() + " (Inscrito)");
        } else {
            holder.tvNombre.setText(torneo.getNombre());
        }

        holder.tvDetalles.setText("Inicio: " + fechaFormateada);

        String colorHex = determinarColorPorFecha(fechaFormateada);
        holder.layoutInterno.setBackgroundColor(Color.parseColor(colorHex));

        holder.cardTorneo.setOnClickListener(v -> {
            Intent intent = new Intent(context, TorneoDetalleActivity.class);
            intent.putExtra("idTorneo", torneo.getIdTorneo());
            intent.putExtra("nombreTorneo", torneo.getNombre());
            intent.putExtra("fechaTorneo", "Inicio: " + fechaFormateada);
            if (colorHex.equals("#FF8A8A")) {
                intent.putExtra("estadoTorneo", "Cerrado");
            } else {
                intent.putExtra("estadoTorneo", "Abierto");
            }

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaTorneos != null ? listaTorneos.size() : 0;
    }

    public void actualizarLista(List<Torneo> nuevaLista) {
        this.listaTorneos = nuevaLista;
        notifyDataSetChanged();
    }

    private String limpiarFormatoFechaHora(String fechaRaw) {
        if (fechaRaw == null || fechaRaw.trim().isEmpty()) return "No disponible";
        try {
            if (fechaRaw.contains(".")) fechaRaw = fechaRaw.split("\\.")[0];
            if (fechaRaw.contains(" ")) {
                String[] partes = fechaRaw.split(" ");
                String fecha = partes[0];
                String horaCompleta = partes[1];
                if (horaCompleta.contains(":")) {
                    String[] subPartesHora = horaCompleta.split(":");
                    if (subPartesHora.length >= 2) return fecha + " " + subPartesHora[0] + ":" + subPartesHora[1];
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return fechaRaw;
    }

    private String determinarColorPorFecha(String fechaInicioTorneo) {
        if (fechaInicioTorneo == null || fechaInicioTorneo.trim().isEmpty() || fechaInicioTorneo.equals("Hoy")) return "#B2E9B3";
        try {
            java.text.SimpleDateFormat formatoCompleto = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault());
            java.util.Date fechaActual = new java.util.Date();
            java.util.Date fechaLimite;
            if (fechaInicioTorneo.contains(" ")) {
                fechaLimite = formatoCompleto.parse(fechaInicioTorneo);
            } else {
                java.text.SimpleDateFormat formatoSimple = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());
                fechaLimite = formatoSimple.parse(fechaInicioTorneo);
            }
            long diferenciaMilisegundos = fechaLimite.getTime() - fechaActual.getTime();
            long diferenciaHoras = diferenciaMilisegundos / (1000 * 60 * 60);

            if (diferenciaMilisegundos <= 0) return "#FF8A8A";
            else if (diferenciaHoras <= 2) return "#FBEC89";
            else return "#B2E9B3";
        } catch (Exception e) {
            return "#B2E9B3";
        }
    }

    static class TorneoViewHolder extends RecyclerView.ViewHolder {
        CardView cardTorneo;
        LinearLayout layoutInterno;
        TextView tvNombre, tvDetalles;

        public TorneoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTorneo = itemView.findViewById(R.id.cardTorneo);
            layoutInterno = itemView.findViewById(R.id.layoutInterno);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDetalles = itemView.findViewById(R.id.tvDetalles);
        }
    }
}