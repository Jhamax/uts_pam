# ☕ Brew & Bite - University Android Project

Aplikasi pemesanan makanan dan minuman berbasis Android native dengan skema warna kopi (*Coffee-themed Palette*).

Proyek ini dibangun menggunakan **Kotlin** dan **XML (ConstraintLayout)** untuk memenuhi tugas mata kuliah Pemrograman Aplikasi Mobile (PAM).

---

## 📸 Tampilan Aplikasi (Screenshots)

|           Splash Screen           |              Sign Up               |              Login               |           Register            |
|:---------------------------------:|:----------------------------------:|:--------------------------------:|:-----------------------------:|
| ![Splash](screenshots/splash.png) | ![Sign Up](screenshots/signup.png) | ![Login](screenshots/login.png)  | ![Register](screenshots/login.png) |

|           Home Menu            |             Order              |              Konfirmasi Pesanan               |               Profile               |
|:------------------------------:|:------------------------------:|:---------------------------------------------:|:-----------------------------------:|
| ![Home](screenshots/home.png)  | ![Cart](screenshots/order.png) | ![Confirmation](screenshots/confirmation.png) | ![Profile](screenshots/profile.png) |

---

## ✨ Fitur Utama

- **Autentikasi Pengguna**: Layar Splash, Login, dan Register dengan validasi input dasar.
- **Daftar Menu Interaktif**: Menampilkan daftar produk menggunakan `RecyclerView` dan `ConstraintLayout`.
- **Sistem Keranjang Multi-Item (`CartManager`)**: Menggunakan arsitektur *Singleton Object* untuk menampung banyak item pesanan sekaligus dari katalog.
- **Kalkulasi Total Otomatis**: Menghitung ringkasan item dan akumulasi harga secara real-time di halaman *Checkout*.
- **Konfirmasi & Resi Pesanan**: Halaman ringkasan sukses transaksi (*Success/Receipt Screen*) yang menampilkan alamat, catatan, dan rincian pembayaran.
- **Profil Pengguna**: Manajemen profil interaktif dengan dukungan *Initial Avatar* dinamis.
- **Custom Floating Bottom Navigation**: Tab navigasi kustom 3 halaman (Home, Cart, Profile) yang mulus tanpa kedip (*smooth transition*).

---

## 🛠️ Teknologi & Stack

- **Bahasa Pemrograman**: Kotlin
- **UI Framework**: Android XML (ConstraintLayout, ScrollView, LinearLayout)
- **Design System**: Material Design Components (`MaterialCardView`, `MaterialButton`, `TextInputLayout`)
- **List Processing**: `RecyclerView` & Custom Adapter (`MenuAdapter`)
- **Data Management**: State Management berbasis Singleton Object (`CartManager`)
- **Navigasi**: `Intent` berbasis Data Passing (`putExtra`) & Flag Clearing (`FLAG_ACTIVITY_CLEAR_TOP`)
- **IDE**: Android Studio Quali 3

---

## 🎨 Palet Warna (Color Palette)

| Warna | Hex Code | Penggunaan |
|---|---|---|
| **Coffee Brown** | `#6F4E37` | Warna utama, Header, Tombol Utama, Teks Judul |
| **Warm Amber** | `#E5A93C` | Aksen warna, Poin Kopi, Total Harga |
| **Off White** | `#F9F6F0` | Latar belakang (*Background*) aplikasi |
| **Pure White** | `#FFFFFF` | Latar belakang Card / Kontainer |

---

## 🚀 Cara Menjalankan Aplikasi

1. **Clone Repository Ini**
   ```bash
   https://github.com/Jhamax/uts_pam.git
