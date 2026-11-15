package id.sch.smpn45sby.ilok;

/** Semua pengaturan penting ada di sini. Ubah sesuai kebutuhan sekolah. */
final class Config {
    private Config() {}

    static final String APP_VERSION = "1.1";

    /** Alamat website ujian. */
    static final String EXAM_URL = "https://sas.smpnegeri45sby.sch.id";

    /**
     * Domain yang boleh dibuka. Link ke domain lain diblokir.
     * Tambahkan bila perlu, mis. "docs.google.com" untuk Google Form.
     */
    static final String[] ALLOWED_HOSTS = {
            "sas.smpnegeri45sby.sch.id",
            // --- Login & formulir Google (untuk form yang mewajibkan login, mode "buka langsung") ---
            "accounts.google.com", "docs.google.com", "accounts.youtube.com", "forms.gle",
            // --- Login & formulir Microsoft 365 ---
            "forms.office.com", "forms.microsoft.com", "login.microsoftonline.com", "login.live.com", "login.microsoft.com",
    };

    /** PIN pengawas untuk membuka kunci / keluar dari ujian. GANTI SEBELUM DIPAKAI! */
    static final String PROCTOR_PIN = "454545";

    /**
     * KUNCI RAHASIA untuk tanda pengenal aplikasi (dikirim ke server lewat User-Agent).
     * HARUS SAMA dengan ILOK_SECRET di server/ilok_guard.php. GANTI dengan teks acak panjang!
     */
    static final String SECRET = "GANTI_DENGAN_KUNCI_RAHASIA_ANDA_123";

    /** Lama berlaku satu token (detik). Harus sama dengan ILOK_WINDOW di server. */
    static final int TOKEN_WINDOW_SEC = 600;

    /** Jumlah pelanggaran sebelum ujian dikunci. */
    static final int MAX_VIOLATIONS = 3;

    /** Izinkan tombol Back untuk mundur halaman di dalam website ujian. */
    static final boolean ALLOW_BACK = false;

    /** Tolak perangkat root dan emulator. */
    static final boolean BLOCK_ROOT_EMULATOR = true;

    /** Tolak ujian bila "Debugging USB" aktif (mencegah mirroring layar ke PC). */
    static final boolean BLOCK_USB_DEBUGGING = true;

    /**
     * Wajibkan layar tersemat (screen pinning). Selama layar tidak tersemat, isi ujian ditutup.
     * Set false HANYA jika ada HP lama yang tidak bisa menyematkan layar.
     */
    static final boolean REQUIRE_PINNING = true;

    /**
     * Jika siswa MELEPAS sematan layar saat ujian berlangsung, ujian langsung terkunci
     * sampai pengawas memasukkan PIN (tidak menunggu 3 pelanggaran).
     */
    static final boolean UNPIN_LOCKS_EXAM = true;

    /** Bagian alamat halaman yang menandakan siswa SEDANG mengerjakan ujian (halaman soal di website). */
    static final String EXAM_PAGE_MARKER = "exam.php";

    /**
     * Tombol "Keluar" di layar ujian:
     *  false = tanpa PIN hanya di luar halaman soal (beranda / setelah selesai); saat halaman soal terbuka perlu PIN pengawas.
     *  true  = tanpa PIN di mana pun, termasuk saat mengerjakan soal (TIDAK AMAN: siswa bisa keluar dan membuka aplikasi lain).
     */
    static final boolean EXIT_NO_PIN_IN_EXAM = false;

    /**
     * Google menolak login dari WebView yang UA-nya memuat "; wv". Jika true, UA dibuat bergaya Chrome.
     * Tidak ada jaminan: Google bisa tetap menolak. Uji dengan satu akun siswa dulu.
     */
    static final boolean CHROME_STYLE_UA = true;
}
