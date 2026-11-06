package lat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        supportActionBar?.hide()

        val tvConfirmedItems = findViewById<TextView>(R.id.tvConfirmedItems)
        val tvConfirmedAddress = findViewById<TextView>(R.id.tvConfirmedAddress)
        val tvConfirmedNotes = findViewById<TextView>(R.id.tvConfirmedNotes)
        val tvNotesLabel = findViewById<TextView>(R.id.tvNotesLabel)
        val tvConfirmedTotal = findViewById<TextView>(R.id.tvConfirmedTotal)
        val btnBackToHome = findViewById<MaterialButton>(R.id.btnBackToHome)

        val items = intent.getStringExtra("EXTRA_ITEMS") ?: "-"
        val address = intent.getStringExtra("EXTRA_ADDRESS") ?: "-"
        val notes = intent.getStringExtra("EXTRA_NOTES") ?: ""
        val total = intent.getStringExtra("EXTRA_TOTAL") ?: "Rp 0"

        val username = intent.getStringExtra("USER_NAME") ?: "Pelanggan"

        tvConfirmedItems.text = items
        tvConfirmedAddress.text = address
        tvConfirmedTotal.text = total

        if (notes.isNotEmpty()) {
            tvConfirmedNotes.visibility = View.VISIBLE
            tvNotesLabel.visibility = View.VISIBLE
            tvConfirmedNotes.text = notes
        } else {
            tvConfirmedNotes.visibility = View.GONE
            tvNotesLabel.visibility = View.GONE
        }

        btnBackToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USER_NAME", username)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}