# Sesi 5: Pemrograman Lanjutan dengan Java Swing

Pada sesi kelima ini, kita akan melanjutkan pembahasan tentang Java Swing dengan fokus pada pemrograman yang lebih kompleks dan penggunaan komponen-komponen lanjutan.

## Isi Folder
```
Sesi 5/
  |- ComboBoxExample.java //contoh aplikasi desktop menampilkan combo box dengan JComboBoc
  |- ComboBoxModelExample.java //cotoh aplikasi desktop menampilkan combo box dengan Default Model
  |- DynamicJListExample.java //contoh aplikasi desktop menambahkan text di dalam list
  |- JLabelHTMLExample.java //contoh aplikasi desktop menjalankan/mengeksekusi tag html
  |- JListExample.java //contoh aplikasi desktop menampilkan list
  |- JTableAddRemoveRowExample.java //contoh aplikasi desktop menampilkan tabel dan button tambah baris serta delete baris dan edit setiap kolom dengan double klik
  |- JTableEditableExample.java //contoh aplikasi desktop menampilkan tabel dan hanya bisa mengedit kolom nama dengan double klik 
  |- JTableExample.java //contoh aplikasi desktop menampilkan table dan bisa mengedit semua kolom dengan double klik
  |- JTableSortExample.java //contoh aplikasi desktop menampilkan table dengan baris yang urut secara otomatis ketika mengklik kolom ID
  |- README.md //file ini
```

## Cara Menjalankan Program

Untuk menjalankan program-program dalam folder ini, ikuti langkah-langkah berikut:

1. Buka terminal atau command prompt di dalam folder `Sesi 5`.
2. Compile program yang ingin dijalankan, misalnya:
   ```
   javac ComboBoxExample.java
   ```
3. Jalankan program dengan perintah:
   ```
   java ComboBoxExample
   ```

## Penjelasan Singkat

1. [`ComboBoxExample.java`](./ComboBoxExample.java):
   Program ini menunjukkan cara menggunakan JComboBox untuk membuat dropdown menu dalam Java Swing. Program ini membuat JComboBox dengan beberapa opsi, dan ketika pengguna memilih salah satu opsi, program akan mencetak pesan ke konsol yang menunjukkan opsi yang dipilih.

2. [`ComboBoxModelExample.java`](./ComboBoxModelExample.java):
   Program ini menunjukkan cara menggunakan DefaultComboBoxModel untuk membuat model combo box dalam Java Swing. Program ini membuat model combo box dengan beberapa opsi, dan ketika pengguna memilih salah satu opsi, program akan mencetak pesan ke konsol yang menunjukkan opsi yang dipilih.

3. [`DynamicJListExample.java`](./DynamicJListExample.java):
   Program ini menunjukkan cara membuat JList yang dinamis dalam Java Swing. Program ini membuat JList dengan beberapa item awal, dan kemudian menambahkan tombol untuk menambahkan item baru dan menghapus item yang dipilih. Ketika pengguna mengklik tombol "Add Item", program akan menambahkan item baru ke dalam JList. Ketika pengguna mengklik tombol "Remove Item", program akan menghapus item yang dipilih dari JList.

4. [`JLabelHTMLExample.java`](./JLabelHTMLExample.java):
   Program ini menunjukkan cara menggunakan JLabel untuk menampilkan teks HTML dalam Java Swing. Program ini membuat JLabel dengan teks HTML yang berisi teks tebal, miring, dan bergaris bawah. Ketika dijalankan, program ini akan menampilkan JFrame dengan JLabel yang menampilkan teks HTML tersebut.

5. [`JListExample.java`](./JListExample.java):
   Program ini menunjukkan cara menggunakan JList untuk membuat daftar dalam Java Swing. Program ini membuat JList dengan beberapa item awal, dan ketika pengguna memilih salah satu item, program akan mencetak pesan ke konsol yang menunjukkan item yang dipilih.

6. [`JTableAddRemoveRowExample.java`](./JTableAddRemoveRowExample.java):
   Program ini menunjukkan cara membuat JTable yang dapat ditambahkan dan dihapus barisnya dalam Java Swing. Program ini membuat JTable dengan tombol "Add Row" untuk menambahkan baris baru dan tombol "Remove Row" untuk menghapus baris yang dipilih.

7. [`JTableEditableExample.java`](./JTableEditableExample.java):
   Program ini menunjukkan cara membuat JTable yang dapat diedit dalam Java Swing. Program ini membuat JTable dengan beberapa data awal, dan hanya kolom 'Name' yang dapat diedit. Ketika pengguna mengubah nilai dalam kolom 'Name', perubahan tersebut akan disimpan dalam model tabel.

8. [`JTableExample.java`](./JTableExample.java):
   Program ini menunjukkan cara membuat JTable yang dapat diedit dalam Java Swing. Program ini membuat JTable dengan beberapa data awal, dan semua kolom dapat diedit. Ketika pengguna mengubah nilai dalam kolom, perubahan tersebut akan disimpan dalam model tabel.

9. [`JTableSortExample.java`](./JTableSortExample.java):
   Program ini menunjukkan cara membuat JTable yang dapat diurutkan secara otomatis dalam Java Swing. Program ini membuat JTable dengan beberapa data awal, dan mengaktifkan pengurutan otomatis untuk setiap kolom. Ketika pengguna mengklik header kolom, program akan mengurutkan data dalam kolom tersebut secara otomatis.

Semoga dengan kode-kode dalam sesi ini, dapat membantu pemahaman dengan bahasa Java 😊
