public class Node {
    String nama;
    Node next;
    Node prev;

    // Perbaikan pada konstruktor
    public Node(String nama) {
        this.nama = nama;
        this.next = null;
        this.prev = null;
    }
}