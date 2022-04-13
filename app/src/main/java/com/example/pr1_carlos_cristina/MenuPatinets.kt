package com.example.pr1_carlos_cristina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MenuPatinets : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var mDrawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_patinets)


        //UI
        mDrawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)
        supportFragmentManager.beginTransaction().add(R.id.content, Patinets_disponibles()).commit()
        title = "Available scooters"


        //Settings
        setSupportActionBar(toolbar)
        navigationView?.let {
            it.setNavigationItemSelectedListener(this)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectItemNav(item)
        return true
    }

    private fun selectItemNav(item: MenuItem) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        when (item.itemId) {
            R.id.nav_pat_disp -> ft.replace(R.id.content, Patinets_disponibles()).commit()
            R.id.nav_historial -> ft.replace(R.id.content, FragmentHistorial()).commit()
            R.id.nav_perfil -> ft.replace(R.id.content, fragmentPerfil()).commit()
            R.id.nav_preferencies -> ft.replace(R.id.content, fragmentPreferencies()).commit()
        }
        title = item.title
        mDrawerLayout!!.closeDrawers()
    }
}




