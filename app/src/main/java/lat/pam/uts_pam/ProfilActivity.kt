package lat.pam.uts_pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar?.hide()

        val tvAvatarInitial = findViewById<TextView>(R.id.tvAvatarInitial)
        val etProfileName = findViewById<TextInputEditText>(R.id.etProfileName)
        val btnSaveProfile = findViewById<Button>(R.id.btnSaveProfile)

        val btnNavHome = findViewById<TextView>(R.id.btnNavHome)
        val btnNavCart = findViewById<TextView>(R.id.btnNavCart)
        val btnNavProfile = findViewById<TextView>(R.id.btnNavProfile)

        val currentUsername = intent.getStringExtra("USER_NAME") ?: "User"
        etProfileName.setText(currentUsername)

        if (currentUsername.isNotEmpty()) {
            tvAvatarInitial.text = currentUsername.first().uppercase()
        }

        btnSaveProfile.setOnClickListener {
            val updatedName = etProfileName.text.toString().trim()
            if (updatedName.isNotEmpty()) {
                tvAvatarInitial.text = updatedName.first().uppercase()
                Toast.makeText(this, "Profil berhasil diperbarui!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }

        btnNavHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USER_NAME", etProfileName.text.toString().trim())
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        btnNavCart.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        btnNavProfile.setOnClickListener {
        }
    }
}