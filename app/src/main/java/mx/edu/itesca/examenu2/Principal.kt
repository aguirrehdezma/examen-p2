package mx.edu.itesca.examenu2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iv_header)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnDetalles: Button = findViewById(R.id.btn_detalles)
        val btnGlobos: Button = findViewById(R.id.btn_globos)
        val btnPeluches: Button = findViewById(R.id.btn_peluches)
        val btnRegalos: Button = findViewById(R.id.btn_regalos)
        val btnTazas: Button = findViewById(R.id.btn_tazas)

        btnDetalles.setOnClickListener {
            val intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipoProducto", "Detalles")
            startActivity(intent)
        }
        btnGlobos.setOnClickListener {
            val intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipoProducto", "Globos")
            startActivity(intent)
        }
        btnPeluches.setOnClickListener {
            val intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipoProducto", "Peluches")
            startActivity(intent)
        }
        btnRegalos.setOnClickListener {
            val intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipoProducto", "Regalos")
            startActivity(intent)
        }
        btnTazas.setOnClickListener {
            val intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipoProducto", "Tazas")
            startActivity(intent)
        }
    }
}