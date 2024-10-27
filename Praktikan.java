class Node {
    String nama;
    Node next;
    Node prev;

    Node(String nama) {
        this.nama = nama;
        this.next = null;
        this.prev = null;
    }
}

class Praktikan {
    Node head;
    Node tail;

    // Metode untuk menambahkan praktikan
    public void addPraktikan(String nama) {
        Node newPraktikan = new Node(nama); // Menggunakan Node bukan Praktikan
        if (head == null) {
            head = tail = newPraktikan;
        } else {
            tail.next = newPraktikan;
            newPraktikan.prev = tail;
            tail = newPraktikan;
        }
    }

    // Metode untuk menghapus praktikan
    public void deletePraktikan(String nama) {
        Node temp = head;
        while (temp != null) {
            if (temp.nama.equals(nama)) { // Mengganti name dengan nama
                if (temp == head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    // Metode untuk menukar posisi praktikan
    public void swap(String nama1, String nama2) {
        Node namaswap1 = null, namaswap2 = null, temp = head;
        
        // Mencari node yang ingin ditukar
        while (temp != null) {
            if (temp.nama.equals(nama1)) namaswap1 = temp;
            if (temp.nama.equals(nama2)) namaswap2 = temp;
            temp = temp.next;
        }
        
        // Pastikan kedua node ditemukan
        if (namaswap1 == null || namaswap2 == null) return;

        // Tukar node
        if (namaswap1.prev != null) {
            namaswap1.prev.next = namaswap2;
        } else {
            head = namaswap2;
        }

        if (namaswap2.prev != null) {
            namaswap2.prev.next = namaswap1;
        } else {
            head = namaswap1;
        }

        Node tempNext = namaswap1.next;
        namaswap1.next = namaswap2.next;
        namaswap2.next = tempNext;

        if (namaswap1.next != null) namaswap1.next.prev = namaswap1;
        if (namaswap2.next != null) namaswap2.next.prev = namaswap2;

        namaswap1.prev = namaswap2.prev;
        namaswap2.prev = tempNext != null ? tempNext : namaswap1;
    }
}