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

    // Metode untuk menambahkan praktikan di depan
    public void addFirst(String nama) {
        Node newPraktikan = new Node(nama);
        if (head == null) {
            head = tail = newPraktikan;
        } else {
            newPraktikan.next = head;
            head.prev = newPraktikan;
            head = newPraktikan;
        }
    }

    // Metode untuk menambahkan praktikan di belakang
    public void addLast(String nama) {
        Node newPraktikan = new Node(nama);
        if (head == null) {
            head = tail = newPraktikan;
        } else {
            tail.next = newPraktikan;
            newPraktikan.prev = tail;
            tail = newPraktikan;
        }
    }

    // Metode untuk menghapus praktikan berdasarkan nama
    public void delete(String nama) {
        Node temp = head;
        while (temp != null) {
            if (temp.nama.equals(nama)) {
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

    // Metode untuk membalik bagian tengah list
    public void reverseMiddle() {
        if (head == null || head.next == null) return;

        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int midStart = (size / 2) - (size % 2 == 0 ? 1 : 0);
        int midEnd = size / 2;

        Node start = head;
        for (int i = 0; i < midStart; i++) {
            start = start.next;
        }

        Node end = start;
        for (int i = midStart; i < midEnd; i++) {
            end = end.next;
        }

        while (start != end && start.prev != end) {
            String tempNama = start.nama;
            start.nama = end.nama;
            end.nama = tempNama;
            start = start.next;
            end = end.prev;
        }
    }

    // Metode untuk membalik seluruh list
    public void reverseAll() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // Metode untuk mencetak daftar praktikan
    public void printDaftarPraktikan() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.nama + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Praktikan daftarPraktikan = new Praktikan();

        // Menambahkan nama-nama praktikan ke dalam daftar secara berurutan
        daftarPraktikan.addLast("Nayla");
        daftarPraktikan.addLast("Nini");
        daftarPraktikan.addLast("Wira");
        daftarPraktikan.addLast("Ananta");
        daftarPraktikan.addLast("Salsa");
        daftarPraktikan.addLast("Raja");
        daftarPraktikan.addLast("Alfath");
        daftarPraktikan.addLast("Nopal");

        // Menampilkan daftar praktikan awal
        System.out.println("Daftar Praktikan awal:");
        daftarPraktikan.printDaftarPraktikan();

        // Menghapus praktikan yang tidak hadir (misalnya "Wira")
        daftarPraktikan.delete("Wira");

        // Menampilkan daftar praktikan setelah menghapus
        System.out.println("\nDaftar Praktikan setelah menghapus yang tidak hadir:");
        daftarPraktikan.printDaftarPraktikan();

        // Membalik bagian tengah list
        daftarPraktikan.reverseMiddle();

        // Menampilkan daftar praktikan setelah membalik bagian tengah
        System.out.println("\nDaftar Praktikan setelah membalik bagian tengah:");
        daftarPraktikan.printDaftarPraktikan();

        // Membalik seluruh list
        daftarPraktikan.reverseAll();

        // Menampilkan daftar praktikan setelah membalik seluruh list
        System.out.println("\nDaftar Praktikan setelah membalik seluruh list:");
        daftarPraktikan.printDaftarPraktikan();
    }
}