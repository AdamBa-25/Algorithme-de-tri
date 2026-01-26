import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class tri {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Bienvenue dans le programme de tri visuel !");
        System.out.println();


        System.out.println("Commencez par choisir la taille de votre tableau. (min : 3 / max : 20)");
        System.out.println();


        System.out.print("Saisissez la taille : ");
        int Taille = scanner.nextInt();
        if (Taille < 3) {
            Taille = 3;
            System.out.println("Erreur : Taille trop petite. Taille fixée à 3.");

        }
        if (Taille > 20) {
            Taille = 20;
            System.out.println("Erreur : Taille trop grande. Taille fixée à 20.");
        }

        System.out.println("La taille du tableau est fixée à " + Taille);
        Thread.sleep(2000);
        System.out.println("Voici la situation de départ : ");
        int[] tableauUtilisateur = createTab(Taille);
        tableauUtilisateur = shuffle(tableauUtilisateur);
        visualTab(tableauUtilisateur);

        System.out.println("Quelle algorithme de tri voulez-vous utiliser ? ");
        System.out.println("1 : Tri par selection");
        System.out.println("2 : Tri par insertion");
        System.out.println("3 : Tri à bulle ");
        System.out.println("4 : Tri rapide");
        int choix = scanner.nextInt();

        switch(choix){
            default :
                System.out.println("Choix incorrect.");
                break;

            case 1 :
                System.out.println("Vous avez choisi le tri par selection.");
                triSelection(tableauUtilisateur);
                break;
            case 2 :
                System.out.println("Vous avez choisi le tri par insertion.");
                triInsertion(tableauUtilisateur);
                break;
            case 3 :
                System.out.println("Vous avez choisi le tri par insertion.");
                triBulle(tableauUtilisateur);
                break;
            case 4 :
                System.out.println("Vous avez choisi le tri par insertion.");
                quickSort(tableauUtilisateur, 0, tableauUtilisateur.length-1);
                break;
        }

    }
    /**
     * Fonction qui permet de créer un tableau de int qui commence à 1 et fini à Taille.
     * @param taille
     */
    public static int[] createTab(int taille){
        int[] tab = new int[taille];
        for (int i = 0; i < taille; i++){
            tab[i] = i+1;
        }
        return tab;
    }

    /**
     * Fonction qui mélange un tableau d'entier avec un algorithme de Fisher-Yates.
     * @param tab
     */
    public static int[] shuffle(int[] tab) {

        Random r = new Random();
        
        for (int i = tab.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1); 
            int tmp = tab[i];
            tab[i] = tab[j];
            tab[j] = tmp;
        }
        return tab;
    }


    /**
     * Affichage du tableau visuel. Crée et affiche les colonnes des tableaux selon les nombres présent dans le tableau.
     * @param tabInt
     */
    public static void visualTab(int[] tabInt) throws InterruptedException {
        String tabVisuel = "";
        int taille = tabInt.length;
        for (int i = 0; i < tabInt.length; i++ )
        {
            for (int j = 0; j < tabInt.length; j++)
            {
                if(tabInt[j] >= taille-i){
                    tabVisuel += " ■ ";
                }
                else{
                    tabVisuel += "   ";
                }
            }
            tabVisuel += "\n";
        }
        System.out.println(tabVisuel);
    }

    public static void triSelection(int[] tab) throws InterruptedException{
        int n = tab.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (tab[j] < tab[min]) {
                    min = j;

                    visualTab(tab);
                    Thread.sleep(30);
                }

                visualTab(tab);
                Thread.sleep(30);
            }

            int tmp = tab[i];
            tab[i] = tab[min];
            tab[min] = tmp;

            visualTab(tab);
            Thread.sleep(30);
        }
    }

    public static void triInsertion(int[] tab) throws InterruptedException{
        int n = tab.length;

        for (int i = 1; i < n; i++) {
            int cle = tab[i];
            int j = i - 1;

            while (j >= 0 && tab[j] > cle) {
                tab[j + 1] = tab[j];
                j--;

                visualTab(tab);
                Thread.sleep(30);
            }

            tab[j + 1] = cle;

            visualTab(tab);
            Thread.sleep(30);
        }
    }

    public static void triBulle(int[] tab) throws InterruptedException{
        int n = tab.length;
        boolean echange;

        do {
            echange = false;
            for (int i = 0; i < n - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    int tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                    echange = true;

                    visualTab(tab);
                    Thread.sleep(30);
                }

                visualTab(tab);
                Thread.sleep(30);
            }
            visualTab(tab);
            Thread.sleep(30);

            n--;
        } while (echange);
    }

    public static void quickSort(int[] tab, int debut, int fin) throws InterruptedException{
        if (debut < fin) {
            int pivot = partition(tab, debut, fin);
            quickSort(tab, debut, pivot - 1);
            quickSort(tab, pivot + 1, fin);
        }
    }

    private static int partition(int[] tab, int debut, int fin) throws InterruptedException{
        int pivot = tab[fin];
        int i = debut - 1;

        for (int j = debut; j < fin; j++) {
            if (tab[j] <= pivot) {
                i++;
                int tmp = tab[i];
                tab[i] = tab[j];
                tab[j] = tmp;

                visualTab(tab);
                Thread.sleep(30);
            }

            visualTab(tab);
            Thread.sleep(30);
        }

        int tmp = tab[i + 1];
        tab[i + 1] = tab[fin];
        tab[fin] = tmp;

        visualTab(tab);
        Thread.sleep(30);

        return i + 1;
    }

}
