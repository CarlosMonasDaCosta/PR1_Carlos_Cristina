package com.example.pr1_carlos_cristina

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MenuPatinets : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var mDrawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    var toolbar: Toolbar? = null
    var toggle: ActionBarDrawerToggle? = null
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
        toggle = setUpDrawerToggle()
        mDrawerLayout?.let{
            it.addDrawerListener(toggle!!)
        }

        navigationView?.let {
            it.setNavigationItemSelectedListener(this)
        }

    }

    private fun setUpDrawerToggle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(
            this, mDrawerLayout,
            toolbar, R.string.drawer_open, R.string.drawer_close
        )
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle!!.onConfigurationChanged(newConfig)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}




