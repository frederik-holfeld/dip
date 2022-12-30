// by Frederik Holfeld

public class exercise1 {
  public static void main(String[] args) {
    System.out.println("Lösung für Aufgabe 1:");
    System.out.println(4000 * 3000 + " Bits bzw. " + 4000 * 3000 / 8 + " Bytes!\n");

    System.out.println("Lösung für Aufgabe 2:");
    int rgb8 = 640 * 480 * 3 * 8;
    int rgb10 = 640 * 480 * 3 * 10;
    int rgb12 = 640 * 480 * 3 * 12;
    int rgb14 = 640 * 480 * 3 * 14;
    System.out.println("Man braucht " + rgb8 / 8 + " Bytes für 8 Bit, " + rgb10 / 8 + " Bytes für 10 Bit, " + rgb12 / 8 + " Bytes für 12 Bit und " + rgb14 / 8 + " Bytes für 14 Bit!\n");

    System.out.println("Lösung für Aufgabe 3:");
    System.out.println("Das Bild hat eine Dimension von " + 1400 / 72 * 2.54 + "cm x " + 1500 / 72 * 2.54 + "cm!");
  }
}
