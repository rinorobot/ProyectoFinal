package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.proyectofinal.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var toolbar : Toolbar?=null






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar
        toolbar()




        configureTab()
        setupViewPager()









    }

    fun configureTab(){




       binding.tabLayout.apply {
           addTab(this.newTab())
           addTab(this.newTab())
           addTab(this.newTab())

           getTabAt(0)!!.setIcon(R.drawable.ic_quiz)
           getTabAt(1)!!.setIcon(R.drawable.ic_notification)
           getTabAt(2)!!.setIcon(R.drawable.ic_login)


           addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
               override fun onTabSelected(tab: TabLayout.Tab?) {
                   tab?.position?.let {
                       binding.tabsViewPager.currentItem = it
                   }
               }

               override fun onTabUnselected(tab: TabLayout.Tab?) {

               }

               override fun onTabReselected(tab: TabLayout.Tab?) {

               }

           })
       }


    }

    fun setupViewPager(){
        binding.tabsViewPager.apply {
            adapter = TabsAdapter(supportFragmentManager,binding.tabLayout.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        }
    }

    //Toolbar
    private fun toolbar() {
        toolbar = binding.toolbar
       // toolbar?.title = "PulsoApp"

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.manu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.settings ->{
                val intent = Intent(this,SettingsActivity::class.java)
                startActivity(intent)

                return true
            }
            else -> {return super.onOptionsItemSelected(item)}
        }

    }

}