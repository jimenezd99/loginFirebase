package equipo.tres.lexi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MisCursosActivity : AppCompatActivity() {

    var adapter: CursoAdapter? = null
    var cursos = ArrayList<MiCurso>()


    private val nav = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_inicio -> {
                val intent = Intent(this@MisCursosActivity, HomeActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cursos -> {
                val intent = Intent(this@MisCursosActivity, MisCursosActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_perfil -> {
                val intent = Intent(this@MisCursosActivity, PerfilActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_cursos)
        var listView: ListView = findViewById(R.id.listView) as ListView
        val btn_back = findViewById(R.id.btn_back) as Button
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(nav)





        cargarCursos()

        adapter = CursoAdapter(this, cursos)
        listView.adapter = adapter

        btn_back.setOnClickListener {
            super.onBackPressed()

        }


    }

    fun cargarCursos(){
        cursos.add(MiCurso(R.drawable.inglaterra, "Nivel 10","Ingl??s", "Progreso: 58%"))
        cursos.add(MiCurso(R.drawable.francia, "Nivel 1","Franc??s", "Progreso: 10%"))
    }
}