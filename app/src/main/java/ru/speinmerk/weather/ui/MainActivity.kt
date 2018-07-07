package ru.speinmerk.weather.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import ru.speinmerk.weather.BR
import ru.speinmerk.weather.R
import ru.speinmerk.weather.controller.MainViewModel
import ru.speinmerk.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.setVariable(BR.viewModel, viewModel)

        binding.appBar?.let { appBar ->
            setSupportActionBar(appBar.toolbar)
            val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, appBar.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            binding.drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
        }
        binding.navView.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            else -> super.onOptionsItemSelected(item)
//        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.nav_city_list -> startCityListFragment(CityListFragment())
//        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun startCityListFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }
}
