package lv.team10.lmg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import android.view.View
import android.widget.Button
import lv.team10.lmg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAppBar()
    }

    private fun initAppBar() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Add listener to navigation switch check
        navController.addOnDestinationChangedListener { _, _, _ ->
            val loginButton = findViewById<Button>(R.id.appbar_button_login)
            // Checking if current page is login page, then hidding login button in app bar
            if (navController.currentDestination?.id == R.id.loginFragment)
                loginButton.visibility = View.INVISIBLE
            else
                loginButton.visibility = View.VISIBLE
        }

        // Adding listener to appBar
        binding.appbarButtonLogin.setOnClickListener {
            if (navController.currentDestination?.id != R.id.loginFragment) {
                navController.navigate(R.id.action_FirstFragment_to_loginFragment)
            }
        }
    }
}