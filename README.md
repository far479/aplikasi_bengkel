# Aplikasi Manajemen Bengkel

Aplikasi desktop berbasis **Java Swing** untuk mengelola data operasional bengkel secara terintegrasi, meliputi data pelanggan, aset kendaraan, hingga pencatatan transaksi service. Project ini dibangun menggunakan **NetBeans IDE** dan database **MySQL/MariaDB** dengan nama database `aplikasi_bengkel`.

Project ini diajukan untuk memenuhi tugas **UAS Pemrograman**.

---

## Fitur Utama

### Pengelolaan Data Pelanggan
* Menampilkan daftar pelanggan aktif dalam tabel.
* Fitur manajemen data pelanggan meliputi simpan, edit, hapus, dan membersihkan form (*clear*).
* Menyimpan informasi penting seperti Nama Pelanggan, Nomor HP, dan Alamat.

### Pengelolaan Data Kendaraan
* Mencatat data kendaraan yang masuk untuk diservis.
* Fitur relasi yang memungkinkan pemilihan **ID Pelanggan** langsung melalui komponen *combo box*.
* Mengelola informasi Nomor Polisi, Merek Kendaraan, dan Tipe Kendaraan (Mobil/Motor).

### Pengelolaan Data Service
* Mencatat setiap transaksi perbaikan atau perawatan berkala.
* Pemilihan **No Polisi** kendaraan menggunakan *combo box* untuk menghindari kesalahan ketik.
* Dilengkapi *date chooser* untuk penentuan Tanggal Service yang akurat.
* Mencatat Keluhan, Biaya Service, serta tracking Status Service (`Proses` / `Selesai`).

---

## Teknologi yang Digunakan

* **Bahasa Pemrograman:** Java
* **Antarmuka (GUI):** Java Swing Forms & Absolute Layout
* **Database:** MySQL / MariaDB (XAMPP / phpMyAdmin)
* **Konektor & Library:** * `mysql-connector-java-5.1.18-bin.jar` (Koneksi database)
  * `jcalendar-1.4.jar` (Komponen kalender transaksi)
  * `AbsoluteLayout.jar` (Manajemen tata letak komponen GUI)

---



## Struktur Project

Berikut adalah susunan paket (*packages*) dan file sumber utama di dalam proyek NetBeans:

aplikasi_bengkel/
├── Source Packages/
│   ├── aplikasi_bengkel/
│   │   └── Aplikasi_bengkel.java
│   ├── config/
│   │   └── Koneksi.java
│   └── view/
│       ├── FormKendaraan.java
│       ├── FormPelanggan.java
│       ├── FormService.java
│       └── MainForm.java
└── Libraries/
├── mysql-connector-java-5.1.18-bin.jar
├── jcalendar-1.4.jar
└── Absolute Layout - AbsoluteLayout.jar

---

## Struktur Database

Relasi database dirancang menggunakan constraints *Foreign Key* dengan fitur `ON DELETE CASCADE` untuk menjaga integritas data secara otomatis.

### Tabel `tb_pelanggan`
Menyimpan data unik identitas pemilik kendaraan.
* `id_pelanggan` (Primary Key, Auto Increment)
* `nama_pelanggan`
* `no_hp`
* `alamat`

### Tabel `tb_kendaraan`
Menyimpan detail kendaraan yang terhubung ke data pelanggan.
* `no_polisi` (Primary Key)
* `id_pelanggan` (Foreign Key ke `tb_pelanggan`)
* `merk_kendaraan`
* `tipe_kendaraan`

### Tabel `tb_service`
Menyimpan riwayat dan status perbaikan kendaraan.
* `id_service` (Primary Key, Auto Increment)
* `no_polisi` (Foreign Key ke `tb_kendaraan`)
* `tanggal_service`
* `keluhan`
* `biaya`
* `status_service`

---

## Cara Menjalankan Project

### 1. Clone atau ekstrak project
* Unduh berkas ZIP atau lakukan clone repository ini ke direktori lokal komputer Anda.

### 2. Siapkan database
* Pastikan modul **Apache** dan **MySQL** pada XAMPP Control Panel sudah aktif.
* Akses `http://localhost/phpmyadmin` pada browser Anda.
* Buat database baru dengan nama `aplikasi_bengkel`.
* Masuk ke tab **Import**, pilih file `aplikasi_bengkel.sql` yang berada di dalam folder project ini, lalu klik **Go/Kirim**.

### 3. Atur koneksi database
* Jika diperlukan, periksa dan sesuaikan konfigurasi *credential* database (URL, username, dan password) pada file `src/config/Koneksi.java`.

### 4. Pastikan library tersedia
* Buka proyek menggunakan NetBeans IDE.
* Jika library bertanda seru atau *missing*, pastikan file `.jar` untuk `mysql-connector`, `jcalendar`, dan `AbsoluteLayout` dimuat ulang melalui pengaturan properti *Libraries* proyek.

### 5. Jalankan aplikasi
* Cari file `MainForm.java` atau `Aplikasi_bengkel.java`, klik kanan file tersebut, lalu pilih **Run File** (atau tekan `Shift + F6`).

---

## Ringkasan
Aplikasi Manajemen Bengkel ini mengintegrasikan seluruh pengelolaan entitas penting di bengkel ke dalam satu *workspace* (`MainForm`), mempermudah pencatatan dari saat pelanggan mendaftar hingga proses administrasi penyelesaian biaya service.
