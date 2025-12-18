document.addEventListener("DOMContentLoaded", () => {
  const tabel = document.getElementById("tabel-buku");
  const modal = new bootstrap.Modal(document.getElementById("modalPinjam"));
  const form = document.getElementById("formPinjam");

  // Load buku dari API
  fetch("http://localhost:9000/api/buku")
    .then((res) => res.json())
    .then((data) => {
      tabel.innerHTML = data
        .map(
          (b) => `
          <tr>
            <td>${b.judul}</td>
            <td>${b.penulis}</td>
            <td>${b.penerbit}</td>
            <td>${b.tahun}</td>
            <td>${b.kategori}</td>
            <td>${b.stok}</td>
            <td><button class="btn btn-success btn-pinjam" data-id="${b.id}" data-judul="${b.judul}">Pinjam</button></td>
          </tr>
        `
        )
        .join("");

      // Event tombol pinjam
      document.querySelectorAll(".btn-pinjam").forEach((btn) => {
        btn.addEventListener("click", () => {
          document.getElementById("idBuku").value = btn.dataset.id;
          document.getElementById("judulBuku").textContent = btn.dataset.judul;
          modal.show();
        });
      });
    });

  // Kirim peminjaman
  form.addEventListener("submit", (e) => {
    e.preventDefault();
    const id = document.getElementById("idBuku").value;

    fetch("http://localhost:9000/api/peminjaman", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ buku: { id: id } }),
    })
      .then((res) => res.json())
      .then(() => {
        alert("Buku berhasil dipinjam!");
        modal.hide();
      });
  });
});
