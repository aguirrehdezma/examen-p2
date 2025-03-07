package mx.edu.itesca.examenu2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Regalos : AppCompatActivity() {
    var regalos: ArrayList<Detalles> = ArrayList<Detalles>()
    lateinit var tvDetalles: TextView
    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_regalos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvDetalles = findViewById(R.id.tv_detalles)
        gridView = findViewById(R.id.gv_detalles)

        var opcion: String? = intent.getStringExtra("tipoProducto")
        agregarRegalos(opcion)

        var adaptador = AdaptadorRegalos(this, regalos)
        gridView.adapter = adaptador
    }

    fun agregarRegalos(option: String?) {
        when (option) {
            "Detalles" -> {
                tvDetalles.setText("Detalles")
                regalos.add(Detalles(R.drawable.cumplebotanas, "$280"))
                regalos.add(Detalles(R.drawable.cumplecheve, "$320"))
                regalos.add(Detalles(R.drawable.cumpleescolar, "$330"))
                regalos.add(Detalles(R.drawable.cumplepaletas, "$190"))
                regalos.add(Detalles(R.drawable.cumplesnack, "$150"))
                regalos.add(Detalles(R.drawable.cumplevinos, "$370"))
            }
            "Globos" -> {
                tvDetalles.setText("Globos")
                regalos.add(Detalles(R.drawable.globoamor, "$240"))
                regalos.add(Detalles(R.drawable.globocumple, "$820"))
                regalos.add(Detalles(R.drawable.globofestejo, "$260"))
                regalos.add(Detalles(R.drawable.globonum, "$760"))
                regalos.add(Detalles(R.drawable.globoregalo, "$450"))
                regalos.add(Detalles(R.drawable.globos, "$240"))
            }
            "Peluches" -> {
                tvDetalles.setText("Peluches")
                regalos.add(Detalles(R.drawable.peluchemario, "$320"))
                regalos.add(Detalles(R.drawable.pelucheminecraft, "$320"))
                regalos.add(Detalles(R.drawable.peluchepeppa, "$290"))
                regalos.add(Detalles(R.drawable.peluches, "$"))
                regalos.add(Detalles(R.drawable.peluchesony, "$330"))
                regalos.add(Detalles(R.drawable.peluchestich, "$280"))
                regalos.add(Detalles(R.drawable.peluchevarios, "$195"))
            }
            "Regalos" -> {
                tvDetalles.setText("Regalos")
                regalos.add(Detalles(R.drawable.regaloazul, "$80"))
                regalos.add(Detalles(R.drawable.regalobebe, "$290"))
                regalos.add(Detalles(R.drawable.regalocajas, "$140"))
                regalos.add(Detalles(R.drawable.regalocolores, "$85"))
                regalos.add(Detalles(R.drawable.regalos, "$"))
                regalos.add(Detalles(R.drawable.regalovarios, "$75"))
            }
            "Tazas" -> {
                tvDetalles.setText("Tazas")
                regalos.add(Detalles(R.drawable.tazaabuela, "$120"))
                regalos.add(Detalles(R.drawable.tazalove, "$120"))
                regalos.add(Detalles(R.drawable.tazaquiero, "$260"))
                regalos.add(Detalles(R.drawable.tazas, "280"))
            }
        }
    }
}

private class AdaptadorRegalos : BaseAdapter {
    var regalos = ArrayList<Detalles>()
    var contexto: Context? = null

    constructor(contexto: Context, regalos: ArrayList<Detalles>) {
        this.regalos = regalos
        this.contexto = contexto
    }

    override fun getCount(): Int {
        return regalos.size
    }

    override fun getItem(position: Int): Any {
        return regalos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var regalo = regalos[position]
        var inflador = LayoutInflater.from(contexto)
        var vista = inflador.inflate(R.layout.activity_detalle_regalos, null)

        var imagen = vista.findViewById(R.id.iv_regalo_imagen) as ImageView
        var precio = vista.findViewById(R.id.tv_regalo_precio) as TextView

        imagen.setImageResource(regalo.image)
        precio.setText(regalo.precio)

        vista.setOnClickListener {
            val intent: Intent = Intent(contexto, DetalleRegalos::class.java)
            val bundle = Bundle()
            bundle.putInt("image", regalo.image)
            bundle.putString("precio", regalo.precio)
            intent.putExtras(bundle)
            contexto?.startActivity(intent)
        }

        return vista
    }
}