package lat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)

        val btnNavHome = findViewById<TextView>(R.id.btnNavHome)
        val btnNavCart = findViewById<TextView>(R.id.btnNavCart)
        val btnNavProfile = findViewById<TextView>(R.id.btnNavProfile)

        val username = intent.getStringExtra("USER_NAME") ?: "Pelanggan"
        tvGreeting.text = "Halo, $username!"

        val dummyList = listOf(
            MenuItem(1, "Kopi Susu Gula Aren", "Espresso, susu, gula aren asli", "Rp 22.000", R.drawable.palm_sugar),
            MenuItem(2, "Donut Cokelat", "Donat empuk, glaze cokelat", "Rp 12.000", R.drawable.donut),
            MenuItem(3, "Sourdough Loaf", "Roti fermentasi alami", "Rp 35.000", R.drawable.sourdough),
            MenuItem(4, "Cappuccino", "Espresso, foam susu", "Rp 25.000", R.drawable.cappuccino),
            MenuItem(5, "Matcha Latte", "Matcha Jepang, susu segar", "Rp 27.000", R.drawable.matcha)
        )

        rvMenu.layoutManager = LinearLayoutManager(this)

        rvMenu.adapter = MenuAdapter(dummyList) { selectedItem ->
            CartManager.cartItems.add(selectedItem)

            Toast.makeText(this, "${selectedItem.name} ditambahkan ke Order! Silahkan cek pada bagian Order.", Toast.LENGTH_SHORT).show()
        }

        btnNavHome.setOnClickListener {
        }

        btnNavCart.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("USER_NAME", username)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        btnNavProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_NAME", username)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}