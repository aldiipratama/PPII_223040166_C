# Sesi 3: Pemrograman Lanjutan dengan Java Swing

Pada sesi ketiga ini, kita akan melanjutkan pembahasan tentang Java Swing dengan fokus pada pemrograman yang lebih kompleks dan penggunaan komponen-komponen lanjutan.

## Isi Folder

```
Sesi 3
|- AplikasiKalkulatorSederhana.java //Program kalkulator sederhana menggunakan Java Swing.
|- AplikasiPengelolaanTugas.java //Aplikasi manajemen tugas dengan fitur tambah, hapus, dan edit tugas.
|- AplikasiKonversiSuhu.java //Program untuk mengkonversi suhu antara Celsius, Fahrenheit, dan Kelvin.
|- AplikasiPemesananMakanan.java //Simulasi aplikasi pemesanan makanan sederhana.
```

## Cara Menjalankan Program

Untuk menjalankan program-program dalam folder ini, ikuti langkah-langkah berikut:

1. Buka terminal atau command prompt di dalam folder `Sesi 3`.
2. Compile program yang ingin dijalankan, misalnya:
   ```
   javac HelloBorderLayout.java
   ```
3. Jalankan program dengan perintah:
   ```
   java HelloBorderLayout
   ```

## Penjelasan singkat
1. [`HelloBorderLayout.java`](./HelloBorderLayout.java):
   Program ini mendemonstrasikan penggunaan BorderLayout dalam Java Swing. BorderLayout adalah manajer tata letak yang membagi kontainer menjadi lima area: NORTH, SOUTH, EAST, WEST, dan CENTER. Program ini menunjukkan cara menempatkan komponen-komponen GUI seperti tombol di area-area tersebut, memberikan pemahaman tentang cara mengorganisir elemen-elemen antarmuka pengguna dalam aplikasi Java Swing.

2. [`HelloFlowLayout.java`](./HelloFlowLayout.java):
   Program ini menunjukkan penggunaan FlowLayout dalam Java Swing. FlowLayout adalah manajer tata letak yang mengatur komponen-komponen dalam satu baris, mengalir dari kiri ke kanan (atau dari atas ke bawah, tergantung pada orientasi). Ini adalah layout yang sederhana dan fleksibel, cocok untuk menata komponen-komponen seperti tombol atau label dalam urutan linear.

3. [`HelloGridBagLayout.java`](./HelloGridBagLayout.java):
   Program ini memperlihatkan implementasi GridBagLayout, salah satu manajer tata letak yang paling fleksibel dalam Java Swing. GridBagLayout memungkinkan penempatan komponen-komponen dalam grid dengan ukuran sel yang bervariasi. Program ini mendemonstrasikan cara mengatur komponen-komponen dengan presisi tinggi, termasuk pengaturan ukuran, posisi, dan peregangan komponen dalam grid.

4. [`HelloGridLayout.java`](./HelloGridLayout.java):
   Program ini mengilustrasikan penggunaan GridLayout dalam Java Swing. GridLayout mengatur komponen-komponen dalam grid persegi panjang dengan ukuran sel yang seragam. Ini sangat berguna untuk membuat antarmuka yang terstruktur dan simetris, seperti keypad atau papan permainan. Program ini menunjukkan cara membuat tata letak grid sederhana dan menempatkan komponen-komponen di dalamnya.