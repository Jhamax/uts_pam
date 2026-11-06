package lat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        supportActionBar?.hide()

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val tvOrderMenuName = findViewById<TextView>(R.id.tvOrderMenuName)
        val tvOrderTotalPrice = findViewById<TextView>(R.id.tvOrderTotalPrice)
        val etAddress = findViewById<TextInputEditText>(R.id.etAddress)
        val etNotes = findViewById<TextInputEditText>(R.id.etNotes)
        val btnConfirmOrder = findViewById<MaterialButton>(R.id.btnConfirmOrder)

        val username = intent.getStringExtra("USER_NAME") ?: "Pelanggan"

        val itemsInCart = CartManager.cartItems

        if (itemsInCart.isNotEmpty()) {
            val orderSummary = StringBuilder()
            var totalPrice = 0

            for (item in itemsInCart) {
                orderSummary.append("- ${item.name}\n")

                val priceString = item.price.replace("[^0-9]".toRegex(), "")
                if (priceString.isNotEmpty()) {
                    totalPrice += priceString.toInt()
                }
            }

            tvOrderMenuName.text = orderSummary.toString().trim()
            val formattedPrice = String.format(java.util.Locale.US, "%,d", totalPrice).replace(',', '.')
            tvOrderTotalPrice.text = "Rp $formattedPrice"

        } else {
            tvOrderMenuName.text = "Keranjang Kosong"
            tvOrderTotalPrice.text = "Rp 0"
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnConfirmOrder.setOnClickListener {
            val address = etAddress.text.toString().trim()
            val notes = etNotes.text.toString().trim()

            if (CartManager.cartItems.isEmpty()) {
                Toast.makeText(this, "Keranjang masih kosong!", Toast.LENGTH_SHORT).show()
            } else if (address.isEmpty()) {
                Toast.makeText(this, "Alamat pengiriman harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val itemsSummary = tvOrderMenuName.text.toString()
                val totalPriceSummary = tvOrderTotalPrice.text.toString()

                val intent = Intent(this, ConfirmationActivity::class.java)
                intent.putExtra("EXTRA_ITEMS", itemsSummary)
                intent.putExtra("EXTRA_ADDRESS", address)
                intent.putExtra("EXTRA_NOTES", notes)
                intent.putExtra("EXTRA_TOTAL", totalPriceSummary)

                intent.putExtra("USER_NAME", username)

                startActivity(intent)

                CartManager.clearCart()
                finish()
            }
        }
    }
}