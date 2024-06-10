import java.util.Scanner;

public class BEEC1049 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        String y = scanner.nextLine();
        String z = scanner.nextLine();
        String animal = "";

        if (x.equals("vertebrado")) {
            if (y.equals("ave")) {
                if (z.equals("carnivoro")) {
                    animal = "aguia";
                } else if (z.equals("onivoro")) {
                    animal = "pomba";
                }
            } else if (y.equals("mamifero")) {
                if (z.equals("onivoro")) {
                    animal = "homem";
                } else if (z.equals("herbivoro")) {
                    animal = "vaca";
                }
            }
        } else if (x.equals("invertebrado")) {
            if (y.equals("inseto")) {
                if (z.equals("hematofago")) {
                    animal = "pulga";
                } else if (z.equals("herbivoro")) {
                    animal = "lagarta";
                }
            } else if (y.equals("anelideo")) {
                if (z.equals("hematofago")) {
                    animal = "sanguessuga";
                } else if (z.equals("onivoro")) {
                    animal = "minhoca";
                }
            }
        }

        System.out.println(animal);
    }
}
